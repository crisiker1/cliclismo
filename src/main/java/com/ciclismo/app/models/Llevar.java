/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclismo.app.models;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cris
 */
@Entity
@Table(name = "llevar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Llevar.findAll", query = "SELECT l FROM Llevar l")
    , @NamedQuery(name = "Llevar.findByNetapa", query = "SELECT l FROM Llevar l WHERE l.llevarPK.netapa = :netapa")
    , @NamedQuery(name = "Llevar.findByCodigo", query = "SELECT l FROM Llevar l WHERE l.llevarPK.codigo = :codigo")})
public class Llevar implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LlevarPK llevarPK;
    @JoinColumn(name = "dorsal", referencedColumnName = "dorsal")
    @ManyToOne(optional = false)
    private Ciclista dorsal;
    @JoinColumn(name = "netapa", referencedColumnName = "netapa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Etapa etapa;
    @JoinColumn(name = "codigo", referencedColumnName = "CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Maillot maillot;

    public Llevar() {
    }

    public Llevar(LlevarPK llevarPK) {
        this.llevarPK = llevarPK;
    }

    public Llevar(short netapa, String codigo) {
        this.llevarPK = new LlevarPK(netapa, codigo);
    }

    public LlevarPK getLlevarPK() {
        return llevarPK;
    }

    public void setLlevarPK(LlevarPK llevarPK) {
        this.llevarPK = llevarPK;
    }

    public Ciclista getDorsal() {
        return dorsal;
    }

    public void setDorsal(Ciclista dorsal) {
        this.dorsal = dorsal;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public Maillot getMaillot() {
        return maillot;
    }

    public void setMaillot(Maillot maillot) {
        this.maillot = maillot;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (llevarPK != null ? llevarPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Llevar)) {
            return false;
        }
        Llevar other = (Llevar) object;
        if ((this.llevarPK == null && other.llevarPK != null) || (this.llevarPK != null && !this.llevarPK.equals(other.llevarPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Llevar[ llevarPK=" + llevarPK + " ]";
    }
    
}
