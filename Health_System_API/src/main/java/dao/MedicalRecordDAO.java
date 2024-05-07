//@author Senadi Illeperuma
//IIT no: 20220678 

package dao;

import java.util.ArrayList;
import model.MedicalRecord;

public class MedicalRecordDAO {

    //stores all the Medical Records
    private static  ArrayList<MedicalRecord> medicalRecordArray = new ArrayList<>();

    //retrieves all the Medical Records that are on the system
    public ArrayList<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordArray;
    }

    //retrieves a medical based on the medical record ID
    public MedicalRecord getMedicalRecordID(int medicalRecordID) {
        for (MedicalRecord medicalRecord : medicalRecordArray) {
            if (medicalRecord.getMedicalRecordID() == medicalRecordID) {
                return medicalRecord;
            }
        }
        return null;
    }

    //add a medical record
    public void createMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordArray.add(medicalRecord);
    }

    //update a medical record
    public void updateMedicalRecord(int medicalRecordID, MedicalRecord updatedMedicalRecord) {
        for (MedicalRecord medicalRecord : medicalRecordArray) {
            if (medicalRecord.getMedicalRecordID() == medicalRecordID) {
                int no = medicalRecordArray.indexOf(medicalRecord);
                medicalRecordArray.set(no, updatedMedicalRecord);
                return;
            }
        }
    }

    //delete a medical record
     public void deleteMedicalRecord(int medicalRecordID) {
          MedicalRecord medicalTodelete = null;
          for (MedicalRecord medicalRecord : medicalRecordArray) {
              if (medicalRecord.getMedicalRecordID()== medicalRecordID) {
                  medicalTodelete = medicalRecord;
                  break;
              }
          }
          if (medicalTodelete != null) {
              medicalRecordArray.remove(medicalTodelete);
          }
      }
}
