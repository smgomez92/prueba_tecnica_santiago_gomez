package com.testBackend.pruebaTecnica.aplicacion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ApplicationTests {

    @Autowired
    MockMvc mock;

    @Test
    @Order(0)
    void insertarCategoria() throws Exception {
        mock.perform(post("/api/categorias/").contentType(MediaType.APPLICATION_JSON)
                .content("{\"categoryName\": \"CAT-1\", \"categoryDescripcion\":\"Categoria 1\"")).andDo(print());
    }

    @Test
    @Order(1)
    void crearBien() throws Exception {
        mock.perform(post("/api/bienes/").contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                        "    \"name\": \"Edificios tipo casa de costa\",\n" +
                        "    \"activo\": false,\n" +
                        "    \"type\": \"Edificio\",\"categoryId\":1\n" +
                        "    \n" +
                        "}")).andDo(print());;
    }

    @Test
    @Order(2)
    void obtenerBienesDisponiblesPorCategoria() throws Exception {
        mock.perform(get("/api/categorias/statistics")).andDo(print());
    }

    /*@Test
    @Order(3)
    void testActualizacion() throws Exception {
        mock.perform(put("/curso").contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\": \"Angular 10 \", \"duracion\":80,\"horario\":\"noche\"}")).andDo(print());
    }*/

}