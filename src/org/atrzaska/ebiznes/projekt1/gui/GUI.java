package org.atrzaska.ebiznes.projekt1.gui;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import org.apache.mahout.cf.taste.common.TasteException;
import org.atrzaska.ebiznes.projekt1.api.Restaurant;
import org.atrzaska.ebiznes.projekt1.api.RestaurantRecommender;

public final class GUI extends javax.swing.JFrame {

    /**
     * restaurantRecommender
     */
    protected RestaurantRecommender restaurantRecommender;

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

        // skonstruowac dynamicznie liste
        this.boxRestauracje.setModel(new DefaultComboBoxModel(restaurantRecommender.getRestaurantsList().getAsList().toArray()));

        // populate cold start list
        populateColdStartList();
    }

    public void populateColdStartList() throws TasteException {
        this.populateRecomendationList(restaurantRecommender.getColdStartList());
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        recomendationList.setName(""); // NOI18N
        recomendationList.add("abba");
        recomendationList.add("baba");

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

        lblSimiliarUserName.setText("null");

        lblPodobienstwoSt.setText("Stopień podobieństwa:");

        lblPodobienstwoVal.setText("null");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblpodobnyuzytkownik)
                            .addComponent(lblPodobienstwoSt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPodobienstwoVal)
                            .addComponent(lblSimiliarUserName))
                        .addGap(10, 10, 10))
                    .addComponent(recomendationList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblrekomend, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                            .addComponent(lblOcenaRekomendacji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(txtOcenaRekomendacji)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnScoreRecommendation, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblRestauracja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblOcena2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtOcenaRestauracji)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddScoreManual, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(boxRestauracje, 0, 224, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblrekomend)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(recomendationList, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOcenaRekomendacji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOcenaRekomendacji)
                    .addComponent(btnScoreRecommendation))
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRestauracja, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxRestauracje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOcenaRestauracji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddScoreManual)
                    .addComponent(lblOcena2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblpodobnyuzytkownik)
                    .addComponent(lblSimiliarUserName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPodobienstwoSt)
                    .addComponent(lblPodobienstwoVal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnScoreRecommendationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScoreRecommendationActionPerformed
        float val = Float.parseFloat(txtOcenaRekomendacji.getText());
        Restaurant restaurant = restaurantRecommender
                .getRestaurantsList()
                .getRestaurantByName(recomendationList.getSelectedItem());

        restaurantRecommender.getTempUser().rate(restaurant.getId(), val);

        try {
            List<Restaurant> recommendedRestaurants = restaurantRecommender.
                    recommendMoviesForTempUser();
            this.populateRecomendationList(recommendedRestaurants);
        } catch (TasteException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnScoreRecommendationActionPerformed

    private void btnAddScoreManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddScoreManualActionPerformed
        float val = Float.parseFloat(txtOcenaRestauracji.getText());
        Restaurant restaurant = (Restaurant) boxRestauracje.getSelectedItem();

        restaurantRecommender.getTempUser().rate(restaurant.getId(), val);

        try {
            List<Restaurant> recommendedRestaurants = restaurantRecommender.
                    recommendMoviesForTempUser();
            this.populateRecomendationList(recommendedRestaurants);
        } catch (TasteException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddScoreManualActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox boxRestauracje;
    private javax.swing.JButton btnAddScoreManual;
    private javax.swing.JButton btnScoreRecommendation;
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

}
