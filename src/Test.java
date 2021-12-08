import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Test {
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

	public Test() {
		// create frame
		frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setResizable(false);

		TestStage die1 = new TestStage();
		frame.add(die1);
		frame.setVisible(true);

	    }
	


	public static void main(String[] args) {
		Test game = new Test();

	}
}
