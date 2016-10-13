// this algorithm written by Craig Coleman
import java.awt.*;
import java.applet.*;
import java.lang.*;
/*
<applet code="PlotSin.class" width=500 height=500>
</applet>
*/

public class PlotSin extends Applet implements Runnable {
  Thread t = null;
  int state;
  boolean stopFlag;
  
 	

  // Set colors and initialize thread.
  public void init() {
    setBackground(Color.white);
    setForeground(Color.black);
  }

  // Start thread
  public void start() {
    t = new Thread(this);
    stopFlag = false;
    t.start();
  }

  // Entry point for the thread that runs the banner.
  public void run() {
    char ch;

    for( ; ; ) {
      try {
        repaint();
        Thread.sleep(500);

        if(stopFlag)
          break;
      } catch(InterruptedException e) {}
    }
  }

  // Pause the banner.
  public void stop() {
    stopFlag = true;
    t = null;
  }


  public void paint(Graphics g) {
 
		int d;
		double rad;
		double pi = 3.1416;
		int yInt, xInt;
		double x,y;
		int xScale = 2;
		int yScale = 10;
 			for (d = 0;d < 360;d++){
				
				rad = (d * (pi/180));
				xInt = d * xScale;
				y = Math.sin(rad);
				yInt = (int)(y *yScale);
				g.drawLine(xInt,yInt+100,xInt,yInt+100);
					
	}
	
		
  }

}
