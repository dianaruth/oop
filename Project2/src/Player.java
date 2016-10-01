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

    // Pixels per millisecond
    private static final double SPEED = 0.25;
    // respawn position
    private static final int PLAYER_RESPAWN_X = 738, PLAYER_RESPAWN_Y = 549;
    // list of items in inventory
    protected ArrayList<Item> inventory;

    /** Creates a new Player.
     * @param image_path Path of player's image file.
     * @param x The Player's starting x location in pixels.
     * @param y The Player's starting y location in pixels.
     */
    public Player(String image_path, double x, double y)
        throws SlickException
    {
        img = new Image(image_path);
        img_flipped = img.getFlippedCopy(true, false);
        this.x = x;
        this.y = y;
        this.width = img.getWidth();
        this.height = img.getHeight();
        this.face_left = false;
        this.inventory = new ArrayList<Item>();
        this.hp = 100;
        this.max_hp = 100;
        this.max_damage = 26;
        this.cooldown = 600;
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
            this.face_left = false;
        else if (dir_x < 0)
            this.face_left = true;

        // Move the player by dir_x, dir_y, as a multiple of delta * speed
        double new_x = this.x + dir_x * delta * SPEED;
        double new_y = this.y + dir_y * delta * SPEED;

        // Move in x first
        double x_sign = Math.signum(dir_x);
        if(!world.terrainBlocks(new_x + x_sign * width / 2, this.y + height / 2) 
                && !world.terrainBlocks(new_x + x_sign * width / 2, this.y - height / 2)) {
            this.x = new_x;
        }
        
        // Then move in y
        double y_sign = Math.signum(dir_y);
        if(!world.terrainBlocks(this.x + width / 2, new_y + y_sign * height / 2) 
                && !world.terrainBlocks(this.x - width / 2, new_y + y_sign * height / 2)){
            this.y = new_y;
        }
   
    }

    /** Draws the player on the screen based on its x and y coordinates.
     *
     */
    public void render()
    {
        Image which_img;
        which_img = this.face_left ? this.img_flipped : this.img;
        which_img.drawCentered((int) x, (int) y);
    }

    /** Revives the player.
     *  Resets the player's status, hp, damage, and position
     */
    public void revive () {
        this.alive = true;
        this.x = PLAYER_RESPAWN_X;
        this.y = PLAYER_RESPAWN_Y;
    }

    /** Adds the item to the player's inventory
     * @param item The item to be added to the player's inventory
     */
    public void addToInventory(Item item) {
        if (!inventory.contains(item))
            this.inventory.add(item);
    }
}
