import java.awt.Graphics;
import java.awt.Image;

public class Enemy extends Charactor{
	
	public Enemy() {
		super();
	}
	
	public Enemy(int x, int y, int length, int width) {
		super(x,  y,  length,  width);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick() {
	}
	public void addingGravity() {
		int velY = this.VelY;
		//if(jumping) {

			velY += 1;
			setVelY(velY);
	
}
	public void reload() {
		
	}
	public void clear() {
		this.image = null;
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
