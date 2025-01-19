import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

class Recommendations{
    JFrame f = new JFrame();

    Meal mostpopularmeal;
    Meal mostpopularsalad;
    Meal mostpopulardessert;
    Meal mostpopulardrink;

    JLabel mostpopularmealLabelname;
    JLabel mostpopularmealLabel = new JLabel("Most popular meal :");

    JLabel mostpopularsaladLabelname;
    JLabel mostpopularsaladLabel = new JLabel("Most popular salad :");

    JLabel mostpopulardessertLabelname;
    JLabel mostpopulardessertLabel = new JLabel("Most popular dessert :");

    JLabel mostpopulardrinkLabelname ;
    JLabel mostpopulardrinkLabel =  new JLabel("Most popular drink :");

    boolean RecommendationExist=false;

    JLabel RecommendationsIconLabel = new JLabel();
    ImageIcon RecommendationIcon = new ImageIcon("cart.png");

    ArrayList<JLabel> popularmealsarray = new ArrayList<>();

    Recommendations(ArrayList<Meal> meals){

        RecommendationsIconLabel.setBounds(0,0,500,500);
        RecommendationsIconLabel.setIcon(RecommendationIcon);

        f.setLayout(new FlowLayout());
        int min=0;
        for(Meal m : meals){
            if(m.getType().equals("Meal")){
                if(m.getPopularity()>min){
                    mostpopularmeal=m;
                    min=m.getPopularity();
                }
            }
        }
        if(min>0){
            try {
                RecommendationsIconLabel.add(mostpopularmealLabel);
                mostpopularmealLabelname = new JLabel(mostpopularmeal.getName());
                // JLabel l = new JLabel();
                // l=Order.meallabels.get(mostpopularmeal.getSerialnum());
                RecommendationsIconLabel.add(mostpopularmealLabelname);
                // f.add(l);
            } catch (Exception e) {}
            RecommendationExist=true;
        }
        min=0;
        for(Meal m : meals){
            if(m.getType().equals("Salad")){
                if(m.getPopularity()>min){
                    mostpopularsalad=m;
                    min=m.getPopularity();
                }
            }
        }
        if(min>0){
            try {
                RecommendationsIconLabel.add(mostpopularsaladLabel);
                mostpopularsaladLabelname = new JLabel(mostpopularsalad.getName());
                // JLabel l = Order.meallabels.get(mostpopularmeal.getSerialnum()); 
                RecommendationsIconLabel.add(mostpopularsaladLabelname);
                // f.add(l);
            } catch (Exception e) {}
            RecommendationExist=true;
        }
        min=0;
        for(Meal m : meals){
            if(m.getType().equals("Dessert")){
                if(m.getPopularity()>min){
                    mostpopulardessert=m;
                    min=m.getPopularity();
                }
            }
        }
        if(min>0){
            try {
                RecommendationsIconLabel.add(mostpopulardessertLabel);
                mostpopulardessertLabelname = new JLabel(mostpopulardessert.getName());
                // JLabel l = Order.meallabels.get(mostpopularmeal.getSerialnum()); 
                RecommendationsIconLabel.add(mostpopulardessertLabelname);
                // f.add(l);
            } catch (Exception e) {}
            RecommendationExist=true;
        }
        min=0;
        for(Meal m : meals){
            if(m.getType().equals("Drink")){
                if(m.getPopularity()>min){
                    mostpopulardrink=m;
                    min=m.getPopularity();
                }
            }
        }
        if(min>0){
            try {
                RecommendationsIconLabel.add(mostpopulardrinkLabel);
                mostpopulardrinkLabel = new JLabel(mostpopulardrink.getName());
                /*dr.setBounds(10,35,320,30);
                dr.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 25));

                mostpopulardrinkLabel.setBounds(30,80,320,30);
                mostpopulardrinkLabel.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));*/
                RecommendationsIconLabel.add(mostpopulardrinkLabelname);
            } catch (Exception e) {}
            RecommendationExist=true;
        }

        if (!RecommendationExist){
            JLabel nomealLabel=new JLabel("No Recommendation");
            RecommendationsIconLabel.add(nomealLabel);
        }
        
        // mostpopulardessertLabel.
        int ind = 1;
        for(int i = 0 ; i < meals.size() ; i++){
            if(meals.get(i)==mostpopulardrink||meals.get(i)==mostpopulardessert||meals.get(i)==mostpopularmeal||meals.get(i)==mostpopularsalad){
                int x = 50;
                int y = ind * 100;
                y -= 50;
                JLabel mealname = new JLabel(AllMealsFrame.meallist.get(i).getName());
                mealname.setBounds(x, y, 320, 30);
                mealname.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
                ind++;
                RecommendationsIconLabel.add(mealname);
        }}

        f.add(RecommendationsIconLabel);
        f.setResizable(false);
        f.setSize(500, 500);
        f.setVisible(true);
        f.setLocationRelativeTo(null);


}}