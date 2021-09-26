package portfolio.PetsHuddle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portfolio.PetsHuddle.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer> {
}
