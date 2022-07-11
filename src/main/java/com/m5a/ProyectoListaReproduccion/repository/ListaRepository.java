/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.m5a.ProyectoListaReproduccion.repository;

import com.m5a.ProyectoListaReproduccion.model.Cancion;
import com.m5a.ProyectoListaReproduccion.model.ListaReproduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 *
 * @author DELL_USER
 */
public interface ListaRepository extends JpaRepository<ListaReproduccion, Long> {
    @Query (value = "select * from lista_reproduccion JOIN cancion USING(id_cancion) WHERE name =:name", nativeQuery= true)
public ListaReproduccion BuscarLista(String name);   
   // "DELETE FROM lista_reproduccion WHERE `lista_reproduccion`.`id_lista` 


      @Query (value = "DELETE FROM lista_reproduccion WHERE name = :name ", nativeQuery= true)
public ListaReproduccion deleteLista(String name);   
}
