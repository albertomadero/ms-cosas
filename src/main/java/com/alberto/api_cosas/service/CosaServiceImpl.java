package com.alberto.api_cosas.service;

import com.alberto.api_cosas.client.PersonaClient;
import com.alberto.api_cosas.exception.CosaNotFoundException;
import com.alberto.api_cosas.model.Cosa;
import com.alberto.api_cosas.model.PersonaDTO;
import com.alberto.api_cosas.repository.CosaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CosaServiceImpl implements CosaService{

    private final CosaRepository cosaRepository;
    private final PersonaClient personaClient;


    @Override
    public List<Cosa> obtenerCosas() {
        return cosaRepository.findAll();
    }

    @Override
    public Cosa obtenerCosa(Long id) {
        Cosa cosa = cosaRepository.findById(id).orElseThrow(() -> new CosaNotFoundException(id));
        String propietario = cosa.getPropietario();
        try {
            PersonaDTO datosPropietario = personaClient.obtenerDatosPersona(propietario);
            cosa.setPersonaDTO(datosPropietario);
        } catch (Exception e) {
            log.warn("Api personas no disponible: {}", e.getMessage());
            cosa.setPersonaDTO(null);
        }
        return cosa;
    }

    @Override
    public List<Cosa> obtenerCosasPersona(String id) {
        List<Cosa> cosas = cosaRepository.findByPropietario(id);
        try {
            PersonaDTO datosPropietario = personaClient.obtenerDatosPersona(id);
            for (Cosa cosa : cosas) {
                cosa.setPersonaDTO(datosPropietario);
            }
        } catch (Exception e) {
            log.warn("API personas no disponible: {}", e.getMessage());
            for (Cosa cosa : cosas) {
                cosa.setPersonaDTO(null);
            }
        }
        return cosas;
    }

    @Override
    public Cosa crearCosa(Cosa cosa) {
        return cosaRepository.save(cosa);
    }

    @Override
    public Cosa actualizarCosa(Long id, Cosa cosa) {
        obtenerCosa(id);
        cosa.setIdCosa(id);
        return cosaRepository.save(cosa);
    }

    @Override
    public void eliminarCosa(Long id) {
        obtenerCosa(id);
        cosaRepository.deleteById(id);
    }
}
