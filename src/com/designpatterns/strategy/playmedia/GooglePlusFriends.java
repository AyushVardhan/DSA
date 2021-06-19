package com.designpatterns.strategy.playmedia;

public class GooglePlusFriends implements ConnectFriends {
    @Override
    public void connectTo(String name) {
        System.out.println("Found " + name + " on Google");
    }
}
