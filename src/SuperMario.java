import javax.swing.JFrame;
import javax.swing.JPanel;

public class SuperMario{
	//	everything static, since there is only one game.
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 900;
	private static int stageNumber = 1;
	private static int marioLives = 3;
	private static int score = 0;
	private static JFrame frame;
	public SuperMario() {
		//create frame
		frame = new JFrame();
		frame.setSize(WIDTH,HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		gameStart();
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
		Stage stage = new Stage(stageNumber);
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
		}else {
			marioLives--;
			gameStart();
		}
	}
	
	public static int getWIDTH() {
		return WIDTH;
	}
	
	public static void main(String[] args)  {
		SuperMario game = new SuperMario();
		
	}
}
