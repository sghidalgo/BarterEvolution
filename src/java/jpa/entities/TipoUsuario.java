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
@Table(name = "tipo_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoUsuario.findAll", query = "SELECT t FROM TipoUsuario t")
    , @NamedQuery(name = "TipoUsuario.findByIdtipousuario", query = "SELECT t FROM TipoUsuario t WHERE t.idtipousuario = :idtipousuario")
    , @NamedQuery(name = "TipoUsuario.findByNombretipous", query = "SELECT t FROM TipoUsuario t WHERE t.nombretipous = :nombretipous")})
public class TipoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Id_tipo_usuario")
    private String idtipousuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Nombre_tipous")
    private String nombretipous;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private List<UsuariosSistema> usuariosSistemaList;

    public TipoUsuario() {
    }

    public TipoUsuario(String idtipousuario) {
        this.idtipousuario = idtipousuario;
    }

    public TipoUsuario(String idtipousuario, String nombretipous) {
        this.idtipousuario = idtipousuario;
        this.nombretipous = nombretipous;
    }

    public String getIdtipousuario() {
        return idtipousuario;
    }

    public void setIdtipousuario(String idtipousuario) {
        this.idtipousuario = idtipousuario;
    }

    public String getNombretipous() {
        return nombretipous;
    }

    public void setNombretipous(String nombretipous) {
        this.nombretipous = nombretipous;
    }

    @XmlTransient
    public List<UsuariosSistema> getUsuariosSistemaList() {
        return usuariosSistemaList;
    }

    public void setUsuariosSistemaList(List<UsuariosSistema> usuariosSistemaList) {
        this.usuariosSistemaList = usuariosSistemaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipousuario != null ? idtipousuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoUsuario)) {
            return false;
        }
        TipoUsuario other = (TipoUsuario) object;
        if ((this.idtipousuario == null && other.idtipousuario != null) || (this.idtipousuario != null && !this.idtipousuario.equals(other.idtipousuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombretipous ;
    }
    
}
