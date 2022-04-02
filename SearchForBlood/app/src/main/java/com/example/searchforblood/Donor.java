package com.example.searchforblood;


public class Donor {
    private String name,age,contactNumber,bloodGroup,available,city;

    public Donor() {
    }

    public Donor(String name, String age, String contactNumber, String bloodGroup, String available, String city) {
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.bloodGroup = bloodGroup;
        this.available = available;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
