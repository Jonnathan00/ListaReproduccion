/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.ProyectoListaReproduccion.service;

import com.m5a.ProyectoListaReproduccion.config.exception.BadRequestException;
import com.m5a.ProyectoListaReproduccion.config.exception.EntityNotFoundException;
import com.m5a.ProyectoListaReproduccion.model.ListaReproduccion;
import com.m5a.ProyectoListaReproduccion.repository.ListaRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL_USER
 */
@Service
public class ListaServiceImpl implements ListaService {
    
    @Autowired
    private ListaRepository listaRepository; 
    

    @Override
    public ListaReproduccion createPlaylist(ListaReproduccion l) {
       
        
        
        return listaRepository.save(l);
    }

    @Override
    public void deletPlaylist(Long id) {
        
        listaRepository.deleteById(id);
        
    }

    @Override
    public ListaReproduccion finById(Long id) {
        return listaRepository.findById(id).orElse(null);
    }

    @Override
    public List<ListaReproduccion> findByAll() {
        return   (List<ListaReproduccion>) listaRepository.findAll();
    }

    @Override
    public ListaReproduccion BuscarLista(String name) {


        return listaRepository.BuscarLista(name);
    }

    @Override
    public ListaReproduccion deleteNameList(String name) {

        return listaRepository.deleteLista(name);
    
    }
    
}
