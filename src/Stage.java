import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Stage extends JPanel implements Runnable{
	private static final float FRAMERATE = 30;
	private int cameraX = 0;
	private static final int CAMERAEDGE = (int) SuperMario.WIDTH/2;
	private Map map = null;
	private Mario mario;
	private EnemyKuribo enemykuribo;
	public Handler handler;
	private int time = 300;
	public Stage(int stageNumber) {
		this.map = new Map(stageNumber);
		this.mario = new Mario(map.getMarioSpawnCoord()[0],map.getMarioSpawnCoord()[1],16,16,handler);
		this.enemykuribo = new EnemyKuribo(map.getMarioSpawnCoord()[0]+50,map.getMarioSpawnCoord()[1],12,12,handler);
//		new Thread(mario).start();
        Dimension size = new Dimension(SuperMario.WIDTH, SuperMario.HEIGHT);

        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
		
//        add timer ...
//        add UI
	}
	public void run() {
		
		
		while (true) {
//			check timer ...
			
			mario.tick();
			enemykuribo.tick();
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
    	
    	g.drawImage(map.getBgImage(), -cameraX , 0, null);
    	
    	for (GameObject obj: map.getAllObj()) {
    		g.drawImage(obj.getImage(), obj.getX()-cameraX, obj.getY(), null);
    	}
//    	for (Enemy ene: map.getAllEnemy()) {
//    		g.drawImage(ene.getImage(), ene.getX()-cameraX, ene.getY(), null);
//    	}
    	SuperMario.paintUI(g);
    	g.drawImage(mario.getImage(), mario.getX()-cameraX, mario.getY(), null);
    }
    private void updateCamera() {
    	int marioX = mario.getX();

//    	System.out.println(cameraX +SuperMario.WIDTH - marioX - CAMERAEDGE);
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
    	}else if(cameraX + SuperMario.WIDTH - marioX < CAMERAEDGE) {
    		//camera move right
    		cameraX = marioX + CAMERAEDGE - SuperMario.getWIDTH();
    	}
    }
	public Mario getMario() {
		return mario;
	}
	public int getTime() {
		return time;
	}
}
