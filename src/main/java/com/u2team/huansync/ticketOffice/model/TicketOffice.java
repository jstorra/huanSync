package com.u2team.huansync.ticketOffice.model;

public class TicketOffice {

    //public Event eventMain;
    /** The location status of the ticket office. */
    private boolean location;

    /** The address of the ticket office. */
    private String address;

    /** The contact number for the ticket office. */
    private String contactNumber;
     //  public Event personalManager;
    /**
     * Constructs a new {@code TicketOffice} with the specified location,
     * address, and contact number.
     *
     * @param location the location status of the ticket office
     * @param address the address of the ticket office
     * @param contactNumber the contact number for the ticket office
     */
    public TicketOffice(boolean location, String address, String contactNumber) {
        this.location = location;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    /**
     * Returns the location status of the ticket office.
     *
     * @return {@code true} if the ticket office has a location, {@code false} otherwise
     */
    public boolean isLocation() {
        return location;
    }

    /**
     * Sets the location status of the ticket office.
     *
     * @param location the new location status to set
     */
    public void setLocation(boolean location) {
        this.location = location;
    }

    /**
     * Returns the address of the ticket office.
     *
     * @return the address of the ticket office
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the ticket office.
     *
     * @param address the new address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the contact number for the ticket office.
     *
     * @return the contact number for the ticket office
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * Sets the contact number for the ticket office.
     *
     * @param contactNumber the new contact number to set
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
