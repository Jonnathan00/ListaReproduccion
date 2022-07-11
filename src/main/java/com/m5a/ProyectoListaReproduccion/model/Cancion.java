/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.ProyectoListaReproduccion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL_USER
 */
@Entity
@Table(name = "cancion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cancion.findAll", query = "SELECT c FROM Cancion c"),
    @NamedQuery(name = "Cancion.findByIdCancion", query = "SELECT c FROM Cancion c WHERE c.idCancion = :idCancion"),
    @NamedQuery(name = "Cancion.findByTitle", query = "SELECT c FROM Cancion c WHERE c.title = :title"),
    @NamedQuery(name = "Cancion.findByArtist", query = "SELECT c FROM Cancion c WHERE c.artist = :artist"),
    @NamedQuery(name = "Cancion.findByAlbum", query = "SELECT c FROM Cancion c WHERE c.album = :album"),
    @NamedQuery(name = "Cancion.findByYear", query = "SELECT c FROM Cancion c WHERE c.year = :year")})
public class Cancion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cancion")
    private Long idCancion;
    @Size(max = 50)
    @Column(name = "title")
    private String title;
    @Size(max = 50)
    @Column(name = "artist")
    private String artist;
    @Size(max = 50)
    @Column(name = "album")
    private String album;
    @Basic(optional = false)
    @NotNull
    @Column(name = "year")
    private int year;
    
    
    
    
    
    @JsonIgnore
    @OneToMany(mappedBy = "idCancion")
    private List<ListaReproduccion> listaReproduccionList;

    public Cancion() {
    }

    public Cancion(Long idCancion) {
        this.idCancion = idCancion;
    }

    public Cancion(Long idCancion, int year) {
        this.idCancion = idCancion;
        this.year = year;
    }

    public Long getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Long idCancion) {
        this.idCancion = idCancion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @XmlTransient
    public List<ListaReproduccion> getListaReproduccionList() {
        
        
        return listaReproduccionList;
    }

    public void setListaReproduccionList(List<ListaReproduccion> listaReproduccionList) {
        this.listaReproduccionList = listaReproduccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCancion != null ? idCancion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cancion)) {
            return false;
        }
        Cancion other = (Cancion) object;
        if ((this.idCancion == null && other.idCancion != null) || (this.idCancion != null && !this.idCancion.equals(other.idCancion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.m5a.ProyectoListaReproduccion.model.Cancion[ idCancion=" + idCancion + " ]";
    }
    
}
