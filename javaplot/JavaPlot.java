//JavaPlot code by CWColeman

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


public class JavaPlot extends JFrame { 

   public JavaPlot()
   {
      super( "java plot" );
      setSize(800,600);  
      setVisible( true );   
   }

   public void paint( Graphics g )
   {
	   int x, y, h, k, t;	
		x = 0;  y = 0; h = 0; k = 0; t = 0;
	for (t = 0;t <800;t++){
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// only change code below this line
		g.setColor(new Color(255,0,0));//red
		g.drawLine(0,0,800,600);
		
		g.setColor(new Color(0,255,0));//green
		g.drawLine(0,0,790,590);

		g.setColor(new Color(0,0,255));//blue
		g.drawLine(0,0,780,580);
		
		g.setColor(new Color(255,255,0));//yellow
		g.drawLine(0,0,770,570);
		
		g.setColor(new Color(255,0,255));//cyan
		g.drawLine(0,0,760,560);
		
		g.setColor(new Color(255,0,255));//magenta
		g.drawLine(0,0,750,550);
			
		g.setColor(new Color(255,127,0));//orange
		g.drawLine(0,0,740+ h,540 +k);
		h = h - 10;
		k = k + 10;
		
		// call to Wait class
		System.out.println("Ctrl+c to stop. t = " + t+" h= "+h+" k ="+k);
		Wait.millSec(125);
	
		// only change code above this line
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	} 
}

  // execute application
   public static void main( String args[] )
   {
	   JavaPlot myobject = new JavaPlot();//change this 
	 
	   	// adapter to handle only windowClosing event
		myobject.addWindowListener(
			new WindowAdapter() {
				public void windowClosing( WindowEvent event )
				{System.exit( 0 );}
			}  // end anonymous inner class
		); // end call to addWindowListener
   }
}// end class Painter

