/**
 * Created by dianaruth on 9/27/16.
 */
public abstract class Unit extends WorldObject {
    protected int hp;
    protected int max_hp;
    protected int max_damage;
    protected int cooldown;
    protected int cooldown_remaining;
    protected boolean alive;

    public void kill () {
        this.alive = false;
    }

    public boolean isAlive () {
        return this.alive;
    }

    public void render() {
        this.img.drawCentered((float)this.x, (float)this.y);
    }
}
