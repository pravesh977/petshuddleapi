package portfolio.PetsHuddle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import portfolio.PetsHuddle.model.Pet;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Integer> {
    @Query("SELECT p FROM Pet p WHERE p.petName LIKE %?1% ORDER BY petName ASC")
    List<Pet> findAllByPetName(@Param("petName") String searchPetValue);
    //@Param ensures that the value "petName" matches with the field of pet
    //called petName because everything is automatic

    List<Pet> findAllByUserId(String userId);

    //to get all values based on column name
    //List<Pet> findAllByAge(int age);

    @Query("SELECT p FROM Pet p WHERE petId IN (:friendId)")
    List<Pet> getListOfFriendsForPet(List<Integer> friendId);


}
