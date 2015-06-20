package com.screenshots;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class ScreenShots {
	
	public static void main(String[] arg){
		try{
	        Robot robot = new Robot();
	        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
	        int width = (int) d.getWidth();
	        int height = (int) d.getHeight();
	        Image image = robot.createScreenCapture(new Rectangle(0, 0, width,height));
	        BufferedImage bi = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
	        Graphics g = bi.createGraphics();
	        g.drawImage(image, 0, 0, width, height, null);
	        String fileNameToSaveTo = System.getProperty("user.dir") + "/screenCapture_" + createTimeStampStr() + ".PNG";
	        File f = new File(fileNameToSaveTo);
	        f.createNewFile();
	        ImageIO.write(bi, "PNG", f);
        }catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error capturing Screen");
		}
		
   }
	
    public static String createTimeStampStr(){
        Calendar mycalendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
        String timeStamp = formatter.format(mycalendar.getTime());
        return timeStamp;
    }
}
