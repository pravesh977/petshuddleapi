package portfolio.PetsHuddle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import portfolio.PetsHuddle.model.Friend;
import portfolio.PetsHuddle.model.CompositeFriendId;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, CompositeFriendId> {
//    for unidirectional custom query
    @Query("SELECT f FROM Friend f WHERE f.petId = ?1")
    List<Friend> getFriendsListByPetId(int petId);

    //for getting list of friend requests for the selected current pet
    @Query("SELECT f FROM Friend f WHERE f.friendId = ?1 AND requestStatus = 'p'")
    List<Friend> getFriendRequestsForPet(int petId);
}
