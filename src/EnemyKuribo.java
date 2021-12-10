import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;
import java.awt.Image;
import java.util.List;

import javax.imageio.ImageIO;

import  java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EnemyKuribo extends Enemy{
	
	private List<GameObject> allObj = null;
	private List<Enemy> allEnemy = null;
	protected static BufferedImage KuriImage = null;
	public Handler handler;
	
	
	
	public EnemyKuribo(int x, int y,int length, int width, Handler handler) {
		super(x,y,length,width,handler);
		this.image = KuriImage(); 
}
	public BufferedImage KuriImage (){
		//set background
		try {
			KuriImage = new BufferedImage(Map.getMarioSpawnCoord()[0],Map.getMarioSpawnCoord()[1], BufferedImage.TYPE_INT_ARGB);
			System.out.println("kuribo image loaded");
			KuriImage = ImageIO.read(new File(path+"kuribou1"+".png"));// user.dir/scr/images/bg#.png
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("failed to import background image");
			e.printStackTrace();
		} 
		return KuriImage;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	


	public void randomWalk() {
			Random rand = new Random();
			int walkNumber = rand.nextInt(1000);
			if (walkNumber<500) setVelX(-1);
			else {
				setVelX(1);
			}
		}

		public void tick() {
			// TODO Auto-generated method stub
			x+=VelX;
			y+=VelY;
			if(x<=0) x=0;
			if(y<=0) y=0;
			collisionDetection();
			addingGravity();
			randomWalk();
			
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
}