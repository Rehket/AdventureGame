import java.awt.Image;


public abstract class Vehicles extends Object  {
	int xLoc, yLoc, speed, type;
	Image image;
	
	public Vehicles(int x, int y){
		this.xLoc = x;
		this.yLoc = y;
		this.speed = 1;
		this.type = 1;
		this.image = null;
	}
	


}
