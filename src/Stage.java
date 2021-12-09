import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Stage extends JPanel implements Runnable{
	private static final float FRAMERATE = 30;
	private int cameraX = 0;
	private static final int CAMERAEDGE = (int) SuperMario.WIDTH/2;
	private Map map = null;
	private Mario mario;
	public Handler handler;
	public Stage(int stageNumber) {
		this.map = new Map(stageNumber);
		this.mario = new Mario(map.getMarioSpawnCoord()[0],map.getMarioSpawnCoord()[1],16,16,Id.Mario,handler);
//		new Thread(mario).start();
        Dimension size = new Dimension(SuperMario.WIDTH, SuperMario.HEIGHT);

        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
		
	}
	public void run() {
//		int i = 0;
		while (true) {
			mario.tick();
//			System.out.println("frame"+i);
//			i++;
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
    	g.drawImage(mario.getImage(), mario.getX()-cameraX, mario.getY(), null);
    }
    private void updateCamera() {
    	int marioX = mario.getX();
//    	System.out.println("camera position:"+cameraX);
//    	System.out.println("mario position:"+marioX);
//    	System.out.println("map width:"+map.getWidth());
    	
    	System.out.println(cameraX +SuperMario.WIDTH - marioX - CAMERAEDGE);
    	if (marioX<CAMERAEDGE) {
    		System.out.println("fix");
    		//camera fix
    		cameraX = 0;
    	}else if(map.getWidth() - marioX < CAMERAEDGE) {
    		//camera fix
    		cameraX = map.getWidth() - CAMERAEDGE;
    	}
    	else if(marioX-cameraX<CAMERAEDGE) {
    		//camera move left
    		System.out.println("move left");
    		System.out.println(marioX);
//    		System.out.println(marioX);
    		cameraX=marioX-CAMERAEDGE;
    	}else if(cameraX + SuperMario.WIDTH - marioX < CAMERAEDGE) {
    		//camera move right
    		System.out.println("move right11111111111111111111111111111111111\n\n\n\n\n");
    		cameraX = marioX + CAMERAEDGE - SuperMario.getWIDTH();
    	}
    }
	public Mario getMario() {
		return mario;
	}
    
}
