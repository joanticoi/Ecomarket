package com.example.Ecomarket.controller;

import com.example.Ecomarket.model.Libros;
import com.example.Ecomarket.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libro")
public class LibroController {

    @Autowired
    private LibroService LibroService;

    @GetMapping
    public ResponseEntity<List<Libros>> listar() {
        List<Libros> libros  = LibroService.BuscarTodosLosPacientes();
        if (libros.isEmpty()) {
            return ResponseEntity.noContent().build();
            //alternativa 2 -> return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(libros);
        //alternativa 2 -> return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity <Libros> listarunosolo(@PathVariable Integer idLibro)
    {
          Libros libros= LibroService.BuscarPorId(idLibro);
          return ResponseEntity.ok(libros);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long idLibro)
    {
        LibroService.delete(idLibro);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Libros> guardar(@RequestBody Libros libros)
    {
        Libros libroNuevo = LibroService.save(libros);
        return ResponseEntity.status(HttpStatus.CREATED).body(libroNuevo);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Libros> modifcar(@PathVariable Integer idLibro, @RequestBody Libros libros)
{
        Libros libroMod = LibroService.BuscarPorId(idLibro);
        libroMod.setIdLibro(idLibro);
    
        libroMod.setNombre(libros.getNombre());
        libroMod.setEditorial(libros.getEditorial());
        libroMod.setFechaLanzamiento(libros.getFechaLanzamiento());
        LibroService.save(libroMod);

        return ResponseEntity.ok(libroMod);
}
}

