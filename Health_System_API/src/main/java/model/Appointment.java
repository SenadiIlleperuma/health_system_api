/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//@author Senadi Illeperuma
//IIT no: 20220678 

package model;

import java.util.Date;

public class Appointment {

    private Patient patient;
    private Doctor doctor;
    private int appointmentID;
    private Date date;
    private String time;

    //no args constructor
    public Appointment() {  
    }
    
    //full args constructor
    public Appointment(Patient patient, Doctor doctor, int appointmentID, Date date, String time) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentID = appointmentID;
        this.date = date;
        this.time = time;
    }

    //Getters and setters
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;

    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID= appointmentID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;

    }

}
