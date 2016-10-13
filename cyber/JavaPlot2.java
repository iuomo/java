//JavaPlot2 code by CWColeman

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


public class JavaPlot2 extends JFrame { 

   public JavaPlot2()
   {
      super( "java plot" );
      setSize(800,600);  
      setVisible( true );   
   }

   public void paint( Graphics g )
   {
   
   
   // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// only change code below this line
	   int x, y, h, k, t;	
	   int iRed, iGreen, iBlue;//integer RGB
	   double sRed, sGreen, sBlue;// double start RGB
	   double eRed, eGreen, eBlue;// double end RGB
	   double aRed, aGreen, aBlue;// ajust RGB
		sRed = 0;   eRed = 127;
		sGreen = 211; eGreen = 127;
		sBlue = 0; eBlue =127;
		aRed = (eRed - sRed)/800;
		aGreen = (eGreen - sGreen)/800;
		aBlue = (eBlue - sBlue)/800;
		x = 0;  y = 0; h = 0; k = 0; t = 0;
		iRed = (int)sRed; iGreen = (int)sGreen; iBlue = (int)sBlue; 
		System.out.println("Ctrl+c to stop. r = " + aRed+" g = "+aGreen+" b ="+aBlue);
	
	for (t = 0;t <800;t++){
		
		sRed = sRed + aRed;
		sGreen = sGreen + aGreen;	
		sBlue = sBlue + aBlue;
		iRed = (int)sRed;
		iGreen = (int)sGreen;
		iBlue = (int)sBlue;
		g.setColor(new Color(iRed,iGreen,iBlue));
		g.drawLine(h,0,h,h);
		h = h + 1;
		k = k + 1;
		
		// call to Wait class
		//System.out.println("Ctrl+c to stop. t = " + t+" h= "+h+" k ="+k);
		//Wait.millSec(125);
	
		// only change code above this line
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	} 
}

  // execute application
   public static void main( String args[] )
   {
	   JavaPlot2 myobject = new JavaPlot2();//change this 
	 
	   	// adapter to handle only windowClosing event
		myobject.addWindowListener(
			new WindowAdapter() {
				public void windowClosing( WindowEvent event )
				{System.exit( 0 );}
			}  // end anonymous inner class
		); // end call to addWindowListener
   }
}// end class Painter


