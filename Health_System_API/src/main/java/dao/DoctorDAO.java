//@author Senadi Illeperuma
//IIT no: 20220678 

package dao;

import java.util.ArrayList;
import model.Doctor;

public class DoctorDAO {

    //store all the doctor details
    private static ArrayList<Doctor> doctorArray = new ArrayList<>();

    //retrieves all the doctor details that are stored in the system
    public ArrayList<Doctor> getAllDoctors() {
        return doctorArray;
    }

    //retrieves a doctor detail based on the ID
    public Doctor getDoctorID(int id) {
        for (Doctor doctor : doctorArray) {
            if (doctor.getID() == (id)) {
                return doctor;
            }
        }
        return null;
    }

    //add a doctor to the system
    public void addDoctor(Doctor doctor) {
        doctorArray.add(doctor);
    }

    //updates a doctor detail using the ID to the system
    public void updateDoctor(int id, Doctor updatedDoctor) {
        for (Doctor doctor : doctorArray) {
            if (doctor.getID() == id) {
                int no = doctorArray.indexOf(doctor);
                doctorArray.set(no, updatedDoctor);
                return;
            }
        }
    }

    //deletes a doctor using the ID
    public void deleteDoctor(int id) {
        doctorArray.removeIf(person -> person.getID() == id);
    }
}
