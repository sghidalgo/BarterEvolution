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
@Table(name = "prorrogas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prorrogas.findAll", query = "SELECT p FROM Prorrogas p")
    , @NamedQuery(name = "Prorrogas.findByNoprorroga", query = "SELECT p FROM Prorrogas p WHERE p.noprorroga = :noprorroga")
    , @NamedQuery(name = "Prorrogas.findByFechainicioprorroga", query = "SELECT p FROM Prorrogas p WHERE p.fechainicioprorroga = :fechainicioprorroga")
    , @NamedQuery(name = "Prorrogas.findByFechavencimientoprorroga", query = "SELECT p FROM Prorrogas p WHERE p.fechavencimientoprorroga = :fechavencimientoprorroga")
    , @NamedQuery(name = "Prorrogas.findByMesesapagar", query = "SELECT p FROM Prorrogas p WHERE p.mesesapagar = :mesesapagar")
    , @NamedQuery(name = "Prorrogas.findByValormes", query = "SELECT p FROM Prorrogas p WHERE p.valormes = :valormes")
    , @NamedQuery(name = "Prorrogas.findByDiasvencidos", query = "SELECT p FROM Prorrogas p WHERE p.diasvencidos = :diasvencidos")})
public class Prorrogas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "No_prorroga")
    private String noprorroga;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_inicio_prorroga")
    @Temporal(TemporalType.DATE)
    private Date fechainicioprorroga;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_vencimiento_prorroga")
    @Temporal(TemporalType.DATE)
    private Date fechavencimientoprorroga;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Meses_a_pagar")
    private int mesesapagar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Valor_mes")
    private int valormes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Dias_vencidos")
    private int diasvencidos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "noprorroga")
    private List<Contratos> contratosList;
    @JoinColumn(name = "No_contrato", referencedColumnName = "No_contrato")
    @ManyToOne(optional = false)
    private Contratos nocontrato;

    public Prorrogas() {
    }

    public Prorrogas(String noprorroga) {
        this.noprorroga = noprorroga;
    }

    public Prorrogas(String noprorroga, Date fechainicioprorroga, Date fechavencimientoprorroga, int mesesapagar, int valormes, int diasvencidos) {
        this.noprorroga = noprorroga;
        this.fechainicioprorroga = fechainicioprorroga;
        this.fechavencimientoprorroga = fechavencimientoprorroga;
        this.mesesapagar = mesesapagar;
        this.valormes = valormes;
        this.diasvencidos = diasvencidos;
    }

    public String getNoprorroga() {
        return noprorroga;
    }

    public void setNoprorroga(String noprorroga) {
        this.noprorroga = noprorroga;
    }

    public Date getFechainicioprorroga() {
        return fechainicioprorroga;
    }

    public void setFechainicioprorroga(Date fechainicioprorroga) {
        this.fechainicioprorroga = fechainicioprorroga;
    }

    public Date getFechavencimientoprorroga() {
        return fechavencimientoprorroga;
    }

    public void setFechavencimientoprorroga(Date fechavencimientoprorroga) {
        this.fechavencimientoprorroga = fechavencimientoprorroga;
    }

    public int getMesesapagar() {
        return mesesapagar;
    }

    public void setMesesapagar(int mesesapagar) {
        this.mesesapagar = mesesapagar;
    }

    public int getValormes() {
        return valormes;
    }

    public void setValormes(int valormes) {
        this.valormes = valormes;
    }

    public int getDiasvencidos() {
        return diasvencidos;
    }

    public void setDiasvencidos(int diasvencidos) {
        this.diasvencidos = diasvencidos;
    }

    @XmlTransient
    public List<Contratos> getContratosList() {
        return contratosList;
    }

    public void setContratosList(List<Contratos> contratosList) {
        this.contratosList = contratosList;
    }

    public Contratos getNocontrato() {
        return nocontrato;
    }

    public void setNocontrato(Contratos nocontrato) {
        this.nocontrato = nocontrato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noprorroga != null ? noprorroga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prorrogas)) {
            return false;
        }
        Prorrogas other = (Prorrogas) object;
        if ((this.noprorroga == null && other.noprorroga != null) || (this.noprorroga != null && !this.noprorroga.equals(other.noprorroga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  noprorroga ;
    }
    
}
