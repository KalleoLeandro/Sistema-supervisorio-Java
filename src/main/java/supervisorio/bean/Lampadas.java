package supervisorio.bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kleal
 */
@Entity
@Table(name = "lampadas")
@NamedQueries({
    @NamedQuery(name = "Lampadas.findAll", query = "SELECT l FROM Lampadas l")})
public class Lampadas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLampadas")
    private Integer idLampadas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lampadasidLampadas")
    private List<TempoLigado> tempoLigadoList;

    public Lampadas() {
    }

    public Lampadas(Integer idLampadas) {
        this.idLampadas = idLampadas;
    }

    public Integer getIdLampadas() {
        return idLampadas;
    }

    public void setIdLampadas(Integer idLampadas) {
        this.idLampadas = idLampadas;
    }

    public List<TempoLigado> getTempoLigadoList() {
        return tempoLigadoList;
    }

    public void setTempoLigadoList(List<TempoLigado> tempoLigadoList) {
        this.tempoLigadoList = tempoLigadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLampadas != null ? idLampadas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lampadas)) {
            return false;
        }
        Lampadas other = (Lampadas) object;
        if ((this.idLampadas == null && other.idLampadas != null) || (this.idLampadas != null && !this.idLampadas.equals(other.idLampadas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Lampadas[ idLampadas=" + idLampadas + " ]";
    }
    
}
