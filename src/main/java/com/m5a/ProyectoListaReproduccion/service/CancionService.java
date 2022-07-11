/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.m5a.ProyectoListaReproduccion.service;

import com.m5a.ProyectoListaReproduccion.model.Cancion;

import java.util.List;

/**
 *
 * @author DELL_USER
 */
public interface CancionService {
    
    public Cancion createSong(Cancion c);
    public void deleteSong(Long id);
 
    public Cancion finById(Long id);
    public List <Cancion> findByAll();
    
   
     

   // public Casas BuscarCodigo(String codigo);
}
