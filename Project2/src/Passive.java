/**
 * Created by dianaruth on 9/27/16.
 */

import java.util.Random;

public abstract class Passive extends Monster{
    /** The speed of the monster */
    protected final double SPEED = 0.2;
    /** The amount of time that needs to pass before the monster can change directions */
    protected final int MAX_CHANGE_DIR_TIME = 3000;
    /** The amount of time that needs to pass before the monster feels safe and can resume roaming */
    protected final int MAX_WANDER_TIME = 5000;
    /** The amount of time that has passed since the last time the monster changed direction */
    protected int change_dir_timer;
    /** The amount of time that has passed since the monster was last attacked by the player */
    protected int wander_timer;
    /** Array of direction choices */
    protected final int[] DIRECTIONS = {-1, 0, 1};

    /** Changes direction if the wander timer is zero or less, and changes direction based on whether the monster
     * is still wandering or running away from the player
     * @param world  The world that the monster will move in
     * @param player The player that the monster is attempting to attack if it is within range
     * @param delta  The amount of time that has passed (in milliseconds)
     */
    @Override
    public void move(World world, Player player, double delta) {
        // variables for storing new position
        double newX, newY;

        // update wander timer
        if (wander_timer - delta <= 0) {
            wander_timer = 0;
        }
        else {
            wander_timer = wander_timer - (int)delta;
        }

        // run away from player if monster has been attacked recently
        if (wander_timer > 0) {
            double dist_x = Math.abs(player.x - this.x);
            double dist_y = Math.abs(player.y = this.y);
            double dist_total = Math.sqrt(Math.pow(this.x - player.x, 2) + Math.pow(this.y - player.y, 2));
            double amount = Math.sqrt(Math.pow(current_x_dir * delta * SPEED, 2) + Math.pow(current_y_dir * delta * SPEED, 2));
            newX = (dist_x / dist_total) * amount;
            newY = (dist_y / dist_total) * amount;
        }
        // if not attacked recently, wander the world
        else {
            // update the direction change timer and change directions if time to do so
            if (change_dir_timer - delta <= 0) {
                change_dir_timer = MAX_CHANGE_DIR_TIME;
                // change direction
                Random r = new Random();
                int rand = r.nextInt(3);
                current_x_dir = DIRECTIONS[rand];
                rand = r.nextInt(3);
                current_y_dir = DIRECTIONS[rand];
            }
            else {
                change_dir_timer = change_dir_timer - (int)delta;
            }
            // update the monster's position
            newX = x + (current_x_dir * delta * SPEED);
            newY = y + (current_y_dir * delta * SPEED);
        }

        // update position if not blocked
        if (!world.terrainBlocks(newX, newY)) {
            x = newX;
            y = newY;
        }
    }

    /** Subtracts damage from the monster's hp, and sets the runaway timer
     * @param player                The player with which the object will interact
     * @param attemptingInteraction A boolean indicating whether the player is attempting to interact with the object
     */
    @Override
    public void interact(Player player, boolean attemptingInteraction) {
        // first check if player is attempting interaction and is within 50 pixels of the monster
        double dist = Math.sqrt(Math.pow(this.x - player.x, 2) + Math.pow(this.y - player.y, 2));
        if (attemptingInteraction && dist < 50) {
            Random r = new Random();
            int damage = r.nextInt(player.max_damage);
            if (damage >= this.hp) {
                this.kill();
            }
            else {
                this.hp -= damage;
            }
            this.wander_timer = MAX_WANDER_TIME;
        }
    }
}
