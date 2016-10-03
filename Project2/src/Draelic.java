/**
 * Created by dianaruth on 10/2/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Draelic extends Aggressive {
    public Draelic (int initialX, int initialY) throws SlickException {
        this.name = "Draelic";
        this.x = initialX;
        this.y = initialY;
        this.img = new Image("assets/units/necromancer.png");
        this.max_hp = 140;
        this.hp = max_hp;
        this.max_damage = 30;
        this.cooldown = 400;
        this.alive = true;
    }
}