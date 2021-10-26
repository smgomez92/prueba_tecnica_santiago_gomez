package com.testBackend.pruebaTecnica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Clase que representa una tabla Bien de la base de datos
 *
 * @author Santiago Gómez
 */
@Entity
public class Bien {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private boolean active;
    @Setter
    @Getter
    private String type;
    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "categoriaId")
    private Categoria categoria;

    @Setter
    @Getter
    @OneToMany(mappedBy = "bien", fetch = FetchType.LAZY)
    private List<History> history;
}
