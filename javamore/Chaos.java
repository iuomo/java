import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

class Tri{
	
	Tri (Graphics g, int x, int y){
		g.setColor(new Color(200,200,200));
		//g.drawLine(x,y,200,200);
	}
}


public class Chaos extends JFrame { //change the name of class Coleman

   public Chaos()
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
	Tri ob = new Tri (g,20,20);
	int h1 = 220, k1 = 50;
	int h2 = 20, k2 = 320;
	int h3 = 420, k3 = 320;
	
	//g.setColor(new Color(0,0,255));
	
	//g.drawLine(h1,k1,h1,k1);
	//g.setColor(new Color(255,0,0));
	
	//g.drawLine(h2,k2,h2,k2);
	//g.setColor(new Color(0,0,255));
	
	//g.drawLine(h3,k3,h3,k3);
	
	//g.drawLine(sx,sy,sx,sy);
	
	g.setColor(new Color(255,0,0));
	int a,n,nx,ny;
	

		g.setColor(new Color(255,0,0));
		g.fillOval(h1-8,k1-15,5,5);
		
		g.setColor(new Color(0,255,0));
		g.fillOval(h2-7,k2+7,5,5);
		
		g.setColor(new Color(0,0,255));
		g.fillOval(h3-7,k3+7,5,5);
		
		g.setColor(new Color(0,255,255));
		int sx = 20, sy = 320;
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

	//for (p = 0;p<100000;p++);
	}//for a
	
}
  // execute application
   public static void main( String args[] )
   {
	   Chaos myobject = new Chaos();//change this 
	 
	   	// adapter to handle only windowClosing event
		myobject.addWindowListener(
			new WindowAdapter() {
				public void windowClosing( WindowEvent event )
				{System.exit( 0 );}
			}  // end anonymous inner class
		); // end call to addWindowListener
   }
}// end class Painter

