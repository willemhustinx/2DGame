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

        int h = 2;
        int w = 10;
        int titleColor = Color.get(0, 010, 131, 551);
        int xo = (screen.w - w * 8) / 2;
        int yo = 24;
        for(int y = 0; y < h; y++){
            for(int x = 0; x < w; x++){
                screen.render(xo + x * 8, yo + y * 8, x + (y + 3) * 26, titleColor,0 );
            }
        }

        for(int i = 0; i < options.length; i++) {
            String msg = options[i];
            int col = Color.get(0, 222, 222, 222);
            if (i == selected) {
                msg = "[ " + msg + " ]";
                col = Color.get(0, 555, 555, 555);
            }
            Font.draw(msg, screen, (screen.w - msg.length() * 8) / 2, (8 + i) * 8, col);
        }
    }
}