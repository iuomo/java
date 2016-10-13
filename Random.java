import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

public class RandomColors extends JFrame { //change the name of class to match the name of the java file
	//  Use proper namesapce .  The name of the class should be capitalized.
	
   public RandomColors()
   {
      super( "random" );
      setSize(1024,960);  
      setVisible( true );   
   }

   public void paint( Graphics g )
   {
	int nx,ny,count;
	int red, green, blue,n;
	boolean done = false;
	while (!done){		
		red =	(int) (Math.random()*255);
		green =	(int) (Math.random()*255);
		blue = (int) (Math.random()*255);
		nx = (int) (Math.random()*1024);
		ny = (int) (Math.random()*960);
		n = (int) (Math.random()*10)%2;
		switch(n) {
		case 0:
			g.setColor(new Color(127,127,127));
			g.fillRect(nx,ny,5,5);
			break;
		case 1:
			g.setColor(new Color(red,green,blue));
			g.fillOval(nx,ny,5,5);
			break;
		default:
		
		g.setColor(new Color(0,0,255));
		g.drawLine(nx,ny,0,0);
		
	}
}

	
	
}//end paint
  // execute application
   public static void main( String args[] )
   {
	   Random myobject = new RandomColors();//change this to match the name of the file and class
	 
	   	// adapter to handle only windowClosing event
		myobject.addWindowListener(
			new WindowAdapter() {
				public void windowClosing( WindowEvent event )
				{System.exit( 0 );}
			}  // end anonymous inner class
		); // end call to addWindowListener
   }
}
