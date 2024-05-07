//@author Senadi Illeperuma
//IIT no: 20220678 

package resource;

import dao.MedicalRecordDAO;
import model.MedicalRecord;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/medicalRecords")
public class MedicalRecordResource {

    private final MedicalRecordDAO medicalRecordDAO;

    public MedicalRecordResource() {
        this.medicalRecordDAO = new MedicalRecordDAO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public Response getAllMedicalRecords() {
        //retrieves all medical records from the system
        ArrayList<MedicalRecord> medicalRecords = medicalRecordDAO.getAllMedicalRecords();
        return Response.ok().entity(medicalRecords).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{medicalRecordID}")
    //retrieves a medical record by its ID from the system
    public Response getMedicalRecordID(@PathParam("medicalRecordID") int medicalRecordID) {
        MedicalRecord medicalRecord = medicalRecordDAO.getMedicalRecordID(medicalRecordID);
        if (medicalRecord != null) {
            return Response.ok().entity(medicalRecord).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Medical Record not found in the system... ").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    //create a new medical record
    public Response createMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordDAO.createMedicalRecord(medicalRecord);
        return Response.status(Response.Status.CREATED)
                .entity("Medical Record added successfully to the system... ")
                .build();

    }

    @PUT
    @Path("/{medicalRecordID}")
    @Consumes(MediaType.APPLICATION_JSON)
    //updates an existing medical record
    public Response updateMedicalRecord(@PathParam("medicalRecordID") int medicalRecordID, MedicalRecord updatedMedicalRecord) {
        MedicalRecord existingMedical = medicalRecordDAO.getMedicalRecordID(medicalRecordID);
        if (existingMedical != null) {
            medicalRecordDAO.updateMedicalRecord(medicalRecordID, updatedMedicalRecord);
            return Response.ok().entity("Medical Record updated successfully to the system... ").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Medical Record not found in the system... ")
                    .build();
        }
    }

    @DELETE
    @Path("/{medicalRecordID}")
    //deletes an existing medical record
    public Response deleteMedicalRecord(@PathParam("medicalRecordID") int medicalRecordID) {
        MedicalRecord existingMedical = medicalRecordDAO.getMedicalRecordID(medicalRecordID);
        if (existingMedical != null) {
            medicalRecordDAO.deleteMedicalRecord(medicalRecordID);
            return Response.ok()
                    .entity("Medical Record deleted successfully from the system... ")
                    .build();

        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Medical Record not found in the system... ")
                    .build();

        }

    }
}
