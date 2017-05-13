//Adam L Albright
//COP 3330 - 12 FALL 0001  11/11/12
//Main Menu that wiill be used to luanch games.

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;  
import java.io.File;  
import java.io.FileNotFoundException;
import java.io.IOException; 
import javax.swing.*;
 

@SuppressWarnings("unused")
public class MainMenu implements ActionListener, WindowListener{
	public static int unlocks = 0;
	private JFrame main;
	private JButton advGame;
	private JButton spaceGame;
	private JTextField text;
	public static Song RAIDERS = new Song("raiders.mid");
	
    public MainMenu() {
    	
        main = new JFrame("Future Tech Games BETA ver.01");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setLayout(new FlowLayout());
        main.setSize(500, 400);
        main.setVisible(true);
        
        	advGame = new JButton("Adventure Game 2.0");
        	advGame.setSize(150, 50);
        	advGame.setLocation(1, 100);
        	
        	spaceGame = new JButton("Space Game");
        	spaceGame.setSize(200, 50);
        	spaceGame.setLocation(200, 500);
        	if (unlocks <=0){
        	spaceGame.setVisible(false);
        	}
        	  
        main.add(advGame); 
        main.add(spaceGame);
        main.pack();
        advGame.addActionListener(this);
        spaceGame.addActionListener(this);
        main.pack(); // .pack(); sets up final details to display the window.
        
        
    }
 
    @SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
    	 java.io.File file = new java.io.File("logging.txt"); 
    	 Scanner sc = new Scanner(file);
    	 unlocks = sc.nextInt();
    	Song.playSong(RAIDERS);
    	
                new MainMenu();
        
            
    }

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == advGame){
			try {
				new AdventureGame();
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			
			Song.stopSong(RAIDERS);
			main.dispose();
		}
		
		if(event.getSource() == spaceGame){
			new SpaceGame();
			Song.stopSong(RAIDERS);
			main.dispose();
		}
		
		else System.out.println("Doh");
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		Song.stopSong(RAIDERS);
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    
   
    
    

}