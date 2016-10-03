/**
 * Created by dianaruth on 10/2/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Skeleton extends Aggressive {
    public Skeleton (int initialX, int initialY) throws SlickException {
        this.name = "Skeleton";
        this.x = initialX;
        this.y = initialY;
        this.img = new Image("assets/units/skeleton.png");
        this.max_hp = 100;
        this.hp = max_hp;
        this.max_damage = 16;
        this.cooldown = 500;
        this.alive = true;
    }
}