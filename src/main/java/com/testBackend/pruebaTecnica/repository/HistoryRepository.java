package com.testBackend.pruebaTecnica.repository;

import com.testBackend.pruebaTecnica.model.Bien;
import com.testBackend.pruebaTecnica.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History,Long> {

}
