package com.mathmaurer.jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Clavier implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            main.scene.Heros.saut();
        if(e.getKeyCode()==KeyEvent.VK_Z){
            main.scene.Heros.attack();
        }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
