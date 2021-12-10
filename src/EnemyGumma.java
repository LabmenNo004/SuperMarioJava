import java.awt.Image;
import java.awt.image.BufferedImage;

public class EnemyGumma extends Enemy{
	
	protected static BufferedImage GummaImage = null;
	
	public EnemyGumma(int x, int y,int height, int width, Id id, Handler handler) {
		super(x,y,height,width,id,handler);
		this.image = getMarioImage(); 

}
