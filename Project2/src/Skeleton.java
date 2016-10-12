/**
 * Created by dianaruth on 10/2/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Skeleton extends Aggressive {
    public Skeleton (int initialX, int initialY) throws SlickException {this.setName("Skeleton");
        this.setX(initialX);
        this.setY(initialY);
        this.setImg(new Image("assets/units/skeleton.png"));
        this.setMaxHp(100);
        this.setHp(this.getMaxHp());
        this.setMaxDamage(16);
        this.setCooldown(500);
        this.setAlive(true);
    }
}