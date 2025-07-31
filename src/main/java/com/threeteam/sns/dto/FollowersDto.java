package com.threeteam.sns.dto;

import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;

public class FollowersDto {
    private Long	id;
    private String	follower;
    private String	followee;
    private LocalDateTime	created_at;

    public FollowersDto() {}

    public FollowersDto(Long id, String follower, String followee, LocalDateTime created_at) {
        this.id = id;
        this.follower = follower;
        this.followee = followee;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public String getFollowee() {
        return followee;
    }

    public void setFollowee(String followee) {
        this.followee = followee;
    }

    public LocalDateTime getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, follower, followee, created_at);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FollowersDto other = (FollowersDto) obj;
        return Objects.equals(id, other.id) && Objects.equals(follower, other.follower) && Objects.equals(followee, other.followee) && Objects.equals(created_at, other.created_at);
    }

    @Override
    public String toString() {
        return "FollowersDto [id=" + id + ", follower=" + follower + ", followee=" + followee + ", created_at=" + created_at + "]";
    }
}

