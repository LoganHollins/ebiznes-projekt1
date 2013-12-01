package org.atrzaska.ebiznes.projekt1.api;

import org.atrzaska.ebiznes.projekt1.Config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.PlusAnonymousUserDataModel;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.GenericJDBCDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.ReloadFromJDBCDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.model.Preference;
import org.apache.mahout.cf.taste.model.PreferenceArray;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.atrzaska.ebiznes.util.MahoutUtils;

public class RestaurantRecommender {

    /**
     * restaurantsList
     */
    protected RestaurantsList restaurantsList;

    /**
     * userList
     */
    protected UserList userList;

    /**
     * dataModel
     */
    private DataModel dataModel;

    /**
     * tempUser
     */
    private TempUser tempUser;

    public RestaurantRecommender() throws IOException, TasteException {
        // read datamodel
        System.out.println("czytam model");
        System.out.println("----------------------------------------------------------------------------------");
        this.dataModel = new FileDataModel(new File(Config.databaseFile));
//        this.dataModel = new GenericJDBCDataModel(null)

        // read place names
        System.out.println("czytam liste restauracji");
        System.out.println("----------------------------------------------------------------------------------");
        this.restaurantsList = new RestaurantsList(Config.titlesFile);

        System.out.println("tworze użytkownika tymczasowego");
        System.out.println("----------------------------------------------------------------------------------");
        tempUser = new TempUser(this);
    }

    public RestaurantsList getRestaurantsList() {
        return restaurantsList;
    }
    
    public void resetTempUser() {
        setTempUser(new TempUser(this));
    }
    
    public List<Restaurant> getColdStartList() throws TasteException {
        List<Restaurant> results = new ArrayList<>();

        long[] maxIds = new long[5];
        float maxMean = 0;

        // iterate item ids
        for (LongPrimitiveIterator it = getDataModel().getItemIDs(); it.hasNext();) {
            long itemID = it.next();
            PreferenceArray preferenceArray = getDataModel().getPreferencesForItem(itemID);

            float sum = 0;

            // iterate preferences
            for (Preference preference : preferenceArray) {
                sum += preference.getValue();
            }

            float mean = sum / preferenceArray.length();

            if(mean > maxMean) {
                maxMean = mean;

                maxIds[4] = maxIds[3];
                maxIds[3] = maxIds[2];
                maxIds[2] = maxIds[1];
                maxIds[1] = maxIds[0];
                maxIds[0] = itemID;
            }
        }
        
        for(int i = 0; i < 5; i++) {
            results.add(restaurantsList.getRestaurant((int) maxIds[i]));
        }

        return results;
    }

    public TempUser getTempUser() {
        return tempUser;
    }

    public void setTempUser(TempUser tempUser) {
        this.tempUser = tempUser;
    }

    public List<Restaurant> recommendMoviesForTempUser() throws TasteException {
        // prepare new user's preferences
        PlusAnonymousUserDataModel tempModel = new PlusAnonymousUserDataModel(getDataModel());
        tempModel.setTempPrefs(tempUser.getPreferencesArray());

        // create recommender
        RecommenderBuilder recommenderBuilder = new ItemBasedRestaurantRecommenderBuilder();
        Recommender recommender = recommenderBuilder.buildRecommender(tempModel);

        // make recommendations for a new user
        List<RecommendedItem> recommendedItems = recommender.recommend(PlusAnonymousUserDataModel.TEMP_USER_ID, 5);

        return MahoutUtils.recommendedItemListToRestaurantList(recommendedItems, restaurantsList);
    }

    public List<Restaurant> recommendMoviesForUser(int id) throws TasteException {
        // create recommender
        RecommenderBuilder recommenderBuilder = new ItemBasedRestaurantRecommenderBuilder();
        Recommender recommender = recommenderBuilder.buildRecommender(getDataModel());

        // make recommendations for a new user
        List<RecommendedItem> recommendedItems = recommender.recommend(id, 5);

        return MahoutUtils.recommendedItemListToRestaurantList(recommendedItems, restaurantsList);
    }

    /**
     * @return the dataModel
     */
    public DataModel getDataModel() {
        return dataModel;
    }
}
