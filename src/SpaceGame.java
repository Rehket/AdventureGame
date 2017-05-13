import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;



import java.util.Random;
import java.util.TimerTask;


@SuppressWarnings({ "unused", "serial" })
public class SpaceGame extends JPanel implements KeyListener,MouseListener,WindowListener, ActionListener {
	public static Song TREK = new Song("trek.mid");
	public static int WIDTH = 900;
	public static int HEIGHT = 700;
	private JFrame frame;
	private JLabel statusBar;
	
	SpaceGame(){
		
		Song.playSong(TREK);
		buildGui();
		//newGame();
		//updateGameBoard();
		
	}
	private void buildGui() {
		// Make the frame.
		newWindow("Space Game", WIDTH, HEIGHT);
		
		
	}
	
	public JFrame newWindow(String name, int w, int h){
		
		frame = new JFrame(name);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		frame.add(new BackGround());
		
		// Add the status bar.
		/*statusBar = new JLabel();
		statusBar.setSize(WIDTH, 100);
		statusBar.setBorder(BorderFactory.createLoweredBevelBorder());
		statusBar.setVisible(true);
		frame.add(statusBar,BorderLayout.SOUTH);*/
		frame.setSize(w, h);
		
		// Add the listener for key strokes.
		//frame.addKeyListener(this);
		//frame.setFocusTraversalKeysEnabled(false);
		frame.addWindowListener(this);
		// Make it visible.
		//frame.setBackground(Color.BLACK);
		frame.setVisible(true);
		
		frame.setFocusable(false);
		return frame;
	}
	
	
	@Override
	public void windowActivated(WindowEvent arg0) {}

	public void windowClosed(WindowEvent arg0) {}
	@Override
	public void windowClosing(WindowEvent e) {
		Song.stopSong(TREK);
		frame.dispose();
		BackGround.stopTimer();
		new MainMenu();	
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {}
	@Override
	public void windowDeiconified(WindowEvent arg0) {}
	@Override
	public void windowIconified(WindowEvent arg0) {}
	@Override
	public void windowOpened(WindowEvent arg0) {}
	@Override
	public void mouseClicked(MouseEvent arg0) {}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
	@Override
	public void keyPressed(KeyEvent arg0) {}
	@Override
	public void keyReleased(KeyEvent arg0) {}
	@Override
	public void keyTyped(KeyEvent arg0) {}
	@Override
	public void actionPerformed(ActionEvent e) {}








}
	
	
	
  