package com.willemhustinx.games.world;

import com.willemhustinx.games.entity.Entity;
import com.willemhustinx.games.entity.mob.Player;
import com.willemhustinx.games.gfx.Color;
import com.willemhustinx.games.gfx.Screen;

import java.util.ArrayList;
import java.util.List;

public class Level {

    public int w, h;

    public Player player;

    public List<Entity> entities = new ArrayList<Entity>();

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

    public void renderSprites(Screen screen, int xScroll, int yScroll) {

    }
    /*

    	public void renderSprites(Screen screen, int xScroll, int yScroll) {
		int xo = xScroll >> 4; // the game's horizontal scroll offset.
		int yo = yScroll >> 4; // the game's vertical scroll offset.
		int w = (screen.w + 15) >> 4; // width of the screen being rendered
		int h = (screen.h + 15) >> 4; // height of the screen being rendered

		screen.setOffset(xScroll, yScroll); // sets the scroll offsets.
		for (int y = yo; y <= h + yo; y++) { // loops through the vertical positions
			for (int x = xo; x <= w + xo; x++) { // loops through the horizontal positions
				if (x < 0 || y < 0 || x >= this.w || y >= this.h) continue; // If the x & y positions of the sprites are within the map's boundaries
				rowSprites.addAll(entitiesInTiles[x + y * this.w]); // adds all of the sprites in the entitiesInTiles array.
			}
			if (rowSprites.size() > 0) { // If the rowSprites list size is larger than 0...
				sortAndRender(screen, rowSprites); // sorts and renders the sprites on the screen
			}
			rowSprites.clear(); // clears the list
		}
		screen.setOffset(0, 0); // resets the offset.
	}

     */

    public void add(Entity entity) {
        if (entity instanceof Player) {
            player = (Player) entity;
        }
        entities.add(entity);
        entity.init(this);
    }
}

/*

/** Adds a entity to the level *
public void add(Entity entity) {
    if (entity instanceof Player) { // if the entity happens to be a player
        player = (Player) entity; // the player object will be this entity
    }
    entity.removed = false; // sets the entity's removed value to false
    entities.add(entity); // adds the entity to the entities list
    entity.init(this); // Initializes the entity

    insertEntity(entity.x >> 4, entity.y >> 4, entity); // inserts the entity into the world
}
 */

/**
 * This method renders all the tiles in the game *
 * public void renderBackground(Screen screen, int xScroll, int yScroll) {
 * int xo = xScroll >> 4; // the game's horizontal scroll offset.
 * int yo = yScroll >> 4; // the game's vertical scroll offset.
 * int w = (screen.w + 15) >> 4; // width of the screen being rendered
 * int h = (screen.h + 15) >> 4; // height of the screen being rendered
 * screen.setOffset(xScroll, yScroll); // sets the scroll offsets.
 * for (int y = yo; y <= h + yo; y++) { // loops through the vertical positions
 * for (int x = xo; x <= w + xo; x++) { // loops through the horizontal positions
 * getTile(x, y).render(screen, this, x, y); // renders the tile on the screen
 * }
 * }
 * screen.setOffset(0, 0); // resets the offset.
 * }
 */