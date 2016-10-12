/**
 * Created by dianaruth on 10/1/16.
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Garth extends Villager {
    public Garth (int initialX, int initialY) throws SlickException {
        this.setName("Garth");
        this.setX(initialX);
        this.setY(initialY);
        this.setImg(new Image("assets/units/peasant.png"));
        this.setMaxHp(1);
        this.setHp(this.getMaxHp());
        this.setMaxDamage(0);
        this.setCooldown(0);
        this.setAlive(true);
        this.setDialogueTimer(0);
    }

    /** Sets Garth's dialogue based on which items are in the player's inventory
     * @param player                The player with which the object will interact
     * @param attemptingInteraction A boolean indicating whether the player is attempting to interact with the object
     */
    public void interact(Player player, boolean attemptingInteraction) {
        // first check if player is attempting interaction and is within 50 pixels of Garth
        double dist = Math.sqrt(Math.pow(this.getX() - player.getX(), 2) + Math.pow(this.getY() - player.getY(), 2));
        if (attemptingInteraction && dist < 50 && this.getDialogueTimer() == 0) {
            boolean tome = false;
            boolean amulet = false;
            boolean sword = false;
            // check to see which items the player has in inventory
            for (Item i : player.getInventory()) {
                if (i.getName().equals("Tome of Agility"))
                    tome = true;
                if (i.getName().equals("Amulet of Vitality"))
                    amulet = true;
                if (i.getName().equals("Sword of Strength"))
                    sword = true;
            }
            // choose dialogue based on items in player's inventory
            if (!amulet) {
                this.setDialogue("Find the Amulet of Vitality, across the river to the west.");
            }
            else if (!sword) {
                this.setDialogue("Find the Sword of Strength - cross the bridge to the east, then head south.");
            }
            else if (!tome) {
                this.setDialogue("Find the Tome of Agility, in the Land of Shadows.");
            }
            else {
                this.setDialogue("You have found all the treasure I know of.");
            }
            this.setDialogueTimer(DIALOGUE_LENGTH);
        }
    }
}
