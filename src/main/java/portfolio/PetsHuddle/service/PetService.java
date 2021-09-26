package portfolio.PetsHuddle.service;

import portfolio.PetsHuddle.model.Pet;

import java.util.List;

public interface PetService {
    Pet savePet(Pet pet);
    List<Pet> getAllPets();
}
