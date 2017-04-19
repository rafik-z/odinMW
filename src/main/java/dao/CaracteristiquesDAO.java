package dao;

import domain.Caracteristique;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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

    public void supprimer(final Caracteristique caracteristique){
        em.remove(caracteristique);

    }

    public List<Caracteristique> recupererCaracteristiques(){
        final String jpqlQuery = "SELECT c FROM Caracteristique c";
        final TypedQuery<Caracteristique> query = em.createQuery(jpqlQuery, Caracteristique.class);
        final List<Caracteristique> caracteristiquesTrouvees = query.getResultList();
        return caracteristiquesTrouvees;

    }

    public Caracteristique recupererUneCaracteristique(final String denominationATrouver) throws NoResultException{

        final String JPQLQuery = "SELECT c FROM Caracteristique c WHERE c.denomination LIKE :denomination";

        final TypedQuery<Caracteristique> query = em.createQuery(JPQLQuery, Caracteristique.class);

        query.setParameter("denomination", denominationATrouver);

        final Caracteristique caracteristique = query.getSingleResult();

        if (caracteristique == null){
            throw new NoResultException();
        }

        return caracteristique;
    }
}
