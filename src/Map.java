
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
	protected static int mapWidth; //maybe standardize it at a certain #?
	protected static String path = System.getProperty("user.dir") + "/src/images/";
	
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
		this.marioSpawnCoord[0] = 48;
		//y assuming floor at y:864 (2 blocks above bottom)
		this.marioSpawnCoord[1] = 864;
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
			bgImage = new BufferedImage(1200, 900, BufferedImage.TYPE_INT_ARGB);
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
			for (int i = 0; i < 200; i++) { //assume making 200 floor tiles
				//floor assumption: length & width = 16; y starts at 864; floorType 1
					//public Floor(int floorType, int x, int y,int length, int width)
				allObj.add(new Floor(1, i*16, 100, 16 , 16));
			}
			//block objects creation
				//block assumption: object type#: 1 (just one type for now); length & width = 16; y starts at 832;
					//public Block(int blockType, int x, int y,int length, int width)
				//x = 23,25,27 (just for tesing...)
			allObj.add(new Block(1, 23*16, 832, 16 , 16));
			allObj.add(new Block(1, 25*16, 832, 16 , 16));
			allObj.add(new Block(1, 27*16, 832, 16 , 16));

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
