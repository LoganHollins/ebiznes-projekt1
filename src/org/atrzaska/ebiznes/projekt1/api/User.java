package org.atrzaska.ebiznes.projekt1.api;

import java.util.ArrayList;

public class User {
    private int id;
    private ArrayList<RestaurantScore> restaurantScores;

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addScore(RestaurantScore score) {
        this.restaurantScores.add(score);
    }

    public ArrayList<RestaurantScore> getScores() {
        return restaurantScores;
    }
}
