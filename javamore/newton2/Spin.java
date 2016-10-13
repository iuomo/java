import java.awt.*;
import java.applet.*;
import java.lang.*;
/*
<applet code="Spin" width=800 height=700>
</applet>
*/

public class Spin extends Applet implements Runnable {
  int x,y;
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

    // Display banner 
    for( ; ; ) {
      try {
        repaint();
        Thread.sleep(250);
     //   ch = msg.charAt(0);
     //   msg = msg.substring(1, msg.length());
     //   msg += ch;
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

  // Display the banner.
  public void paint(Graphics g) {
   // this algorithm written by Craig Coleman
	 int h,k,c,red,green,blue;
	 double x,y;
	 red = 255; green = 0; blue = 0;
	 int mcount;
	 //g.setColor(new Color(red,green,blue));
	//					g.fillRect(0,0,500,500);
			c = 0;
	for (h = -200; h <= 200; h ++ ){
	for (k = -200; k <= 200; k++){
	x =(double)h/100;
	y =(double)k/100;

	//	INewtonMethod n = new INewtonMethod(x,y,4,1000000L);
					c++;
					mcount = c % 100;
						g.drawLine(h+200,k+200,200-h,200-k);
						 g.setColor(new Color(mcount,mcount,mcount));
}//end for h
}//end for k
		
						g.setColor(new Color(0,0,0));
						g.drawString("Newton's Method", 10,450);
	 					
			
	 
	 
  }
}

