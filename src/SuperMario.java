import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SuperMario {
	// everything static, since there is only one game.
	private static final int WIDTH = 400;
	private static final int HEIGHT = 318;
	private static int stageNumber = 1;
	private static int marioLives = 3;
	private static int score = 0;
	private static JFrame frame;
	private static boolean leftPressed;
	private static boolean rightPressed;
	private static boolean jumpPressed;
	public static Handler handler;
	private static boolean hasStarted = false;

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
	
	public void init() {
		handler = new Handler();
		frame.addKeyListener(new KeyInput());
		handler.addCharactor(new Mario(300,500,64,64,Id.Mario,handler));
		
	}

	public static void gameStart() {
//		needs implement
		
	}

	public static void increaseScore(int number) {
		score += number;
	}

	public static void enterStage() {
		Stage stage = new Stage(stageNumber);
		frame.removeAll();
		frame.add(stage);
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

	public static void loseLive() {
		if (marioLives == 1) {
			gameOver();
		} else {
			marioLives--;
			gameStart();
		}
	}

	public static boolean isLeftPressed() {
		return leftPressed;
	}

	public static boolean isRightPressed() {
		return rightPressed;
	}

	public static boolean isJumpPressed() {
		return jumpPressed;
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
			}
		}

		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				leftPressed = true;
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				rightPressed = true;
			} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				jumpPressed = true;
			}
		}

		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				leftPressed = false;
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				rightPressed = false;
			} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				jumpPressed = false;
			}
		}
	}

	public static void main(String[] args) {
		SuperMario game = new SuperMario();
		
	}
}
