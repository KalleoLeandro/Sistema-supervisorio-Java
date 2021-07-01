package supervisorio.bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author kleal
 */
@Entity
@Table(name = "tempo_ligado")
@NamedQueries({
    @NamedQuery(name = "TempoLigado.findAll", query = "SELECT t FROM TempoLigado t")})
public class TempoLigado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTempo_Ligado")
    private Integer idTempoLigado;
    @Basic(optional = false)
    @Column(name = "tempo")
    private int tempo;
    @Basic(optional = false)
    @Column(name = "data")
    private String data;
    @JoinColumn(name = "Lampadas_idLampadas", referencedColumnName = "idLampadas")
    @ManyToOne(optional = false)
    private Lampadas lampadasidLampadas;

    public TempoLigado() {
    }

    public TempoLigado(Integer idTempoLigado) {
        this.idTempoLigado = idTempoLigado;
    }

    public TempoLigado(Integer idTempoLigado, int tempo, String data) {
        this.idTempoLigado = idTempoLigado;
        this.tempo = tempo;
        this.data = data;
    }

    public Integer getIdTempoLigado() {
        return idTempoLigado;
    }

    public void setIdTempoLigado(Integer idTempoLigado) {
        this.idTempoLigado = idTempoLigado;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Lampadas getLampadasidLampadas() {
        return lampadasidLampadas;
    }

    public void setLampadasidLampadas(Lampadas lampadasidLampadas) {
        this.lampadasidLampadas = lampadasidLampadas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTempoLigado != null ? idTempoLigado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TempoLigado)) {
            return false;
        }
        TempoLigado other = (TempoLigado) object;
        if ((this.idTempoLigado == null && other.idTempoLigado != null) || (this.idTempoLigado != null && !this.idTempoLigado.equals(other.idTempoLigado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TempoLigado[ idTempoLigado=" + idTempoLigado + " ]";
    }
    
}
