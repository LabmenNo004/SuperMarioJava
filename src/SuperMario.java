import javax.swing.JFrame;
import javax.swing.JPanel;

public class SuperMario{
	//	everything static, since there is only one game.
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 900;
	private static int stageNumber = 1;
	private static int marioLives = 3;
	private static int points = 0;
	private static JFrame frame;
	public SuperMario() {
		//creat frame
		frame.setSize(WIDTH,HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		enterStage(1);
	}
	
	public static JPanel getStartPanel() {
		// initial frame
		return null;
	}
	
	public static int getWIDTH() {
		return WIDTH;
	}
	
	public static void incrementScore(int number) {
		points += number;
	}
	
	public static void enterStage(int stageNumber) {
		Stage stage = new Stage(stageNumber);
		frame.add(stage);
	}
	
	
	public static void main(String[] args)  {
		SuperMario game = new SuperMario();
		
	}
}
