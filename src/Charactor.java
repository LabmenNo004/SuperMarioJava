import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public abstract class Charactor implements Runnable{
	protected boolean canCollide;
	protected int x;
	protected int y;
	protected int length; //phsical size
	protected int width; //phsical size
	protected BufferedImage image; //changed to BufferedImage
	protected static String path = System.getProperty("user.dir") + "/src/images/";
	protected int VelX,VelY;
	public Id id;
	public Handler handler;
	
	public boolean jumping=false;
	public boolean falling=true;
	
	public double gravity = 0.0;
	
	//Constructor
	public Charactor() {}
	
	public Charactor(int x, int y,int length, int width, Id id, Handler handler) { //canCollide can be determined by type 
		this.x = x;
		this.y = y;
		this.length = length;
		this.width = width;		
		this.handler = handler;
	}
	
	//Getter
	public BufferedImage getImage() {
		return this.image;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);

	
	public void die() {
		handler.removeCharactor(this);
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


	public void setVelX(int velX) {
		VelX = velX;
	}


	public void setVelY(int velY) {
		VelY = velY;
	}
	
	public Id getId() {
		return this.id;
	}
	
	public boolean[] collisionDetection() {
//		returns [True, False, False, False] 
//		for whether there is object in up, right, down, left direction
		
		return null;
	}

	}