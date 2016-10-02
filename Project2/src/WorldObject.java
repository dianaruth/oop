/**
 * Created by dianaruth on 9/27/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class WorldObject {
    /** The name of the object */
    protected String name;
    /** The image representing the object */
    protected Image img;
    /** The flipped copy of img */
    protected Image img_flipped;
    /** The x position of the object */
    protected double x;
    /** The y position of the object */
    protected double y;
    /** Boolean indicating whether the unit is facing left or right */
    protected boolean face_left;
    /** The width of the object (based on its image) */
    protected int width;
    /** The height of the object (based on its image) */
    protected int height;

    /** Returns the object's x coordinate
     * @return The object's x coordinate
     */
    public double getX() {
        return x;
    }

    /** Returns the object's y coordinate
     * @return The object's y coordinate
     */
    public double getY() {
        return y;
    }
}
