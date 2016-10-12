/**
 * Created by dianaruth on 9/27/16.
 */

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public abstract class Unit extends WorldObject {
    /** The current health of the unit */
    private int hp;
    /** The unit's maximum health */
    private int max_hp;
    /** The maximum damage the unit can deal to another unit */
    private int max_damage;
    /** The amount of time that must pass before the unit can attack again */
    private int cooldown;
    /** The amount of time that has passed since the unit last attacked */
    private int cooldown_remaining;
    /** A boolean indicating whether or not the unit is alive */
    private boolean alive;
    /** The maximum distance between the unit and the player for interaction to be allowed */
    public final int INTERACTION_DISTANCE = 50;

    /** Returns the object's hp
     * @return The object's hp
     */
    public int getHp() {
        return hp;
    }
    
    /** Sets the object's hp
     * @param newHp The object's new hp
     */
    public void setHp(int newHp) {
        this.hp = newHp;
    }
    
    /** Returns the object's max hp
     * @return The object's max hp
     */
    public int getMaxHp() {
        return max_hp;
    }
    
    /** Sets the object's max hp
     * @param newMaxHp The object's new max hp
     */
    public void setMaxHp(int newMaxHp) {
        this.max_hp = newMaxHp;
    }
    
    /** Returns the object's max damage
     * @return The object's max damage
     */
    public int getMaxDamage() {
        return max_damage;
    }
    
    /** Sets the object's max damage
     * @param newMaxDamage The object's new max damage
     */
    public void setMaxDamage(int newMaxDamage) {
        this.max_damage = newMaxDamage;
    }
    
    /** Returns the object's cooldown
     * @return The object's cooldown
     */
    public int getCooldown() {
        return cooldown;
    }
    
    /** Sets the object's cooldown
     * @param newCooldown The object's new cooldown
     */
    public void setCooldown(int newCooldown) {
        this.cooldown = newCooldown;
    }
    
    /** Returns the object's cooldown remaining
     * @return The object's cooldown remaining
     */
    public int getCooldownRemaining() {
        return cooldown_remaining;
    }
    
    /** Sets the object's cooldown remaining
     * @param newCooldownRemaining The object's new cooldown remaining
     */
    public void setCooldownRemaining(int newCooldownRemaining) {
        this.cooldown_remaining = newCooldownRemaining;
    }
    
    /** Returns whether or not the object is alive
     * @return Whether or not the object is alive
     */
    public boolean getAlive() {
        return alive;
    }
    
    /** Sets whether or not the object is alive
     * @param newAlive Whether or not the object is alive
     */
    public void setAlive(boolean newAlive) {
        this.alive = newAlive;
    }
    
    /**
     * Kills the unit, making the alive boolean variable set to false and resetting stats
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
            this.getImg().drawCentered((float) this.getX(), (float) this.getY());
            Color TEXT = new Color(1.0f, 1.0f, 1.0f); // White
            Color BLACK_BACKGROUND = new Color(0.0f, 0.0f, 0.0f, 0.8f); // Transparent Black
            Color RED_BACKGROUND = new Color(0.8f, 0.0f, 0.0f, 0.8f); // Transparent Red

            // variables for drawing
            int barHeight = 20;
            int textWidth = RPG.getTextWidth(this.getName());
            int barWidth;
            if (textWidth > getImg().getWidth()) {
                barWidth = textWidth + 4;
            }
            else {
                barWidth = getImg().getWidth();
            }
            int textIndent = (barWidth - textWidth) / 2;
            float percent = (float) hp / (float) max_hp;
            float barX = (float)(getX() - (barWidth / 2));
            float barY = (float)(getY() - (getImg().getHeight() / 2) - barHeight);
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
            g.drawString(getName(), textX, barY);
        }
    }
}
