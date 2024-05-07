//@author Senadi Illeperuma
//IIT no: 20220678 

package dao;

import java.util.ArrayList;
import model.Patient;

public class PatientDAO {

    private static ArrayList<Patient> patientArray = new ArrayList<>();

    //retrieve all the patient
    public ArrayList<Patient> getAllPatients() {
        return patientArray;
    }

    //retrieve a patient based on the ID
    public Patient getPatientID(int id) {
        for (Patient patient : patientArray) {
            if (patient.getID() == (id)) {
                return patient;
            }
        }
        return null;
    }

    //adds a patient to the system
    public void addPatient(Patient patient) {
        patientArray.add(patient);
    }

    //update a patient 
    public void updatePatient(int id, Patient updatedPatient) {
        for (Patient patient : patientArray) {
            if (patient.getID() == id) {
                int no = patientArray.indexOf(patient);
                patientArray.set(no, updatedPatient);
                return;
            }
        }
    }

    //delete a patient
    public void deletePatient(int id) {
        patientArray.removeIf(person 
                -> person.getID() == id);
    }
    
}
