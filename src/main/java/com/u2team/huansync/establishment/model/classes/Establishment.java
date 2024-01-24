package com.u2team.huansync.establishment.model.classes;

import com.u2team.huansync.establishment.model.classes.builder.CategoryEstablishment;

public class Establishment {

    private long establishmentId;
    private String nameEstablishment;
    private long managerEstablishmentId;
    private CategoryEstablishment categoyEstablishment;
    private long establishmentEventId;

    public Establishment() {
    }

    public Establishment(long establishmentId, String nameEstablishment, long managerEstablishment, CategoryEstablishment categoyEstablisment, long establishmentEventId) {
        this.establishmentId = establishmentId;
        this.nameEstablishment = nameEstablishment;
        this.managerEstablishmentId = managerEstablishment;
        this.categoyEstablishment = categoyEstablisment;
        this.establishmentEventId = establishmentEventId;
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

    public long getManagerEstablishmentId() {
        return managerEstablishmentId;
    }

    public void setManagerEstablishmentId(long managerEstablishmentId) {
        this.managerEstablishmentId = managerEstablishmentId;
    }

    public CategoryEstablishment getCategoyEstablishment() {
        return categoyEstablishment;
    }

    public CategoryEstablishment getCategoyEstablisment(String categoryEstablishment) {
        if (categoryEstablishment.equalsIgnoreCase("store")) {
            return CategoryEstablishment.STORE;
        }
        if (categoryEstablishment.equalsIgnoreCase("restaurant")) {
            return CategoryEstablishment.RESTAURANT;
        }
        return null;
    }

    public void setCategoyEstablishment(CategoryEstablishment categoyEstablishment) {
        this.categoyEstablishment = categoyEstablishment;
    }

    public long getEstablishmentEventId() {
        return establishmentEventId;
    }

    public void setEstablishmentEventId(long establishmentEventId) {
        this.establishmentEventId = establishmentEventId;
    }

}
