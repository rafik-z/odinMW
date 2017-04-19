package rs;

import domain.Caracteristique;
import service.CaracteristiquesService;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Transactional
@WebService
@Path("/caracteristique")
public class CaracteristiqueRS {

    @EJB
    private CaracteristiquesService caracteristiquesService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response recupererListeCaracteristiques(){
        Response.ResponseBuilder builder = null;

        try {
            final List<Caracteristique> listeCaracteristiques = caracteristiquesService.recupererListeCaracteristiques();
            builder = Response.ok(listeCaracteristiques);
        } catch (Exception e){
            builder = Response.status(Response.Status.BAD_REQUEST);
        }

        return builder.build();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ajouterCaracteristique(final Caracteristique caracteristiqueAAjouter){
        Response.ResponseBuilder builder = null;


        try {
            caracteristiquesService.ajouterCaracteristique(caracteristiqueAAjouter);
            builder = Response.ok();
        } catch (Exception e) {
            builder = Response.status(Response.Status.BAD_REQUEST);
        }

        return builder.build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path ( "/{caracteristiqueASupprimer}" )
    public Response supprimerCaracteristique(@PathParam("caracteristiqueASupprimer") final String denomination){
        Response.ResponseBuilder builder = null;

        try {
            this.caracteristiquesService.supprimerCaracteristique(denomination);
            builder = Response.ok("Supprimé");
        } catch (NoResultException e) {
            builder = Response.status(Response.Status.NO_CONTENT);
        }

        return builder.build();
    }

}
