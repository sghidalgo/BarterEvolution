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
@Table(name = "condicion_contratos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CondicionContratos.findAll", query = "SELECT c FROM CondicionContratos c")
    , @NamedQuery(name = "CondicionContratos.findByIdcondicioncontrato", query = "SELECT c FROM CondicionContratos c WHERE c.idcondicioncontrato = :idcondicioncontrato")
    , @NamedQuery(name = "CondicionContratos.findByNombrecondicioncon", query = "SELECT c FROM CondicionContratos c WHERE c.nombrecondicioncon = :nombrecondicioncon")})
public class CondicionContratos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Id_condicion_contrato")
    private String idcondicioncontrato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    @Column(name = "Nombre_condicioncon")
    private String nombrecondicioncon;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcondicioncontrato")
    private List<Contratos> contratosList;

    public CondicionContratos() {
    }

    public CondicionContratos(String idcondicioncontrato) {
        this.idcondicioncontrato = idcondicioncontrato;
    }

    public CondicionContratos(String idcondicioncontrato, String nombrecondicioncon) {
        this.idcondicioncontrato = idcondicioncontrato;
        this.nombrecondicioncon = nombrecondicioncon;
    }

    public String getIdcondicioncontrato() {
        return idcondicioncontrato;
    }

    public void setIdcondicioncontrato(String idcondicioncontrato) {
        this.idcondicioncontrato = idcondicioncontrato;
    }

    public String getNombrecondicioncon() {
        return nombrecondicioncon;
    }

    public void setNombrecondicioncon(String nombrecondicioncon) {
        this.nombrecondicioncon = nombrecondicioncon;
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
        hash += (idcondicioncontrato != null ? idcondicioncontrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CondicionContratos)) {
            return false;
        }
        CondicionContratos other = (CondicionContratos) object;
        if ((this.idcondicioncontrato == null && other.idcondicioncontrato != null) || (this.idcondicioncontrato != null && !this.idcondicioncontrato.equals(other.idcondicioncontrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombrecondicioncon;
    }
    
}
