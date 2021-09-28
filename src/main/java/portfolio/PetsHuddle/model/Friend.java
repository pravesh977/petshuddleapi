package portfolio.PetsHuddle.model;

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

    //remove
    @Column(name = "foreign_key_column")
    private int foreignKeyColumn;

    public Friend() {

    }

    public Friend(int friendId, int foreignKeyColumn) {
        this.friendId = friendId;
        this.foreignKeyColumn = foreignKeyColumn;
    }

    //remove
    public int getForeignKeyColumn() {
        return foreignKeyColumn;
    }

    //remove
    public void setForeignKeyColumn(int foreignKeyColumn) {
        this.foreignKeyColumn = foreignKeyColumn;
    }

    public int getFriendId() {
        return friendId;
    }

    public int getPetFriendUid() {
        return petFriendUid;
    }

}
