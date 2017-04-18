package rs;

import domain.Caracteristique;
import service.CaracteristiquesService;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Transactional
@WebService
@Path("/")
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response supprimerCaracteristique(final String index){
        Response.ResponseBuilder builder = null;

        Integer caracteristiqueASupprimer = Integer.parseInt(index);

        try {
            caracteristiquesService.supprimerCaracteristique(caracteristiqueASupprimer);
            builder = Response.ok();
        } catch (Exception e) {
            builder = Response.status(Response.Status.BAD_REQUEST);
        }

        return builder.build();
    }


}
