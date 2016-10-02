/**
 * Created by dianaruth on 9/27/16.
 */
public abstract class Passive {
    /** The speed of the monster */
    protected final double SPEED = 0.2;
    /** The amount of time that needs to pass before the monster can change directions */
    protected final int MAX_CHANGE_DIR_TIME = 3000;
    /** The amount of time that needs to pass before the monster feels safe and can resume roaming */
    protected final int MAX_WANDER_TIME = 5000;
    /** The amount of time that has passed since the last time the monster changed direction */
    protected int change_dir_timer;
    /** The amount of time that has passed since the monster was last attacked by the player */
    protected int wander_timer;
}
