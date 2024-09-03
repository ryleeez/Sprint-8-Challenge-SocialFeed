package com.bloomtech.socialfeed.models;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private String username;
    private LocalDateTime postedon; //TODO: Convert type to LocalDateTime
    private String body;

    public Post() {
    }

    public Post(String username, LocalDateTime postedon, String body) {
        this.username = username;
        this.postedon = postedon;
        this.body = body;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getPostedon() {
        return postedon;
    }

    public void setPostedon(LocalDateTime postedon) {
        this.postedon = postedon;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Post{" +
                "username='" + username + '\'' +
                ", postedon='" + postedon + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    class LocalDateTimeAdapter implements JsonSerializer<LocalDateTime>,
            JsonDeserializer<LocalDateTime> {
        private final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        @Override
        public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(formatter.format(src));
        }

        @Override
        public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return LocalDateTime.parse(json.getAsString(), formatter);
        }
    }
}
