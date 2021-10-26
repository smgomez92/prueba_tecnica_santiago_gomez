package com.testBackend.pruebaTecnica.services;

import com.testBackend.pruebaTecnica.dto.BienDto;
import com.testBackend.pruebaTecnica.model.Bien;
import com.testBackend.pruebaTecnica.model.Categoria;
import com.testBackend.pruebaTecnica.model.History;
import com.testBackend.pruebaTecnica.repository.BienesRepository;
import com.testBackend.pruebaTecnica.repository.CategoriaRepository;
import com.testBackend.pruebaTecnica.repository.HistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase que realiza la lógica del negocio para los Bienes
 *
 * @author Santiago Gómez
 */
@Service
@Slf4j
public class BienService {
    @Autowired
    BienesRepository bienesRepository;
    @Autowired
    HistoryRepository historyRepository;

    /**
     * Método que guarda un Bien en la base de datos
     *
     * @param bienDto
     */
    public Long saveBien(BienDto bienDto) {
        Bien bien = createBien(bienDto);
        bienesRepository.save(bien);
        saveHistory(bien);
        log.info("Bien Guardada.");
        return bien.getId();
    }

    /**
     * Método que crea un objeto del tipo Bien a partir del objeto BienDto
     *
     * @param bienDto
     * @return objeto Bien
     */
    private Bien createBien(BienDto bienDto) {
        Bien bien = new Bien();
        bien.setCategoria(createCategoria(bienDto.getCategoryId()));
        bien.setName(bienDto.getName());
        bien.setActive(bienDto.isActivo());
        bien.setType(bienDto.getType());
        return bien;
    }

    /**
     * Crea un objeto de Categoría
     *
     * @param id
     * @return categoria
     */
    private Categoria createCategoria(Long id) {
        Categoria categoria = new Categoria();
        categoria.setId(id);
        return categoria;
    }

    /**
     * Método que obtiene un objeto del tipo bien por su id
     *
     * @param id
     * @return objeto del tipo Bien
     */
    public Bien getBienById(Long id) {
        return bienesRepository.findById(id).orElse(null);
    }

    /**
     * Método que recupera una lista de objetos tipo Bien
     *
     * @return Lista de bienes
     */
    public List<BienDto> getBienes() {
      return  bienesRepository.findAll().stream().map(bien -> new BienDto(bien.getType(), bien.isActive(), bien.getName(), bien.getCategoria().getId())
        ).collect(Collectors.toList());

    }

    /**
     * Método que guarda uno o varios Bienes
     *
     * @param bienesTosave Lista de bienesDto
     */
    public void saveBienes(List<BienDto> bienesTosave) {
        bienesTosave.stream().forEach(bien -> {
            this.saveBien(bien);
            log.info("Guardando " + bien.getName());
        });

    }

    private void saveHistory(Bien bien) {
        History history = new History();
        history.setBien(bien);
        history.setObservation("Cambios " + LocalDate.now().toString());
        history.setModificationDate(LocalDateTime.now());
        historyRepository.save(history);
        log.info("Historial guardado....");


    }

    /**
     * Método que da de baja uno o varios bienes
     *
     * @param bienesId Lista de ids
     */
    public void deactivatedBienes(List<Long> bienesId) {
        bienesId.stream().forEach(id -> {
            Bien bien = bienesRepository.findById(id).orElse(null);
            if (bien == null) {
                return;
            }
            bien.setActive(false);
            bienesRepository.save(bien);
            saveHistory(bien);

        });


    }
}
