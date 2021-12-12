import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Block extends GameObject{
	private int blockType;
	
	//Constructor
	public Block(int blockType, int x, int y,int length, int width) { //type for different type of blocks
		super(x,y,length,width);
		this.canCollide = true;
		
		this.blockType = blockType;
		
		//pulling image		
		try {
			this.image = new BufferedImage(width, length, BufferedImage.TYPE_INT_ARGB);
			this.image = ImageIO.read(new File(path+ "block"+ blockType +".png")); // user.dir/scr/images/Block#.png
		} catch (IOException e) {
			System.out.println("Fail to import block image");
			e.printStackTrace();
		}
	}
	public int getBlockType() {
		return blockType;
	}
	public void change() {
		try {
			this.image = ImageIO.read(new File(path+ "block8.png"));
			Stage.interactives.add(new Coin(x,y,height,width));
			SuperMario.eatCoin();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}