/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//@author Senadi Illeperuma
//IIT no: 20220678 

package model;
public class Person {

    private int id;
    private String name;
    private String contactInfo;
    private String address;

    //no args constructor
    public Person() {

    }

    //full args constructor
    public Person(int id,String name, String contactInfo, String address) {
        this.id=id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.address = address;
    }
    
    //Getters and setters
    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}

