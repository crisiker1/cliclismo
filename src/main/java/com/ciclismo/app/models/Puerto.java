/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclismo.app.models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cris
 */
@Entity
@Table(name = "puerto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puerto.findAll", query = "SELECT p FROM Puerto p")
    , @NamedQuery(name = "Puerto.findByNompuerto", query = "SELECT p FROM Puerto p WHERE p.nompuerto = :nompuerto")
    , @NamedQuery(name = "Puerto.findByAltura", query = "SELECT p FROM Puerto p WHERE p.altura = :altura")
    , @NamedQuery(name = "Puerto.findByCategoria", query = "SELECT p FROM Puerto p WHERE p.categoria = :categoria")
    , @NamedQuery(name = "Puerto.findByPendiente", query = "SELECT p FROM Puerto p WHERE p.pendiente = :pendiente")})
public class Puerto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "nompuerto")
    private String nompuerto;
    @Column(name = "altura")
    private Short altura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "categoria")
    private Character categoria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pendiente")
    private BigDecimal pendiente;
    @JoinColumn(name = "dorsal", referencedColumnName = "dorsal")
    @ManyToOne
    private Ciclista dorsal;
    @JoinColumn(name = "netapa", referencedColumnName = "netapa")
    @ManyToOne(optional = false)
    private Etapa netapa;

    public Puerto() {
    }

    public Puerto(String nompuerto) {
        this.nompuerto = nompuerto;
    }

    public Puerto(String nompuerto, Character categoria) {
        this.nompuerto = nompuerto;
        this.categoria = categoria;
    }

    public String getNompuerto() {
        return nompuerto;
    }

    public void setNompuerto(String nompuerto) {
        this.nompuerto = nompuerto;
    }

    public Short getAltura() {
        return altura;
    }

    public void setAltura(Short altura) {
        this.altura = altura;
    }

    public Character getCategoria() {
        return categoria;
    }

    public void setCategoria(Character categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPendiente() {
        return pendiente;
    }

    public void setPendiente(BigDecimal pendiente) {
        this.pendiente = pendiente;
    }

    public Ciclista getDorsal() {
        return dorsal;
    }

    public void setDorsal(Ciclista dorsal) {
        this.dorsal = dorsal;
    }

    public Etapa getNetapa() {
        return netapa;
    }

    public void setNetapa(Etapa netapa) {
        this.netapa = netapa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nompuerto != null ? nompuerto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puerto)) {
            return false;
        }
        Puerto other = (Puerto) object;
        if ((this.nompuerto == null && other.nompuerto != null) || (this.nompuerto != null && !this.nompuerto.equals(other.nompuerto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Puerto[ nompuerto=" + nompuerto + " ]";
    }
    
}
