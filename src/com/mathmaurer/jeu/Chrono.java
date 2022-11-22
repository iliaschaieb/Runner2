package com.mathmaurer.jeu;


import javax.swing.*;
import java.awt.*;

public class Chrono implements Runnable{

    private final int PAUSE = 2 ;

    @Override
    public void run() {
        Audio.playSound("/SON/Blackmoor Tides Loop.wav");


        while(main.scene.finDuJeu == false) {

            main.scene.xFond--;
            main.scene.repaint();
            try {
                Thread.sleep(this.PAUSE);
            } catch (InterruptedException e){}

        }

    }
}
