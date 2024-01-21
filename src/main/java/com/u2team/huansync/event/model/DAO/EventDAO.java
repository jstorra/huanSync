package com.u2team.huansync.event.model.DAO;

import com.u2team.huansync.event.model.classes.builders.EventBuilder;
import com.u2team.huansync.event.model.classes.builders.EventConcreteBuilder;
import com.u2team.huansync.event.model.classes.Event;
import com.u2team.huansync.event.model.util.Validations;
import com.u2team.huansync.persistence.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian Pardo
 */
public class EventDAO implements IDao<Event> {

    @Override
    public Event getById(long id) {

        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_events where eventId = ?;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, id);
            ResultSet rs = Operations.query_db(ps);
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
            } else {
                System.out.println("ERROR: The id has not been found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Event> getAll() {
        List<Event> eventList = new ArrayList<>();

        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_events";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ResultSet rs = Operations.query_db(ps);

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

        boolean validDate = Validations.dateBetween(LocalDate.now(), event.getDateEvent(), 1, 7);

        if (validDate) {
            System.out.println("Invalid date");
            return;
        }

        int repeated = Validations.counterRepeated("tbl_events", "nameEvent", "asdasdasd");
        if (repeated != 0) {
            System.out.println("nameEvent repeated");
            return;
        }

        String stmInsert = "INSERT INTO tbl_events(nameEvent, countryEvent, cityEvent, addressEvent, peopleCapacity, storeCapacity, restaurantCapacity, dateEvent, timeEvent, organizerId, ageClassification, status)  VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
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

            int rows = Operations.insert_update_delete_db(ps);
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

        boolean validDate = Validations.dateBetween(LocalDate.now(), event.getDateEvent(), 1, 7);

        if (!validDate) {
            System.out.println("Invalid date");
            return;
        }

        int repeated = Validations.counterRepeated("tbl_events", "nameEvent", "asdasdasd");
        if (repeated != 0) {
            System.out.println("nameEvent repeated");
            return;
        }

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

            String stmInsert = """
            UPDATE tbl_events
            SET nameEvent = ?,
                countryEvent = ?,
                cityEvent = ?,
                addressEvent = ?,
                peopleCapacity = ?,
                storeCapacity = ?,
                restaurantCapacity = ?,
                dateEvent = ?,
                timeEvent = ?,   
                organizerId = ?,
                ageClassification = ?,
                status = ?
            WHERE eventId = ?;
                               """;
            try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
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
                ps.setLong(13, event.getEventId());

                System.out.println(ps.toString());

                int rows = Operations.insert_update_delete_db(ps);
                if (rows <= 0) {
                    System.out.println("Cannot update event");
                } else {
                    System.out.println("Successful update event");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("not found results event");
        }

    }

    @Override
    public void delete(long eventId) {

        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "DELETE FROM tbl_events WHERE eventId = ?;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, eventId);
            int rows = Operations.insert_update_delete_db(ps);
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
