import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import sun.audio.*;

public class SuperMario {
	// everything static, since there is only one game.
	public static final int WIDTH = 400;
	public static final int HEIGHT = 318;
	public static int stageNumber = 1;
	public static int lastStage = 2;
	public static int marioLives = 3;
	public static int score = 0;
	public static int coins=0;
	private static JFrame frame;
	public static boolean hasStarted = false;
	public static boolean hasEnded = false;
	public static Stage stage = null;
	public static BufferedImage[] numberImages = new BufferedImage[10];
	public static BufferedImage startImages;
	public static BufferedImage endImages;
	public static BufferedImage uiImages;
	public static Thread stageThread = null;
	private GameData gameData = new GameData();

	static {
		try {
			startImages = ImageIO.read(new File(GameObject.path+"start.png"));
			uiImages = ImageIO.read(new File(GameObject.path+"UI.png"));
			endImages = ImageIO.read(new File(GameObject.path+"gameEnd.png"));
		for (int i=0; i<10; i++) {
			
				numberImages[i] = ImageIO.read(new File(GameObject.path+ i +".png"));
			} 
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public SuperMario() {
		// create frame
		frame = new JFrame("Super Mario Bros. Remake");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		frame.addKeyListener(new CustomKeyListener());
		
		gameStart();
		frame.setVisible(true);
	}
	
	public void load() {
		if (stage!=null)
			stage.stop = true;
		FileInputStream fis;
		try {
			fis = new FileInputStream("mario.sav");
	      ObjectInputStream ois = new ObjectInputStream(fis);

	      gameData = (GameData) ois.readObject();
	      gameData.load();
	      ois.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SuperMario.reload();
	}
	
	public static void reload() {
		if (hasStarted) {
			stageThread = new Thread(stage);
			stageThread.start();
			frame.getContentPane().removeAll();
			frame.add(stage);
			SwingUtilities.updateComponentTreeUI(frame);
		}
		else {
			gameStart();
		}
		
	}
	
	public static void gameStart() {
//		restore data
		if (hasEnded) {
			stageNumber = 1;
			marioLives = 3;
			score = 0;
			coins = 0;
		}
		hasEnded = false;
		
		StartPanel startPanel = new StartPanel();
		frame.getContentPane().removeAll();
		frame.add(startPanel);
		SwingUtilities.updateComponentTreeUI(frame);
	}

	public static void increaseScore(int number) {
		score += number;
	}

	public static void enterStage() {
		stage = new Stage(stageNumber);
		stageThread = new Thread(stage);
		stageThread.start();
//		TestStage stage = new TestStage();
		frame.getContentPane().removeAll();
		frame.add(stage);
		SwingUtilities.updateComponentTreeUI(frame);
	}
	public static void gameWin() {
		if (stageNumber != lastStage) {
			stageNumber=stageNumber+1;
			hasStarted=false;
			gameStart();
		}else {
			gameOver();
		}
	}
	
	public static void gameOver() {
//		show game over view, showing score. 
//		needs implement
		EndPanel endPanel = new EndPanel();
		frame.getContentPane().removeAll();
		frame.add(endPanel);
		SwingUtilities.updateComponentTreeUI(frame);		
			
//		restart
		hasEnded = true;
		hasStarted= false;		
	}
	public static void eatCoin() {
		score+=200;
		coins+=1;
		if (coins == 100) {
			coins = 0;
			score+=10000;
			marioLives++;
			playSound("OneUp");
		}
		playSound("coin");
	}
	public static void loseLife() {
		stageThread.interrupt();
		
		if (marioLives == 1) {
			gameOver();
		} else {
			marioLives--;
			hasStarted= false;
			gameStart();
			
		}
	}

	public static int getWIDTH() {
		return WIDTH;
	}

	public static int getHEIGHT() {
		return HEIGHT;
	}
	
	public static void paintHighScore(Graphics g) {
		//g.drawImage(SuperMario.uiImages, 0 , -20,null);
		int size = 14;
//		score
		int x = 150;
		int y = 150;
		int offset = 0;
		BufferedImage[] scoreImages = getImages(score, 6);
		for (BufferedImage img: scoreImages) {
			g.drawImage(img,x+offset,y,size,size,null);
			offset+=size;
		}
	}

	
	public static void paintUI(Graphics g) {
		g.drawImage(SuperMario.uiImages, 0 , -20,null);
		
		int size = 14;
//		score
		int x = 10;
		int y = 28;
		int offset = 0;
		BufferedImage[] scoreImages = getImages(score, 6);
		for (BufferedImage img: scoreImages) {
			g.drawImage(img,x+offset,y,size,size,null);
			offset+=size;
		}
		
//		coins
		x = 85;
		y= 26;

		BufferedImage[] coinImages = getImages(coins, 2);
		for (BufferedImage img: coinImages) {
			g.drawImage(img,x+offset,y,size,size,null);
			offset+=size;
		}
		
//		stage
		x = 225;
		y= 26;
		g.drawImage(numberImages[1],x,y,size,size,null);
		g.drawImage(numberImages[stageNumber],x+45,y,size,size,null);
		
		if (hasStarted) {
//			time
			x = 318;
			y = 28;
			offset = 0;
			BufferedImage[] timeImages = getImages((int)stage.getTime(), 0);
			for (BufferedImage img: timeImages) {
				g.drawImage(img,x+offset,y,size,size,null);
				offset+=size;
			}
		}else {
//			paint mario life and stage in the center
			x = 205;
			y= 112;
			g.drawImage(numberImages[1],x,y,size,size,null);
			g.drawImage(numberImages[stageNumber],x+40,y,size,size,null);
			
			g.drawImage(numberImages[marioLives],220,160,size,size,null);
		}
	}

	class CustomKeyListener implements KeyListener {
		public void keyTyped(KeyEvent e) {
//			System.out.print("typed"+e.getKeyCode());
			 if(e.getKeyCode() == KeyEvent.VK_S) {
				gameData.save();
				System.out.println("Game saved.");
				return;
			}else if(e.getKeyCode() == KeyEvent.VK_L) {
				load();
				System.out.println("Game loaded.");
				return;
			}
			 else if (!hasStarted) {
				hasStarted = true;
				enterStage();
				System.out.println("entering stage"+stageNumber);
			}
		}

		public void keyPressed(KeyEvent e) {
			if (hasEnded) {
				gameStart();
				return;
			}
			if (hasStarted) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					stage.getMario().leftPressed();
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					stage.getMario().rightPressed();
				} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					stage.getMario().jumpPressed();
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					stage.getMario().downPressed();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					stage.getMario().jumpPressed();
				} else if(e.getKeyCode() == KeyEvent.VK_S) {
					gameData.save();
					System.out.println("Game saved.");
					return;
				}else if(e.getKeyCode() == KeyEvent.VK_L) {
					load();
					System.out.println("Game loaded.");
					return;
				}
			}else {
				
				keyTyped(e);
			}
		}

		public void keyReleased(KeyEvent e) {
			if (hasStarted) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					stage.getMario().leftReleased();

				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					stage.getMario().rightReleased();

				} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					stage.getMario().jumpReleased();

				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					stage.getMario().downReleased();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					stage.getMario().jumpReleased();
				}
			}else {
				keyTyped(e);
			}
		}
	}
	public static BufferedImage[] getImages(int i, int len) {
//		len is the total length. if length is variable, set it to 0.
		String str = Integer.toString(i);
		if (len==0 || len<str.length()) len = str.length();

		BufferedImage[] result = new BufferedImage[len];
		int padding = len - str.length();
		for (int j = 0; j<padding;j++) {
			result[j] = SuperMario.numberImages[0];
		}
		for(int j = 0; j<str.length();j++) {
			char ch = str.charAt(j);
			result[j+padding] = SuperMario.numberImages[ch-'0'];
		}
		return result;
	}
	
