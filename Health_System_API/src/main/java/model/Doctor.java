/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//@author Senadi Illeperuma
//IIT no: 20220678 

package model;
public class Doctor extends Person {

    private String specialization;

    //no args constuctor
    public Doctor() {
    }

    //full args constructor
    public Doctor(int id,String name, String contactInfo, String address, String specialization) {
        super(id,name, contactInfo, address);

        this.specialization = specialization;
    }

    //Getters and setters
    public String getSpecialization() {
        return specialization;
    }

    public void setMedicalHistroy(String specialization) {
        this.specialization = specialization;
    }

}
