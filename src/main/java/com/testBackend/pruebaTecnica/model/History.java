package com.testBackend.pruebaTecnica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "HISTORIALBIENES")
public class History {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistory;
    @Setter
    @Getter
    private LocalDateTime modificationDate;
    @Setter
    @Getter
    private String observation;
    @Setter
    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bienId")
    private Bien bien;
}
