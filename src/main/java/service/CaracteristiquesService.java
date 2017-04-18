package service;

import dao.CaracteristiquesDAO;
import domain.Caracteristique;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CaracteristiquesService {

    @EJB
    private CaracteristiquesDAO caracteristiquesDAO;

    public void ajouterCaracteristique(final Caracteristique caracteristiqueAAjouter){
        caracteristiquesDAO.ajouter(caracteristiqueAAjouter);
    }

    public void supprimerCaracteristique(final Integer index){
        caracteristiquesDAO.supprimer(index);
    }

    public List<Caracteristique> recupererListeCaracteristiques(){
        return caracteristiquesDAO.recupererCaracteristiques();
    }
}