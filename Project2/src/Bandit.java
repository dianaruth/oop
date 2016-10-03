/**
 * Created by dianaruth on 10/2/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bandit extends Aggressive {
    public Bandit (int initialX, int initialY) throws SlickException {
        this.name = "Bandit";
        this.x = initialX;
        this.y = initialY;
        this.img = new Image("assets/units/bandit.png");
        this.max_hp = 40;
        this.hp = max_hp;
        this.max_damage = 8;
        this.cooldown = 200;
        this.alive = true;
    }
}