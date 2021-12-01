import javax.swing.JFrame;
import javax.swing.JPanel;

public class SuperMario extends JFrame{
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 900;
	private int stageNumber = 1;
	private int marioLives = 3;
	private int points = 0;
	
	public SuperMario() {
		//creat frame
		setSize(WIDTH,HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		enterStage(1);
	}
	
	public JPanel getStartPanel() {
		// initial frame
		return null;
	}
	
	
	public void enterStage(int stageNumber) {
		Stage stage = new Stage(stageNumber);
		this.add(stage);
	}
	
	public static void main(String[] args)  {
		SuperMario game = new SuperMario();
		
	}
}
