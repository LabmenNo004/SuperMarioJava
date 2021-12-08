import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class KeyInput implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();  
		for (Charactor ch:Handler.charactor) {
		switch(key) {
		case KeyEvent.VK_W:
			setVelY(-5);
			break;
		case KeyEvent.VK_S:
			setVelY(5);
			break;
		case KeyEvent.VK_A:
			setVelX(-5);
			break;
		case KeyEvent.VK_D:
			setVelX(5);
			break;
		}
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();  
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
		
	
	
}
