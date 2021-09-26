package portfolio.PetsHuddle.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id", nullable = false)
    private int petId;

    @Column(name = "pet_name", nullable = false)
    private String petName;

    @Column(name = "species", nullable = false)
    private String species;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "breed", nullable = false)
    private String breed;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "pet_description", nullable = false)
    private String petDescription;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pet", cascade = CascadeType.ALL)
    private List<Friend> friendsList = new ArrayList<>();

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

    public List<Friend> getFriendsList() {
        return friendsList;
    }
}
