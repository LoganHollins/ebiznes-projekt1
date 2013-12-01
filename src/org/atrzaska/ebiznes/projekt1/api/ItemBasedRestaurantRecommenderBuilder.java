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

public class ItemBasedRestaurantRecommenderBuilder implements RecommenderBuilder {
    
    private ItemSimilarity itemSimilarity;

    private Recommender recommender;

    @Override
    public Recommender buildRecommender(DataModel dataModel) throws TasteException {
//        UncenteredCosineSimilarity similarity = new UncenteredCosineSimilarity(dataModel);
//        PearsonCorrelationSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
//        CityBlockSimilarity similarity = new CityBlockSimilarity(dataModel);

        Recommender recommender = new GenericItemBasedRecommender(dataModel, getItemSimilarity());
//        recommender = new CachingRecommender(recommender);
        
        return recommender;
    }

    /**
     * @return the itemSimilarity
     */
    public ItemSimilarity getItemSimilarity() {
        return itemSimilarity;
    }

    /**
     * @param itemSimilarity the itemSimilarity to set
     */
    public void setItemSimilarity(ItemSimilarity itemSimilarity) {
        this.itemSimilarity = itemSimilarity;
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
