import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PipeHead extends GameObject{
	private int pipeHeadType;
	public boolean isHidden = false;
	
	//Constructor
	public PipeHead(int pipeHeadType, int x, int y,int length, int width, boolean isHidden) {
		super(x,y,length,width);
		this.canCollide = true;
		this.isHidden = isHidden;
		
		this.pipeHeadType = pipeHeadType;
		
		//pulling image		
		try {
			this.image = new BufferedImage(width, length, BufferedImage.TYPE_INT_ARGB);
			//this.image = ImageIO.read(new File(path+ "pipeHead"+ pipeHeadType +".png")); // user.dir/scr/images/Floor#.png
			this.image = ImageIO.read(getClass().getResource("/images/pipeHead"+ pipeHeadType +".png")); // user.dir/scr/images/Floor#.png
		} catch (IOException e) {
			System.out.println("Fail to import image");
			e.printStackTrace();
		}
	}
	public void reload() {
		try {
			this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			//this.image = ImageIO.read(new File(path + "pipeHead" + pipeHeadType + ".png")); // user.dir/scr/images/Floor#.png
			this.image = ImageIO.read(getClass().getResource("/images/pipeHead"+ pipeHeadType +".png")); // user.dir/scr/images/Floor#.png
		} catch (IOException e) {
			System.out.println("Fail to import image");
			e.printStackTrace();
		}
	}
}
