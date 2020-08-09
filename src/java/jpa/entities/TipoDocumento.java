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
@Table(name = "tipo_documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t")
    , @NamedQuery(name = "TipoDocumento.findByIdtipodocumento", query = "SELECT t FROM TipoDocumento t WHERE t.idtipodocumento = :idtipodocumento")
    , @NamedQuery(name = "TipoDocumento.findByTipodocumento", query = "SELECT t FROM TipoDocumento t WHERE t.tipodocumento = :tipodocumento")})
public class TipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Id_tipo_documento")
    private String idtipodocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 22)
    @Column(name = "Tipo_documento")
    private String tipodocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddocumento")
    private List<UsuariosSistema> usuariosSistemaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddocumento")
    private List<Clientes> clientesList;

    public TipoDocumento() {
    }

    public TipoDocumento(String idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
    }

    public TipoDocumento(String idtipodocumento, String tipodocumento) {
        this.idtipodocumento = idtipodocumento;
        this.tipodocumento = tipodocumento;
    }

    public String getIdtipodocumento() {
        return idtipodocumento;
    }

    public void setIdtipodocumento(String idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    @XmlTransient
    public List<UsuariosSistema> getUsuariosSistemaList() {
        return usuariosSistemaList;
    }

    public void setUsuariosSistemaList(List<UsuariosSistema> usuariosSistemaList) {
        this.usuariosSistemaList = usuariosSistemaList;
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
        hash += (idtipodocumento != null ? idtipodocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.idtipodocumento == null && other.idtipodocumento != null) || (this.idtipodocumento != null && !this.idtipodocumento.equals(other.idtipodocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tipodocumento ;
    }
    
}
