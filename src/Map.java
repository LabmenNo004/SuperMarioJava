import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Map {
	private Image bgImage = null;
	private List<GameObject> allObj = null;
	private List<Enemy> allEnemy = null;
	private int[] marioSpawnCoord = null;
	private int mapWidth;
	
	public Map(int stageNumber) {
		allObj = new ArrayList<>();
		//...
	}
	
	
	public Image getBgImage() {
		return bgImage;
	}

	public List<GameObject> getAllObj() {
		return allObj;
	}


	public List<Enemy> getAllEnemy() {
		return allEnemy;
	}


	public int[] getMarioSpawnCoord() {
		return marioSpawnCoord;
	}
	
	public int getWidth() {
		//return map width
		return mapWidth;
	}
	
}
