import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Flag extends GameObject {
	private int flagType;

	// Constructor
	public Flag(int flagType, int x, int y, int length, int width) {
		super(x, y, length, width);
		this.canCollide = false;

		this.flagType = flagType;

		// pulling image
		try {
			this.image = new BufferedImage(width, length, BufferedImage.TYPE_INT_ARGB);
			//this.image = ImageIO.read(new File(path + "flag" + flagType + ".png")); // user.dir/scr/images/Floor#.png
			this.image = ImageIO.read(getClass().getResource("/images/flag" + flagType + ".png")); // user.dir/scr/images/Floor#.png

		} catch (IOException e) {
			System.out.println("Fail to import image");
			e.printStackTrace();
		}
	}

	public void reload() {
		try {
			this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			//this.image = ImageIO.read(new File(path + "flag" + flagType + ".png")); // user.dir/scr/images/Floor#.png
			this.image = ImageIO.read(getClass().getResource("/images/flag" + flagType + ".png")); // user.dir/scr/images/Floor#.png
		} catch (IOException e) {
			System.out.println("Fail to import image");
			e.printStackTrace();
		}
	}

}
