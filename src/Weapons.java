import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;




public class Weapons{
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
    //private boolean friendly;
    private boolean alive;
	@SuppressWarnings("unused")
	private boolean friendly;
    
	
	public Weapons(int x, int y){
		this.xLoc = x;
		this.yLoc = y;
		this.type = 1;
		this.speed = 1;
		this.dx = 0;
		this.dy = 0;
		ImageIcon ii = new ImageIcon("icons64/weapon.png");
		this.image = ii.getImage();
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
		this.visible = true;
		this.friendly = true;
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



boolean isVisible(){
	return visible;
}

boolean isAlive(){
	return alive;
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
		dx = 2;
}

public Rectangle getBounds() {
    return new Rectangle(xLoc, yLoc, width, height);
}

public void setAlive(boolean b) {

	this.alive = b;
	
}

public void setVisible(boolean b) {

	this.visible = b;
	
}






}