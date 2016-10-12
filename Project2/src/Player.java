/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Sample Solution
 * Author: Matt Giuca <mgiuca>
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import java.util.ArrayList;

/** The character which the user plays as.
 */
public class Player extends Unit {

    /** The speed of the player */
    private static final double SPEED = 0.25;
    /** The initial position that the player should be moved to when they respawn */
    private static final int PLAYER_RESPAWN_X = 738, PLAYER_RESPAWN_Y = 549;
    /** List of items in the player's inventory */
    private ArrayList<Item> inventory;

    /** Creates a new Player.
     * @param image_path Path of player's image file.
     * @param x The Player's starting x location in pixels.
     * @param y The Player's starting y location in pixels.
     */
    public Player(String image_path, double x, double y)
        throws SlickException
    {
        this.setImg(new Image(image_path));
        this.setFlippedImg(this.getImg().getFlippedCopy(true, false));
        this.setX(x);
        this.setY(y);
        this.setWidth(getImg().getWidth());
        this.setHeight(getImg().getHeight());
        this.setFaceLeft(false);
        this.setInventory(new ArrayList<Item>());
        this.setHp(100);
        this.setMaxHp(100);
        this.setMaxDamage(26);
        this.setCooldown(600);
        this.setAlive(true);
    }
    
    /** Returns the player's inventory
     * @return The player's inventory
     */
    public ArrayList<Item> getInventory() {
        return inventory;
    }
    
    /** Sets the player's inventory
     * @param newInventory The player's new inventory
     */
    public void setInventory(ArrayList<Item> newInventory) {
        this.inventory = newInventory;
    }

    /** Move the player in a given direction.
     * Prevents the player from moving outside the map space, and also updates
     * the direction the player is facing.
     * @param world The world the player is on (to check blocking).
     * @param dir_x The player's movement in the x axis (-1, 0 or 1).
     * @param dir_y The player's movement in the y axis (-1, 0 or 1).
     * @param delta Time passed since last frame (milliseconds).
     */
    public void move(World world, double dir_x, double dir_y, double delta)
    {
        // Update player facing based on X direction
        if (dir_x > 0)
            this.setFaceLeft(false);
        else if (dir_x < 0)
            this.setFaceLeft(true);

        // Move the player by dir_x, dir_y, as a multiple of delta * speed
        double new_x = this.getX() + dir_x * delta * SPEED;
        double new_y = this.getY() + dir_y * delta * SPEED;

        // Move in x first
        double x_sign = Math.signum(dir_x);
        if(!world.terrainBlocks(new_x + x_sign * getWidth() / 2, this.getY() + getHeight() / 2) 
                && !world.terrainBlocks(new_x + x_sign * getWidth() / 2, this.getY() - getHeight() / 2)) {
            this.setX(new_x);
        }
        
        // Then move in y
        double y_sign = Math.signum(dir_y);
        if(!world.terrainBlocks(this.getX() + getWidth() / 2, new_y + y_sign * getHeight() / 2) 
                && !world.terrainBlocks(this.getX() - getWidth() / 2, new_y + y_sign * getHeight() / 2)){
            this.setY(new_y);
        }

        // update attack cooldown
        if (this.getCooldownRemaining() - delta <= 0) {
            this.setCooldownRemaining(0);
        }
        else {
            this.setCooldownRemaining((int)(this.getCooldownRemaining() - delta));
        }
    }

    /** Draws the player on the screen based on its x and y coordinates.
     *
     */
    public void render()
    {
        if (this.isAlive()) {
            Image which_img;
            which_img = this.getFaceLeft() ? this.getFlippedImg() : this.getImg();
            which_img.drawCentered((int) this.getX(), (int) this.getY());
        }
    }

    /** Revives the player.
     *  Resets the player's status, hp, damage, and position
     */
    public void revive () {
        // reset location
        this.setX(PLAYER_RESPAWN_X);
        this.setY(PLAYER_RESPAWN_Y);
        // reset stats
        this.setHp(100);
        this.setMaxHp(100);
        this.setMaxDamage(26);
        this.setCooldown(600);
    }

    /** Adds the item to the player's inventory
     * @param item The item to be added to the player's inventory
     */
    public void addToInventory(Item item) {
        if (!inventory.contains(item))
            this.getInventory().add(item);
    }
}
