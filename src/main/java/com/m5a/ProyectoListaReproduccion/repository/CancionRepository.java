/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.m5a.ProyectoListaReproduccion.repository;

import com.m5a.ProyectoListaReproduccion.model.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author DELL_USER
 */
public interface CancionRepository extends JpaRepository<Cancion, Long>{
    
}
