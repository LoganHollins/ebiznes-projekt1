package org.atrzaska.ebiznes.projekt1.gui;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import org.apache.mahout.cf.taste.common.TasteException;
import org.atrzaska.ebiznes.projekt1.api.Restaurant;
import org.atrzaska.ebiznes.projekt1.api.RestaurantRecommender;
import org.atrzaska.ebiznes.projekt1.api.TempUser;
import org.atrzaska.ebiznes.projekt1.api.UserSimilarityResult;

public final class GUI extends javax.swing.JFrame {
    private RecommenderBuilderCreatorForm recommenderBuilderCreatorForm;

    /**
     * restaurantRecommender
     */
    private RestaurantRecommender restaurantRecommender;

    /**
     * Creates new form GUI
     * @throws java.io.IOException
     * @throws org.apache.mahout.cf.taste.common.TasteException
     */
    public GUI() throws IOException, TasteException {

        // initComponents
        initComponents();

        // create recommender
        this.restaurantRecommender = new RestaurantRecommender();
        this.recommenderBuilderCreatorForm = new RecommenderBuilderCreatorForm(restaurantRecommender);

        // skonstruowac dynamicznie liste
        this.boxRestauracje.setModel(new DefaultComboBoxModel(getRestaurantRecommender().getRestaurantsList().getAsList().toArray()));

        // populate cold start list
        populateColdStartList();
    }

    public void populateColdStartList() throws TasteException {
        this.populateRecomendationList(getRestaurantRecommender().getColdStartList());
    }

