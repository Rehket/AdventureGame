import java.awt.Color;


import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Random;


@SuppressWarnings("serial")
public class BackGround extends JPanel implements ActionListener,KeyListener{
	private static Timer timer;
	private Ship ship;
	private boolean inGame;
	public static int enemiesTime = 0;
	public static int enemiesEnct = 0;
	public static int score = 0;
	private ArrayList<Enemies> enemies;
	public BackGround(){
			addKeyListener(new TAdapter());
	        setFocusable(true);
	        requestFocus(true);
	        setBackground(Color.BLACK);
	        setDoubleBuffered(true);
	        
	        inGame = true;
	        ship = new Ship(50, 50);
	        
	        timer = new Timer(5, this);
	        timer.start();
	        this.enemies = new ArrayList<Enemies>();
	        
	     
	}
	
	
	
	
  public void paint(Graphics g) {

      super.paint(g);
      
      if(inGame){

    	  Graphics2D g2d = (Graphics2D) g;
    	  g2d.setBackground(Color.BLACK);
    	  g2d.setColor(Color.WHITE);

    	  Random r = new Random();

    	 
    	  for (int i=0; i<1000; i++) {
    		  int x =r.nextInt(SpaceGame.WIDTH)+1;
    		  int y =r.nextInt(SpaceGame.HEIGHT)+1;
    		  g2d.drawLine(x, y, x, y);  
    		
    	  }
    	  
    	  if(ship.isVisible() == true){
    		  g2d.drawImage(ship.getImage(), ship.getXLoc(), ship.getYLoc(), this);
    		  
    	  }
    	  
    	  ArrayList<Weapons> wep = ship.getWeapons();
    	  
    		  //Drawing for Bullets
    	  for(int i = 0; i< wep.size();i++){
    		  
    		  if(wep.get(i).isVisible() == true){
        		  g2d.drawImage(wep.get(i).getImage(), wep.get(i).getXLoc()+45, wep.get(i).getYLoc()+16, this);
    		  }
    	  }
    	  
    	  //Drawing For Enemies
 	  
    	  for(int i = 0; i< enemies.size();i++){
    		  
    		  if(enemies.get(i).isVisible() == true){
        		  g2d.drawImage(enemies.get(i).getImage(), enemies.get(i).getXLoc()+45, enemies.get(i).getYLoc()+16, this);
    		  }
    	  }
   
   
   
   //Movement for Bullets
    	  for(int i = 0; i< wep.size();i++){
    		  if(wep.get(i).isVisible() == true){
    			  if(wep.get(i).getXLoc()>875){
    				  wep.remove(i);
    			  }
        		  if(wep.size() != 0){
        			  wep.get(i).move();
        			  
        			  
        		  }
    		  }
    	  }
    	 //Movement for Enemies
    	  int eSize =  enemies.size();
    	  for(int i = 0; i< eSize;i++){
    		  if(enemies.get(i).isVisible() == true){
    			  if(enemies.get(i).getXLoc()<3){
    				  enemies.get(i).setVisible(false);
    				  enemies.get(i).setAlive(false);
    				  eSize--;}
    			  if(enemies.size() != 0){
    				  enemies.get(i).move();
        		  }
        		}
    	  	}
    	 
    	  
    	  //Collision for Bullets and Enemies.
    	  if(eSize >0 && wep.size()>0){
        	  for(int x = 0; x<wep.size();x++){
        		  Rectangle rect1 = wep.get(x).getBounds();
        		  for(int y = 0;y<eSize;y++){
        			Rectangle rect2 = enemies.get(y).getBounds();	
        				if(rect1.intersects(rect2)){
        					wep.get(x).setVisible(false);
        					wep.get(x).setAlive(false);
        					enemies.get(y).setVisible(false);
        					enemies.get(y).setAlive(false);
        					SoundEffects.EDEATH.play();
        				score += 10;
          			  System.out.println(score);
        			}
        		  }  
        	  	}
        	  }
    	  
    	  //Collision for ships and enemies.
    	  
        	  for(int x = 0; x<eSize;x++){
        		  Rectangle rect1 = ship.getBounds();
        			Rectangle rect2 = enemies.get(x).getBounds();	
        				if(rect1.intersects(rect2)){
        					ship.setAlive(false);
        					ship.setVisible(false);
        					enemies.get(x).setVisible(false);
        					enemies.get(x).setAlive(false);
        					SoundEffects.REDALERT.play();
          			  System.out.println(score);
          			  
        			}
        		  }  
        	  
    	 //Clean-up and Score updater.
        	  for(int x = 0; x<wep.size();x++){
        		  if(wep.get(x).isAlive() == false){
        			  wep.remove(x);
        		  }
        	  }
        	  for(int x = 0; x<eSize;x++){
        		  if(enemies.get(x).isAlive() == false){
        			  enemies.remove(x);
        			  eSize--;
        		  }
        	  }
        	  if(ship.isVisible() == false){	
            	  g.drawString("He's Dead Jim...", 250, 250);
            	  g.drawString("Your Score: "+ score, 300, 300);
            	  }
        	  else   g.drawString("Score: "+ score, 25, 25);
      }
      
      
      Toolkit.getDefaultToolkit().sync();
      g.dispose();
  }

  
public void actionPerformed(ActionEvent e) {
	
	ship.move();
	repaint();
	enemiesTime++;
	//System.out.println(enemiesTime);
	if(enemiesTime>2000 || enemiesEnct == 0){
		enemies = randEnemies();
		//System.out.println("Spawing New Enemies");
		enemiesTime = 0;
		enemiesEnct++;
	}
}





  
//Generates a random Number or Randomly placed Enemies.
public ArrayList<Enemies> randEnemies(){
	SoundEffects.ALIENS.play();
	Random gen = new Random();
	ArrayList<Enemies> rand = new ArrayList<Enemies>();
		for (int c = 0; c<(gen.nextInt(12)+9); c++){
					 
			rand.add(new Enemies(gen.nextInt(900)+900, gen.nextInt(600)));	
					 
			}
		return rand;
		}
  
  public static void stopTimer(){
	  
	  timer.stop();
  }
  
private class TAdapter extends KeyAdapter {

    public void keyReleased(KeyEvent e) {
    	
        ship.keyReleased(e);
    }

    public void keyPressed(KeyEvent e) {
    	
        ship.keyPressed(e);
    }
}





public void keyPressed(KeyEvent e) {
	
	
}





public void keyReleased(KeyEvent e) {

	
}




@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

}