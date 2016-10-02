/**
 * Created by dianaruth on 9/27/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class TomeOfAgility extends Item {

    public TomeOfAgility (int x, int y) throws SlickException {
        this.name = "Tome of Agility";
        this.x = x;
        this.y = y;
        this.img = new Image("assets/items/tome.png");
        this.cooldownBonus = -300;
    }
}
