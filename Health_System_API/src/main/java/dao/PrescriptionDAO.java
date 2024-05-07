//@author Senadi Illeperuma
//IIT no: 20220678 

package dao;

import java.util.ArrayList;
import model.Prescription;

public class PrescriptionDAO {

    private static ArrayList<Prescription> prescriptionArray = new ArrayList<>();

    public ArrayList<Prescription> getAllPrescriptions() {
        return prescriptionArray;
    }

    //retrieves a prescription based on prescription ID
    public Prescription getPrescriptionID(int prescriptionID) {
        for (Prescription prescription : prescriptionArray) {
            if (prescription.getPrescriptionID() == prescriptionID) {
                return prescription;
            }
        }
        return null;
    }

    //add a prescription to the system
    public void createPrescription(Prescription prescription) {
        prescriptionArray.add(prescription);
    }

    //update a prescription to the system
    public void updatePrescription(int prescriptionID, Prescription updatedPrescription) {
        for (Prescription prescription : prescriptionArray) {
            if (prescription.getPrescriptionID() == prescriptionID) {
                int no = prescriptionArray.indexOf(prescription);
                prescriptionArray.set(no, updatedPrescription);
                return;
            }
        }
    }

    //deletes a prescription using the prescription ID
    public void deletePrescription(int prescriptionID) {
        Prescription prescriptionTodelete = null;
        for (Prescription prescription : prescriptionArray) {
            if (prescription.getPrescriptionID() == prescriptionID) {
                prescriptionTodelete = prescription;
                break;
            }
        }
        if (prescriptionTodelete != null) {
            prescriptionArray.remove(prescriptionTodelete);
        }
    }
}
