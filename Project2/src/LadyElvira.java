/**
 * Created by dianaruth on 10/1/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class LadyElvira extends Villager {
    public LadyElvira (int initialX, int initialY) throws SlickException {
        this.name = "Elvira";
        this.x = initialX;
        this.y = initialY;
        this.img = new Image("assets/units/shaman.png");
        this.max_hp = 1;
        this.hp = max_hp;
        this.max_damage = 0;
        this.cooldown = 0;
        this.alive = true;
        this.dialogue_timer = 0;
    }

    /** Sets Lady Elvira's dialogue based on the player's health
     * @param player                The player with which the object will interact
     * @param attemptingInteraction A boolean indicating whether the player is attempting to interact with the object
     */
    public void interact(Player player, boolean attemptingInteraction) {
        // first check if player is attempting interaction and is within 50 pixels of Garth
        double dist = Math.sqrt(Math.pow(this.x - player.x, 2) + Math.pow(this.y - player.y, 2));

        // to change the dialogue, the player must be attempting interaction, be within 50 pixels,
        // and the dialogue timer must be zero
        if (attemptingInteraction && dist < 50 && dialogue_timer == 0) {
            boolean elixir = false;
            if (player.hp == player.max_hp) {
                this.dialogue = "Return to me if you ever need healing.";
            }
            else {
                player.hp = player.max_hp;
                this.dialogue = "You're looking much healthier now.";
            }
            this.dialogue_timer = DIALOGUE_LENGTH;
        }
    }
}
