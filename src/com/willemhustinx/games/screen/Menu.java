package com.willemhustinx.games.screen;

import com.willemhustinx.games.Game;
import com.willemhustinx.games.InputHandler;
import com.willemhustinx.games.gfx.Screen;

/**
 * Created by willemhustinx on 8-10-2017.
 */
public class Menu {

    protected Game game;
    protected InputHandler input;

    public void init(Game game, InputHandler input) {
        this.input = input;
        this.game = game;
    }

    public void tick() {

    }

    public void render(Screen screen) {

    }
}
