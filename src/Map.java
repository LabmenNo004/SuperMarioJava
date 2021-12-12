
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
	protected static final int BLOCK_SIZE = 16; //constant of each block legth and width
	protected static int flagX;
	public Map(int stageNumber) {
		allObj = new ArrayList<>();
		allEnemy = new ArrayList<>();
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
			//below are testing location
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*6, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*8, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*10, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*75, mapHeight-(BLOCK_SIZE*10), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*78, mapHeight-(BLOCK_SIZE*10), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*79, mapHeight-(BLOCK_SIZE*10), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*80, mapHeight-(BLOCK_SIZE*10), BLOCK_SIZE, BLOCK_SIZE));

				//need to know: Enemy type#, spawn coords
				//allEnemy.add(new EnemyKuribo(getMarioSpawnCoord()[0]+50,getMarioSpawnCoord()[1],12,12));
		
			}
		else if (stageNumber == 2) {
			//stage 2
		}
		else if (stageNumber == 3) {
			//stage 3			
		}
	}
	
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
		
		//Stage Object Initialization
		if (stageNumber == 1) {
			//stage 1
			stageOneObjIniti();
			flagX = 198*BLOCK_SIZE;
			mapWidth = 3520;
		}
		else if (stageNumber == 2) {
			//stage 2
			stageTwoObjIniti();
			flagX = 165*BLOCK_SIZE;
			mapWidth = 3520;
		}
		else if (stageNumber == 3) {
			//stage 3
			stageThreeObjIniti();
		}
	}

	//each stage "Floorplan"----------------------------------------
	public void stageOneObjIniti() {
		//floor objects creation:
		//empty floor list:
		//x:70,71; 87,88,89; 154,155
	for (int i = 0; i < 70; i++) { //assume making 100 floor tiles
		//floor assumption: length & width = 16; y starts at mapHeight - 2 blocks ; floorType 1
			//public Floor(int floorType, int x, int y,int length, int width)
		allObj.add(new Floor(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
		allObj.add(new Floor(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*1), BLOCK_SIZE , BLOCK_SIZE)); //lowest level
	}
	for (int i = 72; i < 87; i++) { 
		allObj.add(new Floor(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
		allObj.add(new Floor(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*1), BLOCK_SIZE , BLOCK_SIZE)); //lowest level
	}
	for (int i = 90; i < 154; i++) { //
		allObj.add(new Floor(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
		allObj.add(new Floor(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*1), BLOCK_SIZE , BLOCK_SIZE)); //lowest level
	}
	for (int i = 156; i < 221; i++) { //last tile is 220
		allObj.add(new Floor(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
		allObj.add(new Floor(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*1), BLOCK_SIZE , BLOCK_SIZE)); //lowest level
	}
	
	//block objects creation
		//block assumption: object type#: 1 (just one type for now); length & width = 16; y starts at mapHeight - 3 blocks min.;
			//public Block(int blockType, int x, int y,int length, int width)
	allObj.add(new Block(3, 17*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));//item box
	allObj.add(new Block(1, 21*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));
	allObj.add(new Block(3, 22*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));//item box
	allObj.add(new Block(1, 23*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));
	allObj.add(new Block(3, 23*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*10), BLOCK_SIZE , BLOCK_SIZE));//item box
	allObj.add(new Block(3, 24*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));//item box
	allObj.add(new Block(1, 25*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));

	allObj.add(new Block(1, 78*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));
	allObj.add(new Block(3, 79*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));//item box
	allObj.add(new Block(1, 80*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));
	
	for (int i =81; i<= 88; i++) {
	allObj.add(new Block(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*10), BLOCK_SIZE , BLOCK_SIZE));
	}

	allObj.add(new Block(1, 92*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*10), BLOCK_SIZE , BLOCK_SIZE));
	allObj.add(new Block(1, 93*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*10), BLOCK_SIZE , BLOCK_SIZE));
	allObj.add(new Block(1, 94*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*10), BLOCK_SIZE , BLOCK_SIZE));
	allObj.add(new Block(3, 95*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*10), BLOCK_SIZE , BLOCK_SIZE));

	allObj.add(new Block(1, 95*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));
	allObj.add(new Block(1, 101*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));
	allObj.add(new Block(1, 102*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));

	allObj.add(new Block(3, 107*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));
	allObj.add(new Block(3, 110*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));
	allObj.add(new Block(3, 110*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*10), BLOCK_SIZE , BLOCK_SIZE));
	allObj.add(new Block(3, 113*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));

	allObj.add(new Block(1, 119*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));
	allObj.add(new Block(1, 122*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*10), BLOCK_SIZE , BLOCK_SIZE));
	allObj.add(new Block(1, 123*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*10), BLOCK_SIZE , BLOCK_SIZE));
	allObj.add(new Block(1, 124*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*10), BLOCK_SIZE , BLOCK_SIZE));
	
	allObj.add(new Block(1, 129*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*10), BLOCK_SIZE , BLOCK_SIZE));
	allObj.add(new Block(3, 130*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*10), BLOCK_SIZE , BLOCK_SIZE));
	allObj.add(new Block(1, 130*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));
	allObj.add(new Block(3, 131*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*10), BLOCK_SIZE , BLOCK_SIZE));
	allObj.add(new Block(1, 131*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));
	allObj.add(new Block(1, 132*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*10), BLOCK_SIZE , BLOCK_SIZE));

	for (int i = 135; i <= 138; i++) {
		allObj.add(new Block(4, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE , BLOCK_SIZE));
	}
	for (int i = 136; i <= 138; i++) {
		allObj.add(new Block(4, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE , BLOCK_SIZE));
	}
	for (int i = 137; i <= 138; i++) {
		allObj.add(new Block(4, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*5), BLOCK_SIZE , BLOCK_SIZE));
	}
	allObj.add(new Block(4, 138*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));

	allObj.add(new Block(4, 141*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));
	for (int i = 141; i <= 142; i++) {
		allObj.add(new Block(4, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*5), BLOCK_SIZE , BLOCK_SIZE));
	}
	for (int i = 141; i <= 143; i++) {
		allObj.add(new Block(4, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE , BLOCK_SIZE));
	}
	for (int i = 141; i <= 144; i++) {
		allObj.add(new Block(4, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE , BLOCK_SIZE));
	}
	
	for (int i = 149; i <= 153; i++) {
		allObj.add(new Block(4, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE , BLOCK_SIZE));
	}
	for (int i = 150; i <= 153; i++) {
		allObj.add(new Block(4, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE , BLOCK_SIZE));
	}
	for (int i = 151; i <= 153; i++) {
		allObj.add(new Block(4, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*5), BLOCK_SIZE , BLOCK_SIZE));
	}
	for (int i = 152; i <= 153; i++) {
		allObj.add(new Block(4, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));
	}

	allObj.add(new Block(4, 156*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));
	for (int i = 156; i <= 157; i++) {
		allObj.add(new Block(4, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*5), BLOCK_SIZE , BLOCK_SIZE));
	}
	for (int i = 156; i <= 158; i++) {
		allObj.add(new Block(4, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE , BLOCK_SIZE));
	}
	for (int i = 156; i <= 159; i++) {
		allObj.add(new Block(4, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE , BLOCK_SIZE));
	}

	allObj.add(new Block(1, 169*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));
	allObj.add(new Block(1, 170*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));
	allObj.add(new Block(3, 171*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));
	allObj.add(new Block(1, 172*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));

	for (int j = 182;j<=189;j++) {
		for (int i = 3; i<j-178;i++) {
			allObj.add(new Block(4, j*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
		}
	}
	for (int i =3 ; i<=10;i++ ) {
		allObj.add(new Block(4, 190*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
	}

	//pipe object creation
		//will be similar to above once we tested out if above works
	allObj.add(new PipeHead(1, 29*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE*2 , BLOCK_SIZE*2));
	allObj.add(new PipeBody(1, 29*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE*2 , BLOCK_SIZE*2));
	
	allObj.add(new PipeHead(1, 39*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*5), BLOCK_SIZE*2 , BLOCK_SIZE*2));
	allObj.add(new PipeBody(1, 39*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE*2 , BLOCK_SIZE*2));
	allObj.add(new PipeBody(1, 39*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE*2 , BLOCK_SIZE*2));
	
	allObj.add(new PipeHead(1, 47*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE*2 , BLOCK_SIZE*2));
	allObj.add(new PipeBody(1, 47*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*5), BLOCK_SIZE*2 , BLOCK_SIZE*2));
	allObj.add(new PipeBody(1, 47*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE*2 , BLOCK_SIZE*2));
	allObj.add(new PipeBody(1, 47*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE*2 , BLOCK_SIZE*2));

	allObj.add(new PipeHead(1, 58*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE*2 , BLOCK_SIZE*2));
	allObj.add(new PipeBody(1, 58*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*5), BLOCK_SIZE*2 , BLOCK_SIZE*2));
	allObj.add(new PipeBody(1, 58*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE*2 , BLOCK_SIZE*2));
	allObj.add(new PipeBody(1, 58*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE*2 , BLOCK_SIZE*2));
	
	allObj.add(new PipeHead(1, 164*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE*2 , BLOCK_SIZE*2));
	allObj.add(new PipeBody(1, 164*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE*2 , BLOCK_SIZE*2));

	allObj.add(new PipeHead(1, 180*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE*2 , BLOCK_SIZE*2));
	allObj.add(new PipeBody(1, 180*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE*2 , BLOCK_SIZE*2));
	
	//flagPole object creation
	allObj.add(new Block(4, 198*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE , BLOCK_SIZE));
	allObj.add(new FlagPole(1, 198*BLOCK_SIZE, (int)(mapHeight-(BLOCK_SIZE*12.5)), BLOCK_SIZE , BLOCK_SIZE));
	allObj.add(new Flag(1, 198*BLOCK_SIZE-8, mapHeight-(BLOCK_SIZE*12), BLOCK_SIZE , BLOCK_SIZE)); //flag in the middle of a block (of the pole), need to go down once goal is hit
	
	//castle
	allObj.add(new Castle(1, 203*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*7), BLOCK_SIZE*5 , BLOCK_SIZE*5));//5 blocks of height
	//

	}

	public void stageTwoObjIniti() {
	//floor objects creation:
		//empty floor list:
		//x:81-83; 121,122; 125,126; 139-145; 154-161
		for (int i = 0; i < 80; i++) { //assume making 100 floor tiles
			//floor assumption: length & width = 16; y starts at mapHeight - 2 blocks ; floorType 1
			//public Floor(int floorType, int x, int y,int length, int width)
			allObj.add(new Floor(2, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			allObj.add(new Floor(2, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*1), BLOCK_SIZE , BLOCK_SIZE)); //lowest level
		}
		for (int i = 84; i <= 120; i++) { //assume making 100 floor tiles
			//floor assumption: length & width = 16; y starts at mapHeight - 2 blocks ; floorType 1
			//public Floor(int floorType, int x, int y,int length, int width)
			allObj.add(new Floor(2, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			allObj.add(new Floor(2, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*1), BLOCK_SIZE , BLOCK_SIZE)); //lowest level
		}
		for (int i = 123; i <= 124; i++) { //assume making 100 floor tiles
			//floor assumption: length & width = 16; y starts at mapHeight - 2 blocks ; floorType 1
			//public Floor(int floorType, int x, int y,int length, int width)
			allObj.add(new Floor(2, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			allObj.add(new Floor(2, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*1), BLOCK_SIZE , BLOCK_SIZE)); //lowest level
		}
		for (int i = 127; i <= 138; i++) { //assume making 100 floor tiles
			//floor assumption: length & width = 16; y starts at mapHeight - 2 blocks ; floorType 1
			//public Floor(int floorType, int x, int y,int length, int width)
			allObj.add(new Floor(2, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			allObj.add(new Floor(2, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*1), BLOCK_SIZE , BLOCK_SIZE)); //lowest level
		}
		for (int i = 146; i <= 153; i++) { //assume making 100 floor tiles
			//floor assumption: length & width = 16; y starts at mapHeight - 2 blocks ; floorType 1
			//public Floor(int floorType, int x, int y,int length, int width)
			allObj.add(new Floor(2, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			allObj.add(new Floor(2, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*1), BLOCK_SIZE , BLOCK_SIZE)); //lowest level
		}
		for (int i = 162; i <= 193; i++) { //assume making 100 floor tiles
			//floor assumption: length & width = 16; y starts at mapHeight - 2 blocks ; floorType 1
			//public Floor(int floorType, int x, int y,int length, int width)
			allObj.add(new Floor(2, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			allObj.add(new Floor(2, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*1), BLOCK_SIZE , BLOCK_SIZE)); //lowest level
		}
		
	//block objects creation
		//block assumption: object type#: 1 (just one type for now); length & width = 16; y starts at mapHeight - 3 blocks min.;
			//public Block(int blockType, int x, int y,int length, int width)

		//item box --> block 3
		for (int i = 11; i <=15; i++) {
			allObj.add(new Block(3, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));
		}

		//normal block --> block 6
		for (int i = 7 ; i<138; i++) {
			allObj.add(new Block(6, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*13), BLOCK_SIZE , BLOCK_SIZE));
		}
		for (int i = 3 ; i<14; i++) {
			allObj.add(new Block(6, 0*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
		}
		allObj.add(new Block(6, 30*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*7), BLOCK_SIZE , BLOCK_SIZE));
		
		for (int i = 3 ; i<14; i++) {
			allObj.add(new Block(6, 0*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
		}
		
		for (int i = 6 ; i<=8; i++ ) {
			allObj.add(new Block(6, 40*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
		}
		allObj.add(new Block(6, 41*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));		
		for (int i = 6 ; i<=8; i++ ) {
			allObj.add(new Block(6, 42*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
		}
		allObj.add(new Block(6, 43*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*8), BLOCK_SIZE , BLOCK_SIZE));		
		allObj.add(new Block(6, 44*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*8), BLOCK_SIZE , BLOCK_SIZE));		
		for (int i = 6 ; i<=8; i++ ) {
			allObj.add(new Block(6, 45*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
		}
		allObj.add(new Block(6, 46*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));		
		for (int i = 6 ; i<=8; i++ ) {
			allObj.add(new Block(6, 47*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
		}

		for (int i = 6 ; i<=10; i++ ) {
			allObj.add(new Block(6, 53*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
			allObj.add(new Block(6, 54*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
			allObj.add(new Block(6, 63*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
			allObj.add(new Block(6, 64*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
			allObj.add(new Block(6, 68*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
			allObj.add(new Block(6, 73*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
			allObj.add(new Block(6, 74*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
		}

		for (int i = 11 ; i<=12; i++ ) {
			allObj.add(new Block(6, 55*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
			allObj.add(new Block(6, 56*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
			for (int j = 59; j<=64;j++) {
				allObj.add(new Block(6, j*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));				
			}
			for (int k = 67; k<=70;k++) {
				allObj.add(new Block(6, k*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));				
			}
			for (int l = 77; l<=80;l++) {
				allObj.add(new Block(6, l*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));				
			}
		}
		

		
		for (int i = 85; i<=90; i++) {			
			allObj.add(new Block(6, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*7), BLOCK_SIZE , BLOCK_SIZE));
			allObj.add(new Block(6, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*8), BLOCK_SIZE , BLOCK_SIZE));				
		}		
		for (int i =123 ; i<=124;i++ ) {
			allObj.add(new Block(6, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE , BLOCK_SIZE));
			allObj.add(new Block(6, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE , BLOCK_SIZE));
			allObj.add(new Block(6, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*5), BLOCK_SIZE , BLOCK_SIZE));
		}
		for (int i = 146; i<=151; i++) {			
			allObj.add(new Block(6, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*7), BLOCK_SIZE , BLOCK_SIZE));
		}		

		
		//wall block --> block 7
		allObj.add(new Block(7, 18*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE , BLOCK_SIZE));
		for (int i = 3 ; i<=4; i++ ) {
			allObj.add(new Block(7, 20*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
		}
		for (int i = 3 ; i<=5; i++ ) {
			allObj.add(new Block(7, 22*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
		}
		for (int i = 3 ; i<=6; i++ ) {
			allObj.add(new Block(7, 24*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
		}
		for (int i = 3 ; i<=6; i++ ) {
			allObj.add(new Block(7, 26*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
		}
		for (int i = 3 ; i<=5; i++ ) {
			allObj.add(new Block(7, 28*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
		}
		for (int i = 3 ; i<=5; i++ ) {
			allObj.add(new Block(7, 32*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
		}
		for (int i = 3 ; i<=4; i++ ) {
			allObj.add(new Block(7, 34*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
		}
		for (int j = 134;j<=137;j++) {
			for (int i = 3; i<j-130;i++) {
				allObj.add(new Block(7, j*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
			}
		}
		for (int i =3 ; i<=6;i++ ) {
			allObj.add(new Block(7, 138*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));
		}
		


		
	//pipe object creation
		//will be similar to above once we tested out if above works
		allObj.add(new PipeHead(1, 104*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*5), BLOCK_SIZE*2 , BLOCK_SIZE*2));
		allObj.add(new PipeBody(1, 104*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE*2 , BLOCK_SIZE*2));
		allObj.add(new PipeBody(1, 104*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE*2 , BLOCK_SIZE*2));

		allObj.add(new PipeHead(1, 110*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE*2 , BLOCK_SIZE*2));
		allObj.add(new PipeBody(1, 110*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*5), BLOCK_SIZE*2 , BLOCK_SIZE*2));
		allObj.add(new PipeBody(1, 110*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE*2 , BLOCK_SIZE*2));
		allObj.add(new PipeBody(1, 110*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE*2 , BLOCK_SIZE*2));

		allObj.add(new PipeHead(1, 116*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE*2 , BLOCK_SIZE*2));
		allObj.add(new PipeBody(1, 116*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE*2 , BLOCK_SIZE*2));

	//flagPole object creation
		allObj.add(new FlagPole(1, 165*BLOCK_SIZE, (int)(mapHeight-(BLOCK_SIZE*12.5)), BLOCK_SIZE , BLOCK_SIZE));
		allObj.add(new Flag(1, 165*BLOCK_SIZE-8, mapHeight-(BLOCK_SIZE*12), BLOCK_SIZE , BLOCK_SIZE)); //flag in the middle of a block (of the pole), need to go down once goal is hit
		allObj.add(new Block(7, 165*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE , BLOCK_SIZE));

	}
	public void stageThreeObjIniti() {}
	
	//--------------------------------------------------------------
	
	//Getters
	public BufferedImage getBgImage() {
		return bgImage;
	}
	public static List<GameObject> getAllObj() {
		return allObj;
	}
	public static List<Enemy> getAllEnemy() {
		return allEnemy;
	}
	public static int[] getMarioSpawnCoord() {
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
