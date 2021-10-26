package com.testBackend.pruebaTecnica.services;

import com.testBackend.pruebaTecnica.model.Categoria;
import com.testBackend.pruebaTecnica.repository.CategoriaRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CategoriaServiceTest {
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    CategoriaService categoriaService;

    @Test
    public void shouldCreateACategory() {
        Categoria categoria = new Categoria();
        categoria.setCategoryName("CAT-1");
        categoria.setCategoryDescripcion("Categoria Uno");
        categoriaRepository.save(categoria);

        Categoria categoriaResult = categoriaService.getCategoriaById(categoria.getId());

        assertNotNull("Categorìa no deberìa ser null", categoriaResult);
        assertThat(categoriaResult.getCategoryName(), equalTo("CAT-1"));
        assertThat(categoriaResult.getCategoryDescripcion(), equalTo("Categoria Uno"));


    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
}