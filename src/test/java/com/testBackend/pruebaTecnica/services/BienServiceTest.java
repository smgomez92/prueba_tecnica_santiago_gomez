package com.testBackend.pruebaTecnica.services;

import com.testBackend.pruebaTecnica.model.Bien;
import com.testBackend.pruebaTecnica.model.Categoria;
import com.testBackend.pruebaTecnica.repository.BienesRepository;
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
class BienServiceTest {
    @Autowired
    BienesRepository bienesRepository;
    @Autowired
    BienService bienService;
    @Autowired
    CategoriaRepository categoriaRepository;

    @Test
    public void shoulCreateAndReturnABien() {
        Bien bien = new Bien();
        bien.setName("Edificio de playa");
        bien.setCategoria(saveCategory("CAT-1","Descripcion"));
        bien.setType("Edificio");
        bien.setActive(true);

        bienesRepository.save(bien);


        Bien bienResult = bienService.getBienById(bien.getId());

        assertNotNull("Bien no deberìa ser null", bienResult);
        assertThat(bienResult.getName(), equalTo("Edificio de playa"));
        assertThat(bienResult.getType(), equalTo("Edificio"));


    }

    private Categoria saveCategory(String name, String desc) {
        Categoria categoria = new Categoria();
        categoria.setCategoryName(name);
        categoria.setCategoryDescripcion(desc);
        categoriaRepository.save(categoria);
        return categoria;
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
}