import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Platform extends GameObject{
	private int PlatformType;
	
	//Constructor
	public Platform(int PlatformType, int x, int y,int length, int width) { //type for different type of platform size
		super(x,y,length,width);
		this.canCollide = true;
		
		this.PlatformType = PlatformType;
		
		//pulling image		
		try {
			this.image = new BufferedImage(width, length, BufferedImage.TYPE_INT_ARGB);
			this.image = ImageIO.read(new File(path+ "platform"+ PlatformType +".png")); // user.dir/scr/images/Floor#.png
		} catch (IOException e) {
			System.out.println("Fail to import image");
			e.printStackTrace();
		}
	}
	public void reload() {
		try {
			this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			this.image = ImageIO.read(new File(path + "platform" + PlatformType + ".png")); // user.dir/scr/images/Floor#.png
		} catch (IOException e) {
			System.out.println("Fail to import image");
			e.printStackTrace();
		}
	}
}