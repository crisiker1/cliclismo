/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclismo.app.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Cris
 */
@Embeddable
public class LlevarPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "netapa")
    private short netapa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "codigo")
    private String codigo;

    public LlevarPK() {
    }

    public LlevarPK(short netapa, String codigo) {
        this.netapa = netapa;
        this.codigo = codigo;
    }

    public short getNetapa() {
        return netapa;
    }

    public void setNetapa(short netapa) {
        this.netapa = netapa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) netapa;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LlevarPK)) {
            return false;
        }
        LlevarPK other = (LlevarPK) object;
        if (this.netapa != other.netapa) {
            return false;
        }
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.LlevarPK[ netapa=" + netapa + ", codigo=" + codigo + " ]";
    }
    
}
