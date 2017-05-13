
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Enemy {

    private String ships = "icons64/enemy.png";

    private int x;
    private int y;
    private int width;
    private int height;
    public int speed;
    private boolean visible;
    private Image image;

    public Enemy(int x, int y) {
        ImageIcon ii = new ImageIcon(ships);
        image = ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
        visible = true;
        speed = 1;
        this.x = x;
        this.y = y;
    }

    	//This is used to to move the enemy ships. By changing the value for x, the speed can be modified.
    public void move(int s) {
        if (x < 0) 
            x = SpaceGame.WIDTH;
        x -= s;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Image getImage() {
        return image;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}