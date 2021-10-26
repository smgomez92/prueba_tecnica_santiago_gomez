package com.testBackend.pruebaTecnica.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase que representa la cantidad de Bienes activos o inactivos
 *
 * @author Santiago Gómez
 */
public class BienActiveInactiveCountDto {
    @Setter
    @Getter
    Long amount;
    @Setter
    @Getter
    String activeDesc;

    public BienActiveInactiveCountDto(Boolean active, Long amount) {
        if (active) {
            this.activeDesc = "Activo";
        } else {
            this.activeDesc = "Dado De Baja";
        }
        this.amount = amount;

    }

    public BienActiveInactiveCountDto() {

    }


}
