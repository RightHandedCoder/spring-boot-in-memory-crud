package com.shams.spring.springbootinmemorycrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String firstName;
    String lastName;
    String mobileNumber;
    String email;

    public Contact() {
    }

    public Contact(String firstName, String lastName, String email, String mobileNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getFullName() {
        if (this.lastName.isEmpty())
            return this.firstName;
        else if (this.firstName.isEmpty())
            return this.lastName;
        else
            return this.firstName + " " + this.lastName;

    }

    public Boolean validate() throws Exception{
        if (this.firstName.isEmpty() && this.lastName.isEmpty())
            throw new Exception("First Name or Last Name required!!");
        if (this.mobileNumber.isEmpty())
            throw new Exception("Mobile number can not be empty!!");
        return true;
    }
}
