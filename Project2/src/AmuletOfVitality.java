/**
 * Created by dianaruth on 9/29/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class AmuletOfVitality extends Item {
    public AmuletOfVitality (int x, int y) throws SlickException {
        this.setName("Amulet of Vitality");
        this.setX(x);
        this.setY(y);
        this.setImg(new Image("assets/items/amulet.png"));
    }
    
    /** Adds the item to the player's inventory
     * @param player The player whose inventory the item should be added to
     */
    @Override
    public void pickUp(Player player) {
    	if (!this.getInInventory()) {
    		super.pickUp(player);
        	// apply health bonus to player
        	player.setHp(player.getHp() + 80);
        	player.setMaxHp(player.getMaxHp() + 80);
    	}
    }
}
