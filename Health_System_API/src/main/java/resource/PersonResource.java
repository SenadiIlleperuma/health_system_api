//@author Senadi Illeperuma
//IIT no: 20220678 

package resource;

import dao.PersonDAO;
import model.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;


@Path("/person")
public class PersonResource {

    private final PersonDAO personDAO;

    public PersonResource() {
        this.personDAO = new PersonDAO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //retrieve all patients from the system

    public Response getAllPersons() {
        ArrayList<Person> persons = personDAO.getAllPersons();
        return Response.ok().entity(persons).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    //retrieves a patient by its ID from the system
    public Response getByID(@PathParam("id") int id) {
        Person person = personDAO.getbyID(id);
        if (person != null) {
            return Response.ok().entity(person).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Person not found in the system... ").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    //add a new person
    public Response addPerson(Person person) {
        personDAO.addPerson(person);
        return Response.status(Response.Status.CREATED)
                .entity("Person details added successfully to the system... ").build();

    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    //updates a current person
    public Response updatePerson(@PathParam("id") int id, Person updatedPerson) {
        Person currentPerson = personDAO.getbyID(id);
        if (currentPerson != null) {
            updatedPerson.setID(id);
            personDAO.updatePerson(updatedPerson);
            return Response.ok()
                    .entity("Person details updated successfully to the system... ")
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Person not found in the system... ").build();
        }
    }

    @DELETE
    @Path("/{id}")
    //deletes a current person
    public Response deletePerson(@PathParam("id") int id) {
        Person currentPerson = personDAO.getbyID(id);
        if (currentPerson != null) {
            personDAO.deletePerson(id);
            return Response.ok()
                    .entity("Person details deleted successfully from the system... ")
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Person not found in the system... ")
                    .build();

        }

    }

}
