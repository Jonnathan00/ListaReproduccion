/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.m5a.ProyectoListaReproduccion.service;

import com.m5a.ProyectoListaReproduccion.model.ListaReproduccion;
import java.util.List;

/**
 *
 * @author DELL_USER
 */
public interface ListaService {

    public ListaReproduccion createPlaylist(ListaReproduccion l);

    public void deletPlaylist(Long id);

    public ListaReproduccion finById(Long id);

    public List<ListaReproduccion> findByAll();
    
   public ListaReproduccion BuscarLista(String name);
   
   public ListaReproduccion deleteNameList (String name);

}
