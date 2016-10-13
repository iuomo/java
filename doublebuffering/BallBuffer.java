/*<applet code="BallBuffer.class" width=500 height=500>
</applet>
*/

import java.applet.*;
import java.awt.event.*;
import java.awt.*;

public class BallBuffer extends Applet implements MouseMotionListener, Runnable
{
	
	 
  //private Image offscreenImage = null; // The off-screen image used for double buffering.
  private Graphics offscreenGraphics = null;
  private Graphics primaryGraphics = null;
  private boolean done;
  private long pulseCount;
  private int pulseLength = 100;
  private boolean doubleBuffer = true;

	Thread t = null;
	int state;
	boolean stopFlag;
  
 	 double ratio= 0;
		double dart = 0;
		long ldart;
		double hit = 0;
		double s,x,y,sx,sy;
		int h=0,k=0;

     // The object we will use to write with instead of the standard screen graphics
     Graphics bg; //buffered graphic
     // The image that will contain everything that has been drawn on
     // bufferGraphics.
     Image offscreen;
     // To get the width and height of the applet.
     Dimension dim;
     int curX, curY;

     public void init() 
     {
          // We'll ask the width and height by this
          dim = getSize();
          // We'll redraw the applet eacht time the mouse has moved.
          addMouseMotionListener(this);
          setBackground(Color.black);
          // Create an offscreen image to draw on
          // Make it the size of the applet, this is just perfect larger
          // size could slow it down unnecessary.
          offscreen = createImage(dim.width,dim.height);
          // by doing this everything that is drawn by bufferGraphics
          // will be written on the offscreen image.
          bg = offscreen.getGraphics();
     }
     
      public void start() {
	      t = new Thread(this);
	      stopFlag = false;
	      t.start();
      }
       
        public void run()
	{
		done = false;
		while (!done)
		{
			try
			{
				// pause for this frame
				Thread.sleep(pulseLength);

				if (doubleBuffer)
					paintOffscreen(offscreen);
				else
					paintOffscreen(primaryGraphics);

				// paint off-screen image to primary display, if needed
				if (doubleBuffer)
					primaryGraphics.drawImage(offscreen, 0, 0, this);

				// increase the pulse count
				pulseCount++;
			} catch (InterruptedException e)
				{}
		}
	}
	
	  public void paintOffscreen(Graphics g)
	  	{
				// paint the off-screen image
				g.setColor(Color.black);
				g.fillRect(0, 0, getWidth(), getHeight());
		}
	
	
        
      public void paint(Graphics g) 
     {
          // Wipe off everything that has been drawn before
   
          bg.clearRect(0,0,dim.width,dim.width);
          bg.setColor(Color.red);
          bg.drawString("Double-buffered",10,10);
          // draw the oval at the current mouse position to the offscreen image
          bg.fillOval(curX,curY,20,20);
          // draw the offscreen image to the screen like a normal image.
          // Since offscreen is the screen width we start at 0,0.
          g.drawImage(offscreen,0,0,this);
     }

     // Always required for good double-buffering.
     // This will cause the applet not to first wipe off
     // previous drawings but to immediately repaint.
     // the wiping off also causes flickering.
     // Update is called automatically when repaint() is called.

     public void update(Graphics g)
     {
          paint(g);
     }
 

     // Save the current mouse position to paint a rectangle there.
     // and request a repaint()
     public void mouseMoved(MouseEvent evt) 
     {
      //   curX = evt.getX();
      //   curY = evt.getY();
      //   repaint();
     }
 

     // The necessary methods.
     public void mouseDragged(MouseEvent evt) 
     {
     }

 }

/*
This is all about double-buffering. It's easy to use and recommended to use always.
There is one dangerous pitfall here, when you create an offscreen image that's very large
the applet might run slow because it takes a lot of resources and effort.
I would not recommend offscreen images larger than 500*500 when redrawn at 30FPS.
(see Threads)
*/ 

