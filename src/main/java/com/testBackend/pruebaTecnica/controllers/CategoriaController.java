package com.testBackend.pruebaTecnica.controllers;

import com.testBackend.pruebaTecnica.dto.BienActiveInactiveCountDto;
import com.testBackend.pruebaTecnica.dto.CategoryCountDto;
import com.testBackend.pruebaTecnica.model.Categoria;
import com.testBackend.pruebaTecnica.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase que expone un endPoint para la administración de categorías
 *
 * @author Santiago Gómez
 */
@RestController
@RequestMapping("/api")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    /**
     * Método que me devuelve una categoría según el id
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/categorias/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Categoria getCategoryById(@PathVariable Long id) {
        return categoriaService.getCategoriaById(id);
    }

    /**
     * Método que guarda o modifica una categoria
     *
     * @param categoria
     * @return Objeto creado
     */
    @PostMapping(value = "/categorias", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Long saveOrUpdateCategory(@RequestBody Categoria categoria) {
      return  categoriaService.saveOrUpdateCategory(categoria);

    }




    /**
     * Método que expone un endPoint para la consulta de bienes activos o inactivos por categoria
     *
     * @return lista de objetos Categoria
     */
    @GetMapping(value = "/categorias/statistics")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryCountDto> getBienesAbailablesByCategory() {
        return categoriaService.getBienesAbailablesByCategory();
    }

    /**
     * Método que expone un endPoint que permite la consulta de Bienes activos por categoría
     *
     * @param id
     * @return Lista de objetos BienActiveInactiveCountDto
     */
    @GetMapping(value = "/categorias/statistics/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<BienActiveInactiveCountDto> getBienesAbailablesByCategory(@PathVariable Long id) {
        return categoriaService.getTotalActivesInactivesBienes(id);
    }


}
