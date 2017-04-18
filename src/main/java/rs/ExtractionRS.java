package rs;

import service.ExtractionService;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;

@Transactional
@WebService
@Path("/extraction")
public class ExtractionRS {

    @EJB
    private ExtractionService extractionService;

    @POST
    @Consumes({"application/pdf"})
    @Produces(MediaType.APPLICATION_JSON)
    public Response extraireDonnees(File pdf){
        Response.ResponseBuilder builder = null;

        try {
            String donnees = extractionService.extraireDonnees(pdf);
            builder = Response.ok(donnees);
        } catch (Exception e) {
            builder = Response.status(Response.Status.BAD_REQUEST);
        }

        return builder.build();
    }
}
