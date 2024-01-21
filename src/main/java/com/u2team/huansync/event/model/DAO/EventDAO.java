package com.u2team.huansync.event.model.DAO;

import com.u2team.huansync.event.model.classes.builders.EventBuilder;
import com.u2team.huansync.event.model.classes.builders.EventConcreteBuilder;
import com.u2team.huansync.event.model.classes.Event;
import com.u2team.huansync.persistencia.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Usuario
 */
public class EventDAO implements IDao<Event> {

    @Override
    public Event getById(long id) {

        Operaciones.setConnection(ConexionBD.MySQLConnection());
        String stm = "SELECT * FROM tbl_events where eventId = ?;";

        try (PreparedStatement ps = Operaciones.getConnection().prepareStatement(stm)) {
            ps.setLong(1, id);
            ResultSet rs = Operaciones.consultar_BD(ps);
            if (rs.next()) {
                EventBuilder eventBuilder = new EventConcreteBuilder();

                Event sqlEvent = eventBuilder.eventId(rs.getLong("eventId"))
                        .nameEvent(rs.getString("nameEvent"))
                        .country(rs.getString("countryEvent"))
                        .city(rs.getString("cityEvent"))
                        .address(rs.getString("addressEvent"))
                        .peopleCapacity(rs.getInt("peopleCapacity"))
                        .storeCapacity(rs.getInt("storeCapacity"))
                        .restaurantCapacity(rs.getInt("restaurantCapacity"))
                        .dateEvent(LocalDate.parse(rs.getString("dateEvent")))
                        .timeEvent(LocalTime.parse(rs.getString("timeEvent")))
                        .organizerId(rs.getLong("organizerId"))
                        .ageClassificationEnum(rs.getString("ageClassification"))
                        .statusEnum(rs.getString("status"))
                        .build();

                return sqlEvent;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Event> getAll() {
        List<Event> eventList = new ArrayList<>();

        Operaciones.setConnection(ConexionBD.MySQLConnection());
        String stm = "SELECT * FROM tbl_events";

        try (PreparedStatement ps = Operaciones.getConnection().prepareStatement(stm)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EventBuilder eventBuilder = new EventConcreteBuilder();

                Event sqlEvent = eventBuilder.eventId(rs.getLong("eventId"))
                        .nameEvent(rs.getString("nameEvent"))
                        .country(rs.getString("countryEvent"))
                        .city(rs.getString("cityEvent"))
                        .address(rs.getString("addressEvent"))
                        .peopleCapacity(rs.getInt("peopleCapacity"))
                        .storeCapacity(rs.getInt("storeCapacity"))
                        .restaurantCapacity(rs.getInt("restaurantCapacity"))
                        .dateEvent(LocalDate.parse(rs.getString("dateEvent")))
                        .timeEvent(LocalTime.parse(rs.getString("timeEvent")))
                        .organizerId(rs.getLong("organizerId"))
                        .ageClassificationEnum(rs.getString("ageClassification"))
                        .statusEnum(rs.getString("status"))
                        .build();

                eventList.add(sqlEvent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventList;
    }

    @Override
    public void save(Event event) {
        LocalDate curDate = LocalDate.now();
        long difDate = ChronoUnit.DAYS.between(curDate, event.getDateEvent());
        if (difDate < 1 || difDate > 7) {
            System.out.println("Invalid date");
            return;
        }

        Operaciones.setConnection(ConexionBD.MySQLConnection());
        String stm = "select count(eventId) as repeatedNames from tbl_events WHERE nameEvent = ?;";

        try (PreparedStatement ps = Operaciones.getConnection().prepareStatement(stm)) {
            ps.setString(1, event.getNameEvent());
            ResultSet rs = Operaciones.consultar_BD(ps);
            if (rs.next()) {
                int repeatedNames = rs.getInt("repeatedNames");
                if (repeatedNames > 0) {
                    System.out.println("Already name exists");
                    return;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String stmInsert = "INSERT INTO tbl_events(nameEvent, countryEvent, cityEvent, addressEvent, peopleCapacity, storeCapacity, restaurantCapacity, dateEvent, timeEvent, organizerId, ageClassification, status)  VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement ps = Operaciones.getConnection().prepareStatement(stmInsert)) {
            ps.setString(1, event.getNameEvent());
            ps.setString(2, event.getCountry());
            ps.setString(3, event.getCity());
            ps.setString(4, event.getAddress());
            ps.setInt(5, event.getPeopleCapacity());
            ps.setInt(6, event.getStoreCapacity());
            ps.setInt(7, event.getRestaurantCapacity());
            ps.setString(8, event.getDateEvent().toString());
            ps.setString(9, event.getTimeEvent().toString());
            ps.setLong(10, event.getOrganizerId());
            ps.setString(11, event.getAgeClassification().name());
            ps.setString(12, event.getStatusEnum().name());

            int rows = Operaciones.insertar_actualizar_borrar_BD(ps);
            if (rows <= 0) {
                System.out.println("Cannot insert event");
            } else {
                System.out.println("Successful insert event");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Event event) {
        Event sqlEvent = getById(event.getEventId());

        if (sqlEvent != null) {
            sqlEvent.setNameEvent(event.getNameEvent());
            sqlEvent.setCountry(event.getCountry());
            sqlEvent.setCity(event.getCity());
            sqlEvent.setAddress(event.getAddress());
            sqlEvent.setPeopleCapacity(event.getPeopleCapacity());
            sqlEvent.setStoreCapacity(event.getStoreCapacity());
            sqlEvent.setRestaurantCapacity(event.getRestaurantCapacity());
            sqlEvent.setDateEvent(event.getDateEvent());
            sqlEvent.setTimeEvent(event.getTimeEvent());
            sqlEvent.setOrganizerId(event.getOrganizerId());
            sqlEvent.setAgeClassification(event.getAgeClassification());
            sqlEvent.setStatusEnum(event.getStatusEnum());
            
                @Override
    public void update(Event event) {
        Event sqlEvent = getById(event.getEventId());

        if (sqlEvent != null) {
            sqlEvent.setNameEvent(event.getNameEvent());
            sqlEvent.setCountry(event.getCountry());
            sqlEvent.setCity(event.getCity());
            sqlEvent.setAddress(event.getAddress());
            sqlEvent.setPeopleCapacity(event.getPeopleCapacity());
            sqlEvent.setStoreCapacity(event.getStoreCapacity());
            sqlEvent.setRestaurantCapacity(event.getRestaurantCapacity());
            sqlEvent.setDateEvent(event.getDateEvent());
            sqlEvent.setTimeEvent(event.getTimeEvent());
            sqlEvent.setOrganizerId(event.getOrganizerId());
            sqlEvent.setAgeClassification(event.getAgeClassification());
            sqlEvent.setStatusEnum(event.getStatusEnum());
            
            
            
            
            
            
        } else {
            System.out.println("not found results event");
        }

    }

            
            
            
            
        } else {
            System.out.println("not found results event");
        }

    }

    @Override
    public void delete(long eventId) {

        Operaciones.setConnection(ConexionBD.MySQLConnection());
        String stm = "DELETE FROM tbl_events WHERE eventId = ?;";

        try (PreparedStatement ps = Operaciones.getConnection().prepareStatement(stm)) {
            ps.setLong(1, eventId);
            int rows = Operaciones.insertar_actualizar_borrar_BD(ps);
            if (rows > 0) {
                System.out.println("succesful delete event");
                return;
            } else {
                System.out.println("not exists event");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("something was wrong on delete event");
        return;
    }

}
