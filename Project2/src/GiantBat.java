/**
 * Created by dianaruth on 10/2/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GiantBat extends Passive {
    public GiantBat (int initialX, int initialY) throws SlickException{
        this.name = "Giant Bat";
        this.x = initialX;
        this.y = initialY;
        this.img = new Image("assets/units/dreadbat.png");
        this.max_hp = 40;
        this.hp = max_hp;
        this.max_damage = 0;
        this.cooldown = 0;
        this.alive = true;
        this.current_x_dir = 0;
        this.current_y_dir = 0;
        this.change_dir_timer = 0;
        this.wander_timer = 0;
    }
}
