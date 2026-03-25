package com.alberto.api_cosas.controller;

import com.alberto.api_cosas.model.Cosa;
import com.alberto.api_cosas.service.CosaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cosas")
@RequiredArgsConstructor
@Tag(name = "Cosas", description = "API para gestion de las cosas de una persona")
public class CosaController {

    private final CosaService cosaService;

    @Operation(summary = "Obtener todas las cosas de una persona")
    @GetMapping
    public ResponseEntity<List<Cosa>> obtenerCosas() {
        List<Cosa> resultado = cosaService.obtenerCosas();
        return ResponseEntity.ok(resultado);
    }

    @Operation(summary = "Obtener una cosa de una persona")
    @GetMapping("/{id}")
    public ResponseEntity<Cosa> obtenerCosa(@PathVariable Long id) {
        Cosa resultado = cosaService.obtenerCosa(id);
        return ResponseEntity.ok(resultado);
    }

    @Operation(summary = "Crear una cosa")
    @PostMapping
    public ResponseEntity<Cosa> crearCosa(@RequestBody Cosa cosa) {
        Cosa resultado = cosaService.crearCosa(cosa);
        return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
    }

    @Operation(summary = "Actualizar una cosa")
    @PutMapping("/{id}")
    public ResponseEntity<Cosa> actualizarCosa(@PathVariable Long id, @RequestBody Cosa cosa) {
        Cosa resultado = cosaService.actualizarCosa(id, cosa);
        return ResponseEntity.ok(resultado);
    }

    @Operation(summary = "Eliminar una cosa")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCosa(@PathVariable Long id) {
        cosaService.eliminarCosa(id);
        return ResponseEntity.noContent().build();
    }

}
