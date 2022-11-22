 package com.mathmaurer.jeu;


import javax.swing.*;

public class main {
    public static JFrame fenetre;
    public static Scene scene;
    public static void main(String[] args){
        fenetre = new JFrame("Runner d'ilias le sang");
        scene = new Scene();

        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(1600, 400);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(false);

        fenetre.setContentPane(scene);
        fenetre.setAlwaysOnTop(true);



        fenetre.setVisible(true);
    }


}

