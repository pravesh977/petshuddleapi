package portfolio.PetsHuddle.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import portfolio.PetsHuddle.model.Pet;
import portfolio.PetsHuddle.repository.PetRepository;
import portfolio.PetsHuddle.service.PetService;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    private PetRepository petrepository;

    public PetServiceImpl(PetRepository petrepository) {
        this.petrepository = petrepository;
    }

    @Override
    public Pet savePet(Pet pet) {
        petrepository.save(pet);
        return pet;
    }

    @Override
    public List<Pet> getAllPets() {
        return petrepository.findAll();
    }

    @Override
    public Pet getPetById(int petId) {
        Optional<Pet> pet = petrepository.findById(petId);
        if (pet.isPresent()) {
            return pet.get();
        }
        else {
            return null; //fixme: add exception handling
//            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Pet updatePet(Pet petToBeUpdated, int petId) {
        //first check if the sent pet with the id exists or not
        Optional<Pet> existingPet = petrepository.findById(petId);
        if(existingPet.isPresent()) {

//            Pet newPet = new Pet(0, petToBeUpdated.getPetName(), petToBeUpdated.getSpecies(), petToBeUpdated.getSex(), petToBeUpdated.getBreed(), petToBeUpdated.getAge(), petToBeUpdated.getPetDescription(), petToBeUpdated.getUserId());
            Pet newPet = existingPet.get();
            newPet.setPetName(petToBeUpdated.getPetName());
            newPet.setSpecies(petToBeUpdated.getSpecies());
            newPet.setSex(petToBeUpdated.getSex());
            newPet.setBreed(petToBeUpdated.getBreed());
            newPet.setAge(petToBeUpdated.getAge());
            newPet.setPetDescription(petToBeUpdated.getPetDescription());

            petrepository.save(newPet);
            return newPet;

        }
        else {
            return null;
        }
    }

    @Override
    public void deletePet(int petId) {
        //check if id really exists first
        Optional<Pet> existingPet = petrepository.findById(petId);
        if(existingPet.isPresent()) {
            petrepository.deleteById(petId);
        }
        //fixme handle if pet doesn't exist
    }
}
