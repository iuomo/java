//code by CW Coleman
import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;


public class LinePlot extends JFrame {
	
   private static int clinputs[] = new int[8]; // This array gets used in two methods.
   
   public LinePlot()
   {  
      super( "Line Plot" );
      setSize(800,600);  
      setVisible( true );
       int clinputs[] = new  int[8]; 
   }

   public void paint( Graphics g)
   {
   // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// only change code below this line
	  int iRed, iGreen, iBlue, aiRed, aiGreen, aiBlue;//integer RGB
	   double sRed, sGreen, sBlue;// double start RGB
	   double eRed, eGreen, eBlue;// double end RGB
	   double aRed, aGreen, aBlue;// ajust RGB
	 int x1, y1, x2, y2, x3, y3, x4, y4, h, k, t;	
	x1= clinputs[0];
	      y1= clinputs[1];
	         x2= clinputs[2];
	            y2= clinputs[3];
	               x3= clinputs[4];
	                  y3= clinputs[5];
	                     x4= clinputs[6];
	                        y4= clinputs[7];
	                          
	System.out.println("x1="+x1+" y1="+y1+" x2="+x2+" y2="+y2+" x3="+x3+" y3"+y3+" x4="+x4+" y4="+y4);
	iRed = 255;  iGreen = 0; iBlue = 180;	   
	   g.setColor(new Color(iRed,iGreen,iBlue));
	   g.setColor(new Color(255,255,0));
	   g.fillRect(0, 0, 800, 600);
	   
	iRed = 0;  iGreen = 0; iBlue = 255;	
		g.setColor(new Color(iRed,iGreen,iBlue));
		g.drawLine(x1,y1,x2,y2);
	iRed = 255;  iGreen = 0; iBlue = 255;	
		g.setColor(new Color(iRed,iGreen,iBlue));
		g.drawLine(x3,y3,x4,y4);	
		g.drawOval(x1,y1,x2,y2);
		g.fillOval(x1,y1,x2/2,y2/2);
		
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
}

  // execute application
   public static void main( String args[] )
   {	
   	   
   	clinputs[0] = Integer.parseInt(args[0]);
   	clinputs[1] = Integer.parseInt(args[1]);
   	clinputs[2] = Integer.parseInt(args[2]);
   	clinputs[3] = Integer.parseInt(args[3]);
   	clinputs[4] = Integer.parseInt(args[4]);
   	clinputs[5] = Integer.parseInt(args[5]);
   	clinputs[6] = Integer.parseInt(args[6]);
   	clinputs[7] = Integer.parseInt(args[7]);
 
   	
   	   LinePlot myobject = new LinePlot();//change this
	   	// adapter to handle only windowClosing event
		myobject.addWindowListener(
			new WindowAdapter() {
				public void windowClosing( WindowEvent event )
				{System.exit( 0 );}
			}  
		); // end call to addWindowListener
   }
}// end class Painter
