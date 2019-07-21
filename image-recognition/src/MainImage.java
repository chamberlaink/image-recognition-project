import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	final static int finalFrameWidth = 1600;
	final static int finalFrameHeight = 1200;
	
	/*
	 * Description: This method reads an image passed in and then displays it in a window 
	 * 
	 * Objectives:
	 * 	- read an image from input through command line
	 * 	- converts it to a BufferedImage
	 * 	- converts it to an imageIcon
	 * 
	 * Changes
	 * 	7/11/2019: method created
	 * 
	 * @author Keri Chamberlain
	 * 
	 * @param strFilename which is a file name of image 
	 */
	public static void readDisplayImage(final String strFilename) {
		BufferedImage bfImage = null;
		BufferedImage bfSubImage = null;
		
		JFrame frame = new JFrame("Satellite Image");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		File file = new File(strFilename);
		File outputFile = new File("image.jpeg");
		
		try {
			
			bfImage = ImageIO.read(file);
			bfSubImage = bfImage.getSubimage(0,0,30,30);
			ImageIO.write(bfSubImage, "jpeg", outputFile);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		// Displays the entire image
		/*ImageIcon imageIcon = new ImageIcon(bfImage);
		JLabel jLabel = new JLabel();
		jLabel.setIcon(imageIcon);
		frame.setPreferredSize(new Dimension(finalFrameWidth, finalFrameHeight));
		frame.getContentPane().add(jLabel, BorderLayout.CENTER);*/
		
		// Displays the 30 x 30 pixel image 
		/*ImageIcon subImageIcon = new ImageIcon(bfSubImage);
		JLabel subJLabel = new JLabel();
		subJLabel.setIcon(subImageIcon);
		frame.setPreferredSize(new Dimension(finalFrameWidth, finalFrameHeight));
		frame.getContentPane().add(subJLabel, BorderLayout.CENTER);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);*/
		
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
		readDisplayImage(args[0]);
	}

}

