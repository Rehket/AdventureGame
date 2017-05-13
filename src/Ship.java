import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Ship{
	private int dx;
    private int dy;
	private int xLoc;
	private int yLoc;
	private int type;
	private int speed;
	private Image image;
	private int width;
    private int height;
    private boolean visible;
    private boolean alive;
    private ArrayList<Weapons> wep;
	
	public Ship(int x, int y){
		this.xLoc = x;
		this.yLoc = y;
		this.type = 1;
		this.speed = 1;
		this.dx = 0;
		this.dy = 0;
		ImageIcon ii = new ImageIcon("icons64/ship.png");
		this.image = ii.getImage();
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
		this.visible = true;
		this.alive = true;
		this.wep = new ArrayList<Weapons>();
	}
	
int getXLoc(){
		
		return xLoc;
	}
	
int getYLoc(){
		
		return yLoc;
	}

int getSpeed(){
	return speed;
	}

int getType(){
	return type;
	}

Image getImage(){
	return image;
}

int getHeight(){
	return height;
}

int getWidth(){
	return width;
}

boolean isVisible(){
	return visible;
}

 ArrayList<Weapons> getWeapons(){
	return wep;
}
//Method Used to handle movement.
public void move() {
	xLoc += dx;
	yLoc += dy;
		if (xLoc < 1) {
			xLoc = 1;
		}
		if (yLoc < 1) {
			yLoc = 1;
		}
}

public void setVisible(boolean b) {
	visible= b;
}

public void setAlive(boolean b) {
	alive = b;
	
}
public boolean isAlive() {
	return alive;
	
}
	
public Rectangle getBounds() {
    return new Rectangle(xLoc, yLoc, width, height);
}

public void keyPressed(KeyEvent e) {
	
    int key = e.getKeyCode();

    if (key == KeyEvent.VK_SPACE) {
    	SoundEffects.LOLASER.play();
    	Weapons j = new Weapons(this.xLoc, this.yLoc);
        wep.add(j);
    }

    if (key == KeyEvent.VK_LEFT) {
        dx = -1;
    }

    if (key == KeyEvent.VK_RIGHT) {
        dx = 1;
    }

    if (key == KeyEvent.VK_UP) {
        dy = -1;
    }

    if (key == KeyEvent.VK_DOWN) {
        dy = 1;
    }
}

public void keyReleased(KeyEvent e) {

    int key = e.getKeyCode();

    if (key == KeyEvent.VK_SPACE) {
        System.out.println("Fire!");
    }

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
