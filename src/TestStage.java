import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TestStage extends JPanel {
	private static final float FRAMERATE = 30;
	private int cameraX = 0;
	private static final int CAMERAEDGE = 300;
	private Map map = null;
	private Mario mario = null;
	public Handler handler;
	Image img = null;
	
	public TestStage() {
		this.map = new Map(1);
		this.mario = new Mario(map.getMarioSpawnCoord()[0],map.getMarioSpawnCoord()[1],16,16);

		
//		repaint();
//    	System.out.println("painted");
//        Dimension size = new Dimension(SuperMario.getWIDTH(), SuperMario.getHEIGHT());
		this.img = new ImageIcon("src/images/bg1.png").getImage();
        Dimension size = new Dimension(400, 318);

        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
	}
	
    public void paintComponent(Graphics g) {
//    	super.paintComponent(g);
    	
    	//System.out.println("painted");
    	g.drawImage(img, 0, 0, null);
    	
    	//2.)
    	for (GameObject obj: map.getAllObj()) {
    		//System.out.println("printing"+obj);
    		//System.out.println(obj.getImage());
    		g.drawImage(obj.getImage(), obj.getX()-cameraX, obj.getY(), null);
    	}
    	//3.)
    	g.drawImage(mario.getImage(), mario.getX()-cameraX, mario.getY(), null);

//    	for (Enemy ene: map.getAllEnemy()) {
//    		g.drawImage(ene.getImage(), ene.getX()-cameraX, ene.getY(), null);
//    	}
    }

}
