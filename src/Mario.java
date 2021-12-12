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
	
	protected static BufferedImage maImage = null;
	
	public Mario(int x, int y,int height, int width) {
		super(x,y,height,width);
//		this.image = getMarioImage(); 
		
	}
	
	public void run() {
		
	}
	
	public BufferedImage getImage (){
		//set background
		try {
			maImage = new BufferedImage(Map.getMarioSpawnCoord()[0],Map.getMarioSpawnCoord()[1], BufferedImage.TYPE_INT_ARGB);
			System.out.println("mario image loaded");
			if(this.face && !isInAir) {
				maImage = ImageIO.read(new File(path+"marioRight"+".png"));// user.dir/scr/images/bg#.png
			}
			else if(this.face && isInAir){
				maImage = ImageIO.read(new File(path+"jump_right"+".png"));
			}
			else  if(!this.face && !isInAir) {
				maImage = ImageIO.read(new File(path+"marioLeft"+".png"));
			}
			else if(!this.face && isInAir) {
				maImage = ImageIO.read(new File(path+"jump_left"+".png"));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("failed to import background image");
			e.printStackTrace();
		} 
		return maImage;
	}
	

	
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
//		if(x+length>400) x = 400-length;   //   to control Mario not go out of the screen
//		if(y+width>318) y = 318-width;
	}


	public void rightCollide(GameObject obj) {
		
	}

	public void leftCollide(GameObject obj) {
		
	}

	public void upCollide(GameObject obj) {					
//		this.jumping=true;
		if (obj instanceof Block && ((Block) obj).getBlockType()==3) {
			if (x>obj.x-(obj.width/3) && x+width<obj.x+(obj.width/3)+obj.width) {
//				System.out.println("coin");
				((Block) obj).change();
			}
		}
		this.setVelY(0);}

	public void downCollide(GameObject obj) {
//		this.falling = false;
//		this.jumping = false;
		this.setVelY(0);
	}
	
	public void EnemyRightCollide(Enemy enm) {
		SuperMario.stage.die();
	}

	public void EnemyLeftCollide(Enemy enm) {
		SuperMario.stage.die();
	}

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
		if (! isInAir)
		this.face = true;
		setVelX(5);
		
	}
	public void rightReleased() {
		if (VelX>0)
		setVelX(0);

	}
	public void leftPressed() {
		if (! isInAir)
		this.face = false;
		setVelX(-5);
		
	}
	public void leftReleased() {
		if (VelX<0)
		setVelX(0);

	}
	public void downPressed() {
		checkHiddenPipe();
	}
	public void downReleased() {
	}
	public void jumpPressed() {

		if(!this.isInAir) {
			setVelY(-12);
			this.isInAir = true;
			SuperMario.playSound("jump");
	}
	}
	public void jumpReleased() {
		//setVelY(0);
	}
	
	public void addingGravity() {
	int velY = this.VelY;
	//if(jumping) {

		velY += 1;
		setVelY(velY);
		

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
					this.isInAir = true;
					break;
				} else {
//					up collision
					this.EnemyUpCollide(enm);
				}
			}
		}
		//this.isInAir=inAir;
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
	
	public void checkHiddenPipe() {
		//2 cases: either going in or going out of the room
			//1) going in
		System.out.println("Hidden pipe X: " + Map.hiddenPipeIn.getX() +" Y: " + (Map.hiddenPipeIn.getY() - Map.BLOCK_SIZE));		
		System.out.println("Mario X: " + this.getX() +" Y: " + this.getY());		
		
		if ((this.getX() >= Map.hiddenPipeIn.getX() && this.getX() <= Map.hiddenPipeIn.getX() + Map.hiddenPipeIn.getWidth())
				&& (this.getY() == Map.hiddenPipeIn.getY() - Map.BLOCK_SIZE)) {
			System.out.println("1st if called");
			hiddenRoomIn(SuperMario.stageNumber);
		}
			//2) PipeExit
		else if ((this.getX() >= Map.hiddenPipeExit.getX() && this.getX() <= Map.hiddenPipeExit.getX() + Map.hiddenPipeExit.getWidth())
				&& (this.getY() == Map.hiddenPipeExit.getY() - Map.BLOCK_SIZE)) {
			System.out.println("pipe function out called");
			hiddenRoomOut(SuperMario.stageNumber);
		}
	}
	public void hiddenRoomIn(int stageNumber) {
		//change mario x,y coord to the corr beginning point of the room
		if (stageNumber ==1) {
			
		}
		if (stageNumber ==2) {
			//Starting Point: x: 163+18=181 y: 15
			//set mario x y to above
			this.setX(181 * Map.BLOCK_SIZE);
			this.setY(15* Map.BLOCK_SIZE);
			//set camera X
			SuperMario.stage.setCameraX(181 * Map.BLOCK_SIZE);
			Stage.camUpdate = false;
		}
		if (stageNumber ==3) {
			
		}
	}
	public void hiddenRoomOut(int stageNumber) {
		//change mario x,y coord to the corr beginning point of the map
		if (stageNumber ==1) {
		
		}
		if (stageNumber ==2) {
			//Exiting Point: x:116 Y:5
			//set Mariox y to above
			this.setX(116* Map.BLOCK_SIZE);
			this.setY(5* Map.BLOCK_SIZE);
			SuperMario.stage.setCameraX(116* Map.BLOCK_SIZE);
			Stage.camUpdate = true;
		}
		if (stageNumber ==3) {
		}
	}

	
}



