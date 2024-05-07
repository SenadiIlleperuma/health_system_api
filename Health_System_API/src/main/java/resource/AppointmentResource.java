//@author Senadi Illeperuma
//IIT no: 20220678 

package resource;

import dao.AppointmentDAO;
import model.Appointment;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;


@Path("/appointments")
public class AppointmentResource {
    private final AppointmentDAO appointmentDAO;

    public AppointmentResource() {
        this.appointmentDAO = new AppointmentDAO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)

    //retrieves all appointments from the system
    public Response getAllAppointments() {
        ArrayList<Appointment> appointments = appointmentDAO.getAllAppointments();
        return Response.ok().entity(appointments).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{appointmentID}")
    //retrieves an appointment by its ID from the system
    public Response getAppointmentID(@PathParam("appointmentID") int appointmentID) {
        Appointment appointment = appointmentDAO.getAppoinmentID(appointmentID);
        if (appointment != null) {
            return Response.ok().entity(appointment).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Appointment not found in the system...").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    //creates a new appointment
    public Response createAppointment(Appointment appointment) {
        appointmentDAO.createAppointment(appointment);
        return Response.status(Response.Status.CREATED)
                .entity("Appointment added successfully to the system...")
                .build();

    }

    @PUT
    @Path("/{appointmentID}")
    @Consumes(MediaType.APPLICATION_JSON)
    //updates an existing appointment
    public Response updateAppointment(@PathParam("appointmentID") int appointmentID, Appointment updatedAppointment) {
        Appointment existingAppointment = appointmentDAO.getAppoinmentID(appointmentID);
        if (existingAppointment != null) {
           appointmentDAO.updateAppointment(appointmentID, updatedAppointment);
            return Response.ok().entity("Appointment updated successfully to the system...").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Appointment not found in the system...").build();
        }
    }

    @DELETE
    @Path("/{appointmentID}")
    //deletes an existing appointment
    public Response deleteAppointment(@PathParam("appointmentID") int appointmentID) {
        Appointment existingAppointment = appointmentDAO.getAppoinmentID(appointmentID);
        if (existingAppointment != null) {
           appointmentDAO.deleteAppointment(appointmentID);
            return Response.ok()
                    .entity("Appointment deleted successfully from the system...").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Appointment not found in the system...").build();
        }

    }


}
