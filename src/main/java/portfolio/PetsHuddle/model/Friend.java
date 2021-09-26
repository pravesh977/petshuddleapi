package portfolio.PetsHuddle.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "friends")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_friend_uid", nullable = false)
    private int petFriendUid;

    @Column(name = "friend_id")
    private int friendId;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pet_id", referencedColumnName = "pet_id")
    private Pet pet;


    public Friend(int petFriendUid, int friendId, Pet pet) {
        this.petFriendUid = petFriendUid;
        this.friendId = friendId;
        this.pet = pet;
    }

    public int getFriendId() {
        return friendId;
    }

    public Pet getPet() {
        return pet;
    }
}
