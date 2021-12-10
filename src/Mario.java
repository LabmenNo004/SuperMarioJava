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
		this.image = getMarioImage(); 
		
	}
	
	public void run() {
		
	}
	
	public BufferedImage getMarioImage (){
		//set background
		try {
			maImage = new BufferedImage(Map.getMarioSpawnCoord()[0],Map.getMarioSpawnCoord()[1], BufferedImage.TYPE_INT_ARGB);
			System.out.println("mario image loaded");
			maImage = ImageIO.read(new File(path+"marioRight"+".png"));// user.dir/scr/images/bg#.png
			
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
		addingGravity();
//		if(x+length>400) x = 400-length;   //   to control Mario not go out of the screen
//		if(y+width>318) y = 318-width;
	}


	public void rightCollide(GameObject obj) {}

	public void leftCollide(GameObject obj) {}

	public void upCollide(GameObject obj) {					
//		this.jumping=true;
		this.setVelY(0);}

	public void downCollide(GameObject obj) {
//		this.falling = false;
//		this.jumping = false;
		this.setVelY(0);
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
		
	}
	public void rightReleased() {
		setVelX(0);

	}
	public void leftPressed() {
		setVelX(-5);
		
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

		velY += 1;
		setVelY(velY);
		

	//}
	
}
	
}
