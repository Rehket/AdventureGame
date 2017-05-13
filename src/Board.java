
import java.util.*;


public class Board extends Object{
	private Random generator = new Random();
	private int seedCol = AdventureGame.DEFAULT_COLS, randomCol = generator.nextInt(seedCol);
	private int seedRow = AdventureGame.DEFAULT_ROWS, randomRow = generator.nextInt(seedRow);
	int totalCaves = (AdventureGame.DEFAULT_ROWS*AdventureGame.DEFAULT_COLS);
	
	private int rows, cols;
	private Cave[][] caves;
	
	
	
	public Board(int rows, int cols){
		this.rows = rows;
		this.cols = cols;
		System.out.println(rows + cols);
		this.caves = newBoardOfCaves(rows, cols);
		
		/*System.out.println("Open is " + caves[0][0].open);
		System.out.println("Blocked is " + caves[0][0].blocked);
		System.out.println("Pit is " + caves[0][0].pit);
		System.out.println("Teleports is " + caves[0][0].teleport);*/
	}
	
	
	 
	Cave[][] newBoardOfCaves(int _rows, int _columns){
		
		int counter = 0;
		
		Cave[][] board = new Cave[_rows][_columns];

		System.out.println("MAKING A BOARD " + AdventureGame.DEFAULT_ROWS + AdventureGame.DEFAULT_COLS);
		
		for(int i = 0;i<AdventureGame.DEFAULT_ROWS;i++){
			
			for(int j = 0; j<AdventureGame.DEFAULT_COLS; j++){
			int var = generator.nextInt(100)+1;
			if(var>=1 && var<=50){
				board[i][j]=newOpenCave(i,j);
			}
			
			else if(var>=51 && var<=70){
				board[i][j]=newBlockedCave(i, j);
			}
			
			else if(var>=71 && var<=90){
				board[i][j] = newPitCave(i, j);
			}
				
			else if(var>=91 && var<=100){
				board[i][j] = newTeleCave(i, j);
			}
			
			counter++;
			}
		}
		
		board[0][0] = newOpenCave(0, 0);
		board[AdventureGame.DEFAULT_ROWS-1][AdventureGame.DEFAULT_COLS-1] = newOpenCave(AdventureGame.DEFAULT_ROWS-1, 
				AdventureGame.DEFAULT_COLS-1);
		
		System.out.println(counter);
		return board;
	}
	
	
	// Find a location in the grid that is unoccupied,
	Cave getUnoccupiedOpenLocation(){
		System.out.println("Finding unoccupied Location.");
		int row = 4, col = 4;
		
			for(int i=0;i<100;i++){
				int varRow = generator.nextInt(AdventureGame.DEFAULT_ROWS);
				int varCol = generator.nextInt(AdventureGame.DEFAULT_COLS);
		
				System.out.println("Looking for Unoccupied Location at " + varRow +","+varCol);
		
				if(caves[varRow][varCol].open && !caves[varRow][varCol].pit &&
							caves[varRow][varCol].blocked == false && caves[varRow][varCol].occupied == false 
							&&(caves[varRow][varCol].getRows() !=AdventureGame.DEFAULT_ROWS && caves[varRow][varCol].getCols() !=AdventureGame.DEFAULT_COLS)){
					row = varRow;
					col = varCol;
					System.out.println("Unoccupied Location at " + varRow +","+varCol);
					break;
				}
				
				else System.out.println("No Unoccupied Location at " + varRow +","+varCol);
				
			}
		return caves[row][col];}
	
	
	
	public boolean ok(int r, int c){
		if (r<AdventureGame.DEFAULT_ROWS && c<AdventureGame.DEFAULT_COLS && r>=0 && c>=0)
		return true;
		
		else return false;
	}
	
	
	//Cave(int rows, int columns,boolean open, boolean teleport, boolean blocked, boolean pit)
	Cave newOpenCave(int r, int c){
		Cave randOpenCave = new Cave(r, c, true, false, false, false, false);
		System.out.println("Open Cave Made at " +r+","+c);
		return randOpenCave;
	}
	
	Cave newTeleCave(int r, int c){
		Cave randTeleCave = new Cave(r, c, true, true, false, false, false);
		System.out.println("Tele Cave Made at " +r+","+c);
		return randTeleCave;
	}
	
