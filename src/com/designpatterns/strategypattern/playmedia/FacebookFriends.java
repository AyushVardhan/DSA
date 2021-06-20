package com.designpatterns.strategypattern.playmedia;

public class FacebookFriends implements ConnectFriends {
    @Override
    public void connectTo(String name) {
        System.out.println("Found " + name + " on facebook");
    }
}
