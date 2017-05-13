


public abstract class Character extends Object implements CaveWorker {
	Cave loc;
	public Character(Cave initLoc){
		this.loc = initLoc;
		
	}
		
	
	Cave getLocation(){
		return loc;
	}
	
	abstract String getName();

	
	
	
	public boolean move(Cave to) {
		boolean y = false;
		
		if(to.occupied == false && to.blocked == false){
			this.loc.occupied = false;
			this.loc = to;
			to.occupied = true;
			y = true;
		}
		
		else if(to.occupied == false && to.blocked == true){
			if (this.modifyCave(to) == true){
				SoundEffects.MINE.play();
				this.loc.occupied = false;
				to.blocked = false;
				to.open = true;
				to.occupied = true;
				y = true;
				this.loc = to;
			}
		}
		
		
		return y;
		
	}
	
	  
	
	
}
