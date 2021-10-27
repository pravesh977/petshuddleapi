package portfolio.PetsHuddle.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolio.PetsHuddle.model.Event;
import portfolio.PetsHuddle.model.EventsMonthlyReport;
import portfolio.PetsHuddle.model.Pet;
import portfolio.PetsHuddle.service.EventService;
import portfolio.PetsHuddle.service.PetService;

import java.util.List;

@RestController
@RequestMapping("api/events")
public class EventController {

//    Logger logger = LoggerFactory.getLogger(EventController.class);


    private EventService eventService;
    private PetService petService;

    public EventController(EventService eventService, PetService petService) {
        this.eventService = eventService;
        this.petService = petService;
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

    //endpoint for searching event using event name
    @GetMapping("/searchevents/{searchEventsValue}")
    public List<Event> searchEventsByName(@PathVariable("searchEventsValue") String searchEventsValue){
        return eventService.searchEventsByName(searchEventsValue);
    }

    //api for inserting an event on a chosen pet
    //@JsonIgnore
    @PutMapping("/{eventId}/pet/{petId}")
    public ResponseEntity<Event> petJoinsEvent(
            @PathVariable("eventId") int eventId,
            @PathVariable("petId") int petId
    ) {
        Event event = eventService.getEventById(eventId);
        Pet pet = petService.getPetById(petId);
//        logger.info(pet.getPetName() + " name");
//        logger.info(event.getEventTitle() + " title");
        event.addPetToEvent(pet);
        ResponseEntity<Event> newEvent = new ResponseEntity<Event>(eventService.saveEvent(event), HttpStatus.OK);
        return newEvent;
    }

    //endpoint for finding events based on month name for report
    @GetMapping("/eventsbymonth/{eventMonth}")
//    public int numberOfEventsByMonth(@PathVariable("eventMonth") String eventMonth){
//        return eventService.monthlyEventNumber(eventMonth);
//    }

//    public ResponseEntity<EventsMonthlyReport> numberOfEventsByMonth(@PathVariable ("eventMonth") String eventMonth) {
//        //int numOfEvents = eventService.monthlyEventNumber(eventMonth);
//        return new ResponseEntity<EventsMonthlyReport>(eventService.monthlyEventNumber(eventMonth), HttpStatus.OK);
//    }
    public ResponseEntity<EventsMonthlyReport> reportByMonth(@PathVariable ("eventMonth") String eventMonth) {
        //int numOfEvents = eventService.monthlyEventNumber(eventMonth);
        ResponseEntity<EventsMonthlyReport> newReport = new ResponseEntity<EventsMonthlyReport>(eventService.reportByMonth(eventMonth), HttpStatus.OK);
        return newReport;
    }
}
