package com.testBackend.pruebaTecnica.repository;

import com.testBackend.pruebaTecnica.model.Bien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BienesRepository extends JpaRepository<Bien,Long> {
}
