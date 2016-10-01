/**
 * Created by dianaruth on 9/27/16.
 */
public abstract class Monster extends Unit implements Interactive {
    protected int current_x_dir;
    protected int current_y_dir;

    public abstract void move (World world, Player player, double dir_x, double dir_y, double delta);
}
