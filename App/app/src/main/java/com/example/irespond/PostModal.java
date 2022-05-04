package com.example.irespond;

public class PostModal {

    // variables for our coursename,
    // description, tracks and duration, id.
    private String username;
    private String content;
    private int id;

    // creating getter and setter methods
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public PostModal(String username, String content) {
        this.username = username;
        this.content = content;
    }
}
