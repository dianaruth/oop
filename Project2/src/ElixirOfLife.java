/**
 * Created by dianaruth on 9/29/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ElixirOfLife extends Item {
    public ElixirOfLife (int x, int y) throws SlickException {
        this.name = "Elixir of Life";
        this.x = x;
        this.y = y;
        this.img = new Image("assets/items/elixir.png");
    }
}
