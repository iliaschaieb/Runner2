package com.mathmaurer.objet;


import javax.swing.*;
import java.awt.*;

public class Tuyau {

    // VARIABLES
    private int largeur ;
    private int hauteur ;
    private int x ;
    private int y ;
    private ImageIcon icoTuyau;
    private String strImage ;
    private Image imgTuyau ;

    // CONSTRUCTEUR

    public  Tuyau(int x, int y,String strImage) {
        this.largeur = 50;
        this.hauteur = 300;
        this.x = x;
        this.y = y;
        this.strImage = strImage;

        this.icoTuyau = new ImageIcon(getClass().getResource(this.strImage));
        this.imgTuyau = this.icoTuyau.getImage();
    }

    //GETTERS
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public Image getImgTuyau() {
        return imgTuyau;
    }
    //SETTERS

    public void setY(int y) {
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }

}
