package org.atrzaska.ebiznes.projekt1.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.atrzaska.ebiznes.util.FileUtils;

public final class RestaurantsList {

    protected List<Restaurant> restaurantsList = new ArrayList<>();
    protected Map<Integer, Restaurant> restaurantsMap = new HashMap<>();
    protected Map<String, Restaurant> nameToIdMap = new HashMap<>();

    public RestaurantsList(String path) {
       loadRestaurants(path);
    }

    public void loadRestaurants(String path) {
        // open file for reading
        String fileString = FileUtils.readFileAsString(path);

        // compile pattern for matching lines
        Pattern pattern = Pattern.compile("(\\d+),[ ]*(.+)");
        Matcher matcher = pattern.matcher(fileString);

        // find matches
        while (matcher.find()) {
            // parse line
            int id = Integer.parseInt(matcher.group(1));
            String name = matcher.group(2);

            // set value
            Restaurant restaurant = new Restaurant(id, name);
            restaurantsList.add(restaurant);
            restaurantsMap.put(id, restaurant);
            nameToIdMap.put(name, restaurant);
        }
    }

    public Restaurant getRestaurant(int id) {
        return restaurantsMap.get(id);
    }

    public List<Restaurant> getAsList() {
        return restaurantsList;
    }

    public Map<Integer, Restaurant> getAsMap() {
        return restaurantsMap;
    }
    
    public Restaurant getRestaurantByName(String name) {
        return nameToIdMap.get(name);
    }
}
