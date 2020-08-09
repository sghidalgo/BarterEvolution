/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c")
    , @NamedQuery(name = "Clientes.findByCedulacliente", query = "SELECT c FROM Clientes c WHERE c.cedulacliente = :cedulacliente")
    , @NamedQuery(name = "Clientes.findByNombrecliente1", query = "SELECT c FROM Clientes c WHERE c.nombrecliente1 = :nombrecliente1")
    , @NamedQuery(name = "Clientes.findByNombrecliente2", query = "SELECT c FROM Clientes c WHERE c.nombrecliente2 = :nombrecliente2")
    , @NamedQuery(name = "Clientes.findByApellidocliente1", query = "SELECT c FROM Clientes c WHERE c.apellidocliente1 = :apellidocliente1")
    , @NamedQuery(name = "Clientes.findByApellidocliente2", query = "SELECT c FROM Clientes c WHERE c.apellidocliente2 = :apellidocliente2")
    , @NamedQuery(name = "Clientes.findByTelefonomovil", query = "SELECT c FROM Clientes c WHERE c.telefonomovil = :telefonomovil")
    , @NamedQuery(name = "Clientes.findByEmail", query = "SELECT c FROM Clientes c WHERE c.email = :email")
    , @NamedQuery(name = "Clientes.findByDireccionresidencia", query = "SELECT c FROM Clientes c WHERE c.direccionresidencia = :direccionresidencia")
    , @NamedQuery(name = "Clientes.findByCiudad", query = "SELECT c FROM Clientes c WHERE c.ciudad = :ciudad")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cedula_cliente")
    private Integer cedulacliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Nombrecliente1")
    private String nombrecliente1;
    @Size(max = 15)
    @Column(name = "Nombrecliente2")
    private String nombrecliente2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Apellidocliente1")
    private String apellidocliente1;
    @Size(max = 15)
    @Column(name = "Apellidocliente2")
    private String apellidocliente2;
    @Column(name = "Telefono_movil")
    private BigInteger telefonomovil;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 35)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Direccion_residencia")
    private String direccionresidencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Ciudad")
    private String ciudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedulacliente")
    private List<LegalidadArticulos> legalidadArticulosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedulacliente")
    private List<Ventas> ventasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedulacliente")
    private List<Contratos> contratosList;
    @JoinColumn(name = "Id_documento", referencedColumnName = "Id_tipo_documento")
    @ManyToOne(optional = false)
    private TipoDocumento iddocumento;
    @JoinColumn(name = "Genero", referencedColumnName = "idGenero")
    @ManyToOne(optional = false)
    private Genero genero;
    @JoinColumn(name = "Id_localidad", referencedColumnName = "Id_localidad")
    @ManyToOne(optional = false)
    private Localidad idlocalidad;
    @JoinColumn(name = "Id_tipocliente", referencedColumnName = "Id_tipocliente")
    @ManyToOne(optional = false)
    private TipoCliente idtipocliente;

    public Clientes() {
    }

    public Clientes(Integer cedulacliente) {
        this.cedulacliente = cedulacliente;
    }

    public Clientes(Integer cedulacliente, String nombrecliente1, String apellidocliente1, String direccionresidencia, String ciudad) {
        this.cedulacliente = cedulacliente;
        this.nombrecliente1 = nombrecliente1;
        this.apellidocliente1 = apellidocliente1;
        this.direccionresidencia = direccionresidencia;
        this.ciudad = ciudad;
    }

    public Integer getCedulacliente() {
        return cedulacliente;
    }

    public void setCedulacliente(Integer cedulacliente) {
        this.cedulacliente = cedulacliente;
    }

    public String getNombrecliente1() {
        return nombrecliente1;
    }

    public void setNombrecliente1(String nombrecliente1) {
        this.nombrecliente1 = nombrecliente1;
    }

    public String getNombrecliente2() {
        return nombrecliente2;
    }

    public void setNombrecliente2(String nombrecliente2) {
        this.nombrecliente2 = nombrecliente2;
    }

    public String getApellidocliente1() {
        return apellidocliente1;
    }

    public void setApellidocliente1(String apellidocliente1) {
        this.apellidocliente1 = apellidocliente1;
    }

    public String getApellidocliente2() {
        return apellidocliente2;
    }

    public void setApellidocliente2(String apellidocliente2) {
        this.apellidocliente2 = apellidocliente2;
    }

    public BigInteger getTelefonomovil() {
        return telefonomovil;
    }

    public void setTelefonomovil(BigInteger telefonomovil) {
        this.telefonomovil = telefonomovil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccionresidencia() {
        return direccionresidencia;
    }

    public void setDireccionresidencia(String direccionresidencia) {
        this.direccionresidencia = direccionresidencia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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

    public TipoDocumento getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(TipoDocumento iddocumento) {
        this.iddocumento = iddocumento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Localidad getIdlocalidad() {
        return idlocalidad;
    }

    public void setIdlocalidad(Localidad idlocalidad) {
        this.idlocalidad = idlocalidad;
    }

    public TipoCliente getIdtipocliente() {
        return idtipocliente;
    }

    public void setIdtipocliente(TipoCliente idtipocliente) {
        this.idtipocliente = idtipocliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulacliente != null ? cedulacliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.cedulacliente == null && other.cedulacliente != null) || (this.cedulacliente != null && !this.cedulacliente.equals(other.cedulacliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return cedulacliente + " " + nombrecliente1 + " " + apellidocliente1 ;
    }
    
}
