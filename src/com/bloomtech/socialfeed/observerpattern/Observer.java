package com.bloomtech.socialfeed.observerpattern;

import com.bloomtech.socialfeed.models.Post;

import java.util.List;

public interface Observer {
    void update();

    void update(List<Post> posts);
}
