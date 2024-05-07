//@author Senadi Illeperuma
//IIT no: 20220678 

package resource;

import dao.PrescriptionDAO;
import model.Prescription;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;


@Path("/prescriptions")
public class PrescriptionResource {
    private final PrescriptionDAO prescriptionDAO;

    public PrescriptionResource() {
        this.prescriptionDAO = new PrescriptionDAO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //retrieve all prescriptions from the system
    public Response getAllPrescriptions() {
        ArrayList<Prescription> prescriptions = prescriptionDAO.getAllPrescriptions();
        return Response.ok().entity(prescriptions).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{prescriptionID}")
    //retrieves a prescription by its ID from the system
    public Response getPrescriptionID(@PathParam("prescriptionID") int prescriptionID) {
       Prescription prescription = prescriptionDAO.getPrescriptionID(prescriptionID);
        if (prescription != null) {
            return Response.ok().entity(prescription).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Prescription details not found in the system... ").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    //creates a new prescription
    public Response createPrescription(Prescription prescription) {
        prescriptionDAO.createPrescription(prescription);
        return Response.status(Response.Status.CREATED)
                .entity("Prescription details added successfully to the system... ")
                .build();

    }

    @PUT
    @Path("/{prescriptionID}")
    @Consumes(MediaType.APPLICATION_JSON)
    //updates a current prescription
    public Response updatePrescription(@PathParam("prescriptionID") int prescriptionID, Prescription updatedPrescription) {
        Prescription currentPrescription = prescriptionDAO.getPrescriptionID(prescriptionID);
        if (currentPrescription != null) {
           prescriptionDAO.updatePrescription(prescriptionID, updatedPrescription);
            return Response.ok().entity("Prescription details updated successfully to the system... ").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Prescription details not found in the system... ").build();
        }
    }

    @DELETE
    @Path("/{prescriptionID}")
    //deletes a current prescription
    public Response deletePrescription(@PathParam("prescriptionID") int prescriptionID) {
        Prescription currentPrescription = prescriptionDAO.getPrescriptionID(prescriptionID);
        if (currentPrescription != null) {
           prescriptionDAO.deletePrescription(prescriptionID);
            return Response.ok()
                    .entity("Prescription details deleted successfully from the system... ")
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Prescription details not found in the system... ").build();
        }

    }


}
