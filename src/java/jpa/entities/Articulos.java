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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "articulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulos.findAll", query = "SELECT a FROM Articulos a")
    , @NamedQuery(name = "Articulos.findByIdArticulo", query = "SELECT a FROM Articulos a WHERE a.idArticulo = :idArticulo")
    , @NamedQuery(name = "Articulos.findByNombrearticulo", query = "SELECT a FROM Articulos a WHERE a.nombrearticulo = :nombrearticulo")
    , @NamedQuery(name = "Articulos.findBySerie", query = "SELECT a FROM Articulos a WHERE a.serie = :serie")
    , @NamedQuery(name = "Articulos.findByModelo", query = "SELECT a FROM Articulos a WHERE a.modelo = :modelo")
    , @NamedQuery(name = "Articulos.findByMarca", query = "SELECT a FROM Articulos a WHERE a.marca = :marca")
    , @NamedQuery(name = "Articulos.findByPreciounitario", query = "SELECT a FROM Articulos a WHERE a.preciounitario = :preciounitario")
    , @NamedQuery(name = "Articulos.findByDescripcion", query = "SELECT a FROM Articulos a WHERE a.descripcion = :descripcion")})
public class Articulos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "IdArticulo")
    private String idArticulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Nombre_articulo")
    private String nombrearticulo;
    @Size(max = 20)
    @Column(name = "Serie")
    private String serie;
    @Size(max = 15)
    @Column(name = "Modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Precio_unitario")
    private int preciounitario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Descripcion")
    private String descripcion;
    @JoinColumn(name = "Genero", referencedColumnName = "idGenero")
    @ManyToOne
    private Genero genero;
    @JoinColumn(name = "Id_categoria", referencedColumnName = "Id_categoria")
    @ManyToOne(optional = false)
    private Categorias idcategoria;
    @JoinColumn(name = "Id_estado_articulo", referencedColumnName = "Id_estado_articulo")
    @ManyToOne(optional = false)
    private EstadoArticulos idestadoarticulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idarticulo")
    private List<LegalidadArticulos> legalidadArticulosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idarticulo")
    private List<Ventas> ventasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idarticulo")
    private List<Contratos> contratosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idarticulo")
    private List<Inventario> inventarioList;

    public Articulos() {
    }

    public Articulos(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Articulos(String idArticulo, String nombrearticulo, String marca, int preciounitario, String descripcion) {
        this.idArticulo = idArticulo;
        this.nombrearticulo = nombrearticulo;
        this.marca = marca;
        this.preciounitario = preciounitario;
        this.descripcion = descripcion;
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombrearticulo() {
        return nombrearticulo;
    }

    public void setNombrearticulo(String nombrearticulo) {
        this.nombrearticulo = nombrearticulo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(int preciounitario) {
        this.preciounitario = preciounitario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Categorias getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Categorias idcategoria) {
        this.idcategoria = idcategoria;
    }

    public EstadoArticulos getIdestadoarticulo() {
        return idestadoarticulo;
    }

    public void setIdestadoarticulo(EstadoArticulos idestadoarticulo) {
        this.idestadoarticulo = idestadoarticulo;
    }

    @XmlTransient
    public List<LegalidadArticulos> getLegalidadArticulosList() {
        return legalidadArticulosList;
    }

    public void setLegalidadArticulosList(List<LegalidadArticulos> legalidadArticulosList) {
        this.legalidadArticulosList = legalidadArticulosList;
    }

    @XmlTransient
    public List<Ventas> getVentasList() {
        return ventasList;
    }

    public void setVentasList(List<Ventas> ventasList) {
        this.ventasList = ventasList;
    }

    @XmlTransient
    public List<Contratos> getContratosList() {
        return contratosList;
    }

    public void setContratosList(List<Contratos> contratosList) {
        this.contratosList = contratosList;
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
        hash += (idArticulo != null ? idArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulos)) {
            return false;
        }
        Articulos other = (Articulos) object;
        if ((this.idArticulo == null && other.idArticulo != null) || (this.idArticulo != null && !this.idArticulo.equals(other.idArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idArticulo ;
    }
    
}
