/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//@author Senadi Illeperuma
//IIT no: 20220678 

package model;
public class Prescription {

    private int prescriptionID;
    private Patient patient;
    private String medication;
    private String dosage;
    private String instruction;
    private String duration;

    //no args constructor
    public Prescription() {

    }

    //full args constructor
    public Prescription(int prescriptionID, Patient patient, String medication, String dosage, String instruction, String duration) {
        this.prescriptionID = prescriptionID;
        this.patient = patient;
        this.medication = medication;
        this.dosage = dosage;
        this.instruction = instruction;
        this.duration = duration;

    }

    //Getters and setters
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(int prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
