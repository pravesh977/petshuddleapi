package portfolio.PetsHuddle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portfolio.PetsHuddle.model.Friend;

public interface FriendRepository extends JpaRepository<Friend, Integer> {
}
