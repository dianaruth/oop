/**
 * Created by dianaruth on 9/27/16.
 */

import org.newdawn.slick.Image;

public abstract class WorldObject {
    /** The name of the object */
    private String name;
    /** The image representing the object */
    private Image img;
    /** The flipped copy of img */
    private Image img_flipped;
    /** The x position of the object */
    private double x;
    /** The y position of the object */
    private double y;
    /** Boolean indicating whether the unit is facing left or right */
    private boolean face_left;
    /** The width of the object (based on its image) */
    private int width;
    /** The height of the object (based on its image) */
    private int height;

    /** Returns the object's name
     * @return The object's name
     */
    public String getName() {
        return name;
    }
    
    /** Sets the object's name
     * @param newName The object's new name
     */
    public void setName(String newName) {
        this.name = newName;
    }
    
    /** Returns the object's image
     * @return The object's image
     */
    public Image getImg() {
        return img;
    }
    
    /** Sets the object's image
     * @param newImg The object's new image
     */
    public void setImg(Image newImg) {
        this.img = newImg;
    }
    
    /** Returns the object's flipped image
     * @return The object's flipped image
     */
    public Image getFlippedImg() {
        return img_flipped;
    }
    
    /** Sets the object's image
     * @param newFlippedImg The object's new image
     */
    public void setFlippedImg(Image newFlippedImg) {
        this.img_flipped = newFlippedImg;
    }
    
    /** Returns the object's x coordinate
     * @return The object's x coordinate
     */
    public double getX() {
        return x;
    }
    
    /** Sets the object's x coordinate
     * @param newX The object's new x coordinate
     */
    public void setX(double newX) {
        this.x = newX;
    }

    /** Returns the object's y coordinate
     * @return The object's y coordinate
     */
    public double getY() {
        return y;
    }

    /** Sets the object's y coordinate
     * @param newY The object's new y coordinate
     */
    public void setY(double newY) {
        this.y = newY;
    }
    
    /** Returns whether the object is facing left or not
     * @return The object's face_left member
     */
    public boolean getFaceLeft() {
        return face_left;
    }

    /** Sets whether the object is facing left or not
     * @param newFaceLeft The object's new face_left member
     */
    public void setFaceLeft(boolean newFaceLeft) {
        this.face_left = newFaceLeft;
    }
    
    /** Returns the object's width
     * @return The object's width
     */
    public int getWidth() {
        return width;
    }

    /** Sets the object's width
     * @param newWidth The object's new width
     */
    public void setWidth(int newWidth) {
        this.width = newWidth;
    }
    
    /** Returns the object's height
     * @return The object's height
     */
    public int getHeight() {
        return height;
    }

    /** Sets the object's height
     * @param newHeight The object's new height
     */
    public void setHeight(int newHeight) {
        this.width = newHeight;
    }
}
