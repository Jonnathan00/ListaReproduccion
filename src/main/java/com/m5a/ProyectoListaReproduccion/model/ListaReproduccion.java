/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.ProyectoListaReproduccion.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL_USER
 */
@Entity
@Table(name = "lista_reproduccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaReproduccion.findAll", query = "SELECT l FROM ListaReproduccion l"),
    @NamedQuery(name = "ListaReproduccion.findByIdLista", query = "SELECT l FROM ListaReproduccion l WHERE l.idLista = :idLista"),
    @NamedQuery(name = "ListaReproduccion.findByName", query = "SELECT l FROM ListaReproduccion l WHERE l.name = :name"),
    @NamedQuery(name = "ListaReproduccion.findByDescription", query = "SELECT l FROM ListaReproduccion l WHERE l.description = :description"),
    @NamedQuery(name = "ListaReproduccion.findBySongs", query = "SELECT l FROM ListaReproduccion l WHERE l.songs = :songs")})
public class ListaReproduccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_lista")
    private Long idLista;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 50)
    @Column(name = "description")
    private String description;
    @Size(max = 100)
    @Column(name = "songs")
    private String songs;
    
    
    
    @JoinColumn(name = "id_cancion", referencedColumnName = "id_cancion")
    @ManyToOne
    private Cancion idCancion;

    public ListaReproduccion() {
    }

    public ListaReproduccion(Long idLista) {
        this.idLista = idLista;
    }

    public Long getIdLista() {
        return idLista;
    }

    public void setIdLista(Long idLista) {
        this.idLista = idLista;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSongs() {
        return songs;
    }

    public void setSongs(String songs) {
        this.songs = songs;
    }

    public Cancion getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Cancion idCancion) {
        this.idCancion = idCancion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLista != null ? idLista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaReproduccion)) {
            return false;
        }
        ListaReproduccion other = (ListaReproduccion) object;
        if ((this.idLista == null && other.idLista != null) || (this.idLista != null && !this.idLista.equals(other.idLista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.m5a.ProyectoListaReproduccion.model.ListaReproduccion[ idLista=" + idLista + " ]";
    }
    
}
