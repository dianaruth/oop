/**
 * Created by dianaruth on 10/1/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Garth extends Villager {
    public Garth (int initialX, int initialY) throws SlickException {
        this.x = initialX;
        this.y = initialY;
        this.img = new Image("assets/units/peasant.png");
        this.hp = 1;
        this.max_damage = 0;
        this.cooldown = 0;
        this.dialogue_timer = 0;
    }

    /** Sets Garth's dialogue based on which items are in the player's inventory
     * @param player                The player with which the object will interact
     * @param attemptingInteraction A boolean indicating whether the player is attempting to interact with the object
     */
    public void interact(Player player, boolean attemptingInteraction) {
        // first check if player is attempting interaction and is within 50 pixels of Garth
        double dist = Math.sqrt(Math.pow(this.x - player.x, 2) + Math.pow(this.y - player.y, 2));
        if (attemptingInteraction && dist < 50) {
            boolean tome = false;
            boolean amulet = false;
            boolean sword = false;
            // check to see which items the player has in inventory
            for (Item i : player.inventory) {
                if (i.name.equals("Tome of Agility"))
                    tome = true;
                if (i.name.equals("Amulet of Vitality"))
                    amulet = true;
                if (i.name.equals("Sword of Strength"))
                    sword = true;
            }
            // choose dialogue based on items in player's inventory
            if (!amulet) {
                this.dialogue = "Find the Amulet of Vitality, across the river to the west.";
            }
            else if (!sword) {
                this.dialogue = "Find the Sword of Strength - cross the bridge to the east, then head south.";
            }
            else if (!tome) {
                this.dialogue = "Find the Tome of Agility, in the Land of Shadows.";
            }
            else {
                this.dialogue = "You have found all the treasure I know of.";
            }
            this.dialogue_timer = DIALOGUE_LENGTH;
        }
    }
}
