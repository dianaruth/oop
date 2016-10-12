/**
 * Created by dianaruth on 9/27/16.
 */

public abstract class Item extends WorldObject implements Interactive {
    /** Boolean indicating whether the item is in the player's inventory */
    protected boolean inInventory;
    
    /** Returns whether the item is in the player's inventory or not
     * @return Whether or not the item is in the player's inventory
     */
    public boolean getInInventory() {
        return inInventory;
    }
    
    /** Sets whether the item is in the player's inventory or not
     * @param newInInventory The object's new inInventory member
     */
    public void setInInventory(boolean newInInventory) {
        this.inInventory = newInInventory;
    }

    /** Adds the item to the player's inventory
     * @param player The player whose inventory the item should be added to
     */
    public void pickUp(Player player) {
    	if (!inInventory) {
    		player.addToInventory(this);
            this.setInInventory(true);
    	}
    }

    /**
     * Renders the item at its x and y coordinate, if it hasn't been picked up.
     */
    public void render () {
        if (!inInventory)
            this.getImg().drawCentered((float)this.getX(), (float)this.getY());
    }

    /** Adds the item to the player's inventory if it is within 50 pixels of the player
     * @param player                The player with which the object will interact
     * @param attemptingInteraction A boolean indicating whether the player is attempting to interact with the object
     */
    public void interact (Player player, boolean attemptingInteraction) {
        // check to see if the player is within 50 pixels of the item
        double dist = Math.sqrt(Math.pow(this.getX() - player.getX(), 2) + Math.pow(this.getY() - player.getY(), 2));
        if (attemptingInteraction && dist < 50) {
            this.pickUp(player);
        }
    }
}
