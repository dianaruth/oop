/**
 * Created by dianaruth on 9/2/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {

    // the player's coordinates
    private int x;
    private int y;
    // coordinates at which to render the player relative to the camera
    private int cameraX;
    private int cameraY;
    // the image representing the player
    Image pic;
    // the player moves 0.25 pixels per millisecond
    private final double SPEED = 0.25;

    // constructs a new player with initial X and Y position
    public Player (int initialX, int initialY) throws SlickException{
        x = initialX;
        y = initialY;
        pic = new Image("assets/units/player.png");
    }

    public int getX () {
        return x;
    }

    public int getY () {
        return y;
    }

    // updates the location of the player relative to the world and relative to the camera
    public void update(double dir_x, double dir_y, int delta, Camera camera) {
        x += dir_x * delta * SPEED;
        y += dir_y * delta * SPEED;
        cameraX = x - camera.getxPos() + camera.screenwidth/2;
        cameraY = y - camera.getyPos() + camera.screenheight/2;
    }

    // display the player relative to the camera
    public void render () {
        pic.drawCentered(cameraX, cameraY);
    }
}
