import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Ships {

    private String ship = "icons64/ship.png";

    private int dx;
    private int dy;
    private int x;
    private int y;
    private int width;
    private int height;
    private int engine;
    private boolean visible;
    private Image image;
    @SuppressWarnings("rawtypes")
	private ArrayList weapons;


    @SuppressWarnings("rawtypes")
	public Ships() {
        ImageIcon ii = new ImageIcon(ship);
        image = ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
        engine = 2;
        weapons = new ArrayList();
        visible = true;
        x = 40;
        y = 350;
        
    }


    public void move() {

        x += dx;
        y += dy;

        if (x < 1) {
            x = 1;
        }

        if (y < 1) {
            y = 1;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    @SuppressWarnings("rawtypes")
	public ArrayList getWeapons() {
        return weapons;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    


    //Player Fire
    @SuppressWarnings("unchecked")
	public void fire() {
    	SoundEffects.LOLASER.play();
        weapons.add(new Weapons(x + width, y + height/2));
    }
    
    
    //Movement For Player
    public void keyPressed(KeyEvent event) {

        int key = event.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            fire();
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -(engine);
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = engine;
        }

        if (key == KeyEvent.VK_UP) {
        	
            dy = -(engine);
        }

        if (key == KeyEvent.VK_DOWN) {
        	System.out.println(y);
        	if(y>620){
        		
        		dy=0;
        	}
        	else dy = engine;
        }
    }
    
    public void keyReleased(KeyEvent event) {
        int key = event.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}

//END


