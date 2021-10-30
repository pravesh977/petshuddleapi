package portfolio.PetsHuddle.service;

import portfolio.PetsHuddle.model.Friend;

import java.util.List;

public interface FriendService {
    Friend saveFriend(Friend friendObject);
    List<Friend> getAllFriends();
    //    for unidirectional custom query
    List<Friend> getFriendsListByPetId(int petId);
    List<Friend> getFriendRequestsForPet(int petId);
}
