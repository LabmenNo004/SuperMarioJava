import java.awt.Graphics;

import javax.swing.JPanel;

public class Stage extends JPanel implements Runnable{
	private static final float FRAMERATE = 30;
	private int cameraX = 0;
	private Map map = null;
	private Mario mario;
	public Stage(int stageNumber) {
		this.map = new Map(stageNumber);
		Mario mario = new Mario(map.getMarioSpawnCoord()[0],map.getMarioSpawnCoord()[1]);
		
	}
	public void run() {
		while (true) {
		repaint();
		try {
			Thread.sleep((long)(1000/FRAMERATE));
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} 
	}
		}
	
    public void paintComponent(Graphics g) {
    	g.drawImage(mario.getImage(), mario.getX(), mario.getY(), null);
    	for (GameObject obj: map.getAllObj()) {
    		g.drawImage(obj.getImage(), obj.getX(), obj.getY(), null);
    	}
    	for (Enemy ene: map.getAllEnemy()) {
    		g.drawImage(ene.getImage(), ene.getX(), ene.getY(), null);
    	}
    }
}
