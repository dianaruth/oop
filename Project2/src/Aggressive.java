/**
 * Created by dianaruth on 9/27/16.
 */

import java.util.Random;

public abstract class Aggressive extends Monster {
    /** Speed of an aggressive monster */
    public final double SPEED = 0.25;
    /** The maximum distance away from the player the monster must be for it to chase the player */
    public final int MAX_CHASE_DISTANCE = 150;

    /** Move toward the player if the player is within 150 pixels of the monster and attacks if the player
     * is within 50 pixels of the monster
     * @param world  The world that the monster will move in
     * @param player The player that the monster is attempting to attack if it is within range
     * @param delta  The amount of time that has passed (in milliseconds)
     */
    @Override
    public void move(World world, Player player, double delta) {
        // update the monster's attack cooldown
        if (this.getCooldownRemaining() - delta <= 0) {
            this.setCooldownRemaining(0);
        }
        else {
            this.setCooldownRemaining((int)(this.getCooldownRemaining() - delta));
        }

        // calculate distances
        double newX, newY;
        double distX = player.getX() - this.getX();
        double distY = player.getY() - this.getY();
        double dist_total = Math.sqrt((distX * distX) + (distY * distY));
        double amount = SPEED * delta;

        // attack the player if the player is within 50 pixels of the monster and there is no cooldown remaining
        // monster must be alive to attack
        if (dist_total <= INTERACTION_DISTANCE && this.getCooldownRemaining() == 0 && this.isAlive()) {
            // attack the player
            Random r = new Random();
            int damage = r.nextInt(this.getMaxDamage());
            if (damage >= player.getHp()) {
                // player is dead, revive so it can start over
                player.revive();
            }
            else {
                player.setHp(player.getHp() - damage);
            }
            // reset attack cooldown
            this.setCooldownRemaining(this.getCooldown());
        }
        // move toward player if player is within 150 pixels of the monster
        else if (dist_total <= MAX_CHASE_DISTANCE) {
            newX = this.getX() + (distX / dist_total) * amount;
            newY = this.getY() + (distY / dist_total) * amount;

            // update position if not blocked
            if (!world.terrainBlocks(newX, newY)) {
                this.setX(newX);
                this.setY(newY);
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
            player.setCooldownRemaining(player.getCooldown());
        }
    }
}
