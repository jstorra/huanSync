package com.u2team.huansync.event.controller;

import com.u2team.huansync.event.model.DAO.EventDAO;
import com.u2team.huansync.event.model.classes.Event;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class EventController {

    private EventDAO eventDao;

    public EventController() {
        this.eventDao = new EventDAO();
    }

    public Event getById(long eventId) {
        return eventDao.getById(eventId);
    }

    public List<Event> getAllEvents() {
        return eventDao.getAll();
    }

    public void insertEvent(Event event) {
        eventDao.save(event);
    }

    public void deleteEvent(long eventId) {
        eventDao.delete(eventId);
    }

    public void updateEvent(Event event) {
        eventDao.update(event);
    }

}
