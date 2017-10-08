package com.willemhustinx.games;

import javax.swing.*;
import java.awt.*;

public class Game extends Canvas implements Runnable {

    private static final String NAME = "WILLEM'S 2D GAME";
    public static final int HEIGHT = 200;
    public static final int WIDTH = 267;
    public static final int SCALE = 3;

    private InputHandler input = new InputHandler(this);

    private boolean running = false;

    private void start() {
        running = true;
        new Thread(this).start();
    }

    @Override
    public void run() {

        long lastTime = System.nanoTime();
        double unprocessed = 0;
        double nsPerTick = 1000000000.0 / 60;
        int frames = 0;
        int ticks = 0;
        long lastTimer1 = System.currentTimeMillis();


        init();
        
        while(running){
            long now = System.nanoTime();
            unprocessed += (now - lastTime) / nsPerTick;
            lastTime = now;
            boolean shouldRender = true;

            while (unprocessed >= 1) {
                ticks++;
                tick();
                unprocessed -= 1;
            }

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (shouldRender) {
                frames++;
                render();
            }

            if (System.currentTimeMillis() - lastTimer1 > 1000) {
                lastTimer1 += 1000;
                System.out.println(ticks + " ticks, " + frames + " fps");
                frames = 0;
                ticks = 0;
            }
        }

    }

    private void render() {
    }

    private void tick() {
    }

    private void init() {
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        JFrame frame = new JFrame(Game.NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(game, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.start();
    }


}