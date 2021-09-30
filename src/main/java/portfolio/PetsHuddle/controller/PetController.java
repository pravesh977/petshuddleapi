package portfolio.PetsHuddle.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolio.PetsHuddle.model.Pet;
import portfolio.PetsHuddle.service.PetService;

import java.util.List;

@RestController
@RequestMapping("api/petshuddle")
public class PetController {

    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
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
        return matchingPet;
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
}
