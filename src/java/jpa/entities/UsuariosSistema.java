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
@Table(name = "usuarios_sistema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuariosSistema.findAll", query = "SELECT u FROM UsuariosSistema u")
    , @NamedQuery(name = "UsuariosSistema.findByCedulausuario", query = "SELECT u FROM UsuariosSistema u WHERE u.cedulausuario = :cedulausuario")
    , @NamedQuery(name = "UsuariosSistema.findByNombreusuario1", query = "SELECT u FROM UsuariosSistema u WHERE u.nombreusuario1 = :nombreusuario1")
    , @NamedQuery(name = "UsuariosSistema.findByNombreusuario2", query = "SELECT u FROM UsuariosSistema u WHERE u.nombreusuario2 = :nombreusuario2")
    , @NamedQuery(name = "UsuariosSistema.findByApellidousuario1", query = "SELECT u FROM UsuariosSistema u WHERE u.apellidousuario1 = :apellidousuario1")
    , @NamedQuery(name = "UsuariosSistema.findByApellidousuario2", query = "SELECT u FROM UsuariosSistema u WHERE u.apellidousuario2 = :apellidousuario2")
    , @NamedQuery(name = "UsuariosSistema.findByEmail", query = "SELECT u FROM UsuariosSistema u WHERE u.email = :email")
    , @NamedQuery(name = "UsuariosSistema.findByUsuario", query = "SELECT u FROM UsuariosSistema u WHERE u.usuario = :usuario")
    , @NamedQuery(name = "UsuariosSistema.findByContrase\u00f1a", query = "SELECT u FROM UsuariosSistema u WHERE u.contrase\u00f1a = :contrase\u00f1a")})
public class UsuariosSistema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cedula_usuario")
    private Integer cedulausuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Nombreusuario1")
    private String nombreusuario1;
    @Size(max = 15)
    @Column(name = "Nombreusuario2")
    private String nombreusuario2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Apellidousuario1")
    private String apellidousuario1;
    @Size(max = 15)
    @Column(name = "Apellidousuario2")
    private String apellidousuario2;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Contrase\u00f1a")
    private String contraseña;
    @JoinColumn(name = "Id_documento", referencedColumnName = "Id_tipo_documento")
    @ManyToOne(optional = false)
    private TipoDocumento iddocumento;
    @JoinColumn(name = "Id_usuario", referencedColumnName = "Id_tipo_usuario")
    @ManyToOne(optional = false)
    private TipoUsuario idusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedulausuario")
    private List<Ventas> ventasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedulausuario")
    private List<Contratos> contratosList;

    public UsuariosSistema() {
    }

    public UsuariosSistema(Integer cedulausuario) {
        this.cedulausuario = cedulausuario;
    }

    public UsuariosSistema(Integer cedulausuario, String nombreusuario1, String apellidousuario1, String email, String usuario, String contraseña) {
        this.cedulausuario = cedulausuario;
        this.nombreusuario1 = nombreusuario1;
        this.apellidousuario1 = apellidousuario1;
        this.email = email;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public Integer getCedulausuario() {
        return cedulausuario;
    }

    public void setCedulausuario(Integer cedulausuario) {
        this.cedulausuario = cedulausuario;
    }

    public String getNombreusuario1() {
        return nombreusuario1;
    }

    public void setNombreusuario1(String nombreusuario1) {
        this.nombreusuario1 = nombreusuario1;
    }

    public String getNombreusuario2() {
        return nombreusuario2;
    }

    public void setNombreusuario2(String nombreusuario2) {
        this.nombreusuario2 = nombreusuario2;
    }

    public String getApellidousuario1() {
        return apellidousuario1;
    }

    public void setApellidousuario1(String apellidousuario1) {
        this.apellidousuario1 = apellidousuario1;
    }

    public String getApellidousuario2() {
        return apellidousuario2;
    }

    public void setApellidousuario2(String apellidousuario2) {
        this.apellidousuario2 = apellidousuario2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public TipoDocumento getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(TipoDocumento iddocumento) {
        this.iddocumento = iddocumento;
    }

    public TipoUsuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(TipoUsuario idusuario) {
        this.idusuario = idusuario;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulausuario != null ? cedulausuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosSistema)) {
            return false;
        }
        UsuariosSistema other = (UsuariosSistema) object;
        if ((this.cedulausuario == null && other.cedulausuario != null) || (this.cedulausuario != null && !this.cedulausuario.equals(other.cedulausuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  cedulausuario + " " + nombreusuario1 + " " + apellidousuario1 ;
    }
    
}
