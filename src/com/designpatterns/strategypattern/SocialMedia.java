package com.designpatterns.strategypattern;

import com.designpatterns.strategypattern.playmedia.ConnectFriends;

public class SocialMedia {
    private ConnectFriends friends;

    public SocialMedia (ConnectFriends friend) {
        friends = friend;
    }

    public void findFriend(String name) {
        friends.connectTo(name);
    }
}
