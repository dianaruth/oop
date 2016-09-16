/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: Diana Ruth (druth)
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/** Represents the entire game world.
 * (Designed to be instantiated just once for the whole game).
 */
public class World
{
    // variables representing the map, player, and camera
    private TiledMap map;
    private Player player;
    private Camera camera;
    // buffer space to make player appear to be moving smoothly
    private int bufferX;
    private int bufferY;
    // array to store whether a tile can be traversed or not
    private boolean[][] blocked;
    // constants describing the world
    private static final int NUM_TILES_WIDTH = 13;
    private static final int NUM_TILES_HEIGHT = 10;
    private static final int PLAYER_START_X = 756;
    private static final int PLAYER_START_Y = 684;
    private static final int SCREEN_WIDTH = RPG.screenwidth;
    private static final int SCREEN_HEIGHT = RPG.screenheight;
    private static final int TILE_SIZE = 72;

    /** Create a new World object. */
    public World()
            throws SlickException
    {
        map = new TiledMap ("assets/map.tmx", "assets");
        player = new Player(PLAYER_START_X, PLAYER_START_Y);
        camera = new Camera(player, SCREEN_WIDTH, SCREEN_HEIGHT);
        bufferX = 0;
        bufferY = 0;
        // use the map's tile properties to calculate whether or not the player is allowed on each tile
        blocked = new boolean[map.getWidth()][map.getHeight()];
        for (int i = 0; i < map.getWidth(); i++) {
            for (int j = 0; j < map.getHeight(); j++) {
                String prop = map.getTileProperty(map.getTileId(i, j, 0), "block", "0");
                blocked[i][j] = prop.equals("1") ? true : false;
            }
        }
    }

    /** Update the game state for a frame.
     * @param dir_x The player's movement in the x axis (-1, 0 or 1).
     * @param dir_y The player's movement in the y axis (-1, 0 or 1).
     * @param delta Time passed since last frame (milliseconds).
     */
    public void update(double dir_x, double dir_y, int delta) throws SlickException {
        // do not allow player to move onto the tile if it is blocked
        // check individually for x and y coordinate to allow player to slide along blocked terrain
        player.update(getNextX(dir_x, delta), getNextY(dir_y, delta), delta);
        camera.update();
        // update buffer so that camera moves properly around the player rather than tile-to-tile
        bufferX = -(camera.getMinX() % TILE_SIZE);
        bufferY = -(camera.getMinY() % TILE_SIZE);
    }

    // takes in the x-direction the player intends to move to and checks if the new position is blocked
    // returns the original position if the next position is blocked
    public double getNextX (double dir_x, int delta) {
        double newX = player.getX() + (dir_x * delta);
        if (blocked[(int)newX/TILE_SIZE][(int)player.getY()/TILE_SIZE]) {
            return 0;
        }
        return dir_x;
    }

    // takes in the y-direction the player intends to move to and checks if the new position is blocked
    // returns the original position if the next position is blocked
    public double getNextY (double dir_y, int delta) {
        double newY = player.getY() + (dir_y * delta);
        if (blocked[(int)player.getX()/TILE_SIZE][(int)newY/TILE_SIZE]) {
            return 0;
        }
        return dir_y;
    }

    /** Render the entire screen, so it reflects the current game state.
     * @param g The Slick graphics object, used for drawing.
     */
    public void render(Graphics g)
            throws SlickException
    {
        map.render(bufferX, bufferY, camera.getMinX()/TILE_SIZE, camera.getMinY()/TILE_SIZE, NUM_TILES_WIDTH, NUM_TILES_HEIGHT);
        player.render(camera);
    }
}