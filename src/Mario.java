import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.util.List;
import  java.awt.Rectangle;

public class Mario extends Charactor{
//	by Zehao: you can access status of key pressed using 
//	SuperMario.isJumpPressed(), SuperMario.isRightPressed(), SuperMario.isLeftPressed()

	
	private List<GameObject> allObj = null;
	private List<Enemy> allEnemy = null;
	
	public Mario(int x, int y,int length, int width, Id id, Handler handler) {
		super(x,y,length,width,id,handler);
		
	}
	
	public void run() {
		
	}
	
	public Image getImage() {
		//image
		return null;
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
		if(x+length>400) x = 400-length;   //   to control Mario not go out of the screen
		if(y+width>318) y = 318-width;
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		g.fillRect(x,y,length,width);
		
	}
	
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
		
	}
		
}
