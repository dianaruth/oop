/**
 * Created by dianaruth on 9/29/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SwordOfStrength extends Item {
    public SwordOfStrength (int x, int y) throws SlickException {
        this.setName("Sword of Strength");
        this.setX(x);
        this.setY(y);
        this.setImg(new Image("assets/items/sword.png"));
    }
    
    /** Adds the item to the player's inventory
     * @param player The player whose inventory the item should be added to
     */
    @Override
    public void pickUp(Player player) {
    	if (!this.getInInventory()) {
	    	super.pickUp(player);
	    	// apply damage bonus to player
	    	player.setMaxDamage(player.getMaxDamage() + 30);
    	}
    }
}