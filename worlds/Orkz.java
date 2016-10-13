import javax.swing.JApplet;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import Entities.*;
import Worlds.*;
 
 
// run this applet in 640x480
public class Orkz extends JApplet implements Runnable, KeyListener
{
 
	double x_pos = 10;
	double y_pos = 400;
	int xRes=640;
	int yRes=480;
	boolean up_held;
	boolean down_held;
	boolean left_held;
	boolean right_held;
	boolean jump_held;
	Player player;
	World world;
	
	BufferedImage buffer;
	Graphics2D bufferG2D;
	
	
	int radius = 20; 
	
	
	public void init()
	{		
		
		//xRes=(int) this.getSize().getWidth();
		//yRes=(int) this.getSize().getHeight();
        buffer=new BufferedImage(xRes, yRes, BufferedImage.TYPE_INT_RGB);
        
        bufferG2D=buffer.createGraphics();
        
		addKeyListener(this);
	}
 
 
	
	public void start ()
	{
		  player=new Player(320, 240, xRes,yRes);
		  world=new WorldOne(player, getCodeBase(), xRes, yRes);
		  player.setWorld(world);
		  
		  
	      // define a new thread
	      Thread th = new Thread (this);
	      // start this thread
	      th.start ();
 
	} 
	public void keyPressed(KeyEvent e)
	{
		//works fine
			
	}//end public void keypressed
 
	public void keyReleased(KeyEvent e)
	{
		//this works fine
	}
 
	public void keyTyped(KeyEvent e)
	{
 
	}
	
	public void paint( Graphics g ) 
	{
	      update( g );
	}
	
    public void update(Graphics g) 
    {
    	Graphics2D g2 = (Graphics2D)g;         	
    	world.render(bufferG2D);    	        
    	g2.drawImage(buffer, null, null);
    }
 
 
	public void run() 
	{
		// lower ThreadPriority
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		long tm;
		long tm2;
		long tm3;
		long tmAhead=0;
		
		
		
		// run a long while (true) this means in our case "always"
		while (true)
		{
			tm = System.currentTimeMillis();
			player.moveEntity();
	    	x_pos=player.getXPos();
	    	y_pos=player.getYPos();
	    	tm2 = System.currentTimeMillis();
	    	
			 if ((tm2-tm)<20)
			 {
		       // repaint the applet
		       repaint();
			 }
			 else
			 {
				 System.out.println("Skipped draw");
			 }
			 tm3= System.currentTimeMillis();
			 
			 tmAhead=25-(tm3-tm);
		      try
		      {
		          if (tmAhead>0)  
		          {
		    	  // Stop thread for 20 milliseconds
		            Thread.sleep (tmAhead);
		            tmAhead=0;
		          }
		          else
		          {
		        	  System.out.println("Behind");
		          }
		      }
		      catch (InterruptedException ex)
		      {
		            System.out.println("Exception");
		      }
 
		      // set ThreadPriority to maximum value
		      Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
 
		} 	
	}
	
	
	public void stop() { }
 
	public void destroy() { } 
}
