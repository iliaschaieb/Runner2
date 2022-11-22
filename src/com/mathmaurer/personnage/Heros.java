package com.mathmaurer.personnage;

import com.mathmaurer.objet.Tuyau;

import javax.swing.*;
import java.awt.*;

public class Heros implements Runnable {

    //VARIABLES
    private int largeur;
    private int hauteur;
    private int x;
    private int y;
    private int dy;
    private String strImage;
    private ImageIcon icoHeros;
    private Image imgHeros;

    private final int PAUSE = 10 ;

    // CONSTRUCTEUR
    public Heros (int x, int y, String strImage) {
        this.largeur = 65;
        this.hauteur = 100;
        this.x = x;
        this.y = y;
        this.strImage = strImage;
        this.icoHeros = new ImageIcon(getClass().getResource(this.strImage));
        this.imgHeros = this.icoHeros.getImage();

        Thread chronopose = new Thread(this);
        chronopose.start();
    }
    //GETTERS
    public int getHauteur() {
        return hauteur;
    }
    public int getLargeur() {
        return largeur;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Image getImgHeros() {
        return imgHeros;
    }
    //SETTERS
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }


    //METHODES

    public void saut(){
        if(this.y ==250) {
            this.dy = 200;
            this.y = this.y - this.dy;
        }
    }

    public void attack(){
        this.icoHeros = new ImageIcon(getClass().getResource("/Image/Herosattack1.png"));
        this.imgHeros = this.icoHeros.getImage();
      }



    public boolean collision(Tuyau tuyau){
        if ((this.y + this.hauteur>= tuyau.getY() )&&(this.x + this.largeur >= tuyau.getX()&&
                (this.x<= tuyau.getX() + tuyau.getLargeur()))){return true;}

        else {return false;}
    }




    private void SautPose(int dy){
        if (dy > 10){
            this.icoHeros = new ImageIcon(getClass().getResource("/Image/HerosSaut.png"));
            this.imgHeros = this.icoHeros.getImage();
            this.y = this.y - 3;
        }else if (dy > 5) {this.y = this.y - 2;}
        else if (dy > 1) { this.y = this.y - 1;}
        else if (dy == 1) { this.icoHeros = new ImageIcon(getClass().getResource("/Image/heros1.png"));
            this.imgHeros = this.icoHeros.getImage();}


    }
int f = 0%60;
    @Override
    public void run() {
        while(true) {
            if(this.getY() == 250){
                    if (f < 10){
                        this.icoHeros = new ImageIcon(getClass().getResource("/Image/heros1.png"));
                        this.imgHeros = this.icoHeros.getImage();
                        f = (f + 1)%60;
                    }
                    else if(f < 20) {
                        this.icoHeros = new ImageIcon(getClass().getResource("/Image/heros2.png"));
                        this.imgHeros = this.icoHeros.getImage();
                        f = (f + 1)%60;
                    }
                     else if (f < 30){
                    this.icoHeros = new ImageIcon(getClass().getResource("/Image/heros3.png"));
                    this.imgHeros = this.icoHeros.getImage();
                    f = (f + 1)%60;
                }
                      else if (f<40){
                    this.icoHeros = new ImageIcon(getClass().getResource("/Image/heros4.png"));
                    this.imgHeros = this.icoHeros.getImage();
                    f = (f + 1)%60;
                }
                    else if (f<50){
                        this.icoHeros = new ImageIcon(getClass().getResource("/Image/heros5.png"));
                        this.imgHeros = this.icoHeros.getImage();
                        f = (f + 1)%60;
                    }

                    else {
                        this.icoHeros = new ImageIcon(getClass().getResource("/Image/heros6.png"));
                        this.imgHeros = this.icoHeros.getImage();
                        f = (f + 1)%60;
                    }

                }
            this.SautPose(dy);
            this.dy = -2 + this.dy;
            try {
                Thread.sleep(PAUSE);
            } catch (InterruptedException e) {}
        }
    }
}