	Cave newBlockedCave(int r, int c){
		Cave randBlockedCave = new Cave(r, c, false, false, true, false, false);
		System.out.println("Blocked Cave Made at " +r+","+c);
		return randBlockedCave;	
	}
	
	Cave newPitCave(int r, int c){
		Cave randPitCave = new Cave(r, c, false, false, false, true, false);
		System.out.println("Pit Cave Made at " +r+","+c);
		return randPitCave;
	}
	
	Cave newStairs(int r, int c){
		Cave randStairs = new Cave(r, c, false, false, false, true, false);
		System.out.println("Stair Cave Made at " +r+","+c);
		return randStairs;
	}
	
	
	public Cave getCave(int r, int c){
		System.out.println(r + " " + c);
		
		if ((r>=0 && r<=9) && (c>=0 && c<=9)){
			
			return caves[r][c];	
		}
		else return null;
	}
	
	
	/*
	Cave[][] newRandCaveArray(int rows, int columns){
		StringBuilder sb = new  StringBuilder();
		
		List<String> usedCells = new ArrayList<String>();
		int total = rows*columns, counter = 0;
		int open = (total/2)-2, tele = (total/10), blocked = (total/5), pit = (total/5);
		Cave[][] randCave = new Cave[rows][columns];
		
		randCave[0][0] = newOpenCave(0,0);
		randCave[(AdventureGame.DEFAULT_ROWS-1)][(AdventureGame.DEFAULT_COLS-1)] = 
				newOpenCave((AdventureGame.DEFAULT_ROWS-1),(AdventureGame.DEFAULT_COLS-1));
		
		for(int o = 0; o<100;o++){
			usedCells.add("LOL");
		}
		
			
			
			while(counter != 48){
				System.out.println("While Loop");
			int n=randomRow;
			int m=randomCol;
			String sI = Integer.toString(n);
			String sJ = Integer.toString(m);
			sb.append(sI);sb.append(sJ);
			String tmp = sb.toString();
			
			
			System.out.println("Befor For Loop");
			
				for(int v = 1; v<=48;v++){
					System.out.println("For Loop OLOLOLOLOL");
					if(tmp==usedCells.get(v)){
						System.out.println("Space already Used");;
					}
					else{
						randCave[n][m] = newOpenCave(n, m);
						usedCells.add(tmp);
						counter++;
						System.out.println("Open Cave Made");
					}
				}		
			System.out.println("After for Loop");
			sb.setLength(0);
			
			}
			
			counter = 0;
			//Now Place tele spots
			
			while(counter != tele){
				int n=randomRow;
				int m=randomCol;
				String sI = Integer.toString(n);
				String sJ = Integer.toString(m);
				sb.append(sI);sb.append(sJ);
				String tmp = sb.toString();
				
				System.out.println("Before tele For Loop");
				for(int v = 1; v<usedCells.size();v++){
					if(tmp==usedCells.get(v)){
						break;
					}
					else{
						randCave[n][m] = newTeleCave(n, m);
						usedCells.add(tmp);
						counter++;
						System.out.println("Tele Cave Made");
						}
				}		
				
				sb.setLength(0);
				
				}
			counter = 0;
//Now for Blocked Caves
			while(counter != blocked){
				int n=randomRow;
				int m=randomCol;
				String sI = Integer.toString(n);
				String sJ = Integer.toString(m);
				sb.append(sI);sb.append(sJ);
				String tmp = sb.toString();
				
				
				for(int v = 1; v<usedCells.size();v++){
					if(tmp==usedCells.get(v)){
						break;
					}
					else{
						randCave[n][m] = newBlockedCave(n, m);
						usedCells.add(tmp);
						counter++;
						System.out.println("Blocked Cave Made");
						}
					
				}		
				
				sb.setLength(0);
				
				}
			
//Now for Pit Caves
			counter = 0;
			while(counter != pit){
				int n=randomRow;
				int m=randomCol;
				String sI = Integer.toString(n);
				String sJ = Integer.toString(m);
				sb.append(sI);sb.append(sJ);
				String tmp = sb.toString();
				
				
				for(int v = 1; v<usedCells.size();v++){
					if(tmp==usedCells.get(v)){
						break;
					}
					else{
						randCave[n][m] = newPitCave(n, m);
						usedCells.add(tmp);
						counter++;
						System.out.println("Pit Cave Made");
						}
				
				}		
				
				sb.setLength(0);
				
				}
			
			System.out.println("end");
		return randCave;
	}
	
	
	*/
}


	
	
	
	