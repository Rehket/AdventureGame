import java.util.Random;

public class Cave {

	private Random generator = new Random();
	private int seed = 4, randomNum = generator.nextInt(seed)+1;
	
	private int rows, columns;
	boolean marker, open, occupied, blocked, pit, teleport, stairs;
	
	public Cave(int r, int c){
		this.rows = r;
		this.columns = c;
		
		
		
			this.marker = false;
			this.open = true;		//opt 1
			this.teleport = false;	//opt 2
			this.blocked = false;	//opt 3
			this.pit = false;		//opt 4
			this.occupied = false;
			this.stairs = false;
		
		
	}
	
	public Cave(int _rows, int _columns, boolean open, boolean teleport, boolean blocked, boolean pit, boolean stairs){
		this.rows = _rows;
		this.columns = _columns;
		
		
		
			this.marker = false;
			this.open = open;		//opt 1
			this.teleport = teleport;	//opt 2
			this.blocked = blocked;	//opt 3
			this.pit = pit;		//opt 4
			this.occupied = false;
			this.stairs = stairs;
		
	}
	
	public enum CaveType { BLOCKED, OPEN, PIT, TELEPORT;}

	public static Cave initLoc = new Cave (0,0);
	
	int getRows(){
		return rows;
	}
	
	int getCols(){
		return columns;
	}

	public boolean isStairs() {
		
		return stairs;
	}
	
	public boolean isBlocked() {
		
		return blocked;
	}
	
	boolean isMarked(){
		
		return marker;
	}
	
	boolean isOccupied(){
		return occupied;
	}

	boolean isOpen(){
		return open;
	}
	
	boolean isPit(){
		return pit;
	}
	
	boolean isTeleport(){
		return teleport;
	}
	
	void makeBlocked(){
		open = false;
		blocked = true;
		teleport = false;
		pit = false;
		stairs = false;
	}
	
	void makeOpen(){
		open = true;
		blocked = false;
		teleport = false;
		pit = false;
		stairs = false;
	}
	
	void makeStairs(){
		open = true;
		blocked = false;
		teleport = false;
		pit = false;
		stairs = true;
	}
	
	void makePit(){
		open = true;
		blocked = false;
		teleport = false;
		pit = true;
		stairs = false;
	}
	
	void makeTeleport(){
		open = true;
		blocked = false;
		teleport = true;
		pit = false;
		stairs = false;
	}
	
	void setMarked(boolean set){
		marker = set;
	}
	
	void setOccupied(boolean set){
		occupied = set;
	}

}













