package com.bloomtech.socialfeed.observerpattern;

import com.bloomtech.socialfeed.models.Post;
import com.bloomtech.socialfeed.models.User;

import java.util.ArrayList;
import java.util.List;

//TODO: Implement Observer Pattern
public class OUserFeed implements Observer {
    private User user;
    private List<Post> feed;
    private static SourceFeed sourceFeed;

    public OUserFeed(User user) {
        this.user = user;
        //TODO: update OUserFeed in constructor after implementing observer pattern
        this.feed = new ArrayList<>();
        if (sourceFeed != null) {
            sourceFeed.attach(this);
        }
    }

    public static void setSourceFeed(SourceFeed sf) {
        sourceFeed = sf;
    }

    @Override
    public void update() {

    }

    @Override
    public void update(List<Post> posts) {
        feed.clear();
        for (Post post : posts) {
            if (user.getFollowing().contains(post.getUsername())) {
                feed.add(post);
            }
        }
    }

    public User getUser() {
        return user;
    }

    public List<Post> getFeed() {
        return feed;
    }
}
