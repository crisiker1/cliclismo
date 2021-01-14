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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cris
 */
@Entity
@Table(name = "etapa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etapa.findAll", query = "SELECT e FROM Etapa e")
    , @NamedQuery(name = "Etapa.findByNetapa", query = "SELECT e FROM Etapa e WHERE e.netapa = :netapa")
    , @NamedQuery(name = "Etapa.findByKm", query = "SELECT e FROM Etapa e WHERE e.km = :km")
    , @NamedQuery(name = "Etapa.findBySalida", query = "SELECT e FROM Etapa e WHERE e.salida = :salida")
    , @NamedQuery(name = "Etapa.findByLlegada", query = "SELECT e FROM Etapa e WHERE e.llegada = :llegada")})
public class Etapa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "netapa")
    private Short netapa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "km")
    private short km;
    @Size(max = 35)
    @Column(name = "salida")
    private String salida;
    @Size(max = 35)
    @Column(name = "llegada")
    private String llegada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "netapa")
    private Collection<Puerto> puertoCollection;
    @JoinColumn(name = "dorsal", referencedColumnName = "dorsal")
    @ManyToOne
    private Ciclista dorsal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etapa")
    private Collection<Llevar> llevarCollection;

    public Etapa() {
    }

    public Etapa(Short netapa) {
        this.netapa = netapa;
    }

    public Etapa(Short netapa, short km) {
        this.netapa = netapa;
        this.km = km;
    }

    public Short getNetapa() {
        return netapa;
    }

    public void setNetapa(Short netapa) {
        this.netapa = netapa;
    }

    public short getKm() {
        return km;
    }

    public void setKm(short km) {
        this.km = km;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getLlegada() {
        return llegada;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    @XmlTransient
    public Collection<Puerto> getPuertoCollection() {
        return puertoCollection;
    }

    public void setPuertoCollection(Collection<Puerto> puertoCollection) {
        this.puertoCollection = puertoCollection;
    }

    public Ciclista getDorsal() {
        return dorsal;
    }

    public void setDorsal(Ciclista dorsal) {
        this.dorsal = dorsal;
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
        hash += (netapa != null ? netapa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etapa)) {
            return false;
        }
        Etapa other = (Etapa) object;
        if ((this.netapa == null && other.netapa != null) || (this.netapa != null && !this.netapa.equals(other.netapa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Etapa[ netapa=" + netapa + " ]";
    }
    
}
