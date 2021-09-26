package portfolio.PetsHuddle.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import portfolio.PetsHuddle.model.Friend;
import portfolio.PetsHuddle.service.FriendService;

@RestController
@RequestMapping("api/friendslist")
public class FriendController {

    public FriendService friendService;

    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    //build create new Friend API
    @PostMapping
    public ResponseEntity<Friend> saveFriend(@RequestBody Friend friend) {
        ResponseEntity<Friend> newFriend = new ResponseEntity<Friend>(friendService.saveFriend(friend), HttpStatus.CREATED);
        return newFriend;
    }
}
