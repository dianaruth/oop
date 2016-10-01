/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Sample Solution
 * Author: Matt Giuca <mgiuca>
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.Color;
import java.util.ArrayList;

/** Represents the entire game world.
 * (Designed to be instantiated just once for the whole game).
 */
public class World
{
    private static final int PLAYER_START_X = 756, PLAYER_START_Y = 684;
    
    private Player player = null;
    private TiledMap map = null;
    private Camera camera = null;
    private ArrayList<Item> items = null;
    private ArrayList<Villager> villagers = null;
    private ArrayList<Monster> monsters = null;
    private Image panel;

    /** Map width, in pixels. */
    private int getMapWidth()
    {
        return map.getWidth() * getTileWidth();
    }

    /** Map height, in pixels. */
    private int getMapHeight()
    {
        return map.getHeight() * getTileHeight();
    }

    /** Tile width, in pixels. */
    private int getTileWidth()
    {
        return map.getTileWidth();
    }

    /** Tile height, in pixels. */
    private int getTileHeight()
    {
        return map.getTileHeight();
    }

    /** Create a new World object. */
    public World()
    throws SlickException
    {
        map = new TiledMap(RPG.ASSETS_PATH + "/map.tmx", RPG.ASSETS_PATH);
        player = new Player(RPG.ASSETS_PATH + "/units/player.png", PLAYER_START_X, PLAYER_START_Y);
        camera = new Camera(player, RPG.SCREEN_WIDTH, RPG.SCREEN_HEIGHT);
        panel = new Image("assets/panel.png");

        // add items
        items = new ArrayList<Item>();
        items.add(new TomeOfAgility(4791, 1253));
        items.add(new AmuletOfVitality(965, 3563));
        items.add(new ElixirOfLife(1976, 402));
        items.add(new SwordOfStrength(546, 6707));

        // add villagers
        villagers = new ArrayList<Villager>();
        villagers.add(new Garth(756,870));
        villagers.add(new PrinceAldric(467,679));
        villagers.add(new LadyElvira(738,549));
    }

    /** Update the game state for a frame.
     * @param dir_x The player's movement in the x axis (-1, 0 or 1).
     * @param dir_y The player's movement in the y axis (-1, 0 or 1).
     * @param attack Boolean indicating if the user has pressed the A key and wants to attack
     * @param interact Boolean indicating if the user has pressed the T key and wants to interact with a villager
     * @param delta Time passed since last frame (milliseconds).
     */
    public void update(int dir_x, int dir_y, boolean attack, boolean interact, int delta)
    throws SlickException
    {
        player.move(this, dir_x, dir_y, delta);
        camera.update();

        // check for interaction between the player and each item
        for (Item i : items) {
            i.interact(player, true);
        }

        // check for interaction between the player and each villager and update villagers
        for (Villager v : villagers) {
            v.interact(player, interact);
            v.update(delta);
        }
    }

    /** Render the entire screen, so it reflects the current game state.
     * @param g The Slick graphics object, used for drawing.
     */
    public void render(Graphics g)
    throws SlickException
    {
        // Render the relevant section of the map
        int x = -(camera.getMinX() % getTileWidth());
        int y = -(camera.getMinY() % getTileHeight());
        int sx = camera.getMinX() / getTileWidth();
        int sy = camera.getMinY()/ getTileHeight();
        int w = (camera.getMaxX() / getTileWidth()) - (camera.getMinX() / getTileWidth()) + 1;
        int h = (camera.getMaxY() / getTileHeight()) - (camera.getMinY() / getTileHeight()) + 1;
        map.render(x, y, sx, sy, w, h);
        
        // Translate the Graphics object
        g.translate(-camera.getMinX(), -camera.getMinY());

        // Render the player
        player.render();

        // render items
        for (Item i : items) {
            i.render();
        }

        // render villagers
        for (Villager v : villagers) {
            v.render(g);
        }

        // render the player's status panel
        //renderPanel(g);
    }

