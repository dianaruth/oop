/**
 * Created by dianaruth on 10/2/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GiantBat extends Passive {
    public GiantBat (int initialX, int initialY) throws SlickException{
        this.setName("Giant Bat");
        this.setX(initialX);
        this.setY(initialY);
        this.setImg(new Image("assets/units/dreadbat.png"));
        this.setMaxHp(40);
        this.setHp(this.getMaxHp());
        this.setMaxDamage(0);
        this.setCooldown(0);
        this.setAlive(true);
        this.setCurrentXDir(0);
        this.setCurrentYDir(0);
        this.setChangeDirTimer(0);
        this.setWanderTimer(0);
    }
}
