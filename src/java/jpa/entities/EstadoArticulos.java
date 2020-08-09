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
@Table(name = "estado_articulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoArticulos.findAll", query = "SELECT e FROM EstadoArticulos e")
    , @NamedQuery(name = "EstadoArticulos.findByIdestadoarticulo", query = "SELECT e FROM EstadoArticulos e WHERE e.idestadoarticulo = :idestadoarticulo")
    , @NamedQuery(name = "EstadoArticulos.findByNombreestadoart", query = "SELECT e FROM EstadoArticulos e WHERE e.nombreestadoart = :nombreestadoart")})
public class EstadoArticulos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Id_estado_articulo")
    private String idestadoarticulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "Nombre_estadoart")
    private String nombreestadoart;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestadoarticulo")
    private List<Articulos> articulosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestadoarticulo")
    private List<Ventas> ventasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestadoarticulo")
    private List<Inventario> inventarioList;

    public EstadoArticulos() {
    }

    public EstadoArticulos(String idestadoarticulo) {
        this.idestadoarticulo = idestadoarticulo;
    }

    public EstadoArticulos(String idestadoarticulo, String nombreestadoart) {
        this.idestadoarticulo = idestadoarticulo;
        this.nombreestadoart = nombreestadoart;
    }

    public String getIdestadoarticulo() {
        return idestadoarticulo;
    }

    public void setIdestadoarticulo(String idestadoarticulo) {
        this.idestadoarticulo = idestadoarticulo;
    }

    public String getNombreestadoart() {
        return nombreestadoart;
    }

    public void setNombreestadoart(String nombreestadoart) {
        this.nombreestadoart = nombreestadoart;
    }

    @XmlTransient
    public List<Articulos> getArticulosList() {
        return articulosList;
    }

    public void setArticulosList(List<Articulos> articulosList) {
        this.articulosList = articulosList;
    }

    @XmlTransient
    public List<Ventas> getVentasList() {
        return ventasList;
    }

    public void setVentasList(List<Ventas> ventasList) {
        this.ventasList = ventasList;
    }

    @XmlTransient
    public List<Inventario> getInventarioList() {
        return inventarioList;
    }

    public void setInventarioList(List<Inventario> inventarioList) {
        this.inventarioList = inventarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestadoarticulo != null ? idestadoarticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoArticulos)) {
            return false;
        }
        EstadoArticulos other = (EstadoArticulos) object;
        if ((this.idestadoarticulo == null && other.idestadoarticulo != null) || (this.idestadoarticulo != null && !this.idestadoarticulo.equals(other.idestadoarticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreestadoart ;
    }
    
}
