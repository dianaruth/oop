/**
 * Created by dianaruth on 9/27/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class TomeOfAgility extends Item {

	public TomeOfAgility (int x, int y) throws SlickException {
        this.setName("Tome of Agility");
        this.setX(x);
        this.setY(y);
        this.setImg(new Image("assets/items/tome.png"));
    }
    
    /** Adds the item to the player's inventory
     * @param player The player whose inventory the item should be added to
     */
    @Override
    public void pickUp(Player player) {
    	if (!this.getInInventory()) {
	    	super.pickUp(player);
	    	// apply damage bonus to player
	    	player.setCooldown(player.getCooldown() - 300);
    	}
    }
}
