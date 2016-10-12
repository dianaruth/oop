/**
 * Created by dianaruth on 10/2/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Zombie extends Aggressive {
    public Zombie (int initialX, int initialY) throws SlickException {
        this.setName("Zombie");
        this.setX(initialX);
        this.setY(initialY);
        this.setImg(new Image("assets/units/zombie.png"));
        this.setMaxHp(60);
        this.setHp(this.getMaxHp());
        this.setMaxDamage(10);
        this.setCooldown(800);
        this.setAlive(true);
    }
}
