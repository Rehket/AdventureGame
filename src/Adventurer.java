
public class Adventurer extends Character{
	String name; int nameNum = 0;
	
	public Adventurer(Cave initLoc) {
		super(initLoc);
		name = getName();
		initLoc.occupied = true;
	}

	
	public boolean modifyCave(Cave newC) {
		if(newC.teleport == true){
			newC.marker = true;
			return true;
		}
		else return false;
	}

	
	
	public String describeModification() {
		SoundEffects.TELE.play();
		return "Discovered a Portal!";
	}
	

String getName() {
		
		if(nameNum == 0){
			//Random names pop up.
			String name = "Dr. Jones";
			nameNum=1;
			return name;
		}
		else return name;
		
	}


}
