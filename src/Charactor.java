import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;
import java.awt.Graphics;

public abstract class Charactor implements Runnable, java.io.Serializable {
	protected boolean canCollide;
	protected int x;
	protected int y;
	protected int height; // phsical size
	protected int width; // phsical size
	protected BufferedImage image; // changed to BufferedImage
	protected static String path = System.getProperty("user.dir") + "/src/images/";
	protected int VelX, VelY;
	public Id id;
	public Handler handler;
	protected boolean isInAir;
    protected boolean face=true;  // true=right, false=left
    protected boolean walk = true;



//	public boolean jumping = false;
//	public boolean falling = true;

	public double gravity = 0.0;

	// Constructor
	public Charactor() {
	}

	public Charactor(int x, int y, int length, int width) { // canCollide can be determined by
																					// type
		this.x = x;
		this.y = y;
		this.height = length;
		this.width = width;
		
	}

	// Getter
	public BufferedImage getImage() {
		return this.image;
	}

	public abstract void tick();


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

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	// Setter
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setCanCollide(boolean canCollide) {
		this.canCollide = canCollide;
	}

	public void setHeight(int height) {
		this.height = height;
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

	public abstract void rightCollide(GameObject obj);

	public abstract void leftCollide(GameObject obj);

	public abstract void upCollide(GameObject obj);

	public abstract void downCollide(GameObject obj);

	public void collisionDetection() {
		List<GameObject> allObj = Map.getAllObj();
		boolean[] result = new boolean[4];
		boolean inAir = true;
		int edge = 6;
		int slide = 0;
		GameObject sobj = null;
		boolean isMario = this instanceof Mario;
		for (GameObject obj : allObj) {
			boolean isCoin = (isMario && obj instanceof Coin);
			if (!obj.canCollide && !isCoin) continue;
			if (obj.getX() > (this.getX() + this.getWidth()) || obj.getX() + obj.getWidth() < this.getX()
					|| obj.getY() > (this.getY() + this.getHeight()) || obj.getY() + obj.getHeight() < this.getY()) {
//				if Character on left or right or above or below, skip
				continue;
			}

			int rightOverlap = this.getX() + this.getWidth() - obj.getX();
			int leftOverlap = obj.getX() + obj.getWidth() - this.getX();
			int upOverlap = obj.getY() + obj.getHeight() - this.getY();
			int downOverlap = this.getY() + this.getHeight() - obj.getY();
			
			if (this.isInAir && rightOverlap < edge) {
//				slide
				slide = 1;
				sobj = obj;
				continue;
			}
			if (this.isInAir && leftOverlap < edge) {
//				slide
				slide = 2;
				sobj = obj;
				continue;
			}
			
			if (obj.getX() <= (this.getX() + this.getWidth()) && obj.getX() > this.getX() && (rightOverlap < upOverlap
					&& rightOverlap < downOverlap)) {

//				right collision
				if (isCoin) {
					((Coin)obj).eat();
					continue;
				}
				this.setX(obj.getX() - this.getWidth());
				this.rightCollide(obj);
			} else if (this.getX() <= obj.getX() + obj.getWidth()
					&& this.getX() + this.getWidth() > obj.getX() + obj.getWidth() && (leftOverlap < upOverlap
					&& leftOverlap < downOverlap)) {
//					left collision
				if (isCoin) {
					((Coin)obj).eat();
					continue;
				}
				this.setX(obj.getX() + obj.getWidth());
				this.leftCollide(obj);
			}

			else {
				if (this.getY() + this.getHeight() < obj.getY() + obj.getHeight()) {
//					down collision
					if (isCoin) {
						((Coin)obj).eat();
						continue;
					}
					this.setY(obj.getY() - this.getHeight());
					inAir = false;
					downCollide(obj);
				} else {
//					up collision
					if (isCoin) {
						((Coin)obj).eat();
						continue;
					}
					this.setY(obj.getY() + obj.getHeight());
					upCollide(obj);
				}
			}
		}
		this.isInAir=inAir;
		if(isInAir) {
			if(slide == 1) {
				this.setX(sobj.getX() - this.getWidth());
				this.rightCollide(sobj);
			}
			else if (slide == 2) {
				this.setX(sobj.getX() + sobj.getWidth());
				this.leftCollide(sobj);
			}
		}
	}

}