package portfolio.PetsHuddle.service.impl;

import org.springframework.stereotype.Service;
import portfolio.PetsHuddle.model.Pet;
import portfolio.PetsHuddle.repository.PetRepository;
import portfolio.PetsHuddle.service.PetService;

import java.util.List;

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
}
