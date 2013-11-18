package org.atrzaska.ebiznes.projekt1.api;

import java.util.ArrayList;
import java.util.List;
import org.apache.mahout.cf.taste.impl.model.GenericUserPreferenceArray;
import org.apache.mahout.cf.taste.impl.model.PlusAnonymousUserDataModel;
import org.apache.mahout.cf.taste.model.PreferenceArray;

public class TempUser {
    private List<RestaurantScore> restaurantScores = new ArrayList<>();

    public void rate(int id, float rating) {
        restaurantScores.add(new RestaurantScore(id, rating));
    }

    public PreferenceArray getPreferencesArray() {
        PreferenceArray tempPrefs = new GenericUserPreferenceArray(restaurantScores.size());
        tempPrefs.setUserID(0, PlusAnonymousUserDataModel.TEMP_USER_ID);

        for(int i = 0; i < restaurantScores.size(); i++) {
            RestaurantScore restaurantScore = restaurantScores.get(i);
            tempPrefs.setItemID(i, restaurantScore.getId());
            tempPrefs.setValue(i, restaurantScore.getScore());
        }

        return tempPrefs;
    }
}
