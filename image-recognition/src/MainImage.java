import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Scanner;

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
	protected static int g_intSubImageHeight;
	protected static int g_intSubImageWidth;
	protected static int g_intOverlap;
	
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
		
		initialize(0, 0, 0, 0, 0, 0, 0);
	}
	
	/*
	 * Description: setter method of overlap
	 * 
	 * Objectives:
	 * 	- sets global intOverlap to it's local variable 
	 * 
	 * Changes
	 * 	7/24/2019: method created 
	 * 
	 * @author Keri Chamberlain
	 * 
	 * @param intOverlap local variable 
	 *
	 */
	public static void setOverlap(int intOverlap) {
		g_intOverlap = intOverlap;
	}
	
	/*
	 * Description: setter method of position x
	 * 
	 * Objectives:
	 * 	- sets global x to it's local variable 
	 * 
	 * Changes
	 * 	8/13/2019: method created 
	 * 
	 * @author Keri Chamberlain
	 * 
	 * @param intX local variable x
	 *
	 */
	public static void setX(int intX) {
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
	public static void setY(int intY) {
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
	 * Description: setter method of sub image height 
	 * 
	 * Objectives:
	 * 	- sets global sub height to it's local variable 
	 * 
	 * Changes
	 * 	7/24/2019: method created 
	 * 
	 * @author Keri Chamberlain
	 * 
	 * @param intSubHeight local variable height 
	 *
	 */
	public static void setSubHeight(int intSubHeight) {
		g_intSubImageHeight = intSubHeight;
	}
	
	/*
	 * Description: setter method of sub image width 
	 * 
	 * Objectives:
	 * 	- sets global sub width to it's local variable 
	 * 
	 * Changes
	 * 	7/24/2019: method created 
	 * 
	 * @author Keri Chamberlain
	 * 
	 * @param intSubWidth local variable width 
	 *
	 */
	public static void setSubWidth(int intSubWidth) {
		g_intSubImageWidth = intSubWidth;
	}
	
	/*
	 * Description: getter method of overlap
	 * 
	 * Objectives:
	 * 	- returns global overlap
	 * 
	 * Changes
	 * 	8/13/2019: method created 
	 * 
	 * @author Keri Chamberlain
	 * 
	 * @return g_intOverlap global variable overlap
	 *
	 */
	
	public int getOverlap() {
		return g_intOverlap;
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
	 * Description: getter method of sub image height
	 * 
	 * Objectives:
	 * 	- returns global sub image height 
	 * 
	 * Changes
	 * 	7/24/2019: method created 
	 * 
	 * @author Keri Chamberlain
	 * 
	 * @return g_intSubImageHeight global sub image height 
	 *
	 */
	public int getSubHeight() {
		return g_intSubImageHeight;
	}
	
	/*
	 * Description: getter method of sub image width
	 * 
	 * Objectives:
	 * 	- returns global sub image width 
	 * 
	 * Changes
	 * 	7/24/2019: method created 
	 * 
	 * @author Keri Chamberlain
	 * 
	 * @return g_intSubImageWidth global sub image width 
	 *
	 */
	public int getSubWidth() {
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
	 * @param intSubHeight sub image height
	 * @param intSubWidth sub image width
	 * @param intOverlap overlap on image chosen by user 
	 *
	 */
	public void initialize(int intX, int intY, int intHeight, int intWidth, int intSubHeight, int intSubWidth, int intOverlap) {
		g_intPositionX = intX;
		g_intPositionY = intY;
		g_intImageHeight = intHeight;
		g_intImageWidth = intWidth;
		g_intSubImageHeight = intSubHeight;
		g_intSubImageWidth = intSubWidth;
		g_intOverlap = intOverlap;
		
	}
	
	/*
	 * Description: This method gives a percent of overlap for each image, chosen by the user
	 * 
	 * Objectives:
	 * 	- reads the users choice of overlap
	 * 	- user can choose an overlap of 0, 25, or 50 pixels
	 * 
	 * Changes
	 * 	8/13/2019: method created
	 * 
	 * @author Keri Chamberlain
	 * 
	 */
	
	public static void imageOverlap() {
		
		int intOverlapPercentage = 0;
		
		Scanner scanInput = new Scanner(System.in);
		
		System.out.println("Enter Percentage (0, 25, or 50) of overlap: ");
		intOverlapPercentage = scanInput.nextInt();
		
		switch(intOverlapPercentage) {
		case 0:
			System.out.println("The overlap entered is 0");
			setOverlap(0);
			break;
		case 25:
			System.out.println("The overlap entered is 25");
			setOverlap(25);
			break;
		case 50:
			System.out.println("The overlap entered is 50");
			setOverlap(50);
			break;
		default:
			System.out.println("Invalid Input");
			break;
			
		}
		
		scanInput.close();
		
		
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
	 * 	8/5/2019: Every image is divided by 30x30 pixel with remaining amount (when it is odd) is portioned out as well
	 * 
	 * @author Keri Chamberlain
	 * 
	 * @param strFilename which is a file name of image 
	 */
	public static void readSaveImage(final String strFilename) {
		BufferedImage bfImage = null;
		BufferedImage bfSubImage = null;
		int intTempHeight = 0;
		int intTempWidth = 0;
		
		File file = new File(strFilename);
		File outputFile;
		
		try {
			
			bfImage = ImageIO.read(file);
			
			intTempHeight = bfImage.getHeight();
			intTempWidth = bfImage.getWidth();
			setSubHeight(30);
			setSubWidth(30);
			setHeight(intTempHeight - g_intSubImageHeight);
			setWidth(intTempWidth - g_intSubImageWidth);
			
			System.out.println("Image Height: " + g_intImageHeight + " Image Width: " + g_intImageWidth);
			System.out.println("SubImage Height: " + g_intSubImageHeight + " SubImage Width: " + g_intSubImageWidth);
			
			for(g_intPositionY = 0; g_intPositionY <= g_intImageHeight; g_intPositionY+=g_intSubImageHeight) {
				for(g_intPositionX = 0; g_intPositionX <= g_intImageWidth; g_intPositionX+=g_intSubImageWidth) {
				
					outputFile = new File("X" + g_intPositionX + "Y" + g_intPositionY + ".jpeg");
					bfSubImage = bfImage.getSubimage(g_intPositionX,g_intPositionY,g_intSubImageWidth,g_intSubImageHeight);
					ImageIO.write(bfSubImage, "jpeg", outputFile);
				
				}
			}
			
			setX(intTempWidth - g_intSubImageWidth);
			setY(intTempHeight - g_intSubImageHeight);
			
			outputFile = new File("X" + g_intPositionX + "Y" + g_intPositionY + ".jpeg");
			bfSubImage = bfImage.getSubimage(g_intPositionX,g_intPositionY,g_intSubImageWidth,g_intSubImageHeight);
			ImageIO.write(bfSubImage, "jpeg", outputFile);
			
			System.out.println("Final X Position: " + g_intPositionX);
			System.out.println("Final Y Position: " + g_intPositionY);
			
			
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
		
		imageOverlap();
		//readSaveImage(args[0]);
	}

}

