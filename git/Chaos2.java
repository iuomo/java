//chaos code by Craig W. Coleman
//  http://en.wikipedia.org/wiki/Sierpinski_triangle
import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

 class Wait {
  public static void oneSec() {
     try {
       Thread.currentThread().sleep(1000);
       }
     catch (InterruptedException e) {
       e.printStackTrace();
       }
     }  
  public static void manySec(long s) {
     try {
       Thread.currentThread().sleep(s * 1000);
       }
     catch (InterruptedException e) {
       e.printStackTrace();
       }
     }
      public static void millSec(long s) {
     try {
       Thread.currentThread().sleep(s);
       }
     catch (InterruptedException e) {
       e.printStackTrace();
       }
     }
}


public class Chaos2 extends JFrame { //change the name of class Coleman

   public Chaos2()
   {
      super( "chaos" );
      setSize(720,520);  
      setVisible( true );   
   }

   public void paint( Graphics g )
   {
	   

	// this algorithm written by Craig Coleman
	int red;int green;int blue,p;
	red = 255; green = 255; blue = 255;
	g.setColor(new Color(red,green,blue));//change the bg color
	g.fillRect(0,0,720,520);
	red = 255; green = 255; blue = 255;
	g.setColor(new Color(0,0,255));
	//g.drawLine(0,0,200,200);
	
	//set up chaos	
	
	int h1 = 360, k1 = 20;
	int h2 = 10, k2 = 510;
	int h3 = 710, k3 = 510;
	
	g.setColor(new Color(0,0,255));
	
	g.drawLine(h1,k1,h1,k1);
	g.setColor(new Color(255,0,0));
	
	g.drawLine(h2,k2,h2,k2);
	g.setColor(new Color(0,0,255));
	
	g.drawLine(h3,k3,h3,k3);
	g.setColor(new Color(0,255,255));
	
	//g.drawLine(sx,sy,sx,sy);
	
	
	g.setColor(new Color(255,0,0));
	int a,n,nx,ny;
	n = 0;

		g.setColor(new Color(255,0,0));
		g.fillOval(h1-8,k1-15,5,5);
		
		g.setColor(new Color(0,255,0));
		g.fillOval(h2-7,k2+7,5,5);
		
		g.setColor(new Color(0,0,255));
		g.fillOval(h3-7,k3+7,5,5);
		
		g.setColor(new Color(0,255,255));
		int sx = 200, sy = 200;
		//int sx = 10, sy = 10;
		
		//g.fillOval(sx,sy,15,15);
	for (a = 0;a <500000;a++){
		int z = 2;
		n = (int)( Math.random()*3);
	switch(n) {
	case 0:
		nx = (int) ((sx+h1)/z);
		ny = (int) ((sy+k1)/z);
		g.setColor(new Color(255,0,0));
		g.drawLine(nx,ny,nx,ny);
		sx = nx;sy = ny;
		break;
	case 1:
		nx = (int) ((sx + h2) / z);
		ny = (int) ((sy+ k2)/z);
		g.setColor(new Color(0,150,10));
		g.drawLine(nx,ny,nx,ny);
		sx = nx;sy = ny;
		break;
	default:
		nx = (int) ((sx + h3) / z);
		ny = (int) ((sy + k3)/z);
		g.setColor(new Color(0,0,255));
		g.drawLine(nx,ny,nx,ny);
		sx = nx;sy = ny;
	}

// pause

//System.out.println("Wait one second");
  //   Wait.oneSec();
   //  System.out.println("Done\nWait five seconds");
  //   Wait.millSec(1);
   //  System.out.println("Done");
	} 
	
}
  // execute application
   public static void main( String args[] )
   {
	   Chaos2 myobject = new Chaos2();//change this 
	 
	   	// adapter to handle only windowClosing event
		myobject.addWindowListener(
			new WindowAdapter() {
				public void windowClosing( WindowEvent event )
				{System.exit( 0 );}
			}  // end anonymous inner class
		); // end call to addWindowListener
   }
}// end class Painter

