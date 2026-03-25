package com.alberto.api_cosas.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cosas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Representa una cosa en el sistema")
public class Cosa {

    @Schema(description = "Identificador unico generado por SQL")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCosa;

    @Schema(description = "Tipo de cosa", example = "Electronico")
    private String tipo;
    @Schema(description = "Nombre de la cosa", example = "Mouse gamer")
    private String nombre;
    @Schema(description = "Descripción de la cosa", example = "Mouse con tecnologia gamer")
    private String descripcion;
    @Schema(description = "Estatus de la cosa", example = "true")
    private Boolean status;
    @Schema(description = "Propietario de la cosa asociado al id de la persona")
    private String propietario;

    @Schema(description = "Objeto que muestra los datos de la persona asociado a la cosa")
    @Transient
    private PersonaDTO personaDTO;
}
