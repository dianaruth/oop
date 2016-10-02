/**
 * Created by dianaruth on 9/27/16.
 */
public abstract class Aggressive extends Monster {
    /** Speed of an aggressive monster */
    protected final double SPEED = 0.25;
    /** The maximum distance away from the player the monster must be for it to chase the player */
    protected final int MAX_CHASE_DISTANCE = 150;
}
