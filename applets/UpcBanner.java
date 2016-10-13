import java.awt.*;
import java.applet.*;
/*
<applet code="UpcBanner" width=800 height=70>
</applet>
*/

public class UpcBanner extends Applet implements Runnable {
  String msg = " A Simple Moving Banner.";
  int x,y;
  Thread t = null;
  int state;
  boolean stopFlag;

  // Set colors and initialize thread.
  public void init() {
    setBackground(Color.white);
    setForeground(Color.red);
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
	     
	   //   x = (int) (Math.random()*500);
	//      y = (int)(Math.random()*500);
        repaint();
        Thread.sleep(250);
        ch = msg.charAt(0);
        msg = msg.substring(1, msg.length());
        msg += ch;
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
    int k,i, j,rd,oe,be;
	double it;
	java.util.Random generator = new java.util.Random(System.currentTimeMillis());
	
	for (i = 0;i <800;i++){
	g.setColor(new Color(255,255,255));
	g.drawLine(i,0,i,70);
	}
      for (i = 0;i<800;i = i + 3){
		 it = (double) (generator.nextDouble());
		byte color=(byte)(it*600); 
		
		if(color %2==0){
			rd = 255; oe=255; be=255;
		}
		else {
			rd =0; oe=0; be=0;
		}
		g.setColor(new Color(rd,oe,be));
		for (j = 0; j < 3; j++){
			if ((i < 200)||(i>600)){g.drawLine(i+j,0,i+j,70);}
			else{
			g.drawLine(i+j,0,i+j,50);
			}
		}
	}//end fori
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	rd=0;oe=0;be=0;
	g.setColor(new Color(rd,oe,be));
	int x=100;int y=420;
	char code[] = new char[5];
	char thechar;
	String codestring1 = "";
	String codestring2 = "";
	for (k = 0; k < 5;k++){
		it = (double) (generator.nextDouble());
		code[k]=(char)(it*10+48);
	}
	int count = 4;
	for (k = 0; k < 5;k++){
		codestring1 = codestring1 + code[k];
		codestring2 = codestring2 + code[4-k];
	}	
	g.drawString(codestring1+ "     craigcoleman.com     "+codestring2,310,65);

  }
}
