

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class WallPaper extends GameObject{
	private int wallPaperType;
	
	//Constructor
	public WallPaper(int wallPaperType, int x, int y,int length, int width) { //type for different type of wallPaper
		super(x,y,length,width);
		this.canCollide = false;
		
		this.wallPaperType = wallPaperType;
		
		//pulling image		
		try {
			this.image = new BufferedImage(width, length, BufferedImage.TYPE_INT_ARGB);
			//this.image = ImageIO.read(new File(path+ "wallPaper"+ wallPaperType +".png")); // user.dir/scr/images/Floor#.png
			this.image = ImageIO.read(getClass().getResource("/images/wallPaper"+ wallPaperType +".png")); // user.dir/scr/images/Floor#.png

		} catch (IOException e) {
			System.out.println("Fail to import image");
			e.printStackTrace();
		}
		
	}
	public void reload() {
		try {
			this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			//this.image = ImageIO.read(new File(path + "wallPaper" + wallPaperType + ".png")); // user.dir/scr/images/Floor#.png
			this.image = ImageIO.read(getClass().getResource("/images/wallPaper"+ wallPaperType +".png")); // user.dir/scr/images/Floor#.png
		} catch (IOException e) {
			System.out.println("Fail to import image");
			e.printStackTrace();
		}
	}

}
