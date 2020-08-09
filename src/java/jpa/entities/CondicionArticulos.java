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
@Table(name = "condicion_articulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CondicionArticulos.findAll", query = "SELECT c FROM CondicionArticulos c")
    , @NamedQuery(name = "CondicionArticulos.findByIdCondicionArticulo", query = "SELECT c FROM CondicionArticulos c WHERE c.idCondicionArticulo = :idCondicionArticulo")
    , @NamedQuery(name = "CondicionArticulos.findByNombreCondicionart", query = "SELECT c FROM CondicionArticulos c WHERE c.nombreCondicionart = :nombreCondicionart")})
public class CondicionArticulos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "id_condicion_articulo")
    private String idCondicionArticulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "nombre_condicionart")
    private String nombreCondicionart;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcondicionarticulo")
    private List<Inventario> inventarioList;

    public CondicionArticulos() {
    }

    public CondicionArticulos(String idCondicionArticulo) {
        this.idCondicionArticulo = idCondicionArticulo;
    }

    public CondicionArticulos(String idCondicionArticulo, String nombreCondicionart) {
        this.idCondicionArticulo = idCondicionArticulo;
        this.nombreCondicionart = nombreCondicionart;
    }

    public String getIdCondicionArticulo() {
        return idCondicionArticulo;
    }

    public void setIdCondicionArticulo(String idCondicionArticulo) {
        this.idCondicionArticulo = idCondicionArticulo;
    }

    public String getNombreCondicionart() {
        return nombreCondicionart;
    }

    public void setNombreCondicionart(String nombreCondicionart) {
        this.nombreCondicionart = nombreCondicionart;
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
        hash += (idCondicionArticulo != null ? idCondicionArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CondicionArticulos)) {
            return false;
        }
        CondicionArticulos other = (CondicionArticulos) object;
        if ((this.idCondicionArticulo == null && other.idCondicionArticulo != null) || (this.idCondicionArticulo != null && !this.idCondicionArticulo.equals(other.idCondicionArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreCondicionart;
    }
    
}
