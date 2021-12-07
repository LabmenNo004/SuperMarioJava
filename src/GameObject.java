import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameObject{
	protected boolean canCollide;
	protected int x;
	protected int y;
	protected int length; //phsical size
	protected int width; //phsical size
	protected BufferedImage image; //changed to BufferedImage
	protected static String path = System.getProperty("user.dir") + "/src/images/";
	
	//Constructor
	public GameObject() {}
	
	public GameObject(int x, int y,int length, int width) { //canCollide can be determined by type 
		this.x = x;
		this.y = y;
		this.length = length;
		this.width = width;		
	}
	
	//Getter
	public BufferedImage getImage() {
		return this.image;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
