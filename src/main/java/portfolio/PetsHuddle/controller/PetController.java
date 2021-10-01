package portfolio.PetsHuddle.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolio.PetsHuddle.model.Event;
import portfolio.PetsHuddle.model.Pet;
import portfolio.PetsHuddle.service.PetService;
import portfolio.PetsHuddle.service.EventService;
import portfolio.PetsHuddle.service.impl.FriendServiceImpl;

import java.util.List;

@RestController
@RequestMapping("api/petshuddle")
public class PetController {

    Logger logger = LoggerFactory.getLogger(PetController.class);

    private PetService petService;
    private EventService eventService;

    public PetController(PetService petService, EventService eventService) {
        this.petService = petService;
        this.eventService = eventService;
    }

    //build create new pet REST API
    @PostMapping
    public ResponseEntity<Pet> savePet(@RequestBody Pet pet) {
        ResponseEntity<Pet> newPet = new ResponseEntity<Pet>(petService.savePet(pet), HttpStatus.CREATED);
        return newPet;
    }

    //api for getting all pets
    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    //api for getting pet by id
    @GetMapping("{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable("id") int petId) {
        ResponseEntity<Pet> matchingPet = new ResponseEntity<Pet>(petService.getPetById(petId), HttpStatus.OK);
        if(matchingPet != null) {
            logger.info("pet found");
            return matchingPet;
        }
        else {
//                return new ResponseEntity.status(HttpStatus.BAD_REQUEST);
//            return new ResponseEntity<Pet>(HttpStatus.NOT_FOUND);
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            logger.info("pet does not exist");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //building update pets api
    @PutMapping("{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable("id") int petId, @RequestBody Pet pet) {
        return new ResponseEntity<Pet>(petService.updatePet(pet, petId), HttpStatus.OK);
    }

    //building delete pets rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePet(@PathVariable("id") int petId) {
        petService.deletePet(petId);
        return new ResponseEntity<String>("Pet deleted successfully", HttpStatus.OK);
    }

    //this uses the column name and the parameter value in repository to make the query
    //custom query and it becomes http://localhost:8080/api/petshuddle/petbyage/4
//    @GetMapping("/petbyage/{age}")
//    public List<Pet> getAllByAge(@PathVariable("age") int age) {
//        return petService.findAllByAge(age);
//    }

    //api for inserting an event on a chosen pet
    //@JsonIgnore
    @PutMapping("/{petId}/event/{eventId}")
    Pet petJoinsEvent(
            @PathVariable("petId") int petId,
            @PathVariable("eventId") int eventId
    ) {
        Pet pet = petService.getPetById(petId);
        Event event = eventService.getEventById(eventId);
        pet.addPetToEvent(event);
        return petService.savePet(pet);
    }

    //api for searching for pet using their names
    @GetMapping("/searchpets/{searchPetValue}")
    public List<Pet> findAllByName(@PathVariable("searchPetValue") String searchPetValue) {
        return petService.findAllByPetName(searchPetValue);
    }
}
