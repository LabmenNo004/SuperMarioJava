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

	
	
	protected static BufferedImage maImage = null;
	private int counter=0;
	private static int MAXV = 12;
	
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
//			System.out.println("mario image loaded");
			if(this.face && !isInAir &&!this.walk) {
				maImage = ImageIO.read(new File(path+"marioRight"+".png"));// user.dir/scr/images/bg#.png
			}
			else if(this.face && isInAir){
				maImage = ImageIO.read(new File(path+"jump_right"+".png"));
			}
			else  if(!this.face && !isInAir && !this.walk) {
				maImage = ImageIO.read(new File(path+"marioLeft"+".png"));
//				System.out.println(counterLeft);
			}
			else if(!this.face && isInAir) {
				maImage = ImageIO.read(new File(path+"jump_left"+".png"));
			}
			
			else if(this.face && !isInAir && this.walk == true && counter ==0 ) {
				maImage = ImageIO.read(new File(path+"marioRight"+".png"));
			}
			else if(this.face && !isInAir && this.walk == true && counter ==1 ) {
				maImage = ImageIO.read(new File(path+"marioWalkRight1"+".png"));
			}
			else if(this.face && !isInAir && this.walk == true && counter ==2 ) {
				maImage = ImageIO.read(new File(path+"marioWalkRight2"+".png"));
			}
			else if(this.face && !isInAir && this.walk == true && counter ==3 ) {
				maImage = ImageIO.read(new File(path+"marioWalkRight3"+".png"));
			}
			else if(!this.face && !isInAir && this.walk == true && counter ==0 ) {
				maImage = ImageIO.read(new File(path+"marioLeft"+".png"));
			}
			else if(!this.face && !isInAir && this.walk == true && counter ==1 ) {
				maImage = ImageIO.read(new File(path+"marioWalkLeft1"+".png"));
			}
			else if(!this.face && !isInAir && this.walk == true && counter ==2 ) {
				maImage = ImageIO.read(new File(path+"marioWalkLeft2"+".png"));
			}
			else if(!this.face && !isInAir && this.walk == true && counter ==3 ) {
				maImage = ImageIO.read(new File(path+"marioWalkLeft3"+".png"));
			}
			walk();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("failed to import background image");
			e.printStackTrace();
		} 
		return maImage;
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
			if (x>obj.x-(obj.width/2) && x+width<obj.x+(obj.width/2)+obj.width) {
//				System.out.println("coin");
				((Block) obj).change();
			}
		}
		this.setVelY(0);}

	public void downCollide(GameObject obj) {
//		this.falling = false;
//		this.jumping = false;
		if (this.VelX!=0) {
			this.walk = true;
		}
		this.setVelY(0);
//		
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
	
	public void walk() {
		if(counter<3) {
		counter+=1;
		}
		else {
			counter = 0;
		}
	}
	
	
	public void rightPressed() {
		if (! isInAir) {
//		rightWalk();
		this.face = true;
		this.walk = true;
		}
		setVelX(5);
		
		
	}
	public void rightReleased() {
		if (VelX>0) {
			setVelX(0);
			if(!isInAir) {
			
				this.walk = false;
			}
		}
	}
	public void leftPressed() {
		if (! isInAir) {
//			leftWalk();
		this.face = false;
		this.walk = true;
		}
		setVelX(-5);
		
	}
	public void leftReleased() {
		if (VelX<0) {
			setVelX(0);
		if(!isInAir) {
			
			this.walk = false;
		}
		}
	}
	public void downPressed() {
		checkHiddenPipe();
	}
	public void downReleased() {
	}
	public void jumpPressed() {

		if(!this.isInAir) {
			this.walk = false;
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
		setVelY(Math.min(velY, MAXV));

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
			

			if (isInAir && (downOverlap<=6 || leftOverlap>=6 || leftOverlap>=6)) {
				allenemy.remove(enm);
				SuperMario.increaseScore(200);
				SuperMario.playSound("stepEnemy");
				this.setVelY(-6);
				this.isInAir = true;
				break;
			}else {
				SuperMario.stage.die();

			}


		//this.isInAir=inAir;

	}
	}
	
	public void checkHiddenPipe() {
		//2 cases: either going in or going out of the room
			//1) going in
		System.out.println("Hidden pipe X: " + Map.hiddenPipeIn.getX() +" Y: " + (Map.hiddenPipeIn.getY() - Map.BLOCK_SIZE));		
		System.out.println("Mario X: " + this.getX() +" Y: " + this.getY());		
		
		if ((this.getX() >= Map.hiddenPipeIn.getX() && this.getX() <= Map.hiddenPipeIn.getX() + Map.hiddenPipeIn.getWidth())
				&& (this.getY() == Map.hiddenPipeIn.getY() - Map.BLOCK_SIZE)) {
			SuperMario.playSound("enterTube");
			System.out.println("Pipe In");
			hiddenRoomIn(SuperMario.stageNumber);
		}
			//2) PipeExit
		else if ((this.getX() >= Map.hiddenPipeExit.getX() && this.getX() <= Map.hiddenPipeExit.getX() + Map.hiddenPipeExit.getWidth())
				&& (this.getY() == Map.hiddenPipeExit.getY() - Map.BLOCK_SIZE)) {
			SuperMario.playSound("enterTube");
			System.out.println("Pipe Out");
			hiddenRoomOut(SuperMario.stageNumber);
		}
	}
	public void hiddenRoomIn(int stageNumber) {
		//change mario x,y coord to the corr beginning point of the room
		if (stageNumber ==1) {
			//set mario x y to above
			this.setX(221 * Map.BLOCK_SIZE);
			this.setY(5* Map.BLOCK_SIZE);
			//set camera X
			SuperMario.stage.setCameraX(220 * Map.BLOCK_SIZE);
			Stage.camUpdate = false;
		}
		if (stageNumber ==2) {
			//Starting Point: x: 163+18=181 y: 15
			//set mario x y to above
			this.setX(181 * Map.BLOCK_SIZE);
			this.setY(4* Map.BLOCK_SIZE);
			//set camera X
			SuperMario.stage.setCameraX(180 * Map.BLOCK_SIZE);
			Stage.camUpdate = false;
		}
		if (stageNumber ==3) {
			
		}
	}
	public void hiddenRoomOut(int stageNumber) {
		//change mario x,y coord to the corr beginning point of the map
		if (stageNumber ==1) {
			//Exiting Point: x: 164 Y:5
			//set Mariox y to above
			this.setX(164* Map.BLOCK_SIZE);
			this.setY(Map.mapHeight-(Map.BLOCK_SIZE*5));
			SuperMario.stage.setCameraX(164* Map.BLOCK_SIZE);
			Stage.camUpdate = true;
		}
		if (stageNumber ==2) {
			//Exiting Point: x:116 Y:5
			//set Mariox y to above
			this.setX(116* Map.BLOCK_SIZE);
			this.setY(Map.mapHeight-(Map.BLOCK_SIZE*5));
			SuperMario.stage.setCameraX(116* Map.BLOCK_SIZE);
			Stage.camUpdate = true;
		}
		if (stageNumber ==3) {
		}
	}
	

	
}



