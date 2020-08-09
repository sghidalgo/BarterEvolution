/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.List;
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
 * @author Cristian Delgadillo
 */
@Entity
@Table(name = "condicion_legalidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CondicionLegalidad.findAll", query = "SELECT c FROM CondicionLegalidad c")
    , @NamedQuery(name = "CondicionLegalidad.findByCondicionLegalidad", query = "SELECT c FROM CondicionLegalidad c WHERE c.condicionLegalidad = :condicionLegalidad")
    , @NamedQuery(name = "CondicionLegalidad.findByNombreCondicion", query = "SELECT c FROM CondicionLegalidad c WHERE c.nombreCondicion = :nombreCondicion")})
public class CondicionLegalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CondicionLegalidad")
    private String condicionLegalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "Nombre_Condicion")
    private String nombreCondicion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "condLegalidad")
    private List<LegalidadArticulos> legalidadArticulosList;

    public CondicionLegalidad() {
    }

    public CondicionLegalidad(String condicionLegalidad) {
        this.condicionLegalidad = condicionLegalidad;
    }

    public CondicionLegalidad(String condicionLegalidad, String nombreCondicion) {
        this.condicionLegalidad = condicionLegalidad;
        this.nombreCondicion = nombreCondicion;
    }

    public String getCondicionLegalidad() {
        return condicionLegalidad;
    }

    public void setCondicionLegalidad(String condicionLegalidad) {
        this.condicionLegalidad = condicionLegalidad;
    }

    public String getNombreCondicion() {
        return nombreCondicion;
    }

    public void setNombreCondicion(String nombreCondicion) {
        this.nombreCondicion = nombreCondicion;
    }

    @XmlTransient
    public List<LegalidadArticulos> getLegalidadArticulosList() {
        return legalidadArticulosList;
    }

    public void setLegalidadArticulosList(List<LegalidadArticulos> legalidadArticulosList) {
        this.legalidadArticulosList = legalidadArticulosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (condicionLegalidad != null ? condicionLegalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CondicionLegalidad)) {
            return false;
        }
        CondicionLegalidad other = (CondicionLegalidad) object;
        if ((this.condicionLegalidad == null && other.condicionLegalidad != null) || (this.condicionLegalidad != null && !this.condicionLegalidad.equals(other.condicionLegalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreCondicion;
    }
    
}
