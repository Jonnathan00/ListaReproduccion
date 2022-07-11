/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.ProyectoListaReproduccion.controler;

import com.m5a.ProyectoListaReproduccion.config.exception.NotFoundException;
import com.m5a.ProyectoListaReproduccion.model.Cancion;
import com.m5a.ProyectoListaReproduccion.model.ListaReproduccion;
import com.m5a.ProyectoListaReproduccion.service.CancionService;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL_USER
 */
@RestController
@RequestMapping("/api")
public class CancionControler {

    @Autowired
    private CancionService cancionService;

    @PostMapping("/crearCancion")
    public ResponseEntity<Cancion> crear(@RequestBody Cancion c) {

        if (c.getTitle() == null) {
            throw new EntityNotFoundException("Datos Nulos");
        }
        cancionService.createSong(c);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/listarcas")
    public ResponseEntity<List<Cancion>> listar() {

        return new ResponseEntity<>(cancionService.findByAll(), HttpStatus.OK);

    }

    @GetMapping("/buscarCancion/{id}")
    public ResponseEntity<Cancion> listar_id(@PathVariable Long id) {
        Cancion song = new Cancion();

        song = cancionService.finById(id);

        if (song == null) {

            //return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            throw new NotFoundException("404 not foud");

        } else {
            return new ResponseEntity<>(song, HttpStatus.OK);

        }

    }

    @DeleteMapping("/eliminarCancion/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        
         try {

          cancionService.deleteSong(id);

        } catch (Exception e) {

            throw new NotFoundException("404 not foud");

        }
        
        
        
    }

    @PutMapping("/actualizarSong/{id}")
    public ResponseEntity<Cancion> actualizarCasa(@PathVariable Long id, @RequestBody Cancion c) {

        Cancion home = buscarCancion(id);

        if (home == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {

            try {

                home.setAlbum(c.getAlbum());
                home.setArtist(c.getArtist());
                home.setTitle(c.getTitle());
                home.setYear(c.getYear());

                return new ResponseEntity<>(cancionService.createSong(c), HttpStatus.CREATED);

            } catch (Exception e) {

                return new ResponseEntity<>(cancionService.createSong(c), HttpStatus.INTERNAL_SERVER_ERROR);

            }

        }

    }

    public Cancion buscarCancion(Long id) {

        Cancion song = new Cancion();

        song = cancionService.finById(id);

        if (song == null) {
            throw new NotFoundException("404 not foud");
        }

        return song;
    }
        
        
      
    

}
