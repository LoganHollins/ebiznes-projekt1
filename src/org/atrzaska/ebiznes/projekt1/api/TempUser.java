package org.atrzaska.ebiznes.projekt1.api;

import java.util.ArrayList;
import java.util.List;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.model.GenericUserPreferenceArray;
import org.apache.mahout.cf.taste.impl.model.PlusAnonymousUserDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.model.PreferenceArray;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class TempUser {
    private List<RestaurantScore> restaurantScores = new ArrayList<>();

    private RestaurantRecommender restaurantRecommender;
    
    public TempUser(RestaurantRecommender recommender) {
        this.restaurantRecommender = recommender;
    }

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

    public UserSimilarityResult GetMostSimiliarUser() throws TasteException {
        long tempId = PlusAnonymousUserDataModel.TEMP_USER_ID;

        // prepare new user's preferences
        PlusAnonymousUserDataModel tempModel = new PlusAnonymousUserDataModel(restaurantRecommender.getDataModel());
        tempModel.setTempPrefs(this.getPreferencesArray());

        System.out.println("GetMostSimiliarUser");

        // create recommender
        RecommenderBuilder recommenderBuilder = new RestaurantRecommenderBuilder();
        GenericUserBasedRecommender recommender = (GenericUserBasedRecommender)recommenderBuilder.buildRecommender(tempModel);

        // get similar user id
        long[] resultIds = recommender.mostSimilarUserIDs(PlusAnonymousUserDataModel.TEMP_USER_ID, 1);
        long similarUserId = resultIds[0];

        UserSimilarity userSimilarity = recommender.getSimilarity();
        double similarityValue = userSimilarity.userSimilarity(tempId, similarUserId);

        UserSimilarityResult userSimilarityResult = new UserSimilarityResult();
        userSimilarityResult.setUser(new User((int) similarUserId));
        userSimilarityResult.setSimilarity(similarityValue);

        return userSimilarityResult;
    }
}
