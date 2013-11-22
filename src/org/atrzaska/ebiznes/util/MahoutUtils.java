package org.atrzaska.ebiznes.util;

import java.util.ArrayList;
import java.util.List;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.atrzaska.ebiznes.projekt1.api.Restaurant;
import org.atrzaska.ebiznes.projekt1.api.RestaurantsList;

public class MahoutUtils {
    public static List<Restaurant> recommendedItemListToRestaurantList(
            List<RecommendedItem> recommendedItems,
            RestaurantsList restaurantsList) {

        // create result list
        List<Restaurant> results = new ArrayList<>();

        // populate result list
        for (RecommendedItem recommendedItem : recommendedItems) {
            results.add(restaurantsList.getRestaurant((int) recommendedItem.getItemID()));
        }

        return results;
    }
}
