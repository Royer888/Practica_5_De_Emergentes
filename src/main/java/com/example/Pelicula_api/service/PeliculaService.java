package com.example.Pelicula_api.service;

import com.example.Pelicula_api.entity.PeliculaEntity;  // ← IMPORT CORRECTO
import com.example.Pelicula_api.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<PeliculaEntity> obtenerTodas() {  // ← PeliculaEntity
        return peliculaRepository.findAll();
    }

    public Optional<PeliculaEntity> obtenerPorId(Long id) {  // ← PeliculaEntity
        return peliculaRepository.findById(id);
    }

    public PeliculaEntity guardar(PeliculaEntity pelicula) {  // ← PeliculaEntity
        return peliculaRepository.save(pelicula);
    }

    public void eliminar(Long id) {
        peliculaRepository.deleteById(id);
    }

    public boolean existePorId(Long id) {
        return peliculaRepository.existsById(id);
    }
}