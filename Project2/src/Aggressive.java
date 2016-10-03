/**
 * Created by dianaruth on 9/27/16.
 */

import java.util.Random;

public abstract class Aggressive extends Monster {
    /** Speed of an aggressive monster */
    protected final double SPEED = 0.25;
    /** The maximum distance away from the player the monster must be for it to chase the player */
    protected final int MAX_CHASE_DISTANCE = 150;

    /** Move toward the player if the player is within 150 pixels of the monster and attacks if the player
     * is within 50 pixels of the monster
     * @param world  The world that the monster will move in
     * @param player The player that the monster is attempting to attack if it is within range
     * @param delta  The amount of time that has passed (in milliseconds)
     */
    @Override
    public void move(World world, Player player, double delta) {
        // update the monster's attack cooldown
        if (this.cooldown_remaining - delta <= 0) {
            this.cooldown_remaining = 0;
        }
        else {
            this.cooldown_remaining -= delta;
        }

        // calculate distances
        double newX, newY;
        double distX = player.x - this.x;
        double distY = player.y - this.y;
        double dist_total = Math.sqrt((distX * distX) + (distY * distY));
        double amount = SPEED * delta;

        // attack the player if the player is within 50 pixels of the monster and there is no cooldown remaining
        // monster must be alive to attack
        if (dist_total <= INTERACTION_DISTANCE && cooldown_remaining == 0 && this.isAlive()) {
            // attack the player
            Random r = new Random();
            int damage = r.nextInt(this.max_damage);
            if (damage >= player.hp) {
                // player is dead, revive so it can start over
                player.revive();
            }
            else {
                player.hp -= damage;
            }
            // reset attack cooldown
            this.cooldown_remaining = this.cooldown;
        }
        // move toward player if player is within 150 pixels of the monster
        else if (dist_total <= MAX_CHASE_DISTANCE) {
            newX = this.x + (distX / dist_total) * amount;
            newY = this.y + (distY / dist_total) * amount;

            // update position if not blocked
            if (!world.terrainBlocks(newX, newY)) {
                x = newX;
                y = newY;
            }
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

        // only interact if user is attacking, player is within 50 pixels, and cooldown is zero
        if (attemptingInteraction && dist < INTERACTION_DISTANCE && player.cooldown_remaining == 0) {
            Random r = new Random();
            int damage = r.nextInt(player.max_damage);
            if (damage >= this.hp) {
                this.kill();
            }
            else {
                this.hp -= damage;
            }
            player.cooldown_remaining = player.cooldown;
        }
    }
}
