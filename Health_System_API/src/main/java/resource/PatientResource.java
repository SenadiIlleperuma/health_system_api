//@author Senadi Illeperuma
//IIT no: 20220678 

package resource;

import dao.PatientDAO;
import model.Patient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/patients")
public class PatientResource {

    private final PatientDAO patientDAO;

    public PatientResource() {
        this.patientDAO = new PatientDAO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //retrieves all patients from the system
    public Response getAllPatients() {
        ArrayList<Patient> patients = patientDAO.getAllPatients();
        return Response.ok().entity(patients).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    //retrieves a patient by its ID from the system
    public Response getByID(@PathParam("id") int id) {
        Patient patient = patientDAO.getPatientID(id);
        if (patient != null) {
            return Response.ok().entity(patient).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Patient details not found in the system... ")
                    .build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    //adds a new patient
    public Response addPatient(Patient patient) {
        patientDAO.addPatient(patient);
        return Response.status(Response.Status.CREATED)
                .entity("Patient details added successfully to the system... ")
                .build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    //updates an current patient
    public Response updatePatient(@PathParam("id") int id, Patient updatedPatient) {
        Patient currentPatient = patientDAO.getPatientID(id);
        if (currentPatient != null) {
            patientDAO.updatePatient(id, updatedPatient);
            return Response.ok()
                    .entity("Patient details updated successfully to the system... ")
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Patient details not found in the system... ")
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    //deletes an current patient
    public Response deletePatient(@PathParam("id") int id) {
        Patient currentPatient = patientDAO.getPatientID(id);
        if (currentPatient != null) {
            patientDAO.deletePatient(id);
            return Response.ok()
                    .entity("Patient details deleted successfully from the system... ")
                    .build();
        } else {
            
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Patient details not found in the system... ")
                    .build();
        }

    }

}
