
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PipeBody extends GameObject{
	private int pipeBodyType;
	
	//Constructor
	public PipeBody(int pipeBodyType, int x, int y,int length, int width) {
		super(x,y,length,width);
		this.canCollide = true;
		
		this.pipeBodyType = pipeBodyType;
		
		//pulling image		
		try {
			this.image = new BufferedImage(width, length, BufferedImage.TYPE_INT_ARGB);
			this.image = ImageIO.read(new File(path+ "pipeBody"+ pipeBodyType +".png")); // user.dir/scr/images/Floor#.png
		} catch (IOException e) {
			System.out.println("Fail to import image");
			e.printStackTrace();
		}
	}

	public void reload() {
		try {
			this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			this.image = ImageIO.read(new File(path + "pipeBody" + pipeBodyType + ".png")); // user.dir/scr/images/Floor#.png
		} catch (IOException e) {
			System.out.println("Fail to import image");
			e.printStackTrace();
		}
	}
}
