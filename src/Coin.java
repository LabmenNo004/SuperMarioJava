import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Coin extends GameObject{
	boolean move = false;
	
	public Coin(int x, int y,int length, int width) { //type for different type of blocks
		super(x,y,length,width);
		this.canCollide = false;
		
		
		//pulling image		
		try {
			this.image = ImageIO.read(new File(path+ "coin1.png")); // user.dir/scr/images/Block#.png
		} catch (IOException e) {
			System.out.println("Fail to import block image");
			e.printStackTrace();
		}
	}
	int counter = 0;
	public void tick() {
		if (counter<15) {
			y-=3;
			counter+=1;
		}else {
			this.visible = false;
		}
	}
}
