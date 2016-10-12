/**
 * Created by dianaruth on 9/27/16.
 */
public abstract class Monster extends Unit implements Interactive {
    /** The current x direction that the monster is moving in (-1 for left and 1 for right) */
    protected int current_x_dir;
    /** The current y direction that the monster is moving in (-1 for down and 1 for up) */
    protected int current_y_dir;
    
    /** Returns the object's current x direction (0, -1, or 1)
     * @return The object's current x direction
     */
    public int getCurrentXDir() {
        return current_x_dir;
    }
    
    /** Sets the object's current x direction (0, -1, or 1)
     * @param newCurrentXDir The object's new current x direction
     */
    public void setCurrentXDir(int newCurrentXDir) {
        this.current_x_dir = newCurrentXDir;
    }
    
    /** Returns the object's current y direction (0, -1, or 1)
     * @return The object's current y direction
     */
    public int getCurrentYDir() {
        return current_y_dir;
    }
    
    /** Sets the object's current y direction (0, -1, or 1)
     * @param newCurrentYDir The object's new current y direction
     */
    public void setCurrentYDir(int newCurrentYDir) {
        this.current_y_dir = newCurrentYDir;
    }

    /** Updates the direction that the monster should move and moves its position
     * @param world The world that the monster will move in
     * @param player The player that the monster is attempting to attack if it is within range
     * @param delta The amount of time that has passed (in milliseconds)
     */
    public abstract void move (World world, Player player, double delta);
}
