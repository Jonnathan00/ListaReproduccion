/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.ProyectoListaReproduccion.service;

import com.m5a.ProyectoListaReproduccion.config.exception.EntityNotFoundException;
import com.m5a.ProyectoListaReproduccion.model.Cancion;
import com.m5a.ProyectoListaReproduccion.repository.CancionRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL_USER
 */
@Service
public class CancionServiceImpl implements CancionService {

    @Autowired
    private CancionRepository cancionRepository;

    @Override
    public Cancion createSong(Cancion c) {
        if (c.getIdCancion() == null  ){
           throw new EntityNotFoundException ("Datos nulos") ;
        }
        return cancionRepository.save(c);
    }

    @Override
    public void deleteSong(Long id) {

        cancionRepository.deleteById(id);
    }

    @Override
    public Cancion finById(Long id) {
        return cancionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cancion> findByAll() {
        return (List<Cancion>) cancionRepository.findAll();
    }
    
    
     

}
