/**
 * Created by dianaruth on 9/27/16.
 */

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public abstract class Unit extends WorldObject {
    /** The current health of the unit */
    protected int hp;
    /** The unit's maximum health */
    protected int max_hp;
    /** The maximum damage the unit can deal to another unit */
    protected int max_damage;
    /** The amount of time that must pass before the unit can attack again */
    protected int cooldown;
    /** The amount of time that has passed since the unit last attacked */
    protected int cooldown_remaining;
    /** A boolean indicating whether or not the unit is alive */
    protected boolean alive;
    /** The maximum distance between the unit and the player for interaction to be allowed */
    protected final int INTERACTION_DISTANCE = 50;

    /**
     * Kills the unit, making the alive boolean variable set to false
     */
    public void kill () {
        this.alive = false;
    }

    /** Returns whether or not the unit is alive
     * @return Boolean indicating whether or not the unit is alive
     */
    public boolean isAlive () {
        return this.alive;
    }

    /**
     * Renders the unit if they are still alive
     */
    public void render(Graphics g) {
        if (this.isAlive()) {
            this.img.drawCentered((float) this.x, (float) this.y);
            Color TEXT = new Color(1.0f, 1.0f, 1.0f); // White
            Color BLACK_BACKGROUND = new Color(0.0f, 0.0f, 0.0f, 0.8f); // Transparent Black
            Color RED_BACKGROUND = new Color(0.8f, 0.0f, 0.0f, 0.8f); // Transparent Red

            // variables for drawing
            int barHeight = 20;
            int textWidth = RPG.getTextWidth(this.name);
            int barWidth;
            if (textWidth > img.getWidth()) {
                barWidth = textWidth + 4;
            }
            else {
                barWidth = img.getWidth();
            }
            int textIndent = (barWidth - textWidth) / 2;
            float percent = (float) hp / (float) max_hp;
            float barX = (float)(x - (barWidth / 2));
            float barY = (float)(y - (img.getHeight() / 2) - barHeight);
            float healthWidth = barWidth * percent;
            float textX = barX + textIndent;

            // draw black background
            g.setColor(BLACK_BACKGROUND);
            g.fillRect(barX, barY, barWidth, barHeight);

            // draw red health indicator
            g.setColor(RED_BACKGROUND);
            g.fillRect(barX, barY, healthWidth, barHeight);

            // draw name over health bar
            g.setColor(TEXT);
            g.drawString(name, textX, barY);
        }
    }
}
