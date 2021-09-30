package portfolio.PetsHuddle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portfolio.PetsHuddle.model.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
