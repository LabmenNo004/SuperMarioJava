import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SuperMario {
	// everything static, since there is only one game.
	public static final int WIDTH = 400;
	public static final int HEIGHT = 318;
	private static int stageNumber = 1;
	private static int marioLives = 3;
	private static int score = 0;
	private static JFrame frame;
	public static Handler handler;
	private static boolean hasStarted = false;
	private static Stage stage;
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

	public static JPanel getStartPanel() {
//		needs implement
		// initial frame
		return null;
	}


	public static void gameStart() {
//		needs implement
		
	}

	public static void increaseScore(int number) {
		score += number;
	}

	public static void enterStage() {
		stage = new Stage(stageNumber);
		new Thread(stage).start();
//		TestStage stage = new TestStage();
		frame.getContentPane().removeAll();
		frame.add(stage);
		SwingUtilities.updateComponentTreeUI(frame);
	}

	public static void gameOver() {
//		show game over view, showing score. 
//		needs implement

//		restore data
		stageNumber = 1;
		marioLives = 3;
		score = 0;
//		restart
		gameStart();
	}

	public static void loseLife() {
		if (marioLives == 1) {
			gameOver();
		} else {
			marioLives--;
			gameStart();
		}
	}

	public static int getWIDTH() {
		return WIDTH;
	}
	public static int getHEIGHT() {
		return HEIGHT;
	}

	class CustomKeyListener implements KeyListener {
		public void keyTyped(KeyEvent e) {
			if (!hasStarted) {
				hasStarted=true;
				enterStage();
				System.out.println("entering");
			}
		}

		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				stage.getMario().leftPressed();
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				stage.getMario().rightPressed();
			} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				stage.getMario().jumpPressed();
			}else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				stage.getMario().downPressed();
			}else if (e.getKeyCode() == KeyEvent.VK_UP) {
				stage.getMario().jumpPressed();
			}
		}

		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				stage.getMario().leftReleased();
				
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				stage.getMario().rightReleased();

			} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				stage.getMario().jumpReleased();
				
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					stage.getMario().downReleased();
				}else if (e.getKeyCode() == KeyEvent.VK_UP) {
					stage.getMario().jumpReleased();
				}
		}
	}

	public static void main(String[] args) {
		SuperMario game = new SuperMario();
		
	}
}
