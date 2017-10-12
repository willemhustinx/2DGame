package com.willemhustinx.games.world;

import com.willemhustinx.games.gfx.Color;
import com.willemhustinx.games.gfx.Screen;

public class Level {

    public int w, h;

    public Level(int width, int height) {
        this.w = width;
        this.h = height;
    }

    public void tick() {

    }

    public void renderBackground(Screen screen, int xScroll, int yScroll) {

        int col = Color.get(0, 555, 555, 555);

        for (int y = 0; y <= h; y++) {
            for (int x = 0; x <= w; x++) {
                //screen.render(x * 16 + 0, y * 16 + 0, 0, col, 0);
                screen.render(x * 8, y * 8, 0, col, 0);
            }
        }

    }
}

/*

/** This method renders all the tiles in the game *
public void renderBackground(Screen screen, int xScroll, int yScroll) {
    int xo = xScroll >> 4; // the game's horizontal scroll offset.
    int yo = yScroll >> 4; // the game's vertical scroll offset.
    int w = (screen.w + 15) >> 4; // width of the screen being rendered
    int h = (screen.h + 15) >> 4; // height of the screen being rendered
    screen.setOffset(xScroll, yScroll); // sets the scroll offsets.
    for (int y = yo; y <= h + yo; y++) { // loops through the vertical positions
        for (int x = xo; x <= w + xo; x++) { // loops through the horizontal positions
            getTile(x, y).render(screen, this, x, y); // renders the tile on the screen
        }
    }
    screen.setOffset(0, 0); // resets the offset.
}

 */