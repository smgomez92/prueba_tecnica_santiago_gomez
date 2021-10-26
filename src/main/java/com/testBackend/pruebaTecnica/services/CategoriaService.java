package com.testBackend.pruebaTecnica.services;

import com.testBackend.pruebaTecnica.dto.BienActiveInactiveCountDto;
import com.testBackend.pruebaTecnica.dto.CategoryCountDto;
import com.testBackend.pruebaTecnica.model.Categoria;
import com.testBackend.pruebaTecnica.repository.CategoriaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Clase que realiza la lógica del negocio para las Categorías
 *
 * @author Santiago Gómez
 */
@Service
@Slf4j
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    /**
     * Guarda una categoría en la base de datos
     *
     * @param categoria Categoria
     */
    public Long saveCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
        log.info("Categoria " + categoria.getCategoryName() + " creada...");
        return categoria.getId();
    }

    /**
     * Obtiene una categoría desde la base de datos por su Id
     *
     * @param id
     * @return
     */
    public Categoria getCategoriaById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }



    /**
     * Obtiene una lista de bienes activos por categoria desde la base de datos
     *
     * @return Lista de nombre categoria y cantidad de registros
     */
    public List<CategoryCountDto> getBienesAbailablesByCategory() {
        return categoriaRepository.getTotalCategoriesByBien();

    }

    /**
     * Obtiene una lista de bienes activos dada una categoria desde la base de datos
     *
     * @return Lista de nombre categoria y cantidad de registros
     */
    public List<BienActiveInactiveCountDto> getTotalActivesInactivesBienes(Long id) {
        return categoriaRepository.getTotalActivesInactivesBienes(id);
    }
}
