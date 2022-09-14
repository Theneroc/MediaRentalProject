package com.example.mediarentalprojectphase2;

import java.util.ArrayList;

public class Customer implements Comparable<Customer>{
    private String name;
    private String address;
    private String plan;
    private String id;
    private String mobileNumber;
    private ArrayList<String> wantsToRent = new ArrayList<>();
     private ArrayList<String> rented = new ArrayList<>();

    Customer(){
    }

    public Customer(String id,String name, String address, String mobileNumber, String plan) {
        this.name = name;
        this.address = address;
        this.plan = plan;
        this.id = id;
        this.mobileNumber = mobileNumber;
    }

    public int compareTo(Customer o) {
        return this.name.compareTo(o.name);//COME BACK
    }
    public String getName() {
        return name;
    }

    public String getAddress() {return address;}
    public String getPlan() {
        return plan;
    }
    public String getId(){return id;}
    public String getMobileNumber(){return mobileNumber;}



    public void setWantsToRent(ArrayList<String> wantsToRent) {

        this.wantsToRent = wantsToRent;
    }

    public void setRented(ArrayList<String> rented) {
        this.rented = rented;
    }

    public ArrayList<String> getWantsToRent() {

        return wantsToRent;
    }

    public ArrayList<String> getRented() {

        return rented;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", plan='" + plan + '\'' +
                '}';
    }


}
