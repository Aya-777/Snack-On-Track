import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

class Recommendations{
    JFrame f = new JFrame();
    Meal mostpopularmeal;
    Meal mostpopularsalad;
    Meal mostpopulardessert;
    Meal mostpopulardrink;

    JLabel mostpopularmealLabel;
    JLabel m = new JLabel("Most popular meal :");
    JLabel mostpopularsaladLabel;
    JLabel s = new JLabel("Most popular salad :");
    JLabel mostpopulardessertLabel;
    JLabel des = new JLabel("Most popular dessert :");
    JLabel mostpopulardrinkLabel;
    JLabel dr =  new JLabel("Most popular drink :");
    boolean RecommendationExist=false;
    JLabel RecommendationsIconLabel = new JLabel();
    ImageIcon RecommendationIcon = new ImageIcon("cart.png");

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
                RecommendationsIconLabel.add(m);
                mostpopularmealLabel = new JLabel(mostpopularmeal.getName());

              /*  m.setBounds(10,35,320,30);
                m.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 25));
                mostpopularmealLabel.setBounds(30,80,320,30);
                mostpopularmealLabel.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));*/

                // JLabel l = new JLabel();
                // l=Order.meallabels.get(mostpopularmeal.getSerialnum());
                RecommendationsIconLabel.add(mostpopularmealLabel);
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
                RecommendationsIconLabel.add(s);
                mostpopularsaladLabel = new JLabel(mostpopularsalad.getName());
             /*   s.setBounds(10,35,320,30);
                s.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 25));
                mostpopularsaladLabel.setBounds(30,80,320,30);
                mostpopularsaladLabel.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));*/
                // JLabel l = Order.meallabels.get(mostpopularmeal.getSerialnum()); 
                RecommendationsIconLabel.add(mostpopularsaladLabel);
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
                RecommendationsIconLabel.add(des);
                mostpopulardessertLabel = new JLabel(mostpopulardessert.getName());
                /*des.setBounds(10,35,320,30);
                des.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 25));
                mostpopulardessertLabel.setBounds(30,80,320,30);
                mostpopulardessertLabel.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));*/
                // JLabel l = Order.meallabels.get(mostpopularmeal.getSerialnum()); 
                RecommendationsIconLabel.add(mostpopulardessertLabel);
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
                RecommendationsIconLabel.add(dr);
                mostpopulardrinkLabel = new JLabel(mostpopulardrink.getName());
                /*dr.setBounds(10,35,320,30);
                dr.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 25));

                mostpopulardrinkLabel.setBounds(30,80,320,30);
                mostpopulardrinkLabel.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));*/
                RecommendationsIconLabel.add(mostpopulardrinkLabel);
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
            if(meals.get(i)==mostpopulardrink){
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