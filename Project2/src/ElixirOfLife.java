/**
 * Created by dianaruth on 9/29/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ElixirOfLife extends Item {
    public ElixirOfLife (int x, int y) throws SlickException {
        this.setName("Elixir of Life");
        this.setX(x);;
        this.setY(y);
        this.setImg(new Image("assets/items/elixir.png"));
    }
}
