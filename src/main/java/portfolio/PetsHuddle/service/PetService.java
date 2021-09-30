package portfolio.PetsHuddle.service;

import portfolio.PetsHuddle.model.Pet;

import java.util.List;

public interface PetService {
    Pet savePet(Pet pet);
    List<Pet> getAllPets();
    Pet getPetById(int petId);
    Pet updatePet(Pet pet, int petId);
    void deletePet(int petId);
    //List<Pet> findAllByAge(int age);
}
