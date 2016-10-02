/**
 * Created by dianaruth on 9/27/16.
 */
public abstract class Monster extends Unit implements Interactive {
    /** The current x direction that the monster is moving in (-1 for left and 1 for right) */
    protected int current_x_dir;
    /** The current y direction that the monster is moving in (-1 for down and 1 for up) */
    protected int current_y_dir;

    /** Updates the direction that the monster should move and moves its position
     * @param world The world that the monster will move in
     * @param player The player that the monster is attempting to attack if it is within range
     * @param dir_x The x direction of the monster
     * @param dir_y The y direction of the monster
     * @param delta The amount of time that has passed (in milliseconds)
     */
    public abstract void move (World world, Player player, double dir_x, double dir_y, double delta);
}
