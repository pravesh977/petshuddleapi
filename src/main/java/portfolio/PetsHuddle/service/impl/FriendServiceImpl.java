package portfolio.PetsHuddle.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import portfolio.PetsHuddle.model.Friend;
import portfolio.PetsHuddle.model.FriendId;
import portfolio.PetsHuddle.model.Pet;
import portfolio.PetsHuddle.repository.FriendRepository;
import portfolio.PetsHuddle.service.FriendService;

import java.util.List;
import java.util.Optional;

@Service
public class FriendServiceImpl implements FriendService {

    Logger logger = LoggerFactory.getLogger(FriendServiceImpl.class);


    private FriendRepository friendRepository;

    public FriendServiceImpl(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    @Override
    public Friend saveFriend(Friend friendObject) {
        //logger.info("friend stuff is : " + friendObject.getFriendId());
        friendRepository.save(friendObject);
        return friendObject;
    }

    @Override
    public List<Friend> getAllFriends() {
        return friendRepository.findAll();
    }

//    for unidirectional custom query
    @Override
    public List<Friend> getFriendsListByPetId(int petId) {
        return friendRepository.getFriendsListByPetId(petId);
    }

    @Override
    public List<Friend> getFriendRequestsForPet(int petId) {
        return friendRepository.getFriendRequestsForPet(petId);
    }

    @Override
    public Friend updateFriend(Friend friendToBeUpdated, FriendId friendId) {
        Optional<Friend> existingFriend = friendRepository.findById(friendId);
        if(existingFriend.isPresent()) {

            Friend newFriend = existingFriend.get();
            newFriend.setFriendId(friendToBeUpdated.getFriendId());
            newFriend.setPetId(friendToBeUpdated.getPetId());
            newFriend.setRequestStatus(friendToBeUpdated.getRequestStatus());

//            friendRepository.save(newFriend);
            return newFriend;
        }
        else {
            return null; //fixme: handle exception
        }

    }

}
