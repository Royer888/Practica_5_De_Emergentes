package com.example.Pelicula_api.controller;

import com.example.Pelicula_api.entity.PeliculaEntity;  // ← IMPORT CORRECTO
import com.example.Pelicula_api.service.PeliculaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
@Tag(name = "Película", description = "API para gestionar películas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @Operation(summary = "Obtener todas las películas")
    @GetMapping
    public List<PeliculaEntity> obtenerTodas() {  // ← PeliculaEntity
        return peliculaService.obtenerTodas();
    }

    @Operation(summary = "Obtener película por ID")
    @GetMapping("/{id}")
    public ResponseEntity<PeliculaEntity> obtenerPorId(@PathVariable Long id) {  // ← PeliculaEntity
        return peliculaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear una nueva película")
    @PostMapping
    public ResponseEntity<PeliculaEntity> crear(@RequestBody PeliculaEntity pelicula) {  // ← PeliculaEntity
        PeliculaEntity nueva = peliculaService.guardar(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @Operation(summary = "Actualizar una película")
    @PutMapping("/{id}")
    public ResponseEntity<PeliculaEntity> actualizar(@PathVariable Long id, @RequestBody PeliculaEntity pelicula) {  // ← PeliculaEntity
        if (!peliculaService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }
        pelicula.setId(id);
        return ResponseEntity.ok(peliculaService.guardar(pelicula));
    }

    @Operation(summary = "Eliminar una película")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!peliculaService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }
        peliculaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}