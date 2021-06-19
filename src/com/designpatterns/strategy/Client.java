package com.designpatterns.strategy;

import com.designpatterns.strategy.playmedia.FacebookFriends;
import com.designpatterns.strategy.playmedia.GooglePlusFriends;
import com.designpatterns.strategy.playmedia.InstaFriends;

public class Client {
    public static void main(String[] args) {
        SocialMedia facebookFriends = new SocialMedia(new FacebookFriends());
        SocialMedia googleFriends = new SocialMedia(new GooglePlusFriends());
        SocialMedia instaFriends = new SocialMedia(new InstaFriends());

        facebookFriends.findFriend("Ajmera");
        googleFriends.findFriend("Ajmera");
        instaFriends.findFriend("Ajmera");
    }
}
