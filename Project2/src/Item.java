/**
 * Created by dianaruth on 9/27/16.
 */

import org.newdawn.slick.Image;

public abstract class Item extends WorldObject implements Interactive {
    protected String name;
    protected Image image;
    protected boolean inInventory;
    protected int healthBonus = 0;
    protected int damageBonus = 0;
    protected int cooldownBonus = 0;

    /** Adds the item to the player's inventory
     * @param player The player whose inventory the item should be added to
     */
    public void pickUp(Player player) {
        player.addToInventory(this);
        this.inInventory = true;
        player.hp += healthBonus;
        player.cooldown += cooldownBonus;
        player.max_damage += damageBonus;
    }

    /**
     * Renders the item at its x and y coordinate, if it hasn't been picked up.
     */
    public void render () {
        if (!inInventory)
            image.drawCentered((float)this.x, (float)this.y);
    }

    /** Adds the item to the player's inventory if it is within 50 pixels of the player
     * @param player                The player with which the object will interact
     * @param attemptingInteraction A boolean indicating whether the player is attempting to interact with the object
     */
    public void interact (Player player, boolean attemptingInteraction) {
        // check to see if the player is within 50 pixels of the item
        double dist = Math.sqrt(Math.pow(this.x - player.x, 2) + Math.pow(this.y - player.y, 2));
        if (attemptingInteraction && dist < 50) {
            this.pickUp(player);
        }
    }
}