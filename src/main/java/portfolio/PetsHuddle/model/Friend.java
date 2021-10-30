package portfolio.PetsHuddle.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@IdClass(FriendId.class)
@Table(name = "friends")
public class Friend {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "pet_friend_uid", nullable = false)
//    private int petFriendUid;

    @Column(name = "friend_id")
    @Id
    private int friendId;

    //this is unidirectional and should be the same as the join column name
    @Column(name = "pet_id")
    @Id
    private int petId;

    @Column(name = "request_status")
    private char requestStatus;
//    for bidirectional
//    @JsonIgnore
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "pet_id", referencedColumnName = "pet_id")
//    private Pet pet;

    public Friend() {
    }

    public Friend(int friendId, int petId, char requestStatus) {
        this.friendId = friendId;
        this.petId = petId;
        this.requestStatus = requestStatus;
    }
//
//    //remove
//    public int getForeignKeyColumn() {
//        return foreignKeyColumn;
//    }
//
//    //remove
//    public void setForeignKeyColumn(int foreignKeyColumn) {
//        this.foreignKeyColumn = foreignKeyColumn;
//    }

    public int getFriendId() {
        return friendId;
    }

//    public int getPetFriendUid() {
//        return petFriendUid;
//    }

//    public Pet getPet() {
//        return pet;
//    }

    public int getPetId() {
        return petId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public char getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(char requestStatus) {
        this.requestStatus = requestStatus;
    }
}
