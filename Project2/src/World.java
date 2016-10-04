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
    /** Starting coordinates of the player */
    private static final int PLAYER_START_X = 756, PLAYER_START_Y = 684;
    /** The player object */
    private Player player = null;
    /** The tiled map object */
    private TiledMap map = null;
    /** The camera object */
    private Camera camera = null;
    /** The list of items in the world */
    private ArrayList<Item> items = null;
    /** The list of villagers in the world */
    private ArrayList<Villager> villagers = null;
    /** The list of monsters in the world */
    private ArrayList<Monster> monsters = null;
    /** The panel that displays the player's stats */
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
        player = new Player(RPG.ASSETS_PATH + "/units/player.png", 1976, 402);//PLAYER_START_X, PLAYER_START_Y);
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

        // add monsters
        monsters = new ArrayList<Monster>();

        // giant bats
        monsters.add(new GiantBat(1431,864));
        monsters.add(new GiantBat(1154,1321));
        monsters.add(new GiantBat(807,2315));
        monsters.add(new GiantBat(833,2657));
        monsters.add(new GiantBat(1090,3200));
        monsters.add(new GiantBat(676,3187));
        monsters.add(new GiantBat(836,3966));
        monsters.add(new GiantBat(653,4367));
        monsters.add(new GiantBat(1343,2731));
        monsters.add(new GiantBat(1835,3017));
        monsters.add(new GiantBat(1657,3954));
        monsters.add(new GiantBat(1054,5337));
        monsters.add(new GiantBat(801,5921));
        monsters.add(new GiantBat(560,6682));
        monsters.add(new GiantBat(1275,5696));
        monsters.add(new GiantBat(1671,5991));
        monsters.add(new GiantBat(2248,6298));
        monsters.add(new GiantBat(2952,6373));
        monsters.add(new GiantBat(3864,6695));
        monsters.add(new GiantBat(4554,6443));
        monsters.add(new GiantBat(4683,6228));
        monsters.add(new GiantBat(5312,6606));
        monsters.add(new GiantBat(5484,5946));
        monsters.add(new GiantBat(6371,5634));
        monsters.add(new GiantBat(5473,3544));
        monsters.add(new GiantBat(5944,3339));
        monsters.add(new GiantBat(6301,3414));
        monsters.add(new GiantBat(6388,1994));
        monsters.add(new GiantBat(6410,1584));
        monsters.add(new GiantBat(5314,274));

        // zombies
        monsters.add(new Zombie(681,3201));
        monsters.add(new Zombie(691,4360));
        monsters.add(new Zombie(2166,2650));
        monsters.add(new Zombie(2122,2725));
        monsters.add(new Zombie(2284,2962));
        monsters.add(new Zombie(2072,4515));
        monsters.add(new Zombie(2006,4568));
        monsters.add(new Zombie(2385,4629));
        monsters.add(new Zombie(2446,4590));
        monsters.add(new Zombie(2517,4532));
        monsters.add(new Zombie(4157,6730));
        monsters.add(new Zombie(4247,6620));
        monsters.add(new Zombie(4137,6519));
        monsters.add(new Zombie(4234,6449));
        monsters.add(new Zombie(5879,4994));
        monsters.add(new Zombie(5954,4928));
        monsters.add(new Zombie(6016,4866));
        monsters.add(new Zombie(5860,4277));
        monsters.add(new Zombie(5772,4277));
        monsters.add(new Zombie(5715,4277));
        monsters.add(new Zombie(5653,4277));
        monsters.add(new Zombie(5787,797));
        monsters.add(new Zombie(5668,720));
        monsters.add(new Zombie(5813,454));
        monsters.add(new Zombie(5236,917));
        monsters.add(new Zombie(5048,1062));
        monsters.add(new Zombie(4845,996));
        monsters.add(new Zombie(4496,575));
        monsters.add(new Zombie(3457,273));
        monsters.add(new Zombie(3506,779));
        monsters.add(new Zombie(3624,1192));
        monsters.add(new Zombie(2931,1396));
        monsters.add(new Zombie(2715,1326));
        monsters.add(new Zombie(2442,1374));
        monsters.add(new Zombie(2579,1159));
        monsters.add(new Zombie(2799,1269));
        monsters.add(new Zombie(2768,739));
        monsters.add(new Zombie(2099,956));

        // bandits
        monsters.add(new Bandit(1889,2581));
        monsters.add(new Bandit(4502,6283));
        monsters.add(new Bandit(5248,6581));
        monsters.add(new Bandit(5345,6678));
        monsters.add(new Bandit(5940,3412));
        monsters.add(new Bandit(6335,3459));
        monsters.add(new Bandit(6669,260));
        monsters.add(new Bandit(6598,339));
        monsters.add(new Bandit(6598,528));
        monsters.add(new Bandit(6435,528));
        monsters.add(new Bandit(6435,678));
        monsters.add(new Bandit(5076,1082));
        monsters.add(new Bandit(5191,1187));
        monsters.add(new Bandit(4940,1175));
        monsters.add(new Bandit(4760,1039));
        monsters.add(new Bandit(4883,889));
        monsters.add(new Bandit(4427,553));
        monsters.add(new Bandit(3559,162));
        monsters.add(new Bandit(3779,1553));
        monsters.add(new Bandit(3573,1553));
        monsters.add(new Bandit(3534,2464));
        monsters.add(new Bandit(3635,2464));
        monsters.add(new Bandit(3402,2861));
        monsters.add(new Bandit(3151,2857));
        monsters.add(new Bandit(3005,2997));
        monsters.add(new Bandit(2763,2263));
        monsters.add(new Bandit(2648,2263));
        monsters.add(new Bandit(2621,1337));
        monsters.add(new Bandit(2907,1270));
        monsters.add(new Bandit(2331,598));
        monsters.add(new Bandit(2987,394));
        monsters.add(new Bandit(1979,394));
        monsters.add(new Bandit(2045,693));
        monsters.add(new Bandit(2069,1028));

        // skeletons
        monsters.add(new Skeleton(1255,2924));
        monsters.add(new Skeleton(2545,4708));
        monsters.add(new Skeleton(4189,6585));
        monsters.add(new Skeleton(5720,622));
        monsters.add(new Skeleton(5649,767));
        monsters.add(new Skeleton(5291,312));
        monsters.add(new Skeleton(5256,852));
        monsters.add(new Skeleton(4790,976));
        monsters.add(new Skeleton(4648,401));
        monsters.add(new Skeleton(3628,1181));
        monsters.add(new Skeleton(3771,1181));
        monsters.add(new Skeleton(3182,2892));
        monsters.add(new Skeleton(3116,3033));
        monsters.add(new Skeleton(2803,2901));
        monsters.add(new Skeleton(2850,2426));
        monsters.add(new Skeleton(2005,1524));
        monsters.add(new Skeleton(2132,1427));
        monsters.add(new Skeleton(2242,1343));
        monsters.add(new Skeleton(2428,771));
        monsters.add(new Skeleton(2427,907));
        monsters.add(new Skeleton(2770,613));
        monsters.add(new Skeleton(2915,477));
        monsters.add(new Skeleton(1970,553));
        monsters.add(new Skeleton(2143,1048));

        // Draelic
        monsters.add(new Draelic(2069,510));
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

        // check for interaction between the player and each monster and move monsters
        for (Monster m : monsters) {
            m.interact(player, attack);
            m.move(this, player, delta);
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

        // render monsters
        for (Monster m : monsters) {
            m.render(g);
        }

        // render the player's status panel
        renderPanel(g);
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
        int panelX = camera.getMinX();
        int panelY = camera.getMaxY() - RPG.panelheight;
        panel.draw(panelX, panelY);

        // Display the player's health
        text_x = panelX + 15;
        text_y = panelY + 25;
        g.setColor(LABEL);
        g.drawString("Health:", text_x, text_y);
        text = player.hp + "/" + player.max_hp;

        bar_x = panelX + 90;
        bar_y = panelY + 20;
        bar_width = 90;
        bar_height = 30;
        health_percent = (float)player.hp/(float)player.max_hp;
        hp_bar_width = (int) (bar_width * health_percent);
        text_x = bar_x + (bar_width - g.getFont().getWidth(text)) / 2;
        g.setColor(BAR_BG);
        g.fillRect(bar_x, bar_y, bar_width, bar_height);
        g.setColor(BAR);
        g.fillRect(bar_x, bar_y, hp_bar_width, bar_height);
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);

        // Display the player's damage and cooldown
        text_x = panelX + 200;
        g.setColor(LABEL);
        g.drawString("Damage:", text_x, text_y);
        text_x += 80;
        text = Integer.toString(player.max_damage);
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);
        text_x += 40;
        g.setColor(LABEL);
        g.drawString("Rate:", text_x, text_y);
        text_x += 55;
        text = Integer.toString(player.cooldown);
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);

        // Display the player's inventory
        g.setColor(LABEL);
        g.drawString("Items:", panelX + 420, text_y);
        bar_x = panelX + 490;
        bar_y = panelY + 10;
        bar_width = 288;
        bar_height = bar_height + 20;
        g.setColor(BAR_BG);
        g.fillRect(bar_x, bar_y, bar_width, bar_height);

        inv_x = panelX + 490;
        inv_y = panelY + ((RPG.panelheight - 72) / 2);
        for (Item i : player.inventory)
        {
            i.img.draw(inv_x, inv_y);
            inv_x += 72;
        }
    }
}
