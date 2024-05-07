/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//@author Senadi Illeperuma
//IIT no: 20220678 

package model;

public class MedicalRecord {
    private int medicalRecordID;
    private Patient patient;
    private String diagnose;
    private String treatments;
    
    //no args constructor
    public MedicalRecord(){
      }

    //full args constructor
    public MedicalRecord(int medicalRecordID,Patient patient, String diagnose, String treatments) {
        this.medicalRecordID=medicalRecordID;
        this.patient = patient;
        this.diagnose = diagnose;
        this.treatments = treatments;
    }

    //Getters and setters
    public int getMedicalRecordID(){
        return medicalRecordID;
    }
    public void setMedicalRecordID(int medicalRecordID){
        this.medicalRecordID=medicalRecordID;
    }
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;

    }

    public String getTreatments() {
        return treatments;
    }

    public void setTreatments(String treatments) {
        this.treatments = treatments;

    }




}
