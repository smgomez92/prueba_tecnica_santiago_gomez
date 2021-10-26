package com.testBackend.pruebaTecnica.controllers;

import com.testBackend.pruebaTecnica.dto.BienDto;
import com.testBackend.pruebaTecnica.model.Bien;
import com.testBackend.pruebaTecnica.services.BienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase que expone los endPoints Para la gestion de Bienes
 */
@RestController
@RequestMapping("/api")
public class BienController {
    @Autowired
    BienService bienService;

    /**
     * Método que expone un endPoint para crear un bien
     *
     * @param bienDto
     * @return Objeto creado
     */
    @PostMapping(value = "/bienes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Long saveBien(@RequestBody BienDto bienDto) {
      return   bienService.saveBien(bienDto);

    }

    /**
     * Método que expone un endPoint para Consultar los bienes
     *
     * @return
     */
    @GetMapping(value = "/bienes")
    @ResponseStatus(HttpStatus.OK)
    public List<Bien> getBienes() {
        return bienService.getBienes();
    }

    /**
     * Método que expone un endoPoint para crear Bienes por lote
     *
     * @param bienDto
     * @return Lista de los objetos creados.
     */
    @PostMapping(value = "/bienes/lote", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public List<BienDto> saveBien(@RequestBody List<BienDto> bienDto) {
        bienService.saveBienes(bienDto);
        return bienDto;

    }

    /**
     * Método que expone un endPoint para dar de baja a un lote de bienes
     *
     * @param bienesId
     * @return lista de ids dados de baja
     */
    @PostMapping(value = "/bienes/deactivated", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public List<Long> deactivatedBienes(@RequestBody List<Long> bienesId) {
        bienService.deactivatedBienes(bienesId);
        return bienesId;

    }


}
