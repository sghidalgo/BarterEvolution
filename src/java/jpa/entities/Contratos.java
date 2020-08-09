/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cristian Delgadillo
 */
@Entity
@Table(name = "contratos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contratos.findAll", query = "SELECT c FROM Contratos c")
    , @NamedQuery(name = "Contratos.findByNocontrato", query = "SELECT c FROM Contratos c WHERE c.nocontrato = :nocontrato")
    , @NamedQuery(name = "Contratos.findByFechainicio", query = "SELECT c FROM Contratos c WHERE c.fechainicio = :fechainicio")
    , @NamedQuery(name = "Contratos.findByFechavencimiento", query = "SELECT c FROM Contratos c WHERE c.fechavencimiento = :fechavencimiento")
    , @NamedQuery(name = "Contratos.findByFechapago", query = "SELECT c FROM Contratos c WHERE c.fechapago = :fechapago")
    , @NamedQuery(name = "Contratos.findByPlazoestipulado", query = "SELECT c FROM Contratos c WHERE c.plazoestipulado = :plazoestipulado")
    , @NamedQuery(name = "Contratos.findByValorcontrato", query = "SELECT c FROM Contratos c WHERE c.valorcontrato = :valorcontrato")})
public class Contratos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "No_contrato")
    private String nocontrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechavencimiento;
    @Column(name = "Fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date fechapago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Plazo_estipulado")
    private int plazoestipulado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Valor_contrato")
    private int valorcontrato;
    @JoinColumn(name = "Cedula_cliente", referencedColumnName = "Cedula_cliente")
    @ManyToOne(optional = false)
    private Clientes cedulacliente;
    @JoinColumn(name = "Id_condicion_contrato", referencedColumnName = "Id_condicion_contrato")
    @ManyToOne(optional = false)
    private CondicionContratos idcondicioncontrato;
    @JoinColumn(name = "Cedula_usuario", referencedColumnName = "Cedula_usuario")
    @ManyToOne(optional = false)
    private UsuariosSistema cedulausuario;
    @JoinColumn(name = "Id_articulo", referencedColumnName = "IdArticulo")
    @ManyToOne(optional = false)
    private Articulos idarticulo;
    @JoinColumn(name = "No_prorroga", referencedColumnName = "No_prorroga")
    @ManyToOne(optional = false)
    private Prorrogas noprorroga;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nocontrato")
    private List<Prorrogas> prorrogasList;

    public Contratos() {
    }

    public Contratos(String nocontrato) {
        this.nocontrato = nocontrato;
    }

    public Contratos(String nocontrato, Date fechainicio, Date fechavencimiento, int plazoestipulado, int valorcontrato) {
        this.nocontrato = nocontrato;
        this.fechainicio = fechainicio;
        this.fechavencimiento = fechavencimiento;
        this.plazoestipulado = plazoestipulado;
        this.valorcontrato = valorcontrato;
    }

    public String getNocontrato() {
        return nocontrato;
    }

    public void setNocontrato(String nocontrato) {
        this.nocontrato = nocontrato;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public int getPlazoestipulado() {
        return plazoestipulado;
    }

    public void setPlazoestipulado(int plazoestipulado) {
        this.plazoestipulado = plazoestipulado;
    }

    public int getValorcontrato() {
        return valorcontrato;
    }

    public void setValorcontrato(int valorcontrato) {
        this.valorcontrato = valorcontrato;
    }

    public Clientes getCedulacliente() {
        return cedulacliente;
    }

    public void setCedulacliente(Clientes cedulacliente) {
        this.cedulacliente = cedulacliente;
    }

    public CondicionContratos getIdcondicioncontrato() {
        return idcondicioncontrato;
    }

    public void setIdcondicioncontrato(CondicionContratos idcondicioncontrato) {
        this.idcondicioncontrato = idcondicioncontrato;
    }

    public UsuariosSistema getCedulausuario() {
        return cedulausuario;
    }

    public void setCedulausuario(UsuariosSistema cedulausuario) {
        this.cedulausuario = cedulausuario;
    }

    public Articulos getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(Articulos idarticulo) {
        this.idarticulo = idarticulo;
    }

    public Prorrogas getNoprorroga() {
        return noprorroga;
    }

    public void setNoprorroga(Prorrogas noprorroga) {
        this.noprorroga = noprorroga;
    }

    @XmlTransient
    public List<Prorrogas> getProrrogasList() {
        return prorrogasList;
    }

    public void setProrrogasList(List<Prorrogas> prorrogasList) {
        this.prorrogasList = prorrogasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nocontrato != null ? nocontrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contratos)) {
            return false;
        }
        Contratos other = (Contratos) object;
        if ((this.nocontrato == null && other.nocontrato != null) || (this.nocontrato != null && !this.nocontrato.equals(other.nocontrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  nocontrato ;
    }
    
}
