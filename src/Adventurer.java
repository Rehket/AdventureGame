
public class Adventurer extends Character{
	String name; int nameNum = 0;

	// Make a new adventure.
	public Adventurer(Cave initialLocation) {
		super(initialLocation);
		name = getName();
		initialLocation.occupied = true;
	}


	// If the adventure steps on a teleporter, show the teleporter sprite.
	public boolean modifyCave(Cave _cave) {
		if(_cave.teleport){
			_cave.marker = true;
			return true;
		}
		else return false;
	}

	
	// If the adventure steps on a teleporter, show the teleporter sprite and play the sound.
	public String describeModification() {
		SoundEffects.TELE.play();
		return "Discovered a Portal!";
	}
	
	// Going to have a name generator at some point.
	public String getName() {
		
		if(nameNum == 0){
			//Random names pop up.
			String name = "Dr. Jones";
			nameNum=1;
			return name;
		}
		else return name;
		
	}


}
