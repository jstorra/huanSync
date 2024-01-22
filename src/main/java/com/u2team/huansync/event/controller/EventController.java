package com.u2team.huansync.event.controller;

import com.u2team.huansync.event.model.DAO.EventDAO;
import com.u2team.huansync.event.model.classes.Event;
import java.util.List;

/**
 *
 * @author Christian Pardo
 *
 * "eventDao" = eventDao is a class that implements the DAO design pattern for data handling
 * "DAO" = meaning =("Data" "Access" "Object"), it is use in IDao Interface
 */

public class EventController {
    private EventDAO eventDao;

    // Create a new eventDao
    public EventController() {
        this.eventDao = new EventDAO();
    }
    /**
     * GetById Method that use to get a event by id.
     * @param long eventID represent id with each event.
     * @return Event will return the Event .
     */
    public Event getByIdEvent(long eventId) {
        return eventDao.getById(eventId);
    }

    /**
     * List Method that use to get all events of Database.
     * @param parameter  is empty.
     * @return return a List with events inside.
     */
    public List<Event> getAllEvents() {
        return eventDao.getAll();
    }

    /**
     * Method for Send a event to the database.
     * @param Event object.
     * @return return empty (void method).
     */
    public void insertEvent(Event event) {
        eventDao.save(event);
    }

    /**
     * Method for delete a event in the database.
     * @param long eventId.
     * @return return empty (void method).
     */
    public void deleteEvent(long eventId) {
        eventDao.delete(eventId);
    }

    /**
     * Method for update a event in the database.
     * @param Event object.
     * @return return empty (void method).
     */
    public void updateEvent(Event event) {
        eventDao.update(event);
    }

}
