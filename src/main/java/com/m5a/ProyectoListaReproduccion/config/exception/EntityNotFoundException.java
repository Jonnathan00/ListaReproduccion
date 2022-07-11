/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.ProyectoListaReproduccion.config.exception;

import javax.persistence.PersistenceException;

/**
 *
 * @author DELL_USER
 */
public class EntityNotFoundException extends PersistenceException {

    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
    
}
