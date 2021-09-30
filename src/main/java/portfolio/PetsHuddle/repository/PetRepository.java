package portfolio.PetsHuddle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portfolio.PetsHuddle.model.Pet;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Integer> {
    //to get all values based on column name
    //List<Pet> findAllByAge(int age);
}
