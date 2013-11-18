package org.atrzaska.ebiznes.projekt1.api;

public class RestaurantScore {
    private int id;
    private Restaurant restaurant;
    private float score;

    public RestaurantScore(int id, float score) {
        this.id = id;
        this.score = score;
    }
    
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
