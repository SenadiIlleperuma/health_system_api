//@author Senadi Illeperuma
//IIT no: 20220678 

package dao;
import java.util.ArrayList;
import model.Appointment;

public class AppointmentDAO {

    //store all the appointments
    private static ArrayList<Appointment> appointmentArray = new ArrayList<>();

    //Retrieves all the appointments that are stored in the system
    public ArrayList<Appointment> getAllAppointments() {
        return appointmentArray;
    }

    //Retrieves an appointment based on the appointment ID
    public Appointment getAppoinmentID(int appointmentID) {
        for (Appointment appointment : appointmentArray) {
            if (appointment.getAppointmentID() == appointmentID) {
                return appointment;
            }
        }
        return null;
    }

    //Add an appointment to the system
    public void createAppointment(Appointment appointment) {
        appointmentArray.add(appointment);
    }

    //updates an appointment using the appointment ID to the system
    public void updateAppointment(int appointmentID, Appointment updatedAppointment) {
        for (Appointment appointment : appointmentArray) {
            if (appointment.getAppointmentID() == appointmentID) {
                int no = appointmentArray.indexOf(appointment);
                appointmentArray.set(no, updatedAppointment);
                return;
            }
        }
    }

    //deletes an appointment using appointment ID
    
     public void deleteAppointment(int appointmentID) {
          Appointment appointmentTodelete = null;
          for (Appointment appointment : appointmentArray) {
              if (appointment.getAppointmentID()== appointmentID) {
                  appointmentTodelete= appointment;
                  break;
              }
          }
          if (appointmentTodelete != null) {
              appointmentArray.remove(appointmentTodelete);
          }
      }
}
