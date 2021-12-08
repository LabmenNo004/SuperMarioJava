import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Castle extends GameObject{
	private int castleType;
	
	//Constructor
	public Castle(int castleType, int x, int y,int length, int width) {
		super(x,y,length,width);
		this.canCollide = false;
		
		this.castleType = castleType;
		
		//pulling image		
		try {
			this.image = new BufferedImage(width, length, BufferedImage.TYPE_INT_ARGB);
			this.image = ImageIO.read(new File(path+ "castle"+ castleType +".png")); // user.dir/scr/images/Floor#.png
		} catch (IOException e) {
			System.out.println("Fail to import image");
			e.printStackTrace();
		}
	}



}
