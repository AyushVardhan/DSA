package com.designpatterns.strategypattern;

import com.designpatterns.strategypattern.playmedia.FacebookFriends;
import com.designpatterns.strategypattern.playmedia.GooglePlusFriends;
import com.designpatterns.strategypattern.playmedia.InstaFriends;

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
