/**
 * Created by dianaruth on 9/29/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SwordOfStrength extends Item {
    public SwordOfStrength (int x, int y) throws SlickException {
        this.name = "Sword of Strength";
        this.x = x;
        this.y = y;
        this.image = new Image("assets/items/sword.png");
        this.damageBonus = 30;
    }
}