import java.awt.Image;
import java.util.List;

public class Mario extends Charactor{
	private int x;
	private int y;
	private int x_speed;
	private int y_speed;
	private boolean leftPressed;
	private boolean rightPressed;
	private boolean jumpPressed;
	
	private List<GameObject> allObj = null;
	private List<Enemy> allEnemy = null;
	
	public Mario(int x, int y) {
		
	}
	
	public void run() {
		
	}
	
	public Image getImage() {
		//图片
		return null;
	}
	
	public void setObjects(List<GameObject> allObj) {
		this.allObj = allObj;
	}

	public void setLeftPressed(boolean leftPressed) {
		this.leftPressed = leftPressed;
	}

	public void setRightPressed(boolean rightPressed) {
		this.rightPressed = rightPressed;
	}

	public void setJumpPressed(boolean jumpPressed) {
		this.jumpPressed = jumpPressed;
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
