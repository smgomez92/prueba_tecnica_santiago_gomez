package com.testBackend.pruebaTecnica.repository;

import com.testBackend.pruebaTecnica.dto.BienActiveInactiveCountDto;
import com.testBackend.pruebaTecnica.dto.CategoryCountDto;
import com.testBackend.pruebaTecnica.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {


    @Query("select new com.testBackend.pruebaTecnica.dto.CategoryCountDto(a.categoryDescripcion, count(b.id)) from Categoria a, Bien b where a.id=b.categoria.id group by a.categoryDescripcion")
    public List<CategoryCountDto> getTotalCategoriesByBien();
    @Query("select new com.testBackend.pruebaTecnica.dto.BienActiveInactiveCountDto(b.active, count(b.active)) from Bien b where b.categoria.id=:id group by b.active")
    public List<BienActiveInactiveCountDto> getTotalActivesInactivesBienes(Long id);

}
