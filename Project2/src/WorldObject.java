/**
 * Created by dianaruth on 9/27/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class WorldObject {

    protected Image img;
    protected Image img_flipped;
    protected double x;
    protected double y;
    protected int width;
    protected int height;
    protected boolean face_left;

    public abstract void render();

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
