package com.alberto.api_cosas.controller;

import com.alberto.api_cosas.model.Cosa;
import com.alberto.api_cosas.service.CosaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personas")
@RequiredArgsConstructor
@Tag(name = "Obtener cosas de la persona")
public class PropietarioCosaController {

    private final CosaService cosaService;

    @Operation(summary = "Obetener todas las cosas de una persona")
    @GetMapping("/{idPersona}/cosas")
    public ResponseEntity<List<Cosa>> obtenerCosasPersona(@PathVariable String idPersona) {
        List<Cosa> resultado = cosaService.obtenerCosasPersona(idPersona);
        return ResponseEntity.ok(resultado);
    }

}
