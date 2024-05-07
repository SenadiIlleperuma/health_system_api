//@author Senadi Illeperuma
//IIT no: 20220678 

package resource;

import dao.BillingDAO;
import model.Billing;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/bills")
public class BillingResource {

    private final BillingDAO billingDAO;

    public BillingResource() {
        this.billingDAO = new BillingDAO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //retrieves all bills from the system
    public Response getAllBills() {
        ArrayList<Billing> billings = billingDAO.getAllBills();
        return Response.ok().entity(billings).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{billId}")
    //retrieves a bill by its ID from the system
    public Response getBillID(@PathParam("billId") int billId) {
        Billing billing = billingDAO.getBillID(billId);
        if (billing != null) {
            return Response.ok().entity(billing).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Bill details not found in the system... ")
                    .build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    //creates a new bill
    public Response createBill(Billing billing) {
        billingDAO.CreateBill(billing);
        return Response.status(Response.Status.CREATED)
                .entity("Bill details added successfully to the system... ")
                .build();

    }

    @PUT
    @Path("/{billId}")
    @Consumes(MediaType.APPLICATION_JSON)
    //updates the current bill
    public Response updateBill(@PathParam("billId") int billId, Billing updatedBill) {
        Billing currentBill = billingDAO.getBillID(billId);
        if (currentBill != null) {
            billingDAO.updateBill(billId, updatedBill);
            return Response.ok()
                    .entity("Bill details updated successfully to the system... ")
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Bill details not found in the system... ")
                    .build();
        }
    }

    @DELETE
    @Path("/{billId}")
    //deletes an existing bill
    public Response deleteBill(@PathParam("billId") int billId) {
        Billing currentBill = billingDAO.getBillID(billId);
        if (currentBill != null) {
            billingDAO.deleteBill(billId);
            return Response.ok()
                    .entity("Bill details deleted successfully from the system... ")
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Bill details not found in the system... ")
                    .build();
        }

    }

}
