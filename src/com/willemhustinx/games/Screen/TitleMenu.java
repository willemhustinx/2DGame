package com.willemhustinx.games.Screen;

import com.willemhustinx.games.gfx.Color;
import com.willemhustinx.games.gfx.Font;
import com.willemhustinx.games.gfx.Screen;

/**
 * Created by willemhustinx on 11-10-2017.
 */
public class TitleMenu extends Menu {
    private int selected = 0;

    private static final String[] options = {"Start game", "How to play", "About"};

    public TitleMenu() {

    }

    public void tick(){
        if (input.up.clicked){
            selected--;
        }
        if (input.down.clicked) {
            selected++;
        }

        int len = options.length;

        if(selected < 0){
            selected += len;
        }
        if(selected >= len){
            selected -= len;
        }
    }

    public void render(Screen screen){

        screen.clear(0);

        for(int i = 0; i < options.length; i++) {
            String msg = options[i];
            int col = Color.get(0, 222, 222, 222);
            if (i == selected) {
                msg = "AA " + msg + " AA";
                col = Color.get(0, 555, 555, 555);
            }
            Font.draw(msg, screen, (screen.w - msg.length() * 8) / 2, (8 + i) * 8, col);
        }
    }
}