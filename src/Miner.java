
public class Miner extends Character{
	String name; int nameNum = 0;
	public Miner(Cave initLoc) {
		super(initLoc);
		name = getName();
		//System.out.println("Making Miner at "+ initLoc.getRow() + "," + initLoc.getCol());
		initLoc.occupied = true;
	}

	
	public boolean modifyCave(Cave newC) {
		if(newC.blocked == true){
			return true;
		}
		else return false;
	}

	
	public String describeModification() {
		
		String decs = "Breaks open Blocked Caves.";
		return decs;
	}

	
String getName() {
		
		if(nameNum == 0){
			//Random names pop up.
			String name = "Dig Dug";
			nameNum=1;
			return name;
		}
		else return name;
		
	}


}
