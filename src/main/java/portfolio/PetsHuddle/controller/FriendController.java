package portfolio.PetsHuddle.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolio.PetsHuddle.model.Friend;
import portfolio.PetsHuddle.model.CompositeFriendId;
import portfolio.PetsHuddle.service.FriendService;

import java.util.List;

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

    //api for getting all friends list
    @GetMapping
    public List<Friend> getAllFriends() {
        return friendService.getAllFriends();
    }

    //api for getting friendslist by pet id
    //    for unidirectional custom query
    @GetMapping("/friendsbypetid/{petId}")
    public List<Friend> getFriendsListByPetId(@PathVariable("petId") int petId) {
        return friendService.getFriendsListByPetId(petId);
    }

    //building update friend api
//    @PutMapping("{friendId}")
//    public ResponseEntity<Friend> updateFriend(@PathVariable("friendId") FriendId friendId, @RequestBody Friend friend) {
//        return new ResponseEntity<Friend>(friendService.updateFriend(friend, friendId), HttpStatus.OK);
//    }

    @PutMapping("/friendid/{friendId}/petid/{petId}")
    public ResponseEntity<Friend> updateFriend(
            @PathVariable("friendId") int friendId,
            @PathVariable("petId") int petId,
            @RequestBody Friend friend) {
        CompositeFriendId compositeFriendIdObject = new CompositeFriendId(friendId, petId);
        return new ResponseEntity<Friend>(friendService.updateFriend(friend, compositeFriendIdObject), HttpStatus.OK);
    }

    //api for getting friend requests for selected pet with pending requests
    @GetMapping("/friendrequests/{petId}")
    public List<Friend> getFriendRequestsForPet(@PathVariable("petId") int petId) {
        return friendService.getFriendRequestsForPet(petId);
    }
}
