package portfolio.PetsHuddle.model;

import java.io.Serializable;
import java.util.Objects;

public class CompositeFriendId implements Serializable {

    private int friendId;
    private int petId;

    public CompositeFriendId() {
    }

    public CompositeFriendId(int friendId, int petId) {
        this.friendId = friendId;
        this.petId = petId;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeFriendId friendId1 = (CompositeFriendId) o;
        return friendId == friendId1.friendId && petId == friendId1.petId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(friendId, petId);
    }
}
