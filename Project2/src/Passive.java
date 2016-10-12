/**
 * Created by dianaruth on 9/27/16.
 */

import java.util.Random;

public abstract class Passive extends Monster {
    /** The speed of the monster */
    public final double SPEED = 0.2;
    /** The amount of time that needs to pass before the monster can change directions */
    public final int MAX_CHANGE_DIR_TIME = 3000;
    /** The amount of time that needs to pass before the monster feels safe and can resume roaming */
    public final int MAX_WANDER_TIME = 5000;
    /** The amount of time that has passed since the last time the monster changed direction */
    private int change_dir_timer;
    /** The amount of time that has passed since the monster was last attacked by the player */
    private int wander_timer;
    /** Array of direction choices */
    public final int[] DIRECTIONS = {-1, 0, 1};
    
    /** Returns how much time is left until the object should change direction
     * @return How much time is left until the object should change direction
     */
    public int getChangeDirTimer() {
        return change_dir_timer;
    }
    
    /** Sets how much time is left until the object should change direction
     * @param newChangeDirTimer The new amount of time until the object should change direction
     */
    public void setChangeDirTimer(int newChangeDirTimer) {
        this.change_dir_timer = newChangeDirTimer;
    }
    
    /** Returns how much time is left until the object should resume wandering
     * @return How much time is left until the object should resume wandering
     */
    public int getWanderTimer() {
        return wander_timer;
    }
    
    /** Sets how much time is left until the object should resume wandering
     * @param newWanderTimer The new amount of time until the object should resume wandering
     */
    public void setWanderTimer(int newWanderTimer) {
        this.wander_timer = newWanderTimer;
    }

    /** Changes direction if the wander timer is zero or less, and changes direction based on whether the monster
     * is still wandering or running away from the player
     * @param world  The world that the monster will move in
     * @param player The player that is attempting to attack the monster
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
            double distX = -(player.getX() - this.getX());
            double distY = -(player.getY() - this.getY());
            double dist_total = Math.sqrt((distX * distX) + (distY * distY));
            double amount = SPEED * delta;
            newX = this.getX() + (distX / dist_total) * amount;
            newY = this.getY() + (distY / dist_total) * amount;
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
            newX = this.getX() + (current_x_dir * delta * SPEED);
            newY = this.getY() + (current_y_dir * delta * SPEED);
        }

        // update position if not blocked
        if (!world.terrainBlocks(newX, newY)) {
            this.setX(newX);
            this.setY(newY);
        }
    }

    /** Subtracts damage from the monster's hp, and sets the runaway timer
     * @param player                The player with which the object will interact
     * @param attemptingInteraction A boolean indicating whether the player is attempting to interact with the object
     */
    @Override
    public void interact(Player player, boolean attemptingInteraction) {
        // first check if player is attempting interaction and is within 50 pixels of the monster
        double dist = Math.sqrt(Math.pow(this.getX() - player.getX(), 2) + Math.pow(this.getY() - player.getY(), 2));

        // only interact if user is attacking, player is within 50 pixels, and cooldown is zero
        if (attemptingInteraction && dist < INTERACTION_DISTANCE && player.getCooldownRemaining() == 0) {
            Random r = new Random();
            int damage = r.nextInt(player.getMaxDamage());
            if (damage >= this.getHp()) {
                this.kill();
            }
            else {
                this.setHp(this.getHp() - damage);
            }
            this.wander_timer = MAX_WANDER_TIME;
            player.setCooldownRemaining(player.getCooldown());
        }
    }
}
