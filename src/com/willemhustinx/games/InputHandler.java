package com.willemhustinx.games;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by willemhustinx on 6-10-2017.
 */
public class InputHandler implements KeyListener {

    public class Key{
        public int presses, absorbs;
        public boolean down, clicked;

        public Key(){
            keys.add(this);
        }

        public void toggle(boolean pressed){
            if(pressed != down) {
                down = pressed;
            }
            if(pressed){
                presses++;
            }
        }

        public void tick(){
            if(absorbs < presses){
                absorbs++;
                clicked = true;
            } else {
                clicked = false;
            }
        }

    }

    public List<Key> keys = new ArrayList<Key>();

    public Key up = new Key();
    public Key down = new Key();
    public Key left = new Key();
    public Key right = new Key();

    public InputHandler(Game game){
        game.addKeyListener(this);
    }

    public void releaseAll(){
        for(int i = 0; i < keys.size(); i++ ){
            keys.get(i).down = false;
        }
    }

    public void tick(){
        for (int i =0; i< keys.size(); i++){
            keys.get(i).tick();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        toggle(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        toggle(e, false);
    }

    private void toggle(KeyEvent e, boolean pressed){
        if(e.getKeyCode() == KeyEvent.VK_UP){
            up.toggle(pressed);
            System.out.println("up pressed " + pressed);
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            down.toggle(pressed);
            System.out.println("down pressed " + pressed);
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            left.toggle(pressed);
            System.out.println("left pressed " + pressed);
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            right.toggle(pressed);
            System.out.println("right pressed " + pressed);
        }
    }
}