package com.willemhustinx.games.Screen;

import com.willemhustinx.games.Game;
import com.willemhustinx.games.InputHandler;

/**
 * Created by willemhustinx on 8-10-2017.
 */
public class Menu {

    protected Game game;
    protected InputHandler input;

    public void init(Game game, InputHandler input){
        this.input = input;
        this.game = game;
    }

    public void tick() {

    }

    public void render(){

    }
}
