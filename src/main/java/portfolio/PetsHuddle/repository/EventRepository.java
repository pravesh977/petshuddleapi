package portfolio.PetsHuddle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import portfolio.PetsHuddle.model.Event;
import portfolio.PetsHuddle.model.EventsMonthlyReport;
import portfolio.PetsHuddle.model.Pet;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {

    @Query("SELECT e FROM Event e WHERE e.eventTitle LIKE %?1% ORDER BY eventDate DESC")
    List<Event> findAllByEventNamesdf(String eventNameValue);

//    @Query("SELECT COUNT(eventDate) FROM Event WHERE monthname(eventDate) = ?1")
//    int monthlyEventNumber(String eventMonth);

    @Query("SELECT e FROM Event e WHERE monthname(eventDate) = ?1")
    List<Event> eventsListByMonth(String eventMonth);
}