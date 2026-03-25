package com.alberto.api_cosas.client;

import com.alberto.api_cosas.model.PersonaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "personas-api", url = "http://localhost:8080")
public interface PersonaClient {
    @GetMapping("/interno/personas/{idPersona}")
    PersonaDTO obtenerDatosPersona(@PathVariable String idPersona);
}
