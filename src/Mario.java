import java.awt.Image;
import java.util.List;

public class Mario extends Charactor{
//	by Zehao: you can access status of key pressed using 
//	SuperMario.isJumpPressed(), SuperMario.isRightPressed(), SuperMario.isLeftPressed()
	private int x;
	private int y;
	private int x_speed;
	private int y_speed;
	
	private List<GameObject> allObj = null;
	private List<Enemy> allEnemy = null;
	
	public Mario(int x, int y) {
		
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
	
}
