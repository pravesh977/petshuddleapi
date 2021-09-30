package portfolio.PetsHuddle.service;

import portfolio.PetsHuddle.model.Event;

import java.util.List;

public interface EventService {
    Event saveEvent(Event event);
    List<Event> getAllEvents();
    Event getEventById(int eventId);
}
