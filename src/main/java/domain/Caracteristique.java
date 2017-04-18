package domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@Entity
@Table(name="T_CARACTERISTIQUES")
@XmlRootElement
public class Caracteristique implements Serializable{
    private String denomination;
    private Boolean competenceDev;

    public Caracteristique(){
        super();
    }
    public Caracteristique(String denomination, Boolean competenceDev) {
        super();
        this.denomination = denomination.toLowerCase();
        this.competenceDev = competenceDev;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this)
                .append(this.denomination)
                .append(this.competenceDev)
                .build();
    }

    @Override
    public boolean equals(final Object objet){
        if(this == objet){
            return true;
        }

        if(objet == null || !(objet instanceof Candidat)){
            return false;
        }

        final Caracteristique caracteristiqueAComparer = (Caracteristique) objet;

        return new EqualsBuilder()
                .append(this.denomination, caracteristiqueAComparer.denomination)
                .append(this.competenceDev, caracteristiqueAComparer.competenceDev)
                .build();
    }

    @Override
    public int hashCode(){
        return new HashCodeBuilder()
                .append(this.competenceDev)
                .append(this.denomination)
                .build();
    }

    @Id
    @Column(name="CAR_DENOMINATION")
    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    @Column(name="CAR_COMPETENCEDEV")
    public Boolean getCompetenceDev() {
        return competenceDev;
    }

    public void setCompetenceDev(Boolean competenceDev) {
        this.competenceDev = competenceDev;
    }
}
