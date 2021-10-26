package com.testBackend.pruebaTecnica.controllers;

import com.testBackend.pruebaTecnica.dto.BienDto;
import com.testBackend.pruebaTecnica.model.Bien;
import com.testBackend.pruebaTecnica.model.Categoria;
import com.testBackend.pruebaTecnica.services.BienService;
import com.testBackend.pruebaTecnica.services.CategoriaService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
class BienControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    BienService bienService;
    @MockBean
    CategoriaService categoriaService;

    @Test
    public void shouldReturnBienList() throws Exception {
        List<BienDto> bienes = getBienesList();
        when(bienService.getBienes()).thenReturn(bienes);

        mockMvc.perform(get("/api/bienes")).andDo(print());

    }

    private List<BienDto> getBienesList() {
        List<BienDto> bienes = new ArrayList<>();
        BienDto bien1 = new BienDto("Edificio", true, "Casa", 1L);


        bienes.add(bien1);
        BienDto bien2 = new BienDto("Edificio", true, "Casa", 1L);
        bienes.add(bien2);
        return bienes;
    }

    @Test
    public void shouldCreateABien() throws Exception {
        BienDto bienDto = new BienDto("Vehiculo",true,"Camioneta",2L);
        bienDto.setType("Vehiculo");
        bienDto.setName("Camioneta");
        bienDto.setActivo(true);
        bienDto.setCategoryId(2L);
        when(bienService.saveBien(bienDto)).thenReturn(12L);

        String bienBody = "{\"name\": \"Camioneta\",\"activo\": true,\"type\": \"Vehiculo\",\"categoryId\":1 }";
        mockMvc.perform(post("/api/bienes")
                        .content(bienBody)
                        .contentType(APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }


    @BeforeEach
    void setUp() {
        Mockito.reset(bienService);
        Mockito.reset(categoriaService);
    }

    @AfterEach
    void tearDown() {
    }
}