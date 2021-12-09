import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class KeyInput implements KeyListener {


    
    public boolean LEFT;
    public boolean RIGHT;
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		int key = e.getKeyCode();  
		for (Charactor ch:SuperMario.handler.charactor) {
		switch(key) {
		case KeyEvent.VK_W:
			ch.setVelY(-5);
			break;
		case KeyEvent.VK_S:
			ch.setVelY(5);
			break;
		case KeyEvent.VK_A:
			ch.setVelX(-5);
			LEFT = true;
			RIGHT = false;
			break;
		case KeyEvent.VK_D:
			ch.setVelX(5);
			RIGHT = true;
			LEFT = false;
			break;
		}
		}

		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();  
		for (Charactor ch:SuperMario.handler.charactor) {
		switch(key) {
		case KeyEvent.VK_W:
			ch.setVelY(0);
			break;
		case KeyEvent.VK_S:
			ch.setVelY(0);
			break;
		case KeyEvent.VK_A:
			ch.setVelX(0);
			break;
		case KeyEvent.VK_D:
			ch.setVelX(0);
			break;
		}
		} 
		
	}
		
	
	
}
