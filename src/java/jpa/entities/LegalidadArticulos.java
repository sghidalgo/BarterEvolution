/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cristian Delgadillo
 */
@Entity
@Table(name = "legalidad_articulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LegalidadArticulos.findAll", query = "SELECT l FROM LegalidadArticulos l")
    , @NamedQuery(name = "LegalidadArticulos.findByIdlegalidad", query = "SELECT l FROM LegalidadArticulos l WHERE l.idlegalidad = :idlegalidad")
    , @NamedQuery(name = "LegalidadArticulos.findByFechalegalidad", query = "SELECT l FROM LegalidadArticulos l WHERE l.fechalegalidad = :fechalegalidad")
    , @NamedQuery(name = "LegalidadArticulos.findByDescripcionlegalidad", query = "SELECT l FROM LegalidadArticulos l WHERE l.descripcionlegalidad = :descripcionlegalidad")})
public class LegalidadArticulos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_legalidad")
    private Integer idlegalidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_legalidad")
    @Temporal(TemporalType.DATE)
    private Date fechalegalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Descripcion_legalidad")
    private String descripcionlegalidad;
    @JoinColumn(name = "CondLegalidad", referencedColumnName = "CondicionLegalidad")
    @ManyToOne(optional = false)
    private CondicionLegalidad condLegalidad;
    @JoinColumn(name = "Cedula_cliente", referencedColumnName = "Cedula_cliente")
    @ManyToOne(optional = false)
    private Clientes cedulacliente;
    @JoinColumn(name = "Id_articulo", referencedColumnName = "IdArticulo")
    @ManyToOne(optional = false)
    private Articulos idarticulo;

    public LegalidadArticulos() {
    }

    public LegalidadArticulos(Integer idlegalidad) {
        this.idlegalidad = idlegalidad;
    }

    public LegalidadArticulos(Integer idlegalidad, Date fechalegalidad, String descripcionlegalidad) {
        this.idlegalidad = idlegalidad;
        this.fechalegalidad = fechalegalidad;
        this.descripcionlegalidad = descripcionlegalidad;
    }

    public Integer getIdlegalidad() {
        return idlegalidad;
    }

    public void setIdlegalidad(Integer idlegalidad) {
        this.idlegalidad = idlegalidad;
    }

    public Date getFechalegalidad() {
        return fechalegalidad;
    }

    public void setFechalegalidad(Date fechalegalidad) {
        this.fechalegalidad = fechalegalidad;
    }

    public String getDescripcionlegalidad() {
        return descripcionlegalidad;
    }

    public void setDescripcionlegalidad(String descripcionlegalidad) {
        this.descripcionlegalidad = descripcionlegalidad;
    }

    public CondicionLegalidad getCondLegalidad() {
        return condLegalidad;
    }

    public void setCondLegalidad(CondicionLegalidad condLegalidad) {
        this.condLegalidad = condLegalidad;
    }

    public Clientes getCedulacliente() {
        return cedulacliente;
    }

    public void setCedulacliente(Clientes cedulacliente) {
        this.cedulacliente = cedulacliente;
    }

    public Articulos getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(Articulos idarticulo) {
        this.idarticulo = idarticulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlegalidad != null ? idlegalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LegalidadArticulos)) {
            return false;
        }
        LegalidadArticulos other = (LegalidadArticulos) object;
        if ((this.idlegalidad == null && other.idlegalidad != null) || (this.idlegalidad != null && !this.idlegalidad.equals(other.idlegalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idlegalidad + " ";
    }
    
}
