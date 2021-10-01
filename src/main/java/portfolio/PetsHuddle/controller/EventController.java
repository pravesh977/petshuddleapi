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

    //end point to get all events
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    //end point to get an event by event id
    @GetMapping("{id}")
    public ResponseEntity<Event> getEventById(@PathVariable("id") int eventId) {
        ResponseEntity<Event> matchingEvent = new ResponseEntity<Event>(eventService.getEventById(eventId), HttpStatus.OK);
        return matchingEvent;
    }

    //end point to save a new event
    @PostMapping
    public ResponseEntity<Event> saveEvent(@RequestBody Event event) {
        ResponseEntity<Event> newEvent = new ResponseEntity<Event>(eventService.saveEvent(event), HttpStatus.CREATED);
        return newEvent;
    }

    //end point to update an event
    @PutMapping("{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable("id") int eventId, @RequestBody Event event) {
        return new ResponseEntity<Event>(eventService.updateEvent(event, eventId), HttpStatus.OK);
    }

    //end point for deleting an event
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable("id") int eventId) {
        eventService.deleteEvent(eventId);
        return new ResponseEntity<String>("Event Deleted", HttpStatus.OK);
    }

    @GetMapping("/searchevents/{searchEventsValue}")
    public List<Event> searchEventsByName(@PathVariable("searchEventsValue") String searchEventsValue){
        return eventService.searchEventsByName(searchEventsValue);
    }
}
