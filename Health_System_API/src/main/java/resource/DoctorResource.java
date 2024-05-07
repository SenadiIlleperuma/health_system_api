//@author Senadi Illeperuma
//IIT no: 20220678 

package resource;

import dao.DoctorDAO;

import model.Doctor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/doctors")
public class DoctorResource {

    private final DoctorDAO doctorDAO;

    public DoctorResource() {
        this.doctorDAO = new DoctorDAO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //retrieves all doctors from the system
    public Response getAllDoctors() {
        ArrayList<Doctor> doctors = doctorDAO.getAllDoctors();
        return Response.ok().entity(doctors).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    //retrieves a doctor from the system
    public Response getByID(@PathParam("id") int id) {
        Doctor doctor = doctorDAO.getDoctorID(id);
        if (doctor != null) {
            return Response.ok().entity(doctor).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Doctor details not found in the system... ")
                    .build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    //add a new doctor
    public Response addDoctor(Doctor doctor) {
        doctorDAO.addDoctor(doctor);
        return Response.status(Response.Status.CREATED)
                .entity("Doctor details added successfully to the system... ")
                .build();

    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    //updates an existing doctor
    public Response updateDoctor(@PathParam("id") int id, Doctor updatedDoctor) {
        Doctor currentDoctor = doctorDAO.getDoctorID(id);
        if (currentDoctor != null) {
            doctorDAO.updateDoctor(id, updatedDoctor);
            return Response.ok()
                    .entity("Doctor details updated successfully to the system... ")
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Doctor details not found in the system... ")
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    //deletes an existing doctor
    public Response deleteDoctor(@PathParam("id") int id) {
        Doctor currentDoctor = doctorDAO.getDoctorID(id);
        if (currentDoctor != null) {
            doctorDAO.deleteDoctor(id);
            return Response.ok()
                    .entity("Doctor details deleted successfully to the system... ")
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Doctor details not found in the system... ")
                    .build();
        }

    }

}
