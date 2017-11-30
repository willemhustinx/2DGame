package com.willemhustinx.games.entity.mob;

import com.willemhustinx.games.Game;
import com.willemhustinx.games.InputHandler;
import com.willemhustinx.games.gfx.Color;
import com.willemhustinx.games.gfx.Screen;

public class Player extends Mob {

    public Game game;
    private InputHandler input;

    public Player(Game game, InputHandler input) {
        this.game = game;
        this.input = input;

        this.x = 2;
        this.y = 2;

    }

    public void tick() {
        super.tick();
    }

    public void render(Screen screen) {
        int xt = 2;
        int yt = 0;

        int col = Color.get(005, 005, 115, 115);

        screen.render(x * 8, y * 8, 2, col, 0);


    }
}
