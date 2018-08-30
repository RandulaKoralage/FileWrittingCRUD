/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Randula
 */
public class PhoneBook implements Serializable {
    
    private String userId;
    private String personName;
    private String phoneNumber;
    private String location;

    public PhoneBook() {
    }

//    public PhoneBook(String personName, String phoneNumber, String location ) {
//        this.personName = personName;
//        this.phoneNumber = phoneNumber;
//        this.location = location;
//    }

    public PhoneBook(String userId, String personName, String phoneNumber, String location) {
        this.userId = userId;
        this.personName = personName;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }
    

    /**
     * @return the personName
     */
    public String getPersonName() {
        return personName;
    }

    /**
     * @param personName the personName to set
     */
    public void setPersonName(String personName) {
        this.personName = personName;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return userId + ":" +personName + ":" + phoneNumber + ":" + location;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

}
