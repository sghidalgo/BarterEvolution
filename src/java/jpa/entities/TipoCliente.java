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
@Table(name = "tipo_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCliente.findAll", query = "SELECT t FROM TipoCliente t")
    , @NamedQuery(name = "TipoCliente.findByIdtipocliente", query = "SELECT t FROM TipoCliente t WHERE t.idtipocliente = :idtipocliente")
    , @NamedQuery(name = "TipoCliente.findByNombretipocliente", query = "SELECT t FROM TipoCliente t WHERE t.nombretipocliente = :nombretipocliente")})
public class TipoCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Id_tipocliente")
    private String idtipocliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Nombre_tipocliente")
    private String nombretipocliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipocliente")
    private List<Clientes> clientesList;

    public TipoCliente() {
    }

    public TipoCliente(String idtipocliente) {
        this.idtipocliente = idtipocliente;
    }

    public TipoCliente(String idtipocliente, String nombretipocliente) {
        this.idtipocliente = idtipocliente;
        this.nombretipocliente = nombretipocliente;
    }

    public String getIdtipocliente() {
        return idtipocliente;
    }

    public void setIdtipocliente(String idtipocliente) {
        this.idtipocliente = idtipocliente;
    }

    public String getNombretipocliente() {
        return nombretipocliente;
    }

    public void setNombretipocliente(String nombretipocliente) {
        this.nombretipocliente = nombretipocliente;
    }

    @XmlTransient
    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipocliente != null ? idtipocliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCliente)) {
            return false;
        }
        TipoCliente other = (TipoCliente) object;
        if ((this.idtipocliente == null && other.idtipocliente != null) || (this.idtipocliente != null && !this.idtipocliente.equals(other.idtipocliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombretipocliente ;
    }
    
}
