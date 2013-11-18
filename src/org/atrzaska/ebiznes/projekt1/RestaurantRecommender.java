package org.atrzaska.ebiznes.projekt1;

import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.Recommender;

public class RestaurantRecommender {

    /**
     * recommender
     */
    protected Recommender recommender;

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
    protected DataModel dataModel;

    public RestaurantRecommender() throws IOException, TasteException {
        // read datamodel
        System.out.println("czytam model");
        System.out.println("----------------------------------------------------------------------------------");
        this.dataModel = new FileDataModel(new File(Config.databaseFile));

        // read place names
        System.out.println("czytam liste restauracji");
        System.out.println("----------------------------------------------------------------------------------");
        this.restaurantsList = new RestaurantsList(Config.titlesFile);

        // build recommender
        System.out.println("buduje rekomender");
        System.out.println("----------------------------------------------------------------------------------");
        RecommenderBuilder recommenderBuilder = new RestaurantRecommenderBuilder();
        this.recommender = recommenderBuilder.buildRecommender(dataModel);
    }
}
