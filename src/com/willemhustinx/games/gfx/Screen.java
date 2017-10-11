package com.willemhustinx.games.gfx;

/**
 * Created by willemhustinx on 8-10-2017.
 */
public class Screen {

    public final int w, h;
    public int[] pixels;

    private SpriteSheet sheet;

    public Screen(int w, int h, SpriteSheet sheet) {
        this.w = w;
        this.h = h;
        this.sheet = sheet;

        pixels = new int[w * h];
    }

    public void clear(int color) {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = color;
        }
    }

    public void render(int xp, int yp, int tile, int colors, int bits) {

        int xTile = tile % 26;
        int yTile = tile / 26;
        int toffs = xTile * 8 + yTile * 8 * sheet.width;

        for (int y = 0; y < 8; y++) {
            if (y + yp < 0 || y + yp >= h) {
                continue;
            }
            int ys = y;
            for (int x = 0; x < 8; x++) {
                if (y + xp < 0 || x + xp >= w) {
                    continue;
                }
                int xs = x;
                int col = (colors >> (sheet.pixels[xs + ys * sheet.width + toffs] * 8)) & 255;
                if (col < 255) {
                    pixels[(x + xp) + (y + yp) * w] = col;
                }
            }
        }
    }
}