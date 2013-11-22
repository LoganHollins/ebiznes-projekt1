package org.atrzaska.ebiznes.projekt1.api;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.UncenteredCosineSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class RestaurantRecommenderBuilder implements RecommenderBuilder {

    @Override
    public Recommender buildRecommender(DataModel dataModel) throws TasteException {
        UserSimilarity similarity = new UncenteredCosineSimilarity(dataModel);
//        UserSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
//        UserSimilarity similarity = new CityBlockSimilarity(dataModel);

        UserNeighborhood neighborhood = new NearestNUserNeighborhood(10, similarity, dataModel);
//        UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, similarity, dataModel);
//        UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.05, similarity, dataModel);

        Recommender recommender = new GenericUserBasedRecommender(dataModel, neighborhood, similarity);
        Recommender cachingRecommender = new CachingRecommender(recommender);
        return cachingRecommender;
    }
}
