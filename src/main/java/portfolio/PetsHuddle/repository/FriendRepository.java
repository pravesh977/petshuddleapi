package portfolio.PetsHuddle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import portfolio.PetsHuddle.model.Friend;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Integer> {
//    for unidirectional custom query
//    @Query("SELECT f FROM Friend f WHERE f.foreignKeyColumn = ?1")
//    List<Friend> getFriendsListByPetId(int petId);
}
