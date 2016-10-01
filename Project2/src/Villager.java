/**
 * Created by dianaruth on 10/1/16.
 */

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public abstract class Villager extends Unit implements Interactive {
    protected String dialogue;
    protected int dialogue_timer;
    protected final int DIALOGUE_LENGTH = 4000;

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
    public void render(Graphics g) {
        // first render image in correct location
        super.render();

        // render dialogue if timer is more than zero
        if (dialogue_timer > 0) {
            Color TEXT = new Color(1.0f, 1.0f, 1.0f); // White
            Color BACKGROUND = new Color(0.0f, 0.0f, 0.0f, 0.8f); // Transparent Black

            int barWidth = RPG.getTextWidth(dialogue) + 4;
            int barHeight = 20;
            int x = (int)this.x - (barWidth / 2);
            int y = (int)this.y - (this.img.getHeight() / 2) - barHeight;
            g.setColor(BACKGROUND);
            g.fillRect(x, y, barWidth, barHeight);
            g.setColor(TEXT);
            g.drawString(dialogue, x + 2, y);
        }
    }
}
