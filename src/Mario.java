import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.util.List;

import javax.imageio.ImageIO;

import  java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Mario extends Charactor{
//	by Zehao: you can access status of key pressed using 
//	SuperMario.isJumpPressed(), SuperMario.isRightPressed(), SuperMario.isLeftPressed()

	
	
	private List<GameObject> allObj = null;
	private List<Enemy> allEnemy = null;
	private final static int MAXVEL = 15;
	protected static BufferedImage maImage = null;
    protected boolean jumping=false;
	
	public Mario(int x, int y,int height, int width) {
		super(x,y,height,width);
		this.image = getMarioImage(); 
		
	}
	
	public void run() {
		
	}
	
	public BufferedImage getMarioImage (){
		//set background
		try {
			maImage = new BufferedImage(Map.getMarioSpawnCoord()[0],Map.getMarioSpawnCoord()[1], BufferedImage.TYPE_INT_ARGB);
			System.out.println("mario image loaded");
			if(this.FACE && !isInAir) {
			maImage = ImageIO.read(new File(path+"marioRight"+".png"));// user.dir/scr/images/bg#.png
			}
			else if(this.FACE && isInAir){
				maImage = ImageIO.read(new File(path+"jump_right"+".png"));
			}
			else  if(!this.FACE && !isInAir) {
				maImage = ImageIO.read(new File(path+"marioLeft"+".png"));
			}
			else if(!this.FACE && isInAir) {
				maImage = ImageIO.read(new File(path+"jump_left"+".png"));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("failed to import background image");
			e.printStackTrace();
		} 
		return maImage;
	}
	
	/*
	public Image getImage() {
		//image
		return null;
	}*/
	
	public void setObjects(List<GameObject> allObj) {
		this.allObj = allObj;
	}


	public void setAllEnemy(List<Enemy> allEnemy) {
		this.allEnemy = allEnemy;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x+=VelX;
		y+=VelY;
		if(x<=0) x=0;
		if(y<=0) y=0;
		collisionDetection();
		EnemycollisionDetection();
		addingGravity();
		this.image = getMarioImage(); 
//		if(x+length>400) x = 400-length;   //   to control Mario not go out of the screen
//		if(y+width>318) y = 318-width;
	}


	public void rightCollide(GameObject obj) {}

	public void leftCollide(GameObject obj) {}

	public void upCollide(GameObject obj) {					
//		this.jumping=true;
		if (obj instanceof Block && ((Block) obj).getBlockType()==3) {
			if (x>obj.x-(obj.width/4) && x+width<obj.x+(obj.width/4)*5) {
				System.out.println("coin");
			}
		}
		this.setVelY(0);}

	public void downCollide(GameObject obj) {
//		this.falling = false;
//		this.jumping = false;
		if (VelY>0)
		this.setVelY(0);
	}
	
	public void EnemyRightCollide(Enemy enm) {}

	public void EnemyLeftCollide(Enemy enm) {}

	public void EnemyUpCollide(Enemy enm) {					
		}

	public void EnemyDownCollide(Enemy enm) {
		}

	/*
	if(jumping) {
		gravity -=0.1;
		setVelY((int)-gravity);
		if(gravity<=0.0) {
			jumping = false;
			falling = true;
		}
	}
		
	if(falling) {
		gravity+=0.1;
		setVelY((int)gravity);
		
	}*/
	public void rightPressed() {
		setVelX(5);

		if(!this.FACE) {
			this.FACE=true;
		}
		//System.out.println("left:"+LEFT);
		//System.out.println("right:"+RIGHT);
		
	}
	public void rightReleased() {
		setVelX(0);

	}
	public void leftPressed() {
		setVelX(-5);

		if(this.FACE) {
			this.FACE=false;
		}
		//System.out.println("left:"+LEFT);
		//System.out.println("right:"+RIGHT);
		
	}
	public void leftReleased() {
		setVelX(0);

	}
	public void downPressed() {
		if(isInAir) {
		setVelY(5);
	}
	}
	public void downReleased() {
		setVelY(0);
	}
	public void jumpPressed() {

		if(!this.isInAir) {

			setVelY(-12);
			this.isInAir = true;
			SuperMario.playSound("jump");
//		this.jumping = true;
//		this.falling= false;
	}
	}
	public void jumpReleased() {
		//setVelY(0);
	}
	
	public void addingGravity() {
	int velY = this.VelY;
	//if(jumping) {
		if (velY<MAXVEL) {
		velY += 1;
		setVelY(velY);
		}

	//}
	
}
	
	public void EnemycollisionDetection() {
		List<Enemy> allenemy = Map.getAllEnemy();
		boolean[] result = new boolean[4];
		boolean inAir = false;
		int edge = 6;
		int slide = 0;
		Enemy sobj = null;
		for (Enemy enm : allenemy) {
			if (enm.getX() > (this.getX() + this.getWidth()) || enm.getX() + enm.getWidth() < this.getX()
					|| enm.getY() > (this.getY() + this.getHeight()) || enm.getY() + enm.getHeight() < this.getY()) {
//				if Character on left or right or above or below, skip
				continue;
			}

			int rightOverlap = this.getX() + this.getWidth() - enm.getX();
			int leftOverlap = enm.getX() + enm.getWidth() - this.getX();
			int upOverlap = enm.getY() + enm.getHeight() - this.getY();
			int downOverlap = this.getY() + this.getHeight() - enm.getY();
			
			if (this.isInAir && rightOverlap < edge) {
//				slide
				slide = 1;
				sobj = enm;
				continue;
			}
			if (this.isInAir && leftOverlap < edge) {
//				slide
				slide = 2;
				sobj = enm;
				continue;
			}
			
			if (enm.getX() <= (this.getX() + this.getWidth()) && enm.getX() > this.getX() && (rightOverlap < upOverlap
					&& rightOverlap < downOverlap)) {

//				right collision
				this.EnemyRightCollide(enm);
			} else if (this.getX() <= enm.getX() + enm.getWidth()
					&& this.getX() + this.getWidth() > enm.getX() + enm.getWidth() && (leftOverlap < upOverlap
					&& leftOverlap < downOverlap)) {
//					left collision
				this.EnemyLeftCollide(enm);
			}

			else {
				if (this.getY() + this.getHeight() < enm.getY() + enm.getHeight()) {
//					down collision
					this.EnemyDownCollide(enm);
					allenemy.remove(enm);
					this.setVelY(-6);
					break;
				} else {
//					up collision
					this.EnemyUpCollide(enm);
				}
			}
		}
		this.isInAir=inAir;
		if(isInAir) {
			if(slide == 1) {
				this.EnemyRightCollide(sobj);
			}
			else if (slide == 2) {
				this.setX(sobj.getX() + sobj.getWidth());
				this.EnemyLeftCollide(sobj);
			}
		}
	}
	
}
