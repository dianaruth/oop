/**
 * Created by dianaruth on 10/2/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Zombie extends Aggressive {
    public Zombie (int initialX, int initialY) throws SlickException {
        this.name = "Zombie";
        this.x = initialX;
        this.y = initialY;
        this.img = new Image("assets/units/zombie.png");
        this.max_hp = 60;
        this.hp = max_hp;
        this.max_damage = 10;
        this.cooldown = 800;
        this.alive = true;
    }
}
