/**
 * Created by dianaruth on 10/1/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class PrinceAldric extends Villager {
    public PrinceAldric (int initialX, int initialY) throws SlickException {
    	this.setName("Prince Aldric");
        this.setX(initialX);
        this.setY(initialY);
        this.setImg(new Image("assets/units/prince.png"));
        this.setMaxHp(1);
        this.setHp(this.getMaxHp());
        this.setMaxDamage(0);
        this.setCooldown(0);
        this.setAlive(true);
        this.setDialogueTimer(0);
    }

    /** Sets Prince Aldric's dialogue based on whether or not the player has the Elixir of Life
     * @param player                The player with which the object will interact
     * @param attemptingInteraction A boolean indicating whether the player is attempting to interact with the object
     */
    public void interact(Player player, boolean attemptingInteraction) {
        // first check if player is attempting interaction and is within 50 pixels of Garth
        double dist = Math.sqrt(Math.pow(this.getX() - player.getX(), 2) + Math.pow(this.getY() - player.getY(), 2));
        if (attemptingInteraction && dist < 50 && this.getDialogueTimer() == 0) {
            boolean elixir = false;
            // check to see which items the player has in inventory
            for (Item i : player.getInventory()) {
                if (i.getName().equals("Elixir of Life"))
                    elixir = true;
            }
            // choose dialogue depending on if player has elixir of life
            if (!elixir) {
                this.setDialogue("Please seek out the Elixir of Life to cure the king.");
            }
            else {
                this.setDialogue("The elixir! My father is cured! Thank you!");
            }
            this.setDialogueTimer(DIALOGUE_LENGTH);
        }
    }
}
