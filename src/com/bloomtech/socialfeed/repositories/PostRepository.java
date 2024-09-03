package com.bloomtech.socialfeed.repositories;

import com.bloomtech.socialfeed.models.Post;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostRepository {
    private static final String POST_DATA_PATH = "src/resources/PostData.json";

    public PostRepository() {
    }

    public List<Post> getAllPosts() {
        //TODO: return all posts from the PostData.json file
        List<Post> allPosts = new ArrayList<>();
        try (FileReader reader = new FileReader(POST_DATA_PATH)) {
            Type postListType = new TypeToken<ArrayList<Post>>(){}.getType();
            Gson gson = new Gson();
            allPosts = gson.fromJson(reader, postListType);
        } catch (IOException e) {
            // If file doesn't exist or is empty, return an empty list
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return allPosts;
    }

    public List<Post> findByUsername(String username) {
        return getAllPosts()
                .stream()
                .filter(p -> p.getUsername().equals(username))
                .collect(Collectors.toList());
    }

    public List<Post> addPost(Post post) {
        List<Post> allPosts = new ArrayList<>();
        allPosts.add(post);

        //TODO: Write the new Post data to the PostData.json file
        try (FileWriter writer = new FileWriter(POST_DATA_PATH)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(allPosts, writer);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        //TODO: Return an updated list of all posts
        return allPosts;
    }
}
