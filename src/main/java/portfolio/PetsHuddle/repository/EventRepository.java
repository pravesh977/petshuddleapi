package portfolio.PetsHuddle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import portfolio.PetsHuddle.model.Event;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    @Query("SELECT e FROM Event e WHERE e.eventTitle LIKE %?1%")
    List<Event> findAllByEventNamesdf(String eventNameValue);
}
