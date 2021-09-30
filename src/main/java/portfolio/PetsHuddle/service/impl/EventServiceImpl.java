package portfolio.PetsHuddle.service.impl;

import org.springframework.stereotype.Service;
import portfolio.PetsHuddle.model.Event;
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
        return eventRepository.findAll();
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

}
