package portfolio.PetsHuddle.service;

import portfolio.PetsHuddle.model.Event;
import portfolio.PetsHuddle.model.EventsMonthlyReport;

import java.util.List;

public interface EventService {
    Event saveEvent(Event event);
    List<Event> getAllEvents();
    Event getEventById(int eventId);
    Event updateEvent(Event event, int eventId);
    void deleteEvent(int eventId);
    List<Event> searchEventsByName(String eventTitle);
    EventsMonthlyReport reportByMonth(String eventMonth);
}
