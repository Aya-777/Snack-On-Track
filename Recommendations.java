import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

class Recommendations{
    JFrame f = new JFrame();
    Meal mostpopularmeal;
    Meal mostpopularsalad;
    Meal mostpopulardessert;
    Meal mostpopulardrink;

    JLabel mostpopularmealLabel;
    JLabel mostpopularsaladLabel;
    JLabel mostpopulardessertLabel;
    JLabel mostpopulardrinkLabel; 
    boolean RecommendationExist=false;

    Recommendations(ArrayList<Meal> meals){
        f.setLayout(new FlowLayout());
        int min=0;
        for(Meal m : meals){
            if(m.getType()=="Meal"){
                if(m.getPopularity()>min){
                    mostpopularmeal=m;
                    min=m.getPopularity();
                }
            }
        }
        if(min>0){
            try {
                mostpopularmealLabel = new JLabel(mostpopularmeal.getName());
                JLabel l = new JLabel();
                l=Order.meallabels.get(mostpopularmeal.getSerialnum());
                f.add(mostpopularmealLabel);
                f.add(l);
            } catch (Exception e) {}
            RecommendationExist=true;
        }
        min=0;
        for(Meal m : meals){
            if(m.getType()=="Salad"){
                if(m.getPopularity()>min){
                    mostpopularsalad=m;
                    min=m.getPopularity();
                }
            }
        }
        if(min>0){
            try {
                mostpopularsaladLabel = new JLabel(mostpopularsalad.getName()); 
                // JLabel l = Order.meallabels.get(mostpopularmeal.getSerialnum()); 
                f.add(mostpopularsaladLabel);
                // f.add(l);
            } catch (Exception e) {}
            RecommendationExist=true;
        }
        min=0;
        for(Meal m : meals){
            if(m.getType()=="Dessert"){
                if(m.getPopularity()>min){
                    mostpopulardessert=m;
                    min=m.getPopularity();
                }
            }
        }
        if(min>0){
            try {
                mostpopulardessertLabel = new JLabel(mostpopulardessert.getName()); 
                // JLabel l = Order.meallabels.get(mostpopularmeal.getSerialnum()); 
                f.add(mostpopulardessertLabel);
                // f.add(l);
            } catch (Exception e) {}
            RecommendationExist=true;
        }
        min=0;
        for(Meal m : meals){
            if(m.getType()=="Drink"){
                if(m.getPopularity()>min){
                    mostpopulardrink=m;
                    min=m.getPopularity();
                }
            }
        }
        if(min>0){
            try {
                mostpopulardrinkLabel = new JLabel(mostpopulardrink.getName()); 
                f.add(mostpopulardrinkLabel);
            } catch (Exception e) {}
            RecommendationExist=true;
        }

        if (!RecommendationExist){
            JLabel nomealLabel=new JLabel("No Recommendation");
            f.add(nomealLabel);
        }
        
        // mostpopulardessertLabel.

        f.setResizable(false);
        f.setSize(500, 500);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
}