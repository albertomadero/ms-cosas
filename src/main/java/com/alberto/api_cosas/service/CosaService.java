package com.alberto.api_cosas.service;

import com.alberto.api_cosas.model.Cosa;

import java.util.List;

public interface CosaService {
    List<Cosa> obtenerCosas();
    Cosa obtenerCosa(Long id);
    List<Cosa> obtenerCosasPersona(String id);
    Cosa crearCosa(Cosa cosa);
    Cosa actualizarCosa(Long id, Cosa cosa);
    void eliminarCosa(Long id);
}