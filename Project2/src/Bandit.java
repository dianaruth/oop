/**
 * Created by dianaruth on 10/2/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bandit extends Aggressive {
    public Bandit (int initialX, int initialY) throws SlickException {
        this.setName("Bandit");
        this.setX(initialX);
        this.setY(initialY);
        this.setImg(new Image("assets/units/bandit.png"));
        this.setMaxHp(40);
        this.setHp(this.getMaxHp());
        this.setMaxDamage(8);
        this.setCooldown(200);
        this.setAlive(true);
    }
}