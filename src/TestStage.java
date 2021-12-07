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
	Image img = null;
	public TestStage() {
		this.map = new Map(1);
		
//		repaint();
//    	System.out.println("painted");
//        Dimension size = new Dimension(SuperMario.getWIDTH(), SuperMario.getHEIGHT());
		this.img = new ImageIcon("src/images/bg1.png").getImage();
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));

        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
	}
	
    public void paintComponent(Graphics g) {
//    	super.paintComponent(g);
//    	g.drawImage(mario.getImage(), mario.getX()-cameraX, mario.getY(), null);
    	
    	System.out.println("painted");
    	g.drawImage(img, 50, 0, null);
    	
    	for (GameObject obj: map.getAllObj()) {
    		System.out.println("printing"+obj);
    		System.out.println(obj.getImage());
    		g.drawImage(obj.getImage(), obj.getX()-cameraX, obj.getY(), null);
    	}
//    	for (Enemy ene: map.getAllEnemy()) {
//    		g.drawImage(ene.getImage(), ene.getX()-cameraX, ene.getY(), null);
//    	}
    }

}
