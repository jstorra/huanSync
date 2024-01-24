package com.u2team.huansync.establishment.model;

import com.u2team.huansync.establishment.model.classes.builder.CategoryEstablishment;

public class Establishment {
    private long establishmentId;
    private String nameEstablishment;
    private long managerEstablishment;
    private CategoryEstablishment categoyEstablisment;

    public Establishment() {
    }

    public Establishment(long establishmentId, String nameEstablishment, long managerEstablishment, CategoryEstablishment categoyEstablisment) {
        this.establishmentId = establishmentId;
        this.nameEstablishment = nameEstablishment;
        this.managerEstablishment = managerEstablishment;
        this.categoyEstablisment = categoyEstablisment;
    }

    public long getEstablishmentId() {
        return establishmentId;
    }

    public void setEstablishmentId(long establishmentId) {
        this.establishmentId = establishmentId;
    }

    public String getNameEstablishment() {
        return nameEstablishment;
    }

    public void setNameEstablishment(String nameEstablishment) {
        this.nameEstablishment = nameEstablishment;
    }

    public long getManagerEstablishment() {
        return managerEstablishment;
    }

    public void setManagerEstablishment(long managerEstablishment) {
        this.managerEstablishment = managerEstablishment;
    }

    public CategoryEstablishment getCategoyEstablisment() {
        return categoyEstablisment;
    }

    public void setCategoyEstablisment(CategoryEstablishment categoyEstablisment) {
        this.categoyEstablisment = categoyEstablisment;
    }

    


}
