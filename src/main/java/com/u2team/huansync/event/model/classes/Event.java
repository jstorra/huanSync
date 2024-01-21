package com.u2team.huansync.event.model.classes;

import java.time.*;

/**
 *
 * @Cristian Pardo
 */
public class Event {
    
    private long eventId;
    private String nameEvent;
    private String country;
    private String city;
    private String address;
    private int peopleCapacity;
    private int storeCapacity;
    private int restaurantCapacity;
    private LocalDate dateEvent;
    private LocalTime timeEvent;
    private long organizerId;

    private AgeClassificationEnum ageClassification;
    private StatusEnum statusEnum;

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPeopleCapacity() {
        return peopleCapacity;
    }

    public void setPeopleCapacity(int peopleCapacity) {
        this.peopleCapacity = peopleCapacity;
    }

    public int getStoreCapacity() {
        return storeCapacity;
    }

    public void setStoreCapacity(int storeCapacity) {
        this.storeCapacity = storeCapacity;
    }

    public int getRestaurantCapacity() {
        return restaurantCapacity;
    }

    public void setRestaurantCapacity(int restaurantCapacity) {
        this.restaurantCapacity = restaurantCapacity;
    }

    public LocalDate getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(LocalDate dateEvent) {
        this.dateEvent = dateEvent;
    }

    public LocalTime getTimeEvent() {
        return timeEvent;
    }

    public void setTimeEvent(LocalTime timeEvent) {
        this.timeEvent = timeEvent;
    }

    public long getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(long organizerId) {
        this.organizerId = organizerId;
    }

    public AgeClassificationEnum getAgeClassification() {
        return ageClassification;
    }

    public void setAgeClassification(AgeClassificationEnum ageClassification) {
        this.ageClassification = ageClassification;
    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }

    @Override
    public String toString() {
        return "Event{" + "eventId=" + eventId + ", nameEvent=" + nameEvent + ", country=" + country + ", city=" + city + ", address=" + address + ", peopleCapacity=" + peopleCapacity + ", storeCapacity=" + storeCapacity + ", restaurantCapacity=" + restaurantCapacity + ", dateEvent=" + dateEvent + ", timeEvent=" + timeEvent + ", organizerId=" + organizerId + ", ageClassification=" + ageClassification + ", statusEnum=" + statusEnum + '}';
    }
    
    
    
    
}