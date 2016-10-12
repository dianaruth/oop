/**
 * Created by dianaruth on 10/1/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class LadyElvira extends Villager {
    public LadyElvira (int initialX, int initialY) throws SlickException {
    	this.setName("Elvira");
        this.setX(initialX);
        this.setY(initialY);
        this.setImg(new Image("assets/units/shaman.png"));
        this.setMaxHp(1);
        this.setHp(this.getMaxHp());
        this.setMaxDamage(0);
        this.setCooldown(0);
        this.setAlive(true);
        this.setDialogueTimer(0);
    }

    /** Sets Lady Elvira's dialogue based on the player's health
     * @param player                The player with which the object will interact
     * @param attemptingInteraction A boolean indicating whether the player is attempting to interact with the object
     */
    public void interact(Player player, boolean attemptingInteraction) {
        // first check if player is attempting interaction and is within 50 pixels of Garth
        double dist = Math.sqrt(Math.pow(this.getX() - player.getX(), 2) + Math.pow(this.getY() - player.getY(), 2));

        // to change the dialogue, the player must be attempting interaction, be within 50 pixels,
        // and the dialogue timer must be zero
        if (attemptingInteraction && dist < 50 && this.getDialogueTimer() == 0) {
            if (player.getHp() == player.getMaxHp()) {
                this.setDialogue("Return to me if you ever need healing.");
            }
            else {
                player.setHp(player.getMaxHp());
                this.setDialogue("You're looking much healthier now.");
            }
            this.setDialogueTimer(DIALOGUE_LENGTH);
        }
    }
}
