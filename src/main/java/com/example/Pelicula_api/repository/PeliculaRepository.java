package com.example.Pelicula_api.repository;

import com.example.Pelicula_api.entity.PeliculaEntity;  // ← IMPORT CORRECTO
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<PeliculaEntity, Long> {  // ← PeliculaEntity
}