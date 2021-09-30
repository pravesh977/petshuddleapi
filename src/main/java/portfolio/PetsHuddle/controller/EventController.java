package portfolio.PetsHuddle.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolio.PetsHuddle.model.Event;
import portfolio.PetsHuddle.service.EventService;

import java.util.List;

@RestController
@RequestMapping("api/events")
public class EventController {

    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("{id}")
    public ResponseEntity<Event> getEventById(@PathVariable("id") int eventId) {
        ResponseEntity<Event> matchingEvent = new ResponseEntity<Event>(eventService.getEventById(eventId), HttpStatus.OK);
        return matchingEvent;
    }

    @PostMapping
    public ResponseEntity<Event> saveEvent(@RequestBody Event event) {
        ResponseEntity<Event> newEvent = new ResponseEntity<Event>(eventService.saveEvent(event), HttpStatus.CREATED);
        return newEvent;
    }
}
