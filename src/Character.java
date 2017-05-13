


public abstract class Character extends Object implements CaveWorker {
	protected Cave loc;

	public Character(Cave initLoc){
		this.loc = initLoc;
		
	}
		
	
	Cave getLocation(){
		return loc;
	}
	
	abstract String getName();

	
	
	//Attempt to move to cave location.
	public boolean move(Cave _targetCaveSpace) {
		boolean canMoveToCave = false;
		
		if(!_targetCaveSpace.occupied && !_targetCaveSpace.blocked){
			this.loc.occupied = false;
			this.loc = _targetCaveSpace;
			_targetCaveSpace.occupied = true;
			canMoveToCave = true;
		}
		
		else if(!_targetCaveSpace.occupied && _targetCaveSpace.blocked){
			if (this.modifyCave(_targetCaveSpace) == true){
				SoundEffects.MINE.play();
				this.loc.occupied = false;
				_targetCaveSpace.blocked = false;
				_targetCaveSpace.open = true;
				_targetCaveSpace.occupied = true;
				canMoveToCave = true;
				this.loc = _targetCaveSpace;
			}
		}

		return canMoveToCave;
		
	}
	
	  
	
	
}
