package com.designpatterns.strategy.playmedia;

public class InstaFriends implements ConnectFriends {
    @Override
    public void connectTo(String name) {
        System.out.println("Found " + name + " on Instagram");
    }
}
