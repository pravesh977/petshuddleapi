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

    //this is unidirectional and should be the same as the join column name
//    @Column(name = "foreign_key_column")
//    private int foreignKeyColumn;

//    for bidirectional
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id", referencedColumnName = "pet_id")
    private Pet pet;

    public Friend() {

    }

//    public Friend(int friendId, int foreignKeyColumn) {
//        this.friendId = friendId;
//        this.foreignKeyColumn = foreignKeyColumn;
//    }
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

    public int getPetFriendUid() {
        return petFriendUid;
    }

    public Pet getPet() {
        return pet;
    }
}
