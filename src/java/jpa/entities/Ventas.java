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
@Table(name = "ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v")
    , @NamedQuery(name = "Ventas.findByNofactura", query = "SELECT v FROM Ventas v WHERE v.nofactura = :nofactura")
    , @NamedQuery(name = "Ventas.findByFechafactura", query = "SELECT v FROM Ventas v WHERE v.fechafactura = :fechafactura")
    , @NamedQuery(name = "Ventas.findByPreciounitario", query = "SELECT v FROM Ventas v WHERE v.preciounitario = :preciounitario")
    , @NamedQuery(name = "Ventas.findByCantidad", query = "SELECT v FROM Ventas v WHERE v.cantidad = :cantidad")
    , @NamedQuery(name = "Ventas.findBySubTotal", query = "SELECT v FROM Ventas v WHERE v.subTotal = :subTotal")
    , @NamedQuery(name = "Ventas.findByIva", query = "SELECT v FROM Ventas v WHERE v.iva = :iva")
    , @NamedQuery(name = "Ventas.findByValorTotal", query = "SELECT v FROM Ventas v WHERE v.valorTotal = :valorTotal")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "No_factura")
    private String nofactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_factura")
    @Temporal(TemporalType.DATE)
    private Date fechafactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Precio_unitario")
    private int preciounitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUB_TOTAL")
    private int subTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IVA")
    private float iva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_TOTAL")
    private int valorTotal;
    @JoinColumn(name = "Id_articulo", referencedColumnName = "IdArticulo")
    @ManyToOne(optional = false)
    private Articulos idarticulo;
    @JoinColumn(name = "Cedula_cliente", referencedColumnName = "Cedula_cliente")
    @ManyToOne(optional = false)
    private Clientes cedulacliente;
    @JoinColumn(name = "Cedula_usuario", referencedColumnName = "Cedula_usuario")
    @ManyToOne(optional = false)
    private UsuariosSistema cedulausuario;
    @JoinColumn(name = "Id_estado_articulo", referencedColumnName = "Id_estado_articulo")
    @ManyToOne(optional = false)
    private EstadoArticulos idestadoarticulo;

    public Ventas() {
    }

    public Ventas(String nofactura) {
        this.nofactura = nofactura;
    }

    public Ventas(String nofactura, Date fechafactura, int preciounitario, int cantidad, int subTotal, float iva, int valorTotal) {
        this.nofactura = nofactura;
        this.fechafactura = fechafactura;
        this.preciounitario = preciounitario;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
        this.iva = iva;
        this.valorTotal = valorTotal;
    }

    public String getNofactura() {
        return nofactura;
    }

    public void setNofactura(String nofactura) {
        this.nofactura = nofactura;
    }

    public Date getFechafactura() {
        return fechafactura;
    }

    public void setFechafactura(Date fechafactura) {
        this.fechafactura = fechafactura;
    }

    public int getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(int preciounitario) {
        this.preciounitario = preciounitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Articulos getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(Articulos idarticulo) {
        this.idarticulo = idarticulo;
    }

    public Clientes getCedulacliente() {
        return cedulacliente;
    }

    public void setCedulacliente(Clientes cedulacliente) {
        this.cedulacliente = cedulacliente;
    }

    public UsuariosSistema getCedulausuario() {
        return cedulausuario;
    }

    public void setCedulausuario(UsuariosSistema cedulausuario) {
        this.cedulausuario = cedulausuario;
    }

    public EstadoArticulos getIdestadoarticulo() {
        return idestadoarticulo;
    }

    public void setIdestadoarticulo(EstadoArticulos idestadoarticulo) {
        this.idestadoarticulo = idestadoarticulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nofactura != null ? nofactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.nofactura == null && other.nofactura != null) || (this.nofactura != null && !this.nofactura.equals(other.nofactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nofactura ;
    }
    
}
