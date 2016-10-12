/**
 * Created by dianaruth on 10/1/16.
 */

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public abstract class Villager extends Unit implements Interactive {
    /** The dialogue that should be displayed above the villager when the player interacts with the villager */
    private String dialogue;
    /** The amount of time that has passed since the dialogue started displaying */
    private int dialogue_timer;
    /** The amount of time that the dialogue should display for */
    protected final int DIALOGUE_LENGTH = 4000;
    
    /** Returns the villager's dialogue
     * @return The villager's dialogue
     */
    public String getDialogue() {
        return dialogue;
    }
    
    /** Sets the villager's dialogue
     * @param newDialogue The villager's new dialogue
     */
    public void setDialogue(String newDialogue) {
        this.dialogue = newDialogue;
    }
    
    /** Returns the amount of time left for the dialogue to display
     * @return The villager's dialogue timer
     */
    public int getDialogueTimer() {
        return dialogue_timer;
    }
    
    /** Sets how much time the dialogue should display
     * @param newDialogueTimer The villager's new dialogue timer
     */
    public void setDialogueTimer(int newDialogueTimer) {
        this.dialogue_timer = newDialogueTimer;
    }

    /** Updates the dialogue timer
     * @param delta The time (in milliseconds) that has passed
     */
    public void update(int delta) {
        if (dialogue_timer - delta > 0) {
            dialogue_timer -= delta;
        }
        else {
            dialogue_timer = 0;
        }
    }

    /** Renders the villager's image and their dialogue if the dialogue timer is greater than zero
     * @param g Graphics variable
     */
    @Override
    public void render(Graphics g) {
        // first render image in correct location
        super.render(g);

        // render dialogue if timer is more than zero
        if (dialogue_timer > 0) {
            Color TEXT = new Color(1.0f, 1.0f, 1.0f); // White
            Color BACKGROUND = new Color(0.0f, 0.0f, 0.0f, 0.8f); // Transparent Black

            int barWidth = RPG.getTextWidth(dialogue) + 4;
            int barHeight = 20;
            int x = (int)this.getX() - (barWidth / 2);
            int y = (int)this.getY() - (this.getImg().getHeight() / 2) - (barHeight * 2);
            g.setColor(BACKGROUND);
            g.fillRect(x, y, barWidth, barHeight);
            g.setColor(TEXT);
            g.drawString(dialogue, x + 2, y);
        }
    }
}
