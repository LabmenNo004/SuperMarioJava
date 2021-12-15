import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FlagPole extends GameObject{
	private int flagPoleType;
	
	//Constructor
	public FlagPole(int flagPoleType, int x, int y,int length, int width) {
		super(x,y,length,width);
		this.canCollide = false;
		
		this.flagPoleType = flagPoleType;
		//pulling image		
		reload();
	}
	public void reload() {
		try {
			this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			//this.image = ImageIO.read(new File(path + "flagPole" + flagPoleType + ".png")); // user.dir/scr/images/Floor#.png
			this.image = ImageIO.read(getClass().getResource("/images/flagPole"+ flagPoleType +".png")); // user.dir/scr/images/Floor#.png
		} catch (IOException e) {
			System.out.println("Fail to import image");
			e.printStackTrace();
		}
	}

}
