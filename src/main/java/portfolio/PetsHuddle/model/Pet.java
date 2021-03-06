package portfolio.PetsHuddle.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pets")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "petId")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id", nullable = false)
    private int petId;

    @Column(name = "pet_name", nullable = false, length = 30)
    private String petName;

    @Column(name = "species", nullable = false, length = 30)
    private String species;

    @Column(name = "sex", nullable = false, length = 10)
    private String sex;

    @Column(name = "breed", nullable = false, length = 30)
    private String breed;

    @Column(name = "age", nullable = false, length = 3)
    private int age;

    @Column(name = "pet_description", nullable = false, length = 1000)
    private String petDescription;

    @Column(name = "user_id", nullable = false)
    private String userId;


    //this is unidirectional only
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "pet_id", referencedColumnName = "pet_id")
    private List<Friend> friendsList = new ArrayList<>();

//    for bidirectional
//    @JsonIgnore
//    @OneToMany(mappedBy = "pet")
//    private List<Friend> friendsList = new ArrayList<>();

//    @JsonIgnore
//    @OneToMany(mappedBy = "pet")
//    private Set<Friend> friendsList;


    //original working for pet side
//    //for many-to-many relationship between pets and events
//    //@JsonIgnore
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable( name = "pets_events",
//                joinColumns = @JoinColumn(name = "pet_id"),
//                inverseJoinColumns = @JoinColumn(name = "event_id"))
//    //@JsonBackReference
//    private List<Event> eventsListForPets;

    @JsonIgnore
    @ManyToMany(mappedBy = "petsListForEvent")
    private List<Event> eventsListForPets;

    //constructors
    public Pet() {
    }

    public Pet(int petId, String petName, String species, String sex, String breed, int age, String petDescription, String userId) {
        this.petId = petId;
        this.petName = petName;
        this.species = species;
        this.sex = sex;
        this.breed = breed;
        this.age = age;
        this.petDescription = petDescription;
        this.userId = userId;
    }

    public int getPetId() {
        return petId;
    }

    public String getPetName() {
        return petName;
    }

    public String getSpecies() {
        return species;
    }

    public String getSex() {
        return sex;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String getPetDescription() {
        return petDescription;
    }

    public String getUserId() {
        return userId;
    }

//    public List<Friend> getFriendsList() {
//        return friendsList;
//    }


    public List<Friend> getFriendsList() {
        return friendsList;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPetDescription(String petDescription) {
        this.petDescription = petDescription;
    }

    public List<Event> getEventsListForPets() {
        return eventsListForPets;
    }

    public void addEventForPet(Event event) {
        eventsListForPets.add(event);
    }
}