//	playing sound: https://www.tabnine.com/code/java/classes/sun.audio.AudioPlayer
	
	public static AudioStream playSound(String s) {
		String songFile = System.getProperty("user.dir") + "/src/sound/"+s+".wav";
	    InputStream in;
		try {
			in = new FileInputStream(songFile);
		    // create an audiostream from the inputstream
		    AudioStream audioStream = new AudioStream(in);
		    // play the audio clip with the audioplayer class
		    AudioPlayer.player.start(audioStream);
		    return audioStream;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

		
	
	public static void main(String[] args) {
		SuperMario game = new SuperMario();
	}
}

class StartPanel extends JPanel{
	StartPanel(){
		this.setBackground(Color.BLACK);
	}
	
	 public void paintComponent(Graphics g) {
		 /* Draw the image, applying the filter */
	    	g.drawImage(SuperMario.startImages, 0 , -40, SuperMario.WIDTH,SuperMario.HEIGHT,null);
	    	SuperMario.paintUI(g);
	    	
	    }
	
}

class EndPanel extends JPanel{
	EndPanel(){
		//this.setBackground(Color.BLACK);
	}
	
	 public void paintComponent(Graphics g) {
		 /* Draw the image, applying the filter */
	    	g.drawImage(SuperMario.endImages, 0 , -40, SuperMario.WIDTH,SuperMario.HEIGHT,null);
	    	SuperMario.paintHighScore(g);
	    	
	    }
	
}