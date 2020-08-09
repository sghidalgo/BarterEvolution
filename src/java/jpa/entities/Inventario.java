/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
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
 * @author Cristian Delgadillo
 */
@Entity
@Table(name = "inventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i")
    , @NamedQuery(name = "Inventario.findByIdinventario", query = "SELECT i FROM Inventario i WHERE i.idinventario = :idinventario")
    , @NamedQuery(name = "Inventario.findByCantidad", query = "SELECT i FROM Inventario i WHERE i.cantidad = :cantidad")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Id_inventario")
    private String idinventario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cantidad")
    private int cantidad;
    @JoinColumn(name = "Id_categoria", referencedColumnName = "Id_categoria")
    @ManyToOne(optional = false)
    private Categorias idcategoria;
    @JoinColumn(name = "Id_condicion_articulo", referencedColumnName = "id_condicion_articulo")
    @ManyToOne(optional = false)
    private CondicionArticulos idcondicionarticulo;
    @JoinColumn(name = "Id_estado_articulo", referencedColumnName = "Id_estado_articulo")
    @ManyToOne(optional = false)
    private EstadoArticulos idestadoarticulo;
    @JoinColumn(name = "Id_articulo", referencedColumnName = "IdArticulo")
    @ManyToOne(optional = false)
    private Articulos idarticulo;

    public Inventario() {
    }

    public Inventario(String idinventario) {
        this.idinventario = idinventario;
    }

    public Inventario(String idinventario, int cantidad) {
        this.idinventario = idinventario;
        this.cantidad = cantidad;
    }

    public String getIdinventario() {
        return idinventario;
    }

    public void setIdinventario(String idinventario) {
        this.idinventario = idinventario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Categorias getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Categorias idcategoria) {
        this.idcategoria = idcategoria;
    }

    public CondicionArticulos getIdcondicionarticulo() {
        return idcondicionarticulo;
    }

    public void setIdcondicionarticulo(CondicionArticulos idcondicionarticulo) {
        this.idcondicionarticulo = idcondicionarticulo;
    }

    public EstadoArticulos getIdestadoarticulo() {
        return idestadoarticulo;
    }

    public void setIdestadoarticulo(EstadoArticulos idestadoarticulo) {
        this.idestadoarticulo = idestadoarticulo;
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
        hash += (idinventario != null ? idinventario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.idinventario == null && other.idinventario != null) || (this.idinventario != null && !this.idinventario.equals(other.idinventario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idinventario ;
    }
    
}
