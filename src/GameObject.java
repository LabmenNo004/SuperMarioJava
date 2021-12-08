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
	protected int VelX,VelY;
	
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
	public boolean isCanCollide() {
		return canCollide;
	}
	public int getLength() {
		return length;
	}
	public int getWidth() {
		return width;
	}

	//Setter
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setCanCollide(boolean canCollide) {
		this.canCollide = canCollide;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void setWidth(int width) {
		this.width = width;
	}

	public int getVelX() {
		return VelX;
	}

	public void setVelX(int velX) {
		VelX = velX;
	}

	public int getVelY() {
		return VelY;
	}

	public void setVelY(int velY) {
		VelY = velY;
	}
}