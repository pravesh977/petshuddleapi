package portfolio.PetsHuddle.model;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "eventId")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id", nullable = false)
    private int eventId;

    @Column(name = "event_title", nullable = false)
    private String eventTitle;

    @Column(name = "event_details", nullable = false)
    private String eventDetails;

    @Column(name = "event_location", nullable = false)
    private String eventLocation;

    @Column(name = "event_date", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date eventDate;

    //@JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "eventsListForPets")
    //@JsonManagedReference
    private List<Pet> petsListForEvent;

//    public Event() {
//
//    }
//
//    public Event(int eventId, String eventTitle, String eventDetails, String eventLocation, Date eventDate, List<Pet> petsListForEvent) {
//        this.eventId = eventId;
//        this.eventTitle = eventTitle;
//        this.eventDetails = eventDetails;
//        this.eventLocation = eventLocation;
//        this.eventDate = eventDate;
//        this.petsListForEvent = petsListForEvent;
//    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public List<Pet> getPetsListForEvent() {
        return petsListForEvent;
    }
}
