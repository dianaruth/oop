/**
 * Created by dianaruth on 10/2/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Draelic extends Aggressive {
    public Draelic (int initialX, int initialY) throws SlickException {
        this.setName("Draelic");
        this.setX(initialX);
        this.setY(initialY);
        this.setImg(new Image("assets/units/necromancer.png"));
        this.setMaxHp(140);
        this.setHp(this.getMaxHp());
        this.setMaxDamage(30);
        this.setCooldown(400);
        this.setAlive(true);
    }
}