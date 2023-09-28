package gametest;
import se.egy.graphics.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Console;
import java.util.*;

public class GameTest implements KeyListener {
	
	static boolean gameRunning = true;
	static GameScreen gameScreen = new GameScreen("Test", 1280, 960, false);
	
	public GameTest() {
    	this.gameScreen.setKeyListener(this);
    	
    	
    	startGame();

	}
	
	public void startGame() {
    	ArrayList<ImgContainer> icons = new ArrayList<ImgContainer>();
    	Random random = new Random();
    	
    	for (int i = 0; i < 20; i++) {
    		icons.add(new ImgContainer(random.nextInt(0, 1280), random.nextInt(0, 960), "playerImg.png"));


			
		}
    	while(gameRunning) {
    		gameScreen.render(icons); // renderar bilden

    		for (int i = 0; i < icons.size(); i++) {
				
        		ImgContainer cur =  icons.get(i);
        		cur.setX(cur.getX()+random.nextInt(-10, 10));
        		cur.setY(cur.getY()+random.nextInt(-10, 10));
			}
			
        	 
        	try{ Thread.sleep(17);}catch(Exception e){}; // pausar i 20 ms
 
        	
    	}
    	System.exit(0);
		
	}

	public static void main(String[] args) {
    	// Skapar ett spelfönster
		new GameTest();
    	// Skapar och laddar in en bild med en x,y-koordinat.
    	

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		gameRunning = false;
		System.out.println(e.getKeyChar());
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
