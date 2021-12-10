import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.util.List;

import javax.imageio.ImageIO;

import  java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EnemyKuribo extends Enemy{
	
	protected static BufferedImage KuriImage = null;
	public Handler handler;
	
	
	
	public EnemyKuribo(int x, int y,int length, int width, Handler handler) {
		super(x,y,length,width,handler);
		this.image = KuriImage(); 
}
	public BufferedImage KuriImage (){
		//set background
		try {
			KuriImage = new BufferedImage(Map.getMarioSpawnCoord()[0],Map.getMarioSpawnCoord()[1], BufferedImage.TYPE_INT_ARGB);
			System.out.println("kuribo image loaded");
			KuriImage = ImageIO.read(new File(path+"kuribou1"+".png"));// user.dir/scr/images/bg#.png
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("failed to import background image");
			e.printStackTrace();
		} 
		return KuriImage;
	}
	
	
}