
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Map {
	protected static BufferedImage bgImage = null;
	protected static List<GameObject> allObj = null;
	protected static List<Enemy> allEnemy = null;
	protected static int[] marioSpawnCoord = null; //[x,y]
	protected static int mapWidth = SuperMario.getWIDTH();
	protected static int mapHeight = SuperMario.getHEIGHT()-23-16; //max/lowest pixel of the game
	protected static String path = System.getProperty("user.dir") + "/src/images/";
	protected static int BLOCK_SIZE = 16; //constant of each block legth and width
	
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
		//x assuming x starts at 0, will give a bit space (3 blocks)
		this.marioSpawnCoord[0] = BLOCK_SIZE*3;
		//y assuming floor at y:mapHeight - 3 blocks (3 blocks above bottom; 2 blocks of floor)
		this.marioSpawnCoord[1] = mapHeight-(BLOCK_SIZE*3);
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
		//set background
		try {
			bgImage = new BufferedImage(SuperMario.getWIDTH(), SuperMario.getHEIGHT(), BufferedImage.TYPE_INT_ARGB);
			bgImage = ImageIO.read(new File(path+ "bg"+ stageNumber +".png"));// user.dir/scr/images/bg#.png
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("failed to import background image");
			e.printStackTrace();
		} 

		//ALL subject to change for below, syntax are drafted:
		if (stageNumber == 1) {
		//stage 1
			//floor objects creation:
			for (int i = 0; i < 100; i++) { //assume making 100 floor tiles
				//floor assumption: length & width = 16; y starts at mapHeight - 2 blocks ; floorType 1
					//public Floor(int floorType, int x, int y,int length, int width)
				allObj.add(new Floor(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
				allObj.add(new Floor(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*1), BLOCK_SIZE , BLOCK_SIZE)); //lowest level
			}
			//block objects creation
				//block assumption: object type#: 1 (just one type for now); length & width = 16; y starts at mapHeight - 3 blocks min.;
					//public Block(int blockType, int x, int y,int length, int width)
				//x = 23,25,27 blocks (just for tesing...)
			allObj.add(new Block(1, 23*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*5), BLOCK_SIZE , BLOCK_SIZE));
			allObj.add(new Block(1, 25*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*5), BLOCK_SIZE , BLOCK_SIZE));
			allObj.add(new Block(1, 27*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*5), BLOCK_SIZE , BLOCK_SIZE));

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
	public int getHeight() {
		//return map height
		return mapHeight;
	}

}
