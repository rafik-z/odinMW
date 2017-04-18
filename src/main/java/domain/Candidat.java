package domain;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Candidat implements Serializable{
    private String carac1;
    private String carac2;
    private String carac3;

    private Boolean estDev;

    public Candidat(){
        super();
    }

    public Candidat(String carac1, String carac2, String carac3, Boolean estDev) {
        super();
        this.carac1 = carac1;
        this.carac2 = carac2;
        this.carac3 = carac3;
        this.estDev = estDev;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(this.carac1)
                .append(this.carac2)
                .append(this.carac3)
                .append(this.estDev)
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

        final Candidat candidatAComparer = (Candidat) objet;

        return new EqualsBuilder()
                .append(this.carac1, candidatAComparer.carac1)
                .append(this.carac2, candidatAComparer.carac2)
                .append(this.carac3, candidatAComparer.carac3)
                .append(this.estDev, candidatAComparer.estDev)
                .build();
    }

    @Override
    public int hashCode(){
        return new HashCodeBuilder()
                .append(this.carac1)
                .append(this.carac2)
                .append(this.carac3)
                .append(this.estDev)
                .build();
    }

    public String getCarac1() {
        return carac1;
    }

    public void setCarac1(String carac1) {
        this.carac1 = carac1;
    }

    public String getCarac2() {
        return carac2;
    }

    public void setCarac2(String carac2) {
        this.carac2 = carac2;
    }

    public String getCarac3() {
        return carac3;
    }

    public void setCarac3(String carac3) {
        this.carac3 = carac3;
    }

    public Boolean getEstDev() {
        return estDev;
    }

    public void setEstDev(Boolean estDev) {
        this.estDev = estDev;
    }
}
