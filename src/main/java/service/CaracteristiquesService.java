package service;

import dao.CaracteristiquesDAO;
import domain.Caracteristique;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import java.util.List;

@Stateless
public class CaracteristiquesService {

    @EJB
    private CaracteristiquesDAO caracteristiquesDAO;

    public void ajouterCaracteristique(final Caracteristique caracteristiqueAAjouter){
        caracteristiquesDAO.ajouter(caracteristiqueAAjouter);
    }

    public void supprimerCaracteristique(final String caracteristique){
        final Caracteristique carac = this.recupererUneCaracteristique(caracteristique);
        caracteristiquesDAO.supprimer(carac);
    }

    public List<Caracteristique> recupererListeCaracteristiques(){
        return caracteristiquesDAO.recupererCaracteristiques();
    }

    public Caracteristique recupererUneCaracteristique(final String denominationATrouver) throws NoResultException{
        return caracteristiquesDAO.recupererUneCaracteristique(denominationATrouver);
    }

}