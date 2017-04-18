package dao;

import domain.Caracteristique;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CaracteristiquesDAO {
    @PersistenceContext
    private EntityManager em;

    public void ajouter(final Caracteristique elt){
            em.persist(elt);
    }

    public void supprimer(final Integer index){

    }

    public List<Caracteristique> recupererCaracteristiques(){
        final String jpqlQuery = "SELECT c FROM Caracteristique c";
        final TypedQuery<Caracteristique> query = em.createQuery(jpqlQuery, Caracteristique.class);
        final List<Caracteristique> caracteristiquesTrouvees = query.getResultList();
        return caracteristiquesTrouvees;

    }
}
