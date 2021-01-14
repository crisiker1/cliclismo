/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclismo.app.models;

import java.io.Serializable;

import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.sun.istack.NotNull;

/**
 *
 * @author Cris
 */
@Entity
@Table(name = "ciclista")
public class Ciclista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "dorsal")
    private Short dorsal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private short edad;
    @OneToMany(mappedBy = "dorsal")
    private Collection<Puerto> puertoCollection;
    @JoinColumn(name = "nomeq", referencedColumnName = "nomeq")
    @ManyToOne(optional = false)
    private Equipo nomeq;
    @OneToMany(mappedBy = "dorsal")
    private Collection<Etapa> etapaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dorsal")
    private Collection<Llevar> llevarCollection;

    public Ciclista() {
    }

    public Ciclista(Short dorsal) {
        this.dorsal = dorsal;
    }

    public Ciclista(Short dorsal, String nombre, short edad) {
        this.dorsal = dorsal;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Short getDorsal() {
        return dorsal;
    }

    public void setDorsal(Short dorsal) {
        this.dorsal = dorsal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getEdad() {
        return edad;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    @XmlTransient
    public Collection<Puerto> getPuertoCollection() {
        return puertoCollection;
    }

    public void setPuertoCollection(Collection<Puerto> puertoCollection) {
        this.puertoCollection = puertoCollection;
    }

    public Equipo getNomeq() {
        return nomeq;
    }

    public void setNomeq(Equipo nomeq) {
        this.nomeq = nomeq;
    }

    @XmlTransient
    public Collection<Etapa> getEtapaCollection() {
        return etapaCollection;
    }

    public void setEtapaCollection(Collection<Etapa> etapaCollection) {
        this.etapaCollection = etapaCollection;
    }

    @XmlTransient
    public Collection<Llevar> getLlevarCollection() {
        return llevarCollection;
    }

    public void setLlevarCollection(Collection<Llevar> llevarCollection) {
        this.llevarCollection = llevarCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dorsal != null ? dorsal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciclista)) {
            return false;
        }
        Ciclista other = (Ciclista) object;
        if ((this.dorsal == null && other.dorsal != null) || (this.dorsal != null && !this.dorsal.equals(other.dorsal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Ciclista[ dorsal=" + dorsal + " ]";
    }
    
}
