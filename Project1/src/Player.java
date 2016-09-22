/* SWEN20003 Object Oriented Software Development
 * RPG Game Engine
 * Author: Diana Ruth (druth)
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {

    // the player's coordinates
    private double x;
    private double y;
    // the image representing the player
    private Image picRight;
    private Image picLeft;
    private Image pic;
    // the player moves 0.25 pixels per millisecond
    private final double SPEED = 0.25;

    // constructs a new player with initial X and Y position
    public Player (int initialX, int initialY) throws SlickException{
        x = initialX;
        y = initialY;
        picRight = new Image("assets/units/player.png");
        picLeft = picRight.getFlippedCopy(true, false);
        pic = picRight;
    }

    public double getX () {
        return x;
    }

    public double getY () {
        return y;
    }

    // updates the location of the player relative to the world
    public void update(double dir_x, double dir_y, int delta) {
        if (dir_x == 1) {
            pic = picRight;
        }
        else if (dir_x == -1) {
            pic = picLeft;
        }
        x += dir_x * SPEED * delta;
        y += dir_y * SPEED * delta;
    }

    // display the player relative to the camera
    public void render (Camera c) {
        pic.drawCentered((float)(x - c.getxPos() + (c.screenwidth/2)), (float)(y - c.getyPos() + (c.screenheight/2)));
    }
}