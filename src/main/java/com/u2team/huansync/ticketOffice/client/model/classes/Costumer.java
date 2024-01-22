package com.u2team.huansync.ticketOffice.client.model.classes;

import java.util.Date;

public class Costumer {
    private long costumerId;
    private String name;
    private String document;
    private String gender;
    private Date birthDate;
    private String email;
    private String phoneNumber;
    
    
    private CostumerTypeEnum costumerTypeEnum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(long costumerId) {
        this.costumerId = costumerId;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }  

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CostumerTypeEnum getCostumerTypeEnum() {
        return costumerTypeEnum;
    }

    public void setCostumerTypeEnum(CostumerTypeEnum costumerTypeEnum) {
        this.costumerTypeEnum = costumerTypeEnum;
    }

    @Override
    public String toString() {
        return "Costumer{" + "costumerId=" + costumerId + ", name=" + name + ", document=" + document + ", gender=" + gender + ", birthDate=" + birthDate + ", email=" + email + ", phoneNumber=" + phoneNumber + ", costumerTypeEnum=" + costumerTypeEnum + '}';
    }

    
}
