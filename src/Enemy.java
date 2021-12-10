import java.awt.Graphics;
import java.awt.Image;

public class Enemy extends Charactor{
	
	public Enemy() {
		super();
	}
	
	public Enemy(int x, int y, int length, int width, Handler handler) {
		super(x,  y,  length,  width,  handler);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
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
//			if(x+length>400) x = 400-length;   //   to control Mario not go out of the screen
//			if(y+width>318) y = 318-width;
	}
	public void addingGravity() {
		int velY = this.VelY;
		//if(jumping) {

			velY += 1;
			setVelY(velY);
	
}

	@Override
	public void rightCollide(GameObject obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leftCollide(GameObject obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void upCollide(GameObject obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void downCollide(GameObject obj) {
		// TODO Auto-generated method stub
		
	}





}
