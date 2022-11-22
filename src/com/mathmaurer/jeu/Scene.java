package com.mathmaurer.jeu;


import com.mathmaurer.objet.Mechant;
import com.mathmaurer.objet.Tuyau;
import com.mathmaurer.personnage.Heros;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Random;

public class Scene extends JPanel {

    //VARIABLES
    private ImageIcon IcoFond;
    private Image ImgFond;

    public Tuyau tuyauHauteur1;
    public Tuyau tuyauHauteur2;
    public Tuyau tuyauHauteur3;

    public Mechant mechant1;
    public Mechant mechant2;
    public Mechant mechant3;

    public com.mathmaurer.personnage.Heros Heros;




    private int score;
    private Font police;


    private final int LARGEUR_BANDE_FOND = 800;
    private final int DISTANCES_TUYAUX = 800;
    private final int ECART_TUYAUX = 800;
    private final int DISTANCE_MECHANT = 800;
    private final int ECART_MECHANT = 800;

    public int xFond;
    private int xTuyaux;
    private int xMechant;


    public boolean finDuJeu;

    private Random hasard;
    private ImageIcon icoHeros;
    private Image imgHeros;




    //CONSTRUCTEUR
    public Scene() {

        super();
        this.IcoFond = new ImageIcon(getClass().getResource("/Image/desert.png"));
        this.ImgFond = this.IcoFond.getImage();

        this.finDuJeu = false;
        this.xFond = 0;
        this.xTuyaux = 400;
        this.tuyauHauteur1 = new Tuyau(this.xTuyaux, 300, "/Image/tuyau.png");
        this.tuyauHauteur2 = new Tuyau(this.xTuyaux + this.DISTANCES_TUYAUX, 250 ,"/Image/tuyau.png");
        this.tuyauHauteur3 = new Tuyau(this.xTuyaux + this.DISTANCES_TUYAUX*2, 200, "/Image/tuyau.png");



        this.mechant1 = new Mechant(this.xMechant ,250,"/Image/heros2.png");
        this.mechant2 = new Mechant(this.xMechant + this.ECART_MECHANT ,250,"/Image/heros2.png");
        this.mechant3 = new Mechant(this.xMechant + this.ECART_MECHANT ,250,"/Image/heros2.png");


        this.Heros = new Heros(20,250,"/Image/heros1.png");

        this.score = 0;
        this.police = new Font("Arial",Font.PLAIN,40);


        hasard = new Random();

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Clavier());

