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
@Table(name = "equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e")
    , @NamedQuery(name = "Equipo.findByNomeq", query = "SELECT e FROM Equipo e WHERE e.nomeq = :nomeq")
    , @NamedQuery(name = "Equipo.findByDirector", query = "SELECT e FROM Equipo e WHERE e.director = :director")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nomeq")
    private String nomeq;
    @Size(max = 100)
    @Column(name = "director")
    private String director;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nomeq")
    private Collection<Ciclista> ciclistaCollection;

    public Equipo() {
    }

    public Equipo(String nomeq) {
        this.nomeq = nomeq;
    }

    public String getNomeq() {
        return nomeq;
    }

    public void setNomeq(String nomeq) {
        this.nomeq = nomeq;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @XmlTransient
    public Collection<Ciclista> getCiclistaCollection() {
        return ciclistaCollection;
    }

    public void setCiclistaCollection(Collection<Ciclista> ciclistaCollection) {
        this.ciclistaCollection = ciclistaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomeq != null ? nomeq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.nomeq == null && other.nomeq != null) || (this.nomeq != null && !this.nomeq.equals(other.nomeq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Equipo[ nomeq=" + nomeq + " ]";
    }
    
}
