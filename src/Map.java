import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Map {
	private BufferedImage bgImage = null;
	private List<GameObject> allObj = null;
	private List<Enemy> allEnemy = null;
	private int[] marioSpawnCoord = null; //[x,y]
	private static int mapWidth; //maybe standardize it at a certain #?
	
	public Map(int stageNumber) {
		allObj = new ArrayList<>();
		//...
		/**given stageNumber, will create the Map object, GameObjects stored in allObj with the corr. private things above*/
		stageObjectCreation(stageNumber);
		stageEnemyCreation(stageNumber);
		stageMarioSpawn(stageNumber);
		
	}
	
	public void stageMarioSpawn (int stageNumber) {
		//at the beginning
		marioSpawnCoord = new int[2];
		//x assuming x starts at 0, will give a bit space
		this.marioSpawnCoord[0] = 10;
		//y assuming floor at y:500
		this.marioSpawnCoord[1] = 501;
		//may add other spawn point based on stage later
	}

	public void stageEnemyCreation (int stageNumber) {
		allEnemy = new ArrayList<>();
		
		//will expect something like add certain enemy based on a # or name etc.
		if (stageNumber == 1) {
		//stage 1
			//Enemy character creation: assume character# is 0
				//need to know: Enemy type#, spawn coords
				allEnemy.add(new Enemy( ));
				
			}
		
		else if (stageNumber == 2) {
			//stage 2
		}

		else if (stageNumber == 3) {
			//stage 3			
		}
	}
	
	
	
	//each stage "Floorplan"
	public void stageObjectCreation (int stageNumber){
		//ALL subject to change for below, syntax are drafted:
		if (stageNumber == 1) {
		//stage 1
			//floor objects creation: assume type# is 0
			for (int i = 0; i < 200; i++) { //assume making 200 floor tiles
				//floor assumption: length & width = 1; y starts at 500
					//public GameObject(int type, int x, int y, int length, int width)
				allObj.add(new GameObject(0, i, 500, 1 , 1));
			}
			//block objects creation
				//block assumption: object type#: 10 (just one type for now); length & width = 1; y starts at 400;
				//x = 23 (just for tesing...)
			allObj.add(new GameObject(10, 23, 400, 1 , 1));
			allObj.add(new GameObject(10, 25, 400, 1 , 1));
			allObj.add(new GameObject(10, 27, 400, 1 , 1));

			//pipe object creation
				//will be similar to above once we tested out if above works
			
		}
		else if (stageNumber == 2) {
			//stage 2
		}

		else if (stageNumber == 3) {
			//stage 3			
		}
	}
	
	//Getters
	public BufferedImage getBgImage() {
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
