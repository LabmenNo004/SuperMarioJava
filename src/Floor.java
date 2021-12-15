import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Floor extends GameObject{
	private int floorType;
	
	//Constructor
	public Floor(int floorType, int x, int y,int length, int width) { //type for different type of floors
		super(x,y,length,width);
		this.canCollide = true;
		
		this.floorType = floorType;
		
		//pulling image		
		try {
			this.image = new BufferedImage(width, length, BufferedImage.TYPE_INT_ARGB);
			//this.image = ImageIO.read(new File(path+ "floor"+ floorType +".png")); // user.dir/scr/images/Floor#.png
			this.image = ImageIO.read(getClass().getResource("/images/floor"+ floorType +".png")); // user.dir/scr/images/Floor#.png
		} catch (IOException e) {
			System.out.println("Fail to import image");
			e.printStackTrace();
		}
		
	}
	public void reload() {
		try {
			this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			//this.image = ImageIO.read(new File(path + "floor" + floorType + ".png")); // user.dir/scr/images/Floor#.png
			this.image = ImageIO.read(getClass().getResource("/images/floor"+ floorType +".png")); // user.dir/scr/images/Floor#.png
		} catch (IOException e) {
			System.out.println("Fail to import image");
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
