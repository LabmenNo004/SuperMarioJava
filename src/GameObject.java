import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameObject{
	private boolean canCollide;
	private int x;
	private int y;
	private int length; //for image?
	private int width; //for image?
	//need image and type of gameObject?	
	private int type; //need a list to represent # = what type of object
	private BufferedImage image; //changed to BufferedImage
	private static String path = System.getProperty("user.dir") + "/src/images/";
	
	//Constructor
	public GameObject(int type, int x, int y,int length, int width) { //canCollide can be determined by type 
		this.type = type;
		this.x = x;
		this.y = y;
		this.length = length;
		this.width = width;
		
		//pulling image & canCollide based on type
		try {
			this.image = new BufferedImage(width, length, BufferedImage.TYPE_INT_ARGB);
			this.image = ImageIO.read(new File(path + type +".png")); // user.dir/scr/images/#.png
		} catch (IOException e) {
			System.out.println("Fail to import image");
			e.printStackTrace();
		}
		
		//Maybe will put any transparent (aka canCollide = false) object after certain number of image;
		if (type > 100) { //putting 100 as placeholder, NEED to reconfirm later
			this.canCollide = false;			
		}else {
			this.canCollide = true;
		}
	}
	
	//Getter
	public BufferedImage getImage() {
		return this.image;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
