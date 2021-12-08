import java.util.LinkedList;
import java.awt.Graphics;
public class Handler {
	
	public LinkedList<Charactor> charactor = new LinkedList<Charactor>(); 
	
	public void tick() {
		for(Charactor ch:charactor) {
			ch.tick();
		}
		
	}
	
	public void render(Graphics g) {
		for(Charactor ch:charactor) {
			ch.render(g);
		}
	}
	
	public void addCharactor(Charactor ch) {
		charactor.add(ch);
	}
	
	public void removeCharactor(Charactor ch) {
		charactor.remove(ch);
	}

}
