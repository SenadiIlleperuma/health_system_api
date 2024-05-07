/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//@author Senadi Illeperuma
//IIT no: 20220678 

package model;
public class Billing {

    private int billId;
    private int patientNo;
    private String patientName;
    private String invoice;
    private String payment;
    private String balance;

    //no args constructor
    public Billing() {
    }

    //full args constructor
    public Billing(int billId, int patientNo, String patientName,String invoice, String payment, String balance) {
        this.billId = billId;
        this.patientNo = patientNo;
        this.patientName=patientName;
        this.invoice = invoice;
        this.payment = payment;
        this.balance = balance;
    }

    //Getters and setters
    public int getBillID() {
        return billId;
    }

    public void setBillID(int billId) {
        this.billId = billId;
    }

    public int getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(int patientNo) {
        this.patientNo =patientNo;
    }
      public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName =patientName;
    }


    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
