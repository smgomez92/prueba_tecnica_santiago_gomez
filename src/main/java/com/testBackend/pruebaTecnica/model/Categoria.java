package com.testBackend.pruebaTecnica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Clase que representa una tabla Categoria de la base de datos
 *
 * @author Santiago Gómez
 */
@Entity
public class Categoria {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @Getter
    private String categoryName;
    @Setter
    @Getter
    private String categoryDescripcion;
    @OneToMany(mappedBy = "categoria")
    private List<Bien> bienes;

}
