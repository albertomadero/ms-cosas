package com.alberto.api_cosas.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Representa una persona en el sistema")
public class PersonaDTO {
    @Schema(description = "Identificador unico generado por MongoDB")
    private String idPersona;
    @Schema(description = "Nombre de la persona", example = "Alberto")
    private String nombre;
    @Schema(description = "Apellidos de la persona", example = "Monkey D.")
    private String apellidos;
    @Schema(description = "Edad de la persona", example = "34")
    private int edad;
    @Schema(description = "Genero de la persona", example = "Masculino")
    private String genero;
    @Schema(description = "Estatus de la persona", example = "true")
    private Boolean status;
}
