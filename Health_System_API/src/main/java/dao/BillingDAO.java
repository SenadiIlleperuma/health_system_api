//@author Senadi Illeperuma
//IIT no: 20220678 

package dao;
import java.util.ArrayList;
import model.Billing;

public class BillingDAO {

    //store all the bills
    private static ArrayList<Billing> billArray = new ArrayList<>();

    //retrieve all the bills that are on the system
    public ArrayList<Billing> getAllBills() {
        return billArray;
    }

    //retrieves a bill based on the bill ID
    public Billing getBillID(int billId) {
        for (Billing billing : billArray) {
            if (billing.getBillID() == billId) {
                return billing;
            }
        }
        return null;
    }

    //adding a bill to the system
    public void CreateBill(Billing billing) {
        billArray.add(billing);
    }

    //update a bill using the bill ID to the system
    public void updateBill(int billId, Billing updatedBill) {
        for (Billing billing : billArray) {
            if (billing.getBillID() == billId) {
                int no = billArray.indexOf(billing);
                billArray.set(no, updatedBill);
                return;
            }
        }
    }

    //deletes a bill using the bill ID
    public void deleteBill(int billId) {
        Billing billTodelete = null;
        for (Billing billing : billArray) {
            if (billing.getBillID() == billId) {
                billTodelete = billing;
                break;
            }
        }
        if (billTodelete != null) {
            billArray.remove(billTodelete);
        }
    }
}
