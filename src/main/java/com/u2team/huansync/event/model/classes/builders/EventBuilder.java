
package com.u2team.huansync.event.model.classes.builders;

import com.u2team.huansync.event.model.classes.Event;
import java.time.*;


/**
 *
 * @author Cristian Pardo
 */
public interface EventBuilder {
    
    EventBuilder eventId(long eventId);
    EventBuilder nameEvent(String nameEvent);
    EventBuilder country(String country);
    EventBuilder city(String city);
    EventBuilder address(String address);
    EventBuilder peopleCapacity(int peopleCapacity);
    EventBuilder storeCapacity(int storeCapacity);
    EventBuilder restaurantCapacity(int restaurantCapacity);
    EventBuilder dateEvent(LocalDate dateEvent);
    EventBuilder timeEvent(LocalTime timeEvent);
    EventBuilder organizerId(long organizerId);
    EventBuilder ageClassificationEnum(String ageClassificationEnum);
    EventBuilder statusEnum(String statusEnum);
    Event build();
}
