package portfolio.PetsHuddle.service.impl;

import org.springframework.stereotype.Service;
import portfolio.PetsHuddle.model.Friend;
import portfolio.PetsHuddle.repository.FriendRepository;
import portfolio.PetsHuddle.service.FriendService;

@Service
public class FriendServiceImpl implements FriendService {

    private FriendRepository friendRepository;

    public FriendServiceImpl(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    @Override
    public Friend saveFriend(Friend friendObject) {
       friendRepository.save(friendObject);
       return friendObject;
    }
}