    public void populateRecomendationList(List<Restaurant> restaurants) {
        this.recomendationList.removeAll();

        for (Restaurant restaurant : restaurants) {
            this.recomendationList.add(restaurant.getName());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        recomendationList = new java.awt.List();
        lblrekomend = new javax.swing.JLabel();
        btnScoreRecommendation = new javax.swing.JButton();
        lblRestauracja = new javax.swing.JLabel();
        boxRestauracje = new javax.swing.JComboBox();
        lblOcenaRekomendacji = new javax.swing.JLabel();
        txtOcenaRekomendacji = new javax.swing.JTextField();
        txtOcenaRestauracji = new javax.swing.JTextField();
        btnAddScoreManual = new javax.swing.JButton();
        lblOcena2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lblpodobnyuzytkownik = new javax.swing.JLabel();
        lblSimiliarUserName = new javax.swing.JLabel();
        lblPodobienstwoSt = new javax.swing.JLabel();
        lblPodobienstwoVal = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        recomendationList.setName(""); // NOI18N
        recomendationList.add("abba");
        recomendationList.add("baba");
        recomendationList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                recomendationListItemStateChanged(evt);
            }
        });

        lblrekomend.setText("Propozycje");

        btnScoreRecommendation.setText("OK");
        btnScoreRecommendation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScoreRecommendationActionPerformed(evt);
            }
        });

        lblRestauracja.setText("Restauracja");

        boxRestauracje.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "polute this with all restaurants" }));
        boxRestauracje.setName(""); // NOI18N
        boxRestauracje.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxRestauracjeItemStateChanged(evt);
            }
        });

        lblOcenaRekomendacji.setText("Oceń:");
        lblOcenaRekomendacji.setToolTipText("");

        btnAddScoreManual.setText("OK");
        btnAddScoreManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddScoreManualActionPerformed(evt);
            }
        });

        lblOcena2.setText("Oceń:");

        lblpodobnyuzytkownik.setText("Najbardziej podobny użytkownik:");

        lblSimiliarUserName.setText("0");

        lblPodobienstwoSt.setText("Stopień podobieństwa:");

        lblPodobienstwoVal.setText("0");

        jButton1.setText("Wybierz sposób rekomendacji");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacje o restauracji"));

        jLabel1.setText("wybierz restaurację, aby wyświetlić jej szczegóły");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblOcenaRekomendacji, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtOcenaRekomendacji, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnScoreRecommendation, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblRestauracja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblOcena2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtOcenaRestauracji, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddScoreManual, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(boxRestauracje, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblrekomend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblpodobnyuzytkownik)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSimiliarUserName))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPodobienstwoSt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPodobienstwoVal))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(recomendationList, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblrekomend)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(recomendationList, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOcenaRekomendacji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOcenaRekomendacji)
                    .addComponent(btnScoreRecommendation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRestauracja, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxRestauracje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOcenaRestauracji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddScoreManual)
                    .addComponent(lblOcena2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblpodobnyuzytkownik)
                    .addComponent(lblSimiliarUserName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPodobienstwoSt)
                    .addComponent(lblPodobienstwoVal))
                .addGap(11, 11, 11)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnScoreRecommendationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScoreRecommendationActionPerformed
        float val = Float.parseFloat(txtOcenaRekomendacji.getText());
        Restaurant restaurant = getRestaurantRecommender()
                .getRestaurantsList()
                .getRestaurantByName(recomendationList.getSelectedItem());

        TempUser tempUser = getRestaurantRecommender().getTempUser();
    
        tempUser.rate(restaurant.getId(), val);

        try {
            List<Restaurant> recommendedRestaurants = getRestaurantRecommender().
                    recommendMoviesForTempUser();
            
            this.populateRecomendationList(recommendedRestaurants);
            
            UserSimilarityResult usr = tempUser.GetMostSimiliarUser();

            this.lblSimiliarUserName.setText(String.valueOf(usr.getUser().getId()));
            this.lblPodobienstwoVal.setText(String.valueOf(usr.getSimilarity()));
        } catch (TasteException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnScoreRecommendationActionPerformed

    private void btnAddScoreManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddScoreManualActionPerformed
        float val = Float.parseFloat(txtOcenaRestauracji.getText());
        Restaurant restaurant = (Restaurant) boxRestauracje.getSelectedItem();

        // remove added index
        //boxRestauracje.remove(boxRestauracje.getSelectedIndex());

        TempUser tempUser = getRestaurantRecommender().getTempUser();
    
        tempUser.rate(restaurant.getId(), val);

        try {
            List<Restaurant> recommendedRestaurants = getRestaurantRecommender().
                    recommendMoviesForTempUser();
            
            this.populateRecomendationList(recommendedRestaurants);

            UserSimilarityResult usr = tempUser.GetMostSimiliarUser();

            this.lblSimiliarUserName.setText(String.valueOf(usr.getUser().getId()));
            this.lblPodobienstwoVal.setText(String.valueOf(usr.getSimilarity()));
        } catch (TasteException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddScoreManualActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RecommenderBuilderCreatorForm form = new RecommenderBuilderCreatorForm(restaurantRecommender);
        form.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void boxRestauracjeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxRestauracjeItemStateChanged
        Restaurant restaurant = (Restaurant) boxRestauracje.getSelectedItem();
    
        this.displayRstaurantInfo(restaurant);
    }//GEN-LAST:event_boxRestauracjeItemStateChanged

    private void recomendationListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_recomendationListItemStateChanged
        Restaurant restaurant = getRestaurantRecommender()
                .getRestaurantsList()
                .getRestaurantByName(recomendationList.getSelectedItem());
        
        this.displayRstaurantInfo(restaurant);
    }//GEN-LAST:event_recomendationListItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox boxRestauracje;
    private javax.swing.JButton btnAddScoreManual;
    private javax.swing.JButton btnScoreRecommendation;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblOcena2;
    private javax.swing.JLabel lblOcenaRekomendacji;
    private javax.swing.JLabel lblPodobienstwoSt;
    private javax.swing.JLabel lblPodobienstwoVal;
    private javax.swing.JLabel lblRestauracja;
    private javax.swing.JLabel lblSimiliarUserName;
    private javax.swing.JLabel lblpodobnyuzytkownik;
    private javax.swing.JLabel lblrekomend;
    private java.awt.List recomendationList;
    private javax.swing.JTextField txtOcenaRekomendacji;
    private javax.swing.JTextField txtOcenaRestauracji;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the restaurantRecommender
     */
    public RestaurantRecommender getRestaurantRecommender() {
        return restaurantRecommender;
    }

    /**
     * @param restaurantRecommender the restaurantRecommender to set
     */
    public void setRestaurantRecommender(RestaurantRecommender restaurantRecommender) {
        this.restaurantRecommender = restaurantRecommender;
    }

    private void displayRstaurantInfo(Restaurant restaurant) {
        String info = "Id: " + restaurant.getId() +
                "Nazwa restauracji: " + restaurant.getName() +
                "Strona www: " + restaurant.get
    }

}
