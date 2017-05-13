

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class SpaceArea extends JPanel implements ActionListener{
	private Timer timer;
    private Ships ship;
    @SuppressWarnings("rawtypes")
	private ArrayList enemies;
    private boolean ingame;
    private int B_WIDTH;
    private int B_HEIGHT;
    
    Random gen = new Random();
    int numEnemiesX = gen.nextInt(20)+7;
    int numEnemiesY = gen.nextInt(20)+7;
    
    //This is where the position of enemy Ships is determined.
    private int[][] pos = randEnemies(numEnemiesX, numEnemiesY);
            
   
    
    //Sets Up the Board
    public SpaceArea() {
    	
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.GRAY);
        setDoubleBuffered(true);
        setVisible(true);
        ingame = true;

        setSize(700, 700);

        ship = new Ships();

        initEnemies();
        	//Timer Affects How fast the Ships move
        timer = new Timer(10, this);
       timer.start();
    }
    
  //Puts Enemies on the Play Area
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void initEnemies() {
    	enemies = new ArrayList();

        for (int i=0; i<pos.length; i++ ) {
        	enemies.add(new Enemy(pos[i][0], pos[i][1]));
        }
    }
    
    public void addNotify() {
        super.addNotify();
        B_WIDTH = SpaceGame.WIDTH;
        B_HEIGHT = SpaceGame.HEIGHT;   
    }
    
    //Paints Everything In the Game.
    @SuppressWarnings("rawtypes")
	public void paint(Graphics g) {
        super.paint(g);

        if (ingame) {

            Graphics2D g2d = (Graphics2D)g;

            if (ship.isVisible())
                g2d.drawImage(ship.getImage(), ship.getX(), ship.getY(),
                              this);

            ArrayList ms = ship.getWeapons();

            for (int i = 0; i < ms.size(); i++) {
                Weapons m = (Weapons)ms.get(i);
                g2d.drawImage(m.getImage(), m.getXLoc(), m.getYLoc(), this);
            }

            for (int i = 0; i < enemies.size(); i++) {
                Enemy a = (Enemy)enemies.get(i);
                if (a.isVisible())
                    g2d.drawImage(a.getImage(), a.getX(), a.getY(), this);
            }

            g2d.setColor(Color.WHITE);
            g2d.drawString("Aliens left: " + enemies.size(), 5, 15);


        } else {
            String msg = "Game Over";
            Font small = new Font("Helvetica", Font.BOLD, 14);
            FontMetrics metr = this.getFontMetrics(small);

            g.setColor(Color.white);
            g.setFont(small);
            g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2,
                         B_HEIGHT / 2);
            
            Song.stopSong(SpaceGame.TREK);
              
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
        
    }

    @SuppressWarnings("rawtypes")
	public void actionPerformed(ActionEvent e) {

        if (enemies.size()==0) {
            ingame = false;
        }

        ArrayList ms = ship.getWeapons();

        for (int i = 0; i < ms.size(); i++) {
            Weapons w = (Weapons) ms.get(i);
            if (w.isVisible()) 
                w.move();
            else ms.remove(i);
        }

        for (int i = 0; i < enemies.size(); i++) {
            Enemy a = (Enemy) enemies.get(i);
            if (a.isVisible()) 
                a.move(a.speed);
            else enemies.remove(i);
        }

        ship.move();
        checkCollisions();
        repaint();  
    }

    @SuppressWarnings("rawtypes")
	public void checkCollisions() {

        Rectangle r3 = ship.getBounds();

        for (int j = 0; j<enemies.size(); j++) {
            Enemy a = (Enemy) enemies.get(j);
            Rectangle r2 = a.getBounds();

            if (r3.intersects(r2)) {
            	SoundEffects.PEW.play();
                ship.setVisible(false);
                a.setVisible(false);
                
                ingame = false;
            }
        }

        ArrayList ms = ship.getWeapons();

        for (int i = 0; i < ms.size(); i++) {
            Weapons m = (Weapons) ms.get(i);

            Rectangle r1 = m.getBounds();

            for (int j = 0; j<enemies.size(); j++) {
                Enemy a = (Enemy) enemies.get(j);
                Rectangle r2 = a.getBounds();

                if (r1.intersects(r2)) {
                	SoundEffects.EDEATH.play();
                    m.setVisible(false);
                    a.setVisible(false);
                }
            }
        }
    }
    
    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            ship.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            ship.keyPressed(e);
        }
    }
    
    //Generates a random Number or Randomly placed Enemies.
    public int[][] randEnemies(int x, int y){
    	Random gen = new Random();
    	
    	int[][] enemies = new int[x][2];
    	
    		for (int c = 0; c<(x*y); c++){
    			for(int i = 0;i<x;i++){
    				for(int j = 0; j<2; j++){
				
    					if(j == 0){
    						enemies[i][j] = gen.nextInt(1000)+700;
    					}
    					else
    						enemies[i][j] = gen.nextInt(651);
    					}
    				}
    			}
    		return enemies;
    		}
    
}
    