    /** Determines whether a particular map coordinate blocks movement.
     * @param x Map x coordinate (in pixels).
     * @param y Map y coordinate (in pixels).
     * @return true if the coordinate blocks movement.
     */
    public boolean terrainBlocks(double x, double y)
    {
        // Check we are within the bounds of the map
        if (x < 0 || y < 0 || x > getMapWidth() || y > getMapHeight()) {
            return true;
        }
        
        // Check the tile properties
        int tile_x = (int) x / getTileWidth();
        int tile_y = (int) y / getTileHeight();
        int tileid = map.getTileId(tile_x, tile_y, 0);
        String block = map.getTileProperty(tileid, "block", "0");
        return !block.equals("0");
    }

    /** Renders the player's status panel.
     * @param g The current Slick graphics context.
     */
    public void renderPanel(Graphics g)
    {
        // Panel colours
        Color LABEL = new Color(0.9f, 0.9f, 0.4f);          // Gold
        Color VALUE = new Color(1.0f, 1.0f, 1.0f);          // White
        Color BAR_BG = new Color(0.0f, 0.0f, 0.0f, 0.8f);   // Black, transp
        Color BAR = new Color(0.8f, 0.0f, 0.0f, 0.8f);      // Red, transp

        // Variables for layout
        String text;                // Text to display
        int text_x, text_y;         // Coordinates to draw text
        int bar_x, bar_y;           // Coordinates to draw rectangles
        int bar_width, bar_height;  // Size of rectangle to draw
        int hp_bar_width;           // Size of red (HP) rectangle
        int inv_x, inv_y;           // Coordinates to draw inventory item

        float health_percent;       // Player's health, as a percentage

        // Panel background image
        panel.draw(0, RPG.SCREEN_HEIGHT - RPG.panelheight);

        // Display the player's health
        text_x = 15;
        text_y = RPG.SCREEN_HEIGHT - RPG.panelheight + 25;
        g.setColor(LABEL);
        g.drawString("Health:", text_x, text_y);
        text = player.hp + "/" + player.max_hp;            // TODO: HP / Max-HP

        bar_x = 90;
        bar_y = RPG.SCREEN_HEIGHT - RPG.panelheight + 20;
        bar_width = 90;
        bar_height = 30;
        health_percent = (float)player.hp/(float)player.max_hp;      // TODO: HP / Max-HP
        hp_bar_width = (int) (bar_width * health_percent);
        text_x = bar_x + (bar_width - g.getFont().getWidth(text)) / 2;
        g.setColor(BAR_BG);
        g.fillRect(bar_x, bar_y, bar_width, bar_height);
        g.setColor(BAR);
        g.fillRect(bar_x, bar_y, hp_bar_width, bar_height);
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);

        // Display the player's damage and cooldown
        text_x = 200;
        g.setColor(LABEL);
        g.drawString("Damage:", text_x, text_y);
        text_x += 80;
        text = Integer.toString(player.max_damage);            // TODO: Damage
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);
        text_x += 40;
        g.setColor(LABEL);
        g.drawString("Rate:", text_x, text_y);
        text_x += 55;
        text = Integer.toString(player.cooldown);             // TODO: Cooldown
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);

        // Display the player's inventory
        g.setColor(LABEL);
        g.drawString("Items:", 420, text_y);
        bar_x = 490;
        bar_y = RPG.SCREEN_HEIGHT - RPG.panelheight + 10;
        bar_width = 288;
        bar_height = bar_height + 20;
        g.setColor(BAR_BG);
        g.fillRect(bar_x, bar_y, bar_width, bar_height);

        inv_x = 490;
        inv_y = RPG.SCREEN_HEIGHT - RPG.panelheight
                + ((RPG.panelheight - 72) / 2);
        for (Item i : player.inventory)                // TODO
        {
            i.image.drawCentered(inv_x, inv_y);
            inv_x += 72;
        }
    }

}
