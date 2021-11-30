import javax.swing.JFrame;
import javax.swing.JPanel;

public class SuperMario extends JPanel{
	private int stageNumber = 1;
	
	public SuperMario() {
		
		
	}
	// initial frame
	public static void main(String[] args)  {
		//creat frame
		final int WIDTH = 1200;
		final int HEIGHT = 900;
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(WIDTH,HEIGHT);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		
		
	}
}
