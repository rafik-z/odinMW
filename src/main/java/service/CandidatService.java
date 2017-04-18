package service;

import dao.CaracteristiquesDAO;
import domain.Candidat;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CandidatService {

    public Candidat genererCandidat(){

        Candidat candidatGenere = new Candidat();

        return candidatGenere;

    }



}
