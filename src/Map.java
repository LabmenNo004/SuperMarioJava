
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Map implements java.io.Serializable{
	protected static BufferedImage bgImage = null;
	protected static List<GameObject> allObj = null;
	protected static List<Enemy> allEnemy = null;
	protected static int[] marioSpawnCoord = null; //[x,y]
	protected static int mapWidth = SuperMario.getWIDTH();
	protected static int mapHeight = SuperMario.getHEIGHT()-23-16; //max/lowest pixel of the game
	protected static String path = System.getProperty("user.dir") + "/src/images/";
	protected static final int BLOCK_SIZE = 16; //constant of each block legth and width
	protected static int flagX;
	protected Flag flag; //	
	protected static PipeHead hiddenPipeIn; //1st in
	protected static PipeHead hiddenPipeExit; //exit room
	protected static PipeHead hiddenPipeOut; //back to main map
	
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
		
		//TESTING:
		//this.marioSpawnCoord[0] = BLOCK_SIZE*(100); 
		//this.marioSpawnCoord[1] = mapHeight-(BLOCK_SIZE*15);

	}
	


	public void stageEnemyCreation (int stageNumber) {
		allEnemy = new ArrayList<>();
		//will expect something like add certain enemy based on a # or name etc.
		if (stageNumber == 1) {
		//stage 1
			//Enemy character creation: assume character# is 0
			//below are temp location
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*28, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*29, mapHeight-(BLOCK_SIZE*5), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*32, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*48, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*50, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*52, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*68, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*84, mapHeight-(BLOCK_SIZE*11), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*110, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*112, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*148, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*178, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*187, mapHeight-(BLOCK_SIZE*11), BLOCK_SIZE, BLOCK_SIZE));
				//need to know: Enemy type#, spawn coords
				//allEnemy.add(new EnemyKuribo(getMarioSpawnCoord()[0]+50,getMarioSpawnCoord()[1],16,16));
		
			}
		else if (stageNumber == 2) {
			//stage 2
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*17, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*38, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*44, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*60, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*62, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*64, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*75, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*95, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*97, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*112, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*132, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
		}
		else if (stageNumber == 3) {
			//stage 3
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*29, mapHeight-(BLOCK_SIZE*7), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*30, mapHeight-(BLOCK_SIZE*7), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*31, mapHeight-(BLOCK_SIZE*7), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*29, mapHeight-(BLOCK_SIZE*11), BLOCK_SIZE, BLOCK_SIZE));			
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*45, mapHeight-(BLOCK_SIZE*12), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*46, mapHeight-(BLOCK_SIZE*12), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*47, mapHeight-(BLOCK_SIZE*12), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*62, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*67, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));			
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*68, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*69, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*73, mapHeight-(BLOCK_SIZE*7), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*80, mapHeight-(BLOCK_SIZE*10), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*81, mapHeight-(BLOCK_SIZE*10), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*106, mapHeight-(BLOCK_SIZE*9), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*107, mapHeight-(BLOCK_SIZE*9), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*108, mapHeight-(BLOCK_SIZE*9), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*118, mapHeight-(BLOCK_SIZE*8), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*119, mapHeight-(BLOCK_SIZE*8), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*132, mapHeight-(BLOCK_SIZE*10), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*135, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE, BLOCK_SIZE));
			allEnemy.add(new EnemyKuribo(BLOCK_SIZE*142, mapHeight-(BLOCK_SIZE*9), BLOCK_SIZE, BLOCK_SIZE));
			


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
			mapWidth = 4220;
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
			flagX = 153*BLOCK_SIZE;
			mapWidth = 3520;
		}
	}

	//each stage "Floorplan"----------------------------------------
	public void stageOneObjIniti() {
		//HiddenRoom--------------------------------------------------------------
		//Starting Point: x: 221 y: 15
		//floor
		for (int i = 220; i <= 243; i++) { //assume making 100 floor tiles
			//floor assumption: length & width = 16; y starts at mapHeight - 2 blocks ; floorType 1
			//public Floor(int floorType, int x, int y,int length, int width)
			allObj.add(new Floor(2, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			allObj.add(new Floor(2, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*1), BLOCK_SIZE , BLOCK_SIZE)); //lowest level
		}
		//normal blocks
			//left pillar
		for (int i = 0; i <13; i++) {
			allObj.add(new Block(6, 220*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*(3+i)), BLOCK_SIZE , BLOCK_SIZE));
		}
			//upper
		for (int i = 224; i <239; i++) {
			allObj.add(new Block(6, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*(15)), BLOCK_SIZE , BLOCK_SIZE));
		}
		for (int i = 224; i <239; i++) {
			for (int j = 0; j < 3; j++) {
				allObj.add(new Block(6, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*(3+j)), BLOCK_SIZE , BLOCK_SIZE));				
			}
		}
			//right pillar
		for (int i = 0; i <13; i++) {
			allObj.add(new Block(6, 243*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*(3+i)), BLOCK_SIZE , BLOCK_SIZE));
		}
		
		//pipe out
		hiddenPipeExit = new PipeHead(1, 241*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE*2 , BLOCK_SIZE*2,true); //has hidden passage
		allObj.add(hiddenPipeExit); 
		allObj.add(new PipeBody(1, 241*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE*2 , BLOCK_SIZE*2));
				
		//coin		
		for (int i = 224; i < 239 ; i++) {
			allObj.add(new Coin(i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*7), BLOCK_SIZE , BLOCK_SIZE));
			allObj.add(new Coin(i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));
		}
		for (int i = 225; i < 238 ; i++) {
			allObj.add(new Coin(i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*8), BLOCK_SIZE , BLOCK_SIZE));
		}
		

	//------------------------------------------------------------

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
	for (int i = 156; i < 220; i++) { //last tile is 220
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
	allObj.add(new PipeHead(1, 29*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE*2 , BLOCK_SIZE*2,false));
	allObj.add(new PipeBody(1, 29*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE*2 , BLOCK_SIZE*2));
	
	allObj.add(new PipeHead(1, 39*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*5), BLOCK_SIZE*2 , BLOCK_SIZE*2,false));
	allObj.add(new PipeBody(1, 39*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE*2 , BLOCK_SIZE*2));
	allObj.add(new PipeBody(1, 39*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE*2 , BLOCK_SIZE*2));
	
	allObj.add(new PipeHead(1, 47*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE*2 , BLOCK_SIZE*2,false));
	allObj.add(new PipeBody(1, 47*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*5), BLOCK_SIZE*2 , BLOCK_SIZE*2));
	allObj.add(new PipeBody(1, 47*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE*2 , BLOCK_SIZE*2));
	allObj.add(new PipeBody(1, 47*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE*2 , BLOCK_SIZE*2));

	hiddenPipeIn = new PipeHead(1, 58*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE*2 , BLOCK_SIZE*2,true); 
	allObj.add(hiddenPipeIn); //hidden path in
	allObj.add(new PipeBody(1, 58*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*5), BLOCK_SIZE*2 , BLOCK_SIZE*2));
	allObj.add(new PipeBody(1, 58*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE*2 , BLOCK_SIZE*2));
	allObj.add(new PipeBody(1, 58*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE*2 , BLOCK_SIZE*2));

	hiddenPipeOut = new PipeHead(1, 164*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE*2 , BLOCK_SIZE*2,false); //hidden pipe out
	allObj.add(hiddenPipeOut);
	allObj.add(new PipeBody(1, 164*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE*2 , BLOCK_SIZE*2));

	allObj.add(new PipeHead(1, 180*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE*2 , BLOCK_SIZE*2,false));
	allObj.add(new PipeBody(1, 180*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE*2 , BLOCK_SIZE*2));
	
	//flagPole object creation
	allObj.add(new Block(4, 198*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE , BLOCK_SIZE));
	allObj.add(new FlagPole(1, 198*BLOCK_SIZE, (int)(mapHeight-(BLOCK_SIZE*12.5)), BLOCK_SIZE , BLOCK_SIZE));
	flag = new Flag(1, 198*BLOCK_SIZE-8, mapHeight-(BLOCK_SIZE*12), BLOCK_SIZE , BLOCK_SIZE);
	allObj.add(flag); //flag in the middle of a block (of the pole), need to go down once goal is hit
	
	//castle
	allObj.add(new Castle(1, 203*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*7), BLOCK_SIZE*5 , BLOCK_SIZE*5));//5 blocks of height
	//

	}
	public void stageTwoObjIniti() {
	//HiddenRoom--------------------------------------------------------------
		//Starting Point: x: 183 y: 15
		//floor
		for (int i = 183; i <= 203; i++) { //assume making 100 floor tiles
			//floor assumption: length & width = 16; y starts at mapHeight - 2 blocks ; floorType 1
			//public Floor(int floorType, int x, int y,int length, int width)
			allObj.add(new Floor(2, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			allObj.add(new Floor(2, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*1), BLOCK_SIZE , BLOCK_SIZE)); //lowest level
		}
		//normal blocks
		for (int i = 0; i <13; i++) {
			allObj.add(new Block(6, 180*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*(3+i)), BLOCK_SIZE , BLOCK_SIZE));
		}
		for (int i = 183; i <203; i++) {
			for (int j = 0; j <5 ; j++) {
			allObj.add(new Block(6, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*(15-j)), BLOCK_SIZE , BLOCK_SIZE));
			}
		}
		for (int i = 183; i <200; i++) {
			allObj.add(new Block(6, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*(6)), BLOCK_SIZE , BLOCK_SIZE));
		}
		for (int i = 0; i <13; i++) {
			allObj.add(new Block(6, 203*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*(3+i)), BLOCK_SIZE , BLOCK_SIZE));
		}
		
		//pipe out
		hiddenPipeExit = new PipeHead(1, 201*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE*2 , BLOCK_SIZE*2,true); //has hidden passage
		allObj.add(hiddenPipeExit); 
		allObj.add(new PipeBody(1, 201*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE*2 , BLOCK_SIZE*2));
		
		//pipe in (no usage)
		allObj.add(new PipeBody(1, 181*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*17), BLOCK_SIZE*2 , BLOCK_SIZE*2));
		allObj.add(new PipeBody(1, 181*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*16), BLOCK_SIZE*2 , BLOCK_SIZE*2));
		allObj.add (new PipeHead(1, 181*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*15), BLOCK_SIZE*2 , BLOCK_SIZE*2,false));
		
		//coin
		for (int i = 183; i < 200 ; i++) {
			allObj.add(new Coin(i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*7), BLOCK_SIZE , BLOCK_SIZE));
			allObj.add(new Coin(i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE , BLOCK_SIZE));
		}

	//------------------------------------------------------------
	//coin objects creation:
		//no type, only 1
		for (int i = 42; i <= 45 ; i++) {
			allObj.add(new Coin(i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*10), BLOCK_SIZE , BLOCK_SIZE));
		}
		allObj.add(new Coin(41*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*7), BLOCK_SIZE , BLOCK_SIZE));
		allObj.add(new Coin(46*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*7), BLOCK_SIZE , BLOCK_SIZE));
		for (int i = 59; i <= 62 ; i++) {
			allObj.add(new Coin(i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*7), BLOCK_SIZE , BLOCK_SIZE));
		}
		allObj.add(new Coin(69*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*7), BLOCK_SIZE , BLOCK_SIZE));
		for (int i = 85; i <= 90 ; i++) {
			allObj.add(new Coin(i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*10), BLOCK_SIZE , BLOCK_SIZE));
		}
		
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
		for (int i = 162; i <= 182; i++) { //assume making 100 floor tiles
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
		for (int i = 4; i<=6;i++) {
			allObj.add(new Block(6, 55*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));				
			allObj.add(new Block(6, 56*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*i), BLOCK_SIZE , BLOCK_SIZE));				
		}
		for (int i = 59; i<=62;i++) {
			allObj.add(new Block(6, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));				
		}
		allObj.add(new Block(6, 69*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));				
	
		allObj.add(new Block(6, 70*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));				
		//allObj.add(new Block(6, 70*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*7), BLOCK_SIZE , BLOCK_SIZE)); //cancel since no big mario			
		for (int i = 77; i<=80;i++) {
			allObj.add(new Block(6, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE , BLOCK_SIZE));				
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
	//platform object creation
		allObj.add(new Platform(1, 156*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), (int)(BLOCK_SIZE*1) , BLOCK_SIZE*3));
		allObj.add(new Platform(1, 141*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), (int)(BLOCK_SIZE*0.7) , BLOCK_SIZE*3));
		allObj.add(new Platform(1, 141*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*8), (int)(BLOCK_SIZE*0.7) , BLOCK_SIZE*3));
		
	//pipe object creation
		//will be similar to above once we tested out if above works
		hiddenPipeIn = new PipeHead(1, 104*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*5), BLOCK_SIZE*2 , BLOCK_SIZE*2,true); //has hidden passage
		allObj.add(hiddenPipeIn); 
		allObj.add(new PipeBody(1, 104*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE*2 , BLOCK_SIZE*2));
		allObj.add(new PipeBody(1, 104*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE*2 , BLOCK_SIZE*2));

		allObj.add(new PipeHead(1, 110*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), BLOCK_SIZE*2 , BLOCK_SIZE*2,false));
		allObj.add(new PipeBody(1, 110*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*5), BLOCK_SIZE*2 , BLOCK_SIZE*2));
		allObj.add(new PipeBody(1, 110*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE*2 , BLOCK_SIZE*2));
		allObj.add(new PipeBody(1, 110*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE*2 , BLOCK_SIZE*2));
		
		hiddenPipeOut = new PipeHead(1, 116*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE*2 , BLOCK_SIZE*2,false);//hidden passage exit
		allObj.add(hiddenPipeOut); 
		allObj.add(new PipeBody(1, 116*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE*2 , BLOCK_SIZE*2));

	//flagPole object creation
		allObj.add(new FlagPole(1, 165*BLOCK_SIZE, (int)(mapHeight-(BLOCK_SIZE*12.5)), BLOCK_SIZE , BLOCK_SIZE));
		flag = new Flag(1, 165*BLOCK_SIZE-8, mapHeight-(BLOCK_SIZE*12), BLOCK_SIZE , BLOCK_SIZE);
		allObj.add(flag); //flag in the middle of a block (of the pole), need to go down once goal is hit
		allObj.add(new Block(7, 165*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE , BLOCK_SIZE));

	//castle
		allObj.add(new Castle(1, 170*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*7), BLOCK_SIZE*5 , BLOCK_SIZE*5));//5 blocks of height


	}
	public void stageThreeObjIniti() {
		//floor objects creation:
		for (int i = 0; i < 16; i++) {
			//floor assumption: length & width = 16; y starts at mapHeight - 2 blocks ; floorType 1
				//public Floor(int floorType, int x, int y,int length, int width)
			allObj.add(new Floor(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			allObj.add(new Floor(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*1), BLOCK_SIZE , BLOCK_SIZE)); //lowest level
		}
		for (int i = 130; i < 174; i++) {
			//floor assumption: length & width = 16; y starts at mapHeight - 2 blocks ; floorType 1
				//public Floor(int floorType, int x, int y,int length, int width)
			allObj.add(new Floor(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			allObj.add(new Floor(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*1), BLOCK_SIZE , BLOCK_SIZE)); //lowest level
		}
		
		//item box
		allObj.add(new Block(3, 61*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*5), BLOCK_SIZE , BLOCK_SIZE));//item box

		//castle
		allObj.add(new Castle(1, 0*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*7), BLOCK_SIZE*5 , BLOCK_SIZE*5));//5 blocks of height
		allObj.add(new Castle(2, 156*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*13), BLOCK_SIZE*5 , BLOCK_SIZE*5));//7 blocks of height
				
		//coin objects creation:
			//no type, only 1
		for (int i = 29; i <= 31 ; i++) {
			allObj.add(new Coin(i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*11), BLOCK_SIZE , BLOCK_SIZE));
		}
		for (int i = 35; i <= 35 ; i++) {
			allObj.add(new Coin(i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), BLOCK_SIZE , BLOCK_SIZE));
		}
		for (int i = 39; i <= 40 ; i++) {
			allObj.add(new Coin(i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*13), BLOCK_SIZE , BLOCK_SIZE));
		}
		for (int i = 52; i <= 53 ; i++) {
			allObj.add(new Coin(i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*9), BLOCK_SIZE , BLOCK_SIZE));
		}
		for (int i = 62; i <= 65 ; i++) {
			allObj.add(new Coin(i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*11), BLOCK_SIZE , BLOCK_SIZE));
		}
		for (int i = 86; i <= 87 ; i++) {
			allObj.add(new Coin(i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*10), BLOCK_SIZE , BLOCK_SIZE));
		}
		for (int i = 93; i <= 94 ; i++) {
			allObj.add(new Coin(i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*11), BLOCK_SIZE , BLOCK_SIZE));
		}
		for (int i = 97; i <= 98 ; i++) {
			allObj.add(new Coin(i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*11), BLOCK_SIZE , BLOCK_SIZE));
		}
		for (int i = 113; i <= 115 ; i++) {
			allObj.add(new Coin(i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE , BLOCK_SIZE));
		}
		for (int i = 121; i <= 122 ; i++) {
			allObj.add(new Coin(i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*11), BLOCK_SIZE , BLOCK_SIZE));
		}

		
		//platform object creation
		allObj.add(new Platform(1, 57*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*10), (int)(BLOCK_SIZE*1) , BLOCK_SIZE*3));
		allObj.add(new Platform(1, 87*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*7), (int)(BLOCK_SIZE*0.7) , BLOCK_SIZE*3));
		allObj.add(new Platform(1, 94*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), (int)(BLOCK_SIZE*0.7) , BLOCK_SIZE*3));
		allObj.add(new Platform(1, 132*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*9), (int)(BLOCK_SIZE*0.7) , BLOCK_SIZE*3));
			//mushroom platform left:2 Body:3 Right: 4
		allObj.add(new Platform(2, 20*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), (BLOCK_SIZE) , BLOCK_SIZE));
		allObj.add(new Platform(3, 21*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), (BLOCK_SIZE) , BLOCK_SIZE));
		allObj.add(new Platform(3, 22*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), (BLOCK_SIZE) , BLOCK_SIZE));
		allObj.add(new Platform(4, 23*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), (BLOCK_SIZE) , BLOCK_SIZE));

		allObj.add(new Platform(2, 26*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), (BLOCK_SIZE) , BLOCK_SIZE));
		for (int i = 27 ; i <=32; i++) { //x body block length
			allObj.add(new Platform(3, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), (BLOCK_SIZE) , BLOCK_SIZE));
		}
		allObj.add(new Platform(4, 33*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), (BLOCK_SIZE) , BLOCK_SIZE));

		allObj.add(new Platform(2, 28*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*10), (BLOCK_SIZE) , BLOCK_SIZE));
		for (int i = 29 ; i <=31; i++) { //x body block length
			allObj.add(new Platform(3, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*10), (BLOCK_SIZE) , BLOCK_SIZE));
		}
		allObj.add(new Platform(4, 32*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*10), (BLOCK_SIZE) , BLOCK_SIZE));

		allObj.add(new Platform(2, 34*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), (BLOCK_SIZE) , BLOCK_SIZE));
		for (int i = 35 ; i <=35; i++) { //x body block length
			allObj.add(new Platform(3, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), (BLOCK_SIZE) , BLOCK_SIZE));
		}
		allObj.add(new Platform(4, 36*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), (BLOCK_SIZE) , BLOCK_SIZE));

		allObj.add(new Platform(2, 37*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*7), (BLOCK_SIZE) , BLOCK_SIZE));
		for (int i = 38 ; i <=40; i++) { //x body block length
			allObj.add(new Platform(3, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*7), (BLOCK_SIZE) , BLOCK_SIZE));
		}
		allObj.add(new Platform(4, 41*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*7), (BLOCK_SIZE) , BLOCK_SIZE));
		
		allObj.add(new Platform(2, 42*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*11), (BLOCK_SIZE) , BLOCK_SIZE));
		for (int i = 43 ; i <=47; i++) { //x body block length
			allObj.add(new Platform(3, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*11), (BLOCK_SIZE) , BLOCK_SIZE));
		}
		allObj.add(new Platform(4, 48*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*11), (BLOCK_SIZE) , BLOCK_SIZE));

		allObj.add(new Platform(2, 52*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), (BLOCK_SIZE) , BLOCK_SIZE));
		for (int i = 53 ; i <=54; i++) { //x body block length
			allObj.add(new Platform(3, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), (BLOCK_SIZE) , BLOCK_SIZE));
		}
		allObj.add(new Platform(4, 55*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), (BLOCK_SIZE) , BLOCK_SIZE));

		allObj.add(new Platform(2, 61*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), (BLOCK_SIZE) , BLOCK_SIZE));
		for (int i = 62 ; i <=64; i++) { //x body block length
			allObj.add(new Platform(3, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), (BLOCK_SIZE) , BLOCK_SIZE));
		}
		allObj.add(new Platform(4, 65*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), (BLOCK_SIZE) , BLOCK_SIZE));

		allObj.add(new Platform(2, 62*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*10), (BLOCK_SIZE) , BLOCK_SIZE));
		for (int i = 63 ; i <=64; i++) { //x body block length
			allObj.add(new Platform(3, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*10), (BLOCK_SIZE) , BLOCK_SIZE));
		}
		allObj.add(new Platform(4, 65*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*10), (BLOCK_SIZE) , BLOCK_SIZE));
		
		allObj.add(new Platform(2, 67*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), (BLOCK_SIZE) , BLOCK_SIZE));
		for (int i = 68 ; i <=70; i++) { //x body block length
			allObj.add(new Platform(3, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), (BLOCK_SIZE) , BLOCK_SIZE));
		}
		allObj.add(new Platform(4, 71*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), (BLOCK_SIZE) , BLOCK_SIZE));

		allObj.add(new Platform(2, 72*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), (BLOCK_SIZE) , BLOCK_SIZE));
		for (int i = 73 ; i <=73; i++) { //x body block length
			allObj.add(new Platform(3, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), (BLOCK_SIZE) , BLOCK_SIZE));
		}
		allObj.add(new Platform(4, 74*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), (BLOCK_SIZE) , BLOCK_SIZE));

		allObj.add(new Platform(2, 78*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*9), (BLOCK_SIZE) , BLOCK_SIZE));
		for (int i = 79 ; i <=82; i++) { //x body block length
			allObj.add(new Platform(3, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*9), (BLOCK_SIZE) , BLOCK_SIZE));
		}
		allObj.add(new Platform(4, 83*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*9), (BLOCK_SIZE) , BLOCK_SIZE));

		allObj.add(new Platform(2, 98*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), (BLOCK_SIZE) , BLOCK_SIZE));
		for (int i = 99 ; i <=100; i++) { //x body block length
			allObj.add(new Platform(3, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), (BLOCK_SIZE) , BLOCK_SIZE));
		}
		allObj.add(new Platform(4, 101*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*4), (BLOCK_SIZE) , BLOCK_SIZE));

		allObj.add(new Platform(2, 104*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*8), (BLOCK_SIZE) , BLOCK_SIZE));
		for (int i = 105 ; i <=110; i++) { //x body block length
			allObj.add(new Platform(3, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*8), (BLOCK_SIZE) , BLOCK_SIZE));
		}
		allObj.add(new Platform(4, 111*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*8), (BLOCK_SIZE) , BLOCK_SIZE));

		allObj.add(new Platform(2, 113*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), (BLOCK_SIZE) , BLOCK_SIZE));
		for (int i = 114 ; i <=114; i++) { //x body block length
			allObj.add(new Platform(3, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), (BLOCK_SIZE) , BLOCK_SIZE));
		}
		allObj.add(new Platform(4, 115*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), (BLOCK_SIZE) , BLOCK_SIZE));
		
		allObj.add(new Platform(2, 116*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), (BLOCK_SIZE) , BLOCK_SIZE));
		for (int i = 117 ; i <=118; i++) { //x body block length
			allObj.add(new Platform(3, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), (BLOCK_SIZE) , BLOCK_SIZE));
		}
		allObj.add(new Platform(4, 119*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), (BLOCK_SIZE) , BLOCK_SIZE));

		allObj.add(new Platform(2, 123*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), (BLOCK_SIZE) , BLOCK_SIZE));
		for (int i = 124 ; i <=125; i++) { //x body block length
			allObj.add(new Platform(3, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), (BLOCK_SIZE) , BLOCK_SIZE));
		}
		allObj.add(new Platform(4, 126*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*6), (BLOCK_SIZE) , BLOCK_SIZE));

		//wallPaper creation
		for (int i = 21; i <= 22; i++) {
			//floor assumption: length & width = 16; y starts at mapHeight - 2 blocks ; floorType 1
				//public Floor(int floorType, int x, int y,int length, int width)
			allObj.add(new WallPaper(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*2), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			allObj.add(new WallPaper(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*1), BLOCK_SIZE , BLOCK_SIZE)); //lowest level
		}

		for (int i = 27; i <= 32; i++) { //x
			for (int j = 1 ; j <=5; j++) { //y
			allObj.add(new WallPaper(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*j), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			}
		}
		for (int i = 29; i <= 31; i++) { //x
			for (int j = 7 ; j <=9; j++) { //y
			allObj.add(new WallPaper(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*j), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			}
		}
		for (int i = 35; i <= 35; i++) { //x
			for (int j = 1 ; j <=2; j++) { //y
			allObj.add(new WallPaper(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*j), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			}
		}
		for (int i = 38; i <= 40; i++) { //x
			for (int j = 1 ; j <=6; j++) { //y
			allObj.add(new WallPaper(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*j), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			}
		}
		for (int i = 43; i <= 47; i++) { //x
			for (int j = 1 ; j <=10; j++) { //y
			allObj.add(new WallPaper(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*j), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			}
		}
		for (int i = 53; i <= 54; i++) { //x
			for (int j = 1 ; j <=1; j++) { //y
			allObj.add(new WallPaper(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*j), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			}
		}
		for (int i = 62; i <= 64; i++) { //x
			for (int j = 1 ; j <=1; j++) { //y
			allObj.add(new WallPaper(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*j), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			}
		}
		for (int i = 63; i <= 64; i++) { //x
			for (int j = 3 ; j <=9; j++) { //y
			allObj.add(new WallPaper(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*j), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			}
		}
		for (int i = 68; i <= 70; i++) { //x
			for (int j = 1 ; j <=1; j++) { //y
			allObj.add(new WallPaper(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*j), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			}
		}
		for (int i = 73; i <= 73; i++) { //x
			for (int j = 1 ; j <=5; j++) { //y
			allObj.add(new WallPaper(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*j), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			}
		}
		for (int i = 79; i <= 82; i++) { //x
			for (int j = 1 ; j <=8; j++) { //y
			allObj.add(new WallPaper(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*j), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			}
		}
		for (int i = 99; i <= 100; i++) { //x
			for (int j = 1 ; j <=3; j++) { //y
			allObj.add(new WallPaper(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*j), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			}
		}
		for (int i = 105; i <= 110; i++) { //x
			for (int j = 1 ; j <=7; j++) { //y
			allObj.add(new WallPaper(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*j), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			}
		}
		for (int i = 114; i <= 114; i++) { //x
			for (int j = 1 ; j <=1; j++) { //y
			allObj.add(new WallPaper(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*j), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			}
		}
		for (int i = 117; i <= 118; i++) { //x
			for (int j = 1 ; j <=5; j++) { //y
			allObj.add(new WallPaper(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*j), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			}
		}
		for (int i = 124; i <= 125; i++) { //x
			for (int j = 1 ; j <=5; j++) { //y
			allObj.add(new WallPaper(1, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*j), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			}
		}
		
		//Block creation
		for (int i = 139; i <= 140; i++) { //x
			for (int j = 3 ; j <=6; j++) { //y
			allObj.add(new Block(4, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*j), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			}
		}
		for (int i = 141; i <= 142; i++) { //x
			for (int j = 3 ; j <=8; j++) { //y
			allObj.add(new Block(4, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*j), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			}
		}
		for (int i = 143; i <= 144; i++) { //x
			for (int j = 3 ; j <=10; j++) { //y
			allObj.add(new Block(4, i*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*j), BLOCK_SIZE , BLOCK_SIZE)); //2nd lowest
			}
		}
		
		
		//flagPole object creation
		allObj.add(new FlagPole(1, 153*BLOCK_SIZE, (int)(mapHeight-(BLOCK_SIZE*12.5)), BLOCK_SIZE , BLOCK_SIZE));
		flag = new Flag(1, 153*BLOCK_SIZE-8, mapHeight-(BLOCK_SIZE*12), BLOCK_SIZE , BLOCK_SIZE);
		allObj.add(flag); //flag in the middle of a block (of the pole), need to go down once goal is hit
		allObj.add(new Block(4, 153*BLOCK_SIZE, mapHeight-(BLOCK_SIZE*3), BLOCK_SIZE , BLOCK_SIZE));
		
	}
	
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
	public Flag getFlag() {
		return flag;
	}
}
