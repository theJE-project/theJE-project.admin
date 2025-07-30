package com.example.gogguchips.api.users;

public class PendingUserData {
    private UsersData user;
    private long createdAt; // timestamp

    public PendingUserData(UsersData user) {
        this.user = user;
        this.createdAt = System.currentTimeMillis();
    }

    public UsersData getUser() {
        return user;
    }

    public long getCreatedAt() {
        return createdAt;
    }
}