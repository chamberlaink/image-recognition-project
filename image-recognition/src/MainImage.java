import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/*
 * Description: Main image class where we read and display the image 
 * 
 * Objectives:
 * 	- to read the image through command line
 * 	- to display the image in output 
 * 
 * Changes:
 * 	7/10/2019: creation of the class 
 * 
 * @author Keri Chamberlain
 */
public class MainImage {
	
	protected static int g_intPositionX;
	protected static int g_intPositionY;
	protected static int g_intImageHeight;
	protected static int g_intImageWidth;
	
	/*
	 * Description: constructor for global variables  
	 * 
	 * Objectives:
	 * 	- initializes all global variables 
	 * 
	 * Changes
	 * 	7/24/2019: method created 
	 * 
	 * @author Keri Chamberlain
	 *
	 */
	public MainImage() {
		
		initialize(0, 0, 0, 0);
	}
	
	/*
	 * Description: setter method of position x
	 * 
	 * Objectives:
	 * 	- sets global x to it's local variable 
	 * 
	 * Changes
	 * 	7/24/2019: method created 
	 * 
	 * @author Keri Chamberlain
	 * 
	 * @param intX local variable x
	 *
	 */
	public void setX(int intX) {
		g_intPositionX = intX;
	}
	
	/*
	 * Description: setter method of position y
	 * 
	 * Objectives:
	 * 	- sets global y to it's local variable 
	 * 
	 * Changes
	 * 	7/24/2019: method created 
	 * 
	 * @author Keri Chamberlain
	 * 
	 * @param intY local variable y
	 *
	 */
	public void setY(int intY) {
		g_intPositionY = intY;
	}
	
	/*
	 * Description: setter method of image height 
	 * 
	 * Objectives:
	 * 	- sets global height to it's local variable 
	 * 
	 * Changes
	 * 	7/24/2019: method created 
	 * 
	 * @author Keri Chamberlain
	 * 
	 * @param intHeight local variable height 
	 *
	 */
	public static void setHeight(int intHeight) {
		g_intImageHeight = intHeight;
	}
	
	/*
	 * Description: setter method of image width 
	 * 
	 * Objectives:
	 * 	- sets global width to it's local variable 
	 * 
	 * Changes
	 * 	7/24/2019: method created 
	 * 
	 * @author Keri Chamberlain
	 * 
	 * @param intWidth local variable width 
	 *
	 */
	public static void setWidth(int intWidth) {
		g_intImageWidth = intWidth;
	}
	
	/*
	 * Description: getter method of position x
	 * 
	 * Objectives:
	 * 	- returns global position x
	 * 
	 * Changes
	 * 	7/24/2019: method created 
	 * 
	 * @author Keri Chamberlain
	 * 
	 * @return g_intPositionX global position x
	 *
	 */
	public int getX() {
		return g_intPositionX;
	}
	
	/*
	 * Description: getter method of position y
	 * 
	 * Objectives:
	 * 	- returns global position y
	 * 
	 * Changes
	 * 	7/24/2019: method created 
	 * 
	 * @author Keri Chamberlain
	 * 
	 * @return g_intPositionY global position y
	 *
	 */
	public int getY() {
		return g_intPositionY;
	}
	
	/*
	 * Description: getter method of image height
	 * 
	 * Objectives:
	 * 	- returns global image height 
	 * 
	 * Changes
	 * 	7/24/2019: method created 
	 * 
	 * @author Keri Chamberlain
	 * 
	 * @return g_intImageHeight global image height 
	 *
	 */
	public int getHeight() {
		return g_intImageHeight;
	}
	
	/*
	 * Description: getter method of image width
	 * 
	 * Objectives:
	 * 	- returns global image width 
	 * 
	 * Changes
	 * 	7/24/2019: method created 
	 * 
	 * @author Keri Chamberlain
	 * 
	 * @return g_intImageWidth global image width 
	 *
	 */
	public int getWidth() {
		return g_intImageWidth;
	}
	
	/*
	 * Description: can be called from any method to initialize global variables 
	 * 
	 * Objectives:
	 * 	- sets local variables to global to give them values  
	 * 
	 * Changes
	 * 	7/24/2019: method created 
	 * 
	 * @author Keri Chamberlain
	 * 
	 * @param intX position x
	 * @param intY position y
	 * @param intHeight image height
	 * @param intWidth image width
	 *
	 */
	public void initialize(int intX, int intY, int intHeight, int intWidth) {
		g_intPositionX = intX;
		g_intPositionY = intY;
		g_intImageHeight = intHeight;
		g_intImageWidth = intWidth;
	}
	
	/*
	 * Description: This method reads an image passed in and then displays it in a window 
	 * 
	 * Objectives:
	 * 	- read an image from input through command line
	 * 	- converts it to a BufferedImage
	 * 
	 * Changes
	 * 	7/11/2019: method created
	 * 	7/23/2019: Setting an image to be saved by it's x and y position
	 * 	7/24/2019: Getting the image height and width and looping through the image 
	 * 
	 * @author Keri Chamberlain
	 * 
	 * @param strFilename which is a file name of image 
	 */
	public static void readSaveImage(final String strFilename) {
		BufferedImage bfImage = null;
		BufferedImage bfSubImage = null;
		
		File file = new File(strFilename);
		File outputFile = new File("X" + g_intPositionX + "Y" + g_intPositionY + ".jpeg");
		
		try {
			
			bfImage = ImageIO.read(file);
			
			setHeight(bfImage.getHeight());
			setWidth(bfImage.getWidth());
			System.out.println("Image Height: " + g_intImageHeight + " Image Width: " + g_intImageWidth);
			
			bfSubImage = bfImage.getSubimage(g_intPositionX,g_intPositionY,30,30);
			ImageIO.write(bfSubImage, "jpeg", outputFile);
			
		}catch(Exception e) {
			System.out.println("No Image");
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	
	/*
	 * Description: This method is the main which calls all methods of the class
	 * 
	 * Objectives:
	 * 	- read in the command line arguments 
	 * 	- compute appropriate methods
	 * 
	 * Changes
	 * 	7/11/2019: method created
	 * 
	 * @author Keri Chamberlain
	 * 
	 * @param args a string 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		readSaveImage(args[0]);
	}

}

