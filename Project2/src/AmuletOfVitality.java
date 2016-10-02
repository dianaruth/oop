/**
 * Created by dianaruth on 9/29/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class AmuletOfVitality extends Item {
    public AmuletOfVitality (int x, int y) throws SlickException {
        this.name = "Amulet of Vitality";
        this.x = x;
        this.y = y;
        this.img = new Image("assets/items/amulet.png");
        this.healthBonus = 80;
    }
}
