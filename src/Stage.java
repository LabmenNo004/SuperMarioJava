import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Stage extends JPanel implements Runnable {
	private static final float FRAMERATE = 30;
	private int cameraX = 0;
	private static final int CAMERAEDGE = (int) SuperMario.WIDTH / 2;
	private Map map = null;
	private Mario mario;
	private EnemyKuribo enemykuribo; //will use allEnemy list to create enemies
	public Handler handler;
	private float time = 400;
	private boolean inProgress = true;
	private boolean showMario=true;
	AudioStream BGM = null;
	
	public Stage(int stageNumber) {
		this.map = new Map(stageNumber);

		this.mario = new Mario(map.getMarioSpawnCoord()[0],map.getMarioSpawnCoord()[1],16,16);
		//this.enemykuribo = new EnemyKuribo(map.getMarioSpawnCoord()[0]+200,map.getMarioSpawnCoord()[1],16,16);

//		new Thread(mario).start();
		Dimension size = new Dimension(SuperMario.WIDTH, SuperMario.HEIGHT);

		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
		
		if (stageNumber == 1)
			BGM = SuperMario.playSound("bgm");
		else
			BGM = SuperMario.playSound("bgm2");
		
	}

	public void run() {

		while (true) {
//			check timer ...

			if (inProgress) {
				this.time -= (1 / FRAMERATE);
				
				mario.tick();
				if (mario.getX() >= Map.flagX) {
//					win					
					AudioPlayer.player.stop(BGM);
					win();

				}
				if (mario.y>Map.mapHeight || time < 0.5) {
//					die
					SuperMario.playSound("die");
					AudioPlayer.player.stop(BGM);

					SuperMario.loseLife();
					Thread.currentThread().interrupt();
					return;
				}
			} else if(SuperMario.stageNumber==1){
//				animation of going to castle
				if(mario.getY()+mario.height<Map.mapHeight-(Map.BLOCK_SIZE*2)) {
					mario.y+=5;
				}else if(mario.getX() <= Map.flagX+Map.BLOCK_SIZE*7) {
					mario.x += 5;
				}else {
					showMario = false;
					repaint();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					SuperMario.gameWin();
					
					Thread.currentThread().interrupt();
					return;
				}
			}

			//edited here to incorp. allEnemy list usage
			for (Enemy kuribou: map.allEnemy) {
				if (kuribou instanceof EnemyKuribo) {
					kuribou.tick();
				}
			}

			updateCamera();
			repaint();
			try {
				Thread.sleep((long) (1000 / FRAMERATE));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}

	public void win() {
		inProgress = false;
		SuperMario.increaseScore(2000);
	}
	
	public void paintComponent(Graphics g) {

		g.drawImage(map.getBgImage(), -cameraX, 0, null);

		for (GameObject obj : map.getAllObj()) {
			g.drawImage(obj.getImage(), obj.getX() - cameraX, obj.getY(), null);
		}
    	for (Enemy ene: map.getAllEnemy()) {
    		g.drawImage(ene.getImage(), ene.getX()-cameraX, ene.getY(), null);
    	}
		SuperMario.paintUI(g);
		if (showMario) {
			g.drawImage(mario.getImage(), mario.getX() - cameraX, mario.getY(), null);
		    
		}
		//g.drawImage(enemykuribo.getImage(), enemykuribo.getX() - cameraX, enemykuribo.getY(), null);
	}

	private void updateCamera() {
		int marioX = mario.getX();

//    	System.out.println(cameraX +SuperMario.WIDTH - marioX - CAMERAEDGE);
		if (marioX < CAMERAEDGE) {
			// camera fix
			cameraX = 0;
		} else if (map.getWidth() - marioX < CAMERAEDGE) {
			// camera fix
			cameraX = map.getWidth() - CAMERAEDGE;
		} else if (marioX - cameraX < CAMERAEDGE) {
			// camera move left
			cameraX = marioX - CAMERAEDGE;
		} else if (cameraX + SuperMario.WIDTH - marioX < CAMERAEDGE) {
			// camera move right
			cameraX = marioX + CAMERAEDGE - SuperMario.getWIDTH();
		}
	}

	public Mario getMario() {
		return mario;
	}

	public float getTime() {
		return time;
	}
}
