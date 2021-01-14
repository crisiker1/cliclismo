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
@Table(name = "maillot")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maillot.findAll", query = "SELECT m FROM Maillot m")
    , @NamedQuery(name = "Maillot.findByCodigo", query = "SELECT m FROM Maillot m WHERE m.codigo = :codigo")
    , @NamedQuery(name = "Maillot.findByTipo", query = "SELECT m FROM Maillot m WHERE m.tipo = :tipo")
    , @NamedQuery(name = "Maillot.findByColor", query = "SELECT m FROM Maillot m WHERE m.color = :color")
    , @NamedQuery(name = "Maillot.findByPremio", query = "SELECT m FROM Maillot m WHERE m.premio = :premio")})
public class Maillot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TIPO")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Column(name = "premio")
    private int premio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maillot")
    private Collection<Llevar> llevarCollection;

    public Maillot() {
    }

    public Maillot(String codigo) {
        this.codigo = codigo;
    }

    public Maillot(String codigo, String tipo, String color, int premio) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.color = color;
        this.premio = premio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPremio() {
        return premio;
    }

    public void setPremio(int premio) {
        this.premio = premio;
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
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maillot)) {
            return false;
        }
        Maillot other = (Maillot) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Maillot[ codigo=" + codigo + " ]";
    }
    
}
