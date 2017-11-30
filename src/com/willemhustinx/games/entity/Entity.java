package com.willemhustinx.games.entity;

import com.willemhustinx.games.gfx.Screen;
import com.willemhustinx.games.world.Level;

public class Entity {
    public int x, y;

    public Level level;

    public void render(Screen screen) {
    }

    public void tick() {
    }

    public final void init(Level level) {
        this.level = level;
    }

}
