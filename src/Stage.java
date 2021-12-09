import java.awt.Graphics;

import javax.swing.JPanel;

public class Stage extends JPanel implements Runnable{
	private static final float FRAMERATE = 30;
	private int cameraX = 0;
	private static final int CAMERAEDGE = 300;
	private Map map = null;
	private Mario mario;
	public Handler handler;
	public Stage(int stageNumber) {
		this.map = new Map(stageNumber);
		this.mario = new Mario(map.getMarioSpawnCoord()[0],map.getMarioSpawnCoord()[1],16,16,Id.Mario,handler);
		
		
	}
	public void run() {
		while (true) {
			updateCamera();
		repaint();
		try {
			Thread.sleep((long)(1000/FRAMERATE));
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} 
	}
		}
	
    public void paintComponent(Graphics g) {
    	g.drawImage(mario.getImage(), mario.getX()-cameraX, mario.getY(), null);
    	for (GameObject obj: map.getAllObj()) {
    		g.drawImage(obj.getImage(), obj.getX()-cameraX, obj.getY(), null);
    	}
    	for (Enemy ene: map.getAllEnemy()) {
    		g.drawImage(ene.getImage(), ene.getX()-cameraX, ene.getY(), null);
    	}
    }
    private void updateCamera() {
    	int marioX = mario.getX();
    	if (marioX<CAMERAEDGE) {
    		//camera fix
    		cameraX = 0;
    	}else if(map.getWidth() - marioX < CAMERAEDGE) {
    		//camera fix
    		cameraX = map.getWidth() - CAMERAEDGE;
    	}
    	else if(marioX-cameraX<CAMERAEDGE) {
    		//camera move left
    		cameraX=marioX-CAMERAEDGE;
    	}else if(cameraX + SuperMario.getWIDTH() - marioX < CAMERAEDGE) {
    		//camera move right
    		cameraX = marioX + CAMERAEDGE - SuperMario.getWIDTH();
    	}
    }
}
