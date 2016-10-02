/**
 * Created by dianaruth on 10/1/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class PrinceAldric extends Villager {
    public PrinceAldric (int initialX, int initialY) throws SlickException {
        this.name = "Prince Aldric";
        this.x = initialX;
        this.y = initialY;
        this.img = new Image("assets/units/prince.png");
        this.max_hp = 1;
        this.hp = max_hp;
        this.max_damage = 0;
        this.cooldown = 0;
        this.alive = true;
        this.dialogue_timer = 0;
    }

    /** Sets Prince Aldric's dialogue based on whether or not the player has the Elixir of Life
     * @param player                The player with which the object will interact
     * @param attemptingInteraction A boolean indicating whether the player is attempting to interact with the object
     */
    public void interact(Player player, boolean attemptingInteraction) {
        // first check if player is attempting interaction and is within 50 pixels of Garth
        double dist = Math.sqrt(Math.pow(this.x - player.x, 2) + Math.pow(this.y - player.y, 2));
        if (attemptingInteraction && dist < 50) {
            boolean elixir = false;
            // check to see which items the player has in inventory
            for (Item i : player.inventory) {
                if (i.name.equals("Elixir of Life"))
                    elixir = true;
            }
            // choose dialogue depending on if player has elixir of life
            if (!elixir) {
                this.dialogue = "Please seek out the Elixir of Life to cure the king.";
            }
            else {
                this.dialogue = "The elixir! My father is cured! Thank you!";
            }
            this.dialogue_timer = DIALOGUE_LENGTH;
        }
    }
}
