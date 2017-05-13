import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Enemies {
	boolean boss;
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
	public Enemies(int x, int y){
		this.boss = false;
		this.xLoc = x;
		this.yLoc = y;
		this.type = 1;
		this.speed = 1;
		this.dx = 0;
		this.dy = 0;
		this.visible = true;
		ImageIcon ii = new ImageIcon("icons64/enemy.png"); 
		this.image = ii.getImage();
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
		this.alive = true;
		
	}
	public Enemies(int x, int y, String b){
		this.boss = true;
		this.xLoc = x;
		this.yLoc = y;
		this.type = 1;
		this.speed = 1;
		this.dx = 0;
		this.dy = 0;
		this.visible = true;
		ImageIcon ii = new ImageIcon("b"); 
		this.image = ii.getImage();
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
		this.alive = true;
		
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

boolean isAlive(){
	return alive;
}
boolean getBoss(){
	return boss;
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
			dx = -1;
}

public Rectangle getBounds() {
	
    return new Rectangle(xLoc, yLoc, width, height);
}


public boolean isVisible() {
	
	return visible;
}

public void setAlive(boolean b) {

	this.alive = b;
	
}

public void setVisible(boolean b) {

	visible = b;
}




	
}
