package com.testBackend.pruebaTecnica.dto;

import lombok.Getter;
import lombok.Setter;
/**
 * Clase que representa la cantidad de bienes por categoria
 *
 * @author Santiago Gómez
 */
public class CategoryCountDto {
    @Setter
    @Getter
    private String categoryName;
    @Setter
    @Getter
    private Long amount;

    public CategoryCountDto() {
    }

    public CategoryCountDto(String categoryName, Long amount) {
        this.categoryName = categoryName;
        this.amount = amount;
    }
}
