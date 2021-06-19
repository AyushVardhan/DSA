package com.designpatterns.strategy;

import com.designpatterns.strategy.playmedia.ConnectFriends;

public class SocialMedia {
    private ConnectFriends friends;

    public SocialMedia (ConnectFriends friend) {
        friends = friend;
    }

    public void findFriend(String name) {
        friends.connectTo(name);
    }
}
