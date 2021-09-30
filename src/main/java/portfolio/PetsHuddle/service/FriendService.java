package portfolio.PetsHuddle.service;

import portfolio.PetsHuddle.model.Friend;

import java.util.List;

public interface FriendService {
    Friend saveFriend(Friend friendObject);
    List<Friend> getAllFriends();
    List<Friend> getFriendsListByPetId(int petId);
}
