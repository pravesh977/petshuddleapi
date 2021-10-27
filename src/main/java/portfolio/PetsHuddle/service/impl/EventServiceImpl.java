package portfolio.PetsHuddle.service.impl;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import portfolio.PetsHuddle.model.Event;
import portfolio.PetsHuddle.model.EventsMonthlyReport;
import portfolio.PetsHuddle.model.Pet;
import portfolio.PetsHuddle.repository.EventRepository;
import portfolio.PetsHuddle.service.EventService;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll(Sort.by(Sort.Direction.DESC, "eventDate"));
    }

    @Override
    public Event getEventById(int eventId) {
        Optional <Event> event = eventRepository.findById(eventId);
        if(event.isPresent()) {
            return event.get();
        }
        else {
            return null; //fixme: add exception handling
        }
    }

    @Override
    public Event saveEvent(Event event) {
        eventRepository.save(event);
        return event;
    }

    @Override
    public Event updateEvent(Event passedEvent, int eventId) {
        Optional<Event> existingEvent = eventRepository.findById(eventId);
        if(existingEvent.isPresent()) {
            Event newEvent = existingEvent.get();
            newEvent.setEventTitle(passedEvent.getEventTitle());
            newEvent.setEventDetails(passedEvent.getEventDetails());
            newEvent.setEventLocation(passedEvent.getEventLocation());
            newEvent.setEventDate(passedEvent.getEventDate());
            eventRepository.save(newEvent);
            return newEvent;
        }
        else {
            return null; //fixme: handle exception
        }
    }

    @Override
    public void deleteEvent(int eventId) {
        Optional<Event> existingEvent = eventRepository.findById(eventId);
        if(existingEvent.isPresent()) {
            eventRepository.deleteById(eventId);
        } else {
            //fixme: handle exception
        }
    }

    @Override
    public List<Event> searchEventsByName(String eventTitle) {
        return eventRepository.findAllByEventNamesdf(eventTitle);
    }

//    @Override
//    public EventsMonthlyReport monthlyEventNumber(String eventMonth) {
//        EventsMonthlyReport newReport = new EventsMonthlyReport(eventRepository.monthlyEventNumber(eventMonth), 999);
//        return newReport;
//    }

    @Override
    public EventsMonthlyReport reportByMonth(String eventMonth) {
        List<Event> resultingEvent = eventRepository.eventsListByMonth(eventMonth);
        int numOfEvents = resultingEvent.size();
        int numOfPetsForEvent = 0;
        for(Event element:resultingEvent) {
            numOfPetsForEvent = element.getPetsListForEvent().size() + numOfPetsForEvent;
        }
        EventsMonthlyReport newMonthlyReport = new EventsMonthlyReport(numOfEvents, numOfPetsForEvent);
        return newMonthlyReport;
    }


}
