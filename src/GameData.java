import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.JFrame;

public class GameData implements java.io.Serializable{
// for saving feature
	private int stageNumber = 1;
	private int marioLives = 3;
	private int score = 0;
	private int coins=0;
	private boolean hasStarted = false;
	private Stage stage;
	private List<GameObject> interactives;
	private boolean camUpdate;
	
	private List<GameObject> allObj = null;
	private List<Enemy> allEnemy = null;

	
	public GameData() {
	}
	
	public void save() {
		this.stage = SuperMario.stage;
		this.hasStarted=SuperMario.hasStarted;
		this.coins=SuperMario.coins;
		this.score=SuperMario.score;
		this.marioLives=SuperMario.marioLives;
		this.stageNumber=SuperMario.stageNumber;
		
		this.interactives = Stage.interactives;
		this.camUpdate = Stage.camUpdate;
		
		this.allObj = Map.allObj;
		this.allEnemy = Map.allEnemy;
		
		this.interactives.removeAll(interactives);
		if (allObj!=null) {
		for(GameObject obj: allObj) {
			obj.clear();
		}
		for(Enemy obj: allEnemy) {
			obj.clear();
		}
		}
		try {
		FileOutputStream fos = new FileOutputStream("mario.sav");
	      ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(this);
			oos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (allObj!=null) {
			for(GameObject obj: allObj) {
				obj.reload();
			}
			for(Enemy obj: allEnemy) {
				obj.reload();
			}
		}
	    }
	public void load() {
		SuperMario.stage=this.stage;
		SuperMario.hasStarted=this.hasStarted;
		SuperMario.coins=this.coins;
		SuperMario.score=this.score;
		SuperMario.marioLives=this.marioLives;
		SuperMario.stageNumber=this.stageNumber;
		new Map(stageNumber);
		Stage.interactives = this.interactives;
		Stage.camUpdate = this.camUpdate;
		
		Map.allEnemy=this.allEnemy;
		Map.allObj = this.allObj;
		if (allObj!=null) {
		for(GameObject obj: allObj) {
			obj.reload();
		}
		for(Enemy obj: allEnemy) {
			obj.reload();
		}
		}
		
	}
}
