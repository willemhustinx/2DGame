package com.willemhustinx.games.gfx;

/**
 * Created by willemhustinx on 8-10-2017.
 */
public class Screen {

    public final int w, h;
    public int[] pixels;

    public Screen(int w, int h) {
        this.w = w;
        this.h = h;

        pixels = new int[w * h];
    }

    public void clear(int color) {
        for (int i = 0; i < pixels.length; i++){
            pixels[i] = color;
        }
    }
}
