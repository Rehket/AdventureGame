
public class Filler extends Character{
	
String name; int nameNum = 0;
	public Filler(Cave initLoc) {
		super(initLoc);
		name = getName();
		System.out.println("Making Filler at "+ initLoc.getRow() + "," + initLoc.getCol());
		initLoc.occupied = true;
		System.out.println("Making Filler");
	}

	@Override
	public boolean modifyCave(Cave newC) {
		if(newC.pit == true){
			newC.pit = false;
			return true;
		}
		else return false;
	}


	public String describeModification() {
		SoundEffects.PLOOP.play();
		return "Drops a duece in that hole.";
	}

	String getName() {
		
		if(nameNum == 0){
			//Random names pop up.
			String name = "Big Dan";
			nameNum=1;
			return name;
		}
		else return name;
		
	}

}
