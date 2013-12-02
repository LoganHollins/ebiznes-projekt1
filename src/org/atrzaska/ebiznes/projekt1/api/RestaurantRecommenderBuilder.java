package org.atrzaska.ebiznes.projekt1.api;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.CityBlockSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.UncenteredCosineSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class RestaurantRecommenderBuilder implements RecommenderBuilder {
    
    private String recommenderType;

    private String similarityType;
    
    private String userNeighborhoodType;
    
    private String userNeightborhoodValue;

    public RestaurantRecommenderBuilder() {
        this.recommenderType = "user based";
        this.similarityType = "UncenteredCosineSimilarity";
        this.userNeighborhoodType = "NearestNUserNeighborhood";
        this.userNeightborhoodValue = "10";
    }
    
    @Override
    public Recommender buildRecommender(DataModel dataModel) throws TasteException {
        
        if(recommenderType.equals("item based")) {
            ItemSimilarity itemSimilarity = this.convertItemSimilarity(dataModel);
            return new GenericItemBasedRecommender(dataModel, itemSimilarity);
        } else {
            UserSimilarity userSimilarity = this.convertUserSimilarity(dataModel);
            UserNeighborhood userNeighborhood = this.convertUserNeighborhood(dataModel, userSimilarity);
            return new GenericUserBasedRecommender(dataModel, userNeighborhood, userSimilarity);
        }
    }
    public ItemSimilarity convertItemSimilarity(DataModel dataModel) throws TasteException {
        switch (similarityType) {
            case "UncenteredCosineSimilarity":
                return new UncenteredCosineSimilarity(dataModel);
            case "PearsonCorrelationSimilarity":
                return new PearsonCorrelationSimilarity(dataModel);
            case "CityBlockSimilarity":
                return new CityBlockSimilarity(dataModel);
            case "TanimotoCoefficientSimilarity":
                return new TanimotoCoefficientSimilarity(dataModel);
            case "EuclideanDistanceSimilarity":
                return new EuclideanDistanceSimilarity(dataModel);
        }
    
        return null;
    }
    
    public UserSimilarity convertUserSimilarity(DataModel dataModel) throws TasteException {
        switch (similarityType) {
            case "UncenteredCosineSimilarity":
                return new UncenteredCosineSimilarity(dataModel);
            case "PearsonCorrelationSimilarity":
                return new PearsonCorrelationSimilarity(dataModel);
            case "CityBlockSimilarity":
                return new CityBlockSimilarity(dataModel);
            case "TanimotoCoefficientSimilarity":
                return new TanimotoCoefficientSimilarity(dataModel);
            case "EuclideanDistanceSimilarity":
                return new EuclideanDistanceSimilarity(dataModel);
        }
    
        return null;
    }
    /**
     * @return the recommenderType
     */
    public String getRecommenderType() {
        return recommenderType;
    }

    /**
     * @param recommenderType the recommenderType to set
     */
    public void setRecommenderType(String recommenderType) {
        this.recommenderType = recommenderType;
    }

    /**
     * @return the similarityType
     */
    public String getSimilarityType() {
        return similarityType;
    }

    /**
     * @param similarityType the similarityType to set
     */
    public void setSimilarityType(String similarityType) {
        this.similarityType = similarityType;
    }

    /**
     * @return the userNeighborhoodType
     */
    public String getUserNeighborhoodType() {
        return userNeighborhoodType;
    }

    /**
     * @param userNeighborhoodType the userNeighborhoodType to set
     */
    public void setUserNeighborhoodType(String userNeighborhoodType) {
        this.userNeighborhoodType = userNeighborhoodType;
    }

    /**
     * @return the userNeightborhoodValue
     */
    public String getUserNeightborhoodValue() {
        return userNeightborhoodValue;
    }

    /**
     * @param userNeightborhoodValue the userNeightborhoodValue to set
     */
    public void setUserNeightborhoodValue(String userNeightborhoodValue) {
        this.userNeightborhoodValue = userNeightborhoodValue;
    }

    private UserNeighborhood convertUserNeighborhood(DataModel dataModel, UserSimilarity userSimilarity) throws TasteException {
        double value = Double.parseDouble(userNeightborhoodValue);
        switch (userNeighborhoodType) {
            case "NearestNUserNeighborhood":
                return new NearestNUserNeighborhood((int)value, userSimilarity, dataModel);
            case "ThresholdUserNeighborhood":
                return new ThresholdUserNeighborhood(value, userSimilarity, dataModel);
        }
    
        return null;
    }
}
