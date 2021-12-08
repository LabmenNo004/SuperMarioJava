import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.synth.ColorType;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;

public class test2 extends Canvas{
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
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs==null) {
			createBufferStrategy(1);
			return;
		}
		Graphics g = bs.getDrawGraphics(); 
		g.setColor(Color.BLUE);
		g.fillRect(0,0,200,200);
		g.dispose();
		bs.show();
	}

	public test2() {
		// create frame
		frame = new JFrame("Super Mario Bros. Remake - TEST");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setResizable(false);

		TestStage die1 = new TestStage();
		render();
		//frame.pack();
		frame.add(die1);
		frame.setVisible(true);

	    }
	


	public static void main(String[] args) {
		
		test2 game = new test2();
		frame.add(game);

	}
}
