package Worlds;
 
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.net.URL;
import java.awt.geom.AffineTransform;
 
 
 
import Entities.Player;
 
 
public class WorldOne implements World
{
	
	Player player;
	
	//Location of Applet
	URL codeBase;
	
	// Image Resources
	BufferedImage paralax1Image;
	BufferedImage paralax2Image;
	BufferedImage backgroundImage;
	
	
	// Graphics Elements	
	int xRes;
	int yRes;
	double paralaxScale1,paralaxScale2;
 
	
	double worldSize;
	int frameX=1;
	int frameY=1;
	
	public WorldOne(Player player, URL codeBase, int xRes, int yRes)
	{
		this.player=player;
		this.codeBase=codeBase;
		this.xRes=xRes;
		this.yRes=yRes;
		
		
		worldSize=4000; 
				        
        String backgroundImagePath="worlds\\world1Graphics\\WorldOneBack.png";
        String paralax1ImagePath="worlds\\world1Graphics\\WorldOnePara1.png";
        String paralax2ImagePath="worlds\\world1Graphics\\WorldOnePara2.png";
		        		
 
        try
        {
        URL url1 = new URL(codeBase, backgroundImagePath);
    	URL url2 = new URL(codeBase, paralax1ImagePath);
    	URL url3 = new URL(codeBase, paralax2ImagePath);
    	
        backgroundImage = ImageIO.read(url1);
        
        paralax1Image  = ImageIO.read(url2);
        
        paralax2Image = ImageIO.read(url3);
        paralaxScale1=(paralax1Image.getWidth()-xRes)/worldSize;
        paralaxScale2=(paralax2Image.getWidth()-xRes)/worldSize;
        
        }
        catch (Exception e)
        {     
        	System.out.println("Failed to load Background Images in Scene");
        	System.out.println("Background Image Path:"+backgroundImagePath);
        	System.out.println("Background Image Path:"+paralax1ImagePath);
        	System.out.println("Background Image Path:"+paralax2ImagePath);
        }
        
        
        
	}//end constructor
	
	public double getWorldSize()
	{ 
		double xPos=player.getXPos();
		
		return worldSize;
	}
	
	public void setFramePos(int frameX, int frameY)
	{
		this.frameX=frameX;
		this.frameY=frameY;
	}
	
	public int getFrameXPos()
	{
		return frameX;
	}
	
	public int getFrameYPos()
	{
		return frameY;
	}
	
	public void paralax1Render(Graphics2D renderSpace)
	{
		int scaledFrame=(int)(paralaxScale1*frameX);
		renderSpace.drawImage(paralax1Image,-scaledFrame,0,null); //Comment this to increase performance Massively
		
	}
	public void paralax2Render(Graphics2D renderSpace)
	{
		int scaledFrame=(int)(paralaxScale2*frameX);
		renderSpace.drawImage(paralax2Image,-scaledFrame,0,null); //Comment this to increase performance Massively
		
	}
	public void backgroundRender(Graphics2D renderSpace)
	{
		renderSpace.drawImage(backgroundImage,null,null); //Comment this to increase performance Massively
	}
	public void entityRender(Graphics2D renderSpace)
	{
		//System.out.println(frameX);
		double xPos=player.getXPos()-frameX+xRes/2;
    	double yPos=player.getYPos();
    	int radius=15;
            		
							   
    	renderSpace.setColor (Color.blue);
        // paint a filled colored circle
    	
    	renderSpace.fillOval ((int)xPos - radius, (int)yPos - radius, 2 * radius, 2 * radius);
		renderSpace.setColor(Color.blue);
    	
    	
    	
	}
	public void particleRender(Graphics2D renderSpace)
	{
		//NYI
	}
	
	
	public void render(Graphics2D renderSpace)
	{
		backgroundRender(renderSpace);
		paralax2Render(renderSpace);
		entityRender(renderSpace);
		paralax1Render(renderSpace);
	}
	
	
	
}//end class WorldOne