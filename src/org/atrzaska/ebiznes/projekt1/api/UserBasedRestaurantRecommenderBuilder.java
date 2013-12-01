package org.atrzaska.ebiznes.projekt1.api;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.UncenteredCosineSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class UserBasedRestaurantRecommenderBuilder implements RecommenderBuilder {
    
    private UserSimilarity userSimilarity;
    
    private UserNeighborhood userNeighborhood;
    
    private Recommender recommender;

    @Override
    public Recommender buildRecommender(DataModel dataModel) throws TasteException {
//        UncenteredCosineSimilarity similarity = new UncenteredCosineSimilarity(dataModel);
//        PearsonCorrelationSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
//        CityBlockSimilarity similarity = new CityBlockSimilarity(dataModel);

//        UserNeighborhood neighborhood = new NearestNUserNeighborhood(10, userSimilarity, dataModel);
//        UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, similarity, dataModel);
//        UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.05, similarity, dataModel);

        Recommender recommender = new GenericUserBasedRecommender(dataModel, userNeighborhood, userSimilarity);
//        recommender = new CachingRecommender(recommender);
        
        return recommender;
    }

    /**
     * @return the userSimilarity
     */
    public UserSimilarity getUserSimilarity() {
        return userSimilarity;
    }

    /**
     * @param userSimilarity the userSimilarity to set
     */
    public void setUserSimilarity(UserSimilarity userSimilarity) {
        this.userSimilarity = userSimilarity;
    }

    /**
     * @return the userNeighborhood
     */
    public UserNeighborhood getUserNeighborhood() {
        return userNeighborhood;
    }

    /**
     * @param userNeighborhood the userNeighborhood to set
     */
    public void setUserNeighborhood(UserNeighborhood userNeighborhood) {
        this.userNeighborhood = userNeighborhood;
    }

    /**
     * @return the recommender
     */
    public Recommender getRecommender() {
        return recommender;
    }

    /**
     * @param recommender the recommender to set
     */
    public void setRecommender(Recommender recommender) {
        this.recommender = recommender;
    }
}
