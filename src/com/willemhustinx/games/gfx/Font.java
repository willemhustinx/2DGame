package com.willemhustinx.games.gfx;

/**
 * Created by willemhustinx on 10-10-2017.
 */
public class Font {
    private static String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void draw(String msg, Screen screen, int x, int y, int col) {
        msg = msg.toUpperCase();
        for (int i = 0; i < msg.length(); i++) {
            int ix = chars.indexOf(msg.charAt(i));
            if (ix >= 0) {
                screen.render(x + i * 8, y , ix+ 30 * 32, col, 0);
            }
        }
    }
}