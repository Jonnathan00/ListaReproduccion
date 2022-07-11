/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.ProyectoListaReproduccion.controler;

import com.m5a.ProyectoListaReproduccion.config.exception.EntityNotFoundException;
import com.m5a.ProyectoListaReproduccion.config.exception.NotFoundException;
import com.m5a.ProyectoListaReproduccion.model.Cancion;
import com.m5a.ProyectoListaReproduccion.model.ListaReproduccion;

import com.m5a.ProyectoListaReproduccion.service.ListaService;
import java.util.List;

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
public class ListaControler {

    @Autowired
    private ListaService listaService;

    @PostMapping("/crearPlaylist")
    public ResponseEntity<ListaReproduccion> crearPlaylists(@RequestBody ListaReproduccion l) {
        if (l.getName() == null || l.getIdCancion() == null) {
            throw new EntityNotFoundException("Datos nulos");
        }
        return new ResponseEntity<>(listaService.createPlaylist(l), HttpStatus.CREATED);

    }

    @GetMapping("/listarPlaylist")
    public ResponseEntity<List<ListaReproduccion>> listar() {

        return new ResponseEntity<>(listaService.findByAll(), HttpStatus.OK);

    }

    @GetMapping("/buscarPLaylist/{id}")
    public ResponseEntity<ListaReproduccion> listar_id(@PathVariable Long id) {

        ListaReproduccion lista = new ListaReproduccion();

        lista = listaService.finById(id);

        if (lista == null) {

            //return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            throw new NotFoundException("404 not foud");

        } else {
            return new ResponseEntity<>(lista, HttpStatus.OK);

        }

    }

    @DeleteMapping("/deletePlaylist/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlaylist(@PathVariable Long id) {

        try {

            listaService.deletPlaylist(id);

        } catch (Exception e) {

            throw new NotFoundException("404 not foud");

        }

    }

    @GetMapping("/busquedaNombreLista/{name}")
    public ListaReproduccion buscarNombre(@PathVariable String name) {

        ListaReproduccion lista = new ListaReproduccion();

        lista = listaService.BuscarLista(name);
        if (lista == null) {

            //return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            throw new NotFoundException("404 not foud");

        }

        return lista;

    }

    /*
    @DeleteMapping("/deleteLista/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ListaReproduccion eliminarNombre (@PathVariable String name){
    
    
        return listaService.deleteNameList(name);
    
    
    }
    
    
     */
    // editarempleado
    @PutMapping("/editarPlaylist/{id}")
    public ListaReproduccion update(@RequestBody ListaReproduccion l, @PathVariable Long id) {

        ListaReproduccion home = buscarLista(id);

        home.setName(l.getName());
        home.setDescription(l.getDescription());
        home.setIdCancion(l.getIdCancion());
        

        return listaService.createPlaylist(l);

    }

    public ListaReproduccion buscarLista(Long id) {

        ListaReproduccion playlist = new ListaReproduccion();

        playlist = listaService.finById(id);

        if (playlist == null) {
            throw new NotFoundException("404 not foud");
        }

        return playlist;
    }

}