        Thread chronoEcran = new Thread(new Chrono());
        chronoEcran.start();
    }

    //METHODES


    private void deplacementFond (Graphics g){

        if (this.xFond == -800){
            this.xFond = 0;}
        g.drawImage(this.ImgFond, this.xFond, 0, null);
        g.drawImage(this.ImgFond, this. xFond +800, 0, null);
        g.drawImage(this.ImgFond, this. xFond +800*2, 0, null);
        g.drawImage(this.ImgFond, this. xFond +800*3, 0, null);

    }

    private void deplacementTuyaux(Graphics g){


        this.tuyauHauteur1.setX(this.tuyauHauteur1.getX()-1);
        if(this.tuyauHauteur1.getX() == -100){
                this.tuyauHauteur1.setX(this.tuyauHauteur3.getX() + this.DISTANCES_TUYAUX + this.hasard.nextInt(300));
                this.tuyauHauteur1.setY(300 - this.hasard.nextInt(50));
        }
        g.drawImage(this.tuyauHauteur1.getImgTuyau(), this.tuyauHauteur1.getX(),this.tuyauHauteur1.getY(),null);

        this.tuyauHauteur2.setX(this.tuyauHauteur2.getX()-1);
        if(this.tuyauHauteur2.getX() == -100){
            this.tuyauHauteur2.setX(this.tuyauHauteur1.getX() + this.DISTANCES_TUYAUX + this.hasard.nextInt(300));
            this.tuyauHauteur2.setY(300 - this.hasard.nextInt(50));
        }
        g.drawImage(this.tuyauHauteur2.getImgTuyau(), this.tuyauHauteur2.getX(),this.tuyauHauteur2.getY(),null);


        this.tuyauHauteur3.setX(this.tuyauHauteur3.getX()-1);
        if(this.tuyauHauteur3.getX() == -100){
            this.tuyauHauteur3.setX(this.tuyauHauteur2.getX() + this.DISTANCES_TUYAUX + this.hasard.nextInt(300));
            this.tuyauHauteur3.setY(300 - this.hasard.nextInt(50));
        }
        g.drawImage(this.tuyauHauteur3.getImgTuyau(), this.tuyauHauteur3.getX(),this.tuyauHauteur3.getY(),null);
        g.drawImage(this.mechant1.getImgMechant(), this.mechant1.getX(),this.mechant1.getY(),null );
    }

    private void deplacementMechant(Graphics g){


        this.mechant1.setX(this.mechant1.getX()-1);
        if(this.mechant1.getX() == -100){
            this.mechant1.setX(this.mechant3.getX() + this.DISTANCE_MECHANT + this.hasard.nextInt(300));
        }
        g.drawImage(this.mechant1.getImgMechant(), this.mechant1.getX(),this.mechant1.getY(),null);

        this.mechant2.setX(this.mechant2.getX()-1);
        if(this.mechant2.getX() == -100){
            this.mechant2.setX(this.mechant1.getX() + this.DISTANCE_MECHANT + this.hasard.nextInt(300));
            ;
        }
        g.drawImage(this.mechant2.getImgMechant(), this.mechant2.getX(),this.mechant2.getY(),null);


        this.mechant3.setX(this.mechant3.getX()-1);
        if(this.mechant3.getX() == -100){
            this.mechant3.setX(this.mechant2.getX() + this.DISTANCE_MECHANT + this.hasard.nextInt(300));
        }
        g.drawImage(this.mechant3.getImgMechant(), this.mechant3.getX(),this.mechant3.getY(),null);

    }


    private boolean collisionHeros(){
        boolean finDuJeu = false;
        if(this.Heros.getX() + this.Heros.getLargeur() > this.tuyauHauteur1.getX()-20 &&
        this.Heros.getX() < this.tuyauHauteur1.getX() + this.tuyauHauteur1.getLargeur()+20) {
            finDuJeu = this.Heros.collision(this.tuyauHauteur1);
        }else //deuxieme
          if(this.Heros.getX() + this.Heros.getLargeur() > this.tuyauHauteur2.getX()-20 &&
                this.Heros.getX() < this.tuyauHauteur2.getX() + this.tuyauHauteur2.getLargeur()+20) {
            finDuJeu = this.Heros.collision(this.tuyauHauteur2);
        } else //troisième
            if (this.Heros.getX() + this.Heros.getLargeur() > this.tuyauHauteur3.getX()-20 &&
                  this.Heros.getX() < this.tuyauHauteur3.getX() + this.tuyauHauteur3.getLargeur()+20) {
              finDuJeu = this.Heros.collision(this.tuyauHauteur3);
          }
          return finDuJeu;
    }


    private void score(){
        if(this.tuyauHauteur1.getX() + this.tuyauHauteur1.getLargeur() == 95 ||
        this.tuyauHauteur2.getX() + this.tuyauHauteur2.getLargeur() == 95 ||
        this.tuyauHauteur3.getX() + this.tuyauHauteur3.getLargeur() == 95){
        this.score++;
        }
    }


    public void paintComponent(Graphics g) {
        this.deplacementFond(g);
        this.deplacementTuyaux(g);
        this.deplacementMechant(g);
        this.finDuJeu = this.collisionHeros();
        this.score();
        g.setFont(police);
        g.drawString(""+ score, 140,50);
        if (this.Heros.getY() < 250){
        this.Heros.setY(this.Heros.getY()+1);}


        g.drawImage(this.Heros.getImgHeros(),this.Heros.getX(),this.Heros.getY(),null);
        if (this.finDuJeu==true){g.drawString("T'es nul recommence", 60,200);
        Audio.playSound("/SON/Honking.wav");}

    }
}
