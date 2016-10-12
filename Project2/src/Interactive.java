/**
 * Created by dianaruth on 9/30/16.
 */
public interface Interactive {
    /** Performs interaction with the player
     * @param player The player with which the object will interact
     * @param attemptingInteraction A boolean indicating whether the player is attempting to interact with the object
     */
    public void interact (Player player, boolean attemptingInteraction);
}
