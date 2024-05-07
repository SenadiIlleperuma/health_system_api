/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//@author Senadi Illeperuma
//IIT no: 20220678 

package model;
public class Patient extends Person {

    private String medicalHistory;
    private String healthStatus;
    
    //no args constructor
    public Patient(){

    }

    //full args constructor
    public Patient(int id,String name, String contactInfo, String address, String medicalHistory, String healthStatus) {
        super(id, name, contactInfo, address);
        this.medicalHistory = medicalHistory;
        this.healthStatus = healthStatus;

    }

    //Getters and setters
    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistroy(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

}
