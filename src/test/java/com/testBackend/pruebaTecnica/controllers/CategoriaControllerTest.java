package com.testBackend.pruebaTecnica.controllers;

import com.testBackend.pruebaTecnica.model.Categoria;
import com.testBackend.pruebaTecnica.services.BienService;
import com.testBackend.pruebaTecnica.services.CategoriaService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class CategoriaControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    BienService bienService;
    @MockBean
    CategoriaService categoriaService;

    @BeforeEach
    void setUp() {
        Mockito.reset(bienService);
        Mockito.reset(categoriaService);
    }

    @Test
    public void shoulCreateCategory() throws Exception {
        String categoryBody = "{\"categoryName\": \"CAT-1\",\"categoryDescripcion\": \"Categoria 1\"}";
        Categoria categoria = new Categoria();
        categoria.setCategoryName("CAT-1");
        categoria.setCategoryDescripcion("Categoria Uno");
        when(categoriaService.saveCategoria(categoria)).thenReturn(12L);

        mockMvc.perform(post("/api/categorias")
                        .content(categoryBody)
                        .contentType(APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

    @AfterEach
    void tearDown() {
    }
}