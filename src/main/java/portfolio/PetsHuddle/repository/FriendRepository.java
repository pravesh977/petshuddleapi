package portfolio.PetsHuddle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import portfolio.PetsHuddle.model.Friend;
import portfolio.PetsHuddle.model.FriendId;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, FriendId> {
//    for unidirectional custom query
    @Query("SELECT f FROM Friend f WHERE f.petId = ?1")
    List<Friend> getFriendsListByPetId(int petId);
}
