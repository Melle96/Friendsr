package com.example.melle.friendsr;

import java.io.Serializable;

// class Friend maken
public class Friend implements Serializable {
    // geef naam, bio mee
    private String name, bio;
    // id aangemaakt
    private int drawableId;
    // rating gemaakt
    private float rating;

    // constructor wordt gemaakt om zojuist gedefinieerde properties waarden mee te geven
    public Friend(String name, String bio, int drawableId) {
        this.name = name;
        this.bio = bio;
        this.drawableId = drawableId;
        this.rating = 0;
    }

    // getter voor name aanmaken
    public String getName() {
        return this.name;
    }
    // getter voor biografie aanmaken
    public String getBio() {
        return this.bio;
    }
    // getter voor id aanmaken
    public int getDrawableId() {
        return this.drawableId;
    }
    // getter voor rating maken
    public float getRating() {
        return this.rating;
    }

    // setter voor rating maken
    public void setRating(float Ratingg) {
        this.rating = Ratingg;
    }

    // sets biografie
    public void setBio(String bioo) {
        this.bio = bioo;
    }
}
