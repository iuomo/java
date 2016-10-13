// this algorithm written by Craig Coleman
import java.awt.*;
import java.applet.*;
import java.lang.*;
/*
<applet code="PiApp" width=500 height=500>
</applet>
*/

public class PiApp extends Applet implements Runnable {
  Thread t = null;
  int state;
  boolean stopFlag;
  
 	 double ratio= 0;
		double dart = 0;
		long ldart;
		double hit = 0;
		double s,x,y,sx,sy;
		
		int h=0,k=0;

		int scale = 100;
		String sratio = "0";

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
 
		int i;
 			for (i = 0;i < 10000;i++){
				s = Math.random(); sx = 1; if (s > 0.5) sx = -1;
				s = Math.random(); sy = 1; if (s > 0.5) sy = -1;
				x = Math.random()*sx;
				y = Math.random()*sy;
			
					g.setColor(new Color(200,200,200));	
					if (((x*x)+(y*y))<=1.0){ hit++;
					if ((x > 0) & (y > 0)) 	g.setColor(new Color(255,0,0));
					if ((x < 0) & (y > 0)) 	g.setColor(new Color(0,255,0));
					if ((x < 0) & (y < 0)) 	g.setColor(new Color(0,0,255));
					if ((x > 0) & (y < 0)) 	g.setColor(new Color(255,255,16));
						
					}
					ratio = 4*(double)(hit/dart);
					
					//System.out.println(x+"\t"+y+"\t"+ratio);
					//System.out.println(ratio);
					
					h = (int) (x * scale)+scale;
					k = scale - ((int) (y * scale));
					g.drawLine(h,k,h,k);
					ldart = (long)dart;
					sratio = ""+ratio+" with "+ldart+ " ordered pairs.";
					if (dart % 1000 == 0){
						g.setColor(new Color(200,200,200));
						g.fillRect(0,300,600,50);
						g.setColor(new Color(0,0,0));
						g.drawString(sratio, 10,320);
					}
						dart++;
	}
	
		
  }
}

