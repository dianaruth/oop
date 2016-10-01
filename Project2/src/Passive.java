/**
 * Created by dianaruth on 9/27/16.
 */
public abstract class Passive {
    protected final double SPEED = 0.2;
    protected final int MAX_CHANGE_DIR_TIME = 3000;
    protected final int MAX_WANDER_TIME = 5000;
    protected int change_dir_timer;
    protected int wander_timer;
}
