package com.testBackend.pruebaTecnica.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase que representa un Bien
 *
 * @author Santiago Gómez
 */
public class BienDto {
    @Setter
    @Getter
    private String type;
    @Setter
    @Getter
    private boolean activo;
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private Long categoryId;

}
