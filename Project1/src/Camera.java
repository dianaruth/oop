/* SWEN20003 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Your name> <Your login>
 */

import org.newdawn.slick.SlickException;

/** Represents the camera that controls our viewpoint.
 */
public class Camera
{

    /** The unit this camera is following */
    private Player unitFollow;

    /** The width and height of the screen */
    /** Screen width, in pixels. */
    public final int screenwidth;
    /** Screen height, in pixels. */
    public final int screenheight;


    /** The camera's position in the world, in x and y coordinates. */
    private int xPos;
    private int yPos;


    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }


    /** Create a new Camera object. */
    public Camera(Player player, int screenwidth, int screenheight)
    {
        this.unitFollow = player;
        this.screenwidth = screenwidth;
        this.screenheight = screenheight;
    }

    /** Update the game camera to recentre it's viewpoint around the player
     */
    public void update()
    throws SlickException
    {
        xPos = unitFollow.getX();
        yPos = unitFollow.getY();
    }

    /** Returns the minimum x value on screen
     */
    public int getMinX(){
        return xPos - (screenwidth/2);
    }

    /** Returns the maximum x value on screen
     */
    public int getMaxX(){
        return xPos + (screenwidth/2);
    }

    /** Returns the minimum y value on screen
     */
    public int getMinY(){
        return yPos - (screenheight/2);
    }

    /** Returns the maximum y value on screen
     */
    public int getMaxY(){
        return yPos + (screenheight/2);
    }

    /** Tells the camera to follow a given unit.
     */
    public void followUnit(Object unit)
    throws SlickException
    {
        unitFollow = (Player) unit;
    }

}