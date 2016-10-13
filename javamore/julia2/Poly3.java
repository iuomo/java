// Julia.java source by Craig Coleman
import java.awt.*;
import java.applet.*;
import java.io.*;

/*
<applet code="Poly3.class" width= 600 height=500>
</applet>
*/

public class Poly3 extends Applet  {
	String input_c1,inout_c2;
	int iscale, ired, igreen, iblue,redAjust, greenAjust, blueAjust,limit;
double c1,c2;

  public void start() { 
   	 	  
  } 
 
public void paint(Graphics g) {
	int x,h0 = 0,k0 = 0,  h1 = 0,k1 = 0;
	double y; 
	g.setColor(new Color(255,255,255));
	g.fillRect(0,0,650,700);
	g.setColor(new Color(0,0,0));
	g.drawString("Poly.java",300,50);
	// draw and x y here
	g.setColor(new Color(0,0,0));
	g.drawString("X",505,255);
	g.drawLine(10,250,500,250);
	g.setColor(new Color(0,0,0));
	g.drawLine(250,15,250,480);
	g.drawString("Y",247,12);
	//
	int count = 0;
	for (x = -250 ; x < 250 ; x++) {
		
		h0 = 250 + x;
		y = -0.3 * (x * x) + (2* x) + 1;
		k0 = 250 - (int) y ;
		if (count > 0){
			g.setColor(new Color(255,0,0));
			g.drawLine(h0,k0,h1,k1);
			System.out.println(h0+" \t "+k0);
			System.out.println(h1+" \t "+k1+"\n\n");
			g.setColor(new Color(0,0,255));
			g.fillOval(h1,k1,3,3);
			
		}
		count++;
		h1 = h0; 
		k1 = k0;
		
	}//end for j
}//end paint

 
  
  public void setREDajust(String temp) {
	redAjust = Integer.parseInt(temp); 
  
  }              
  
    public void setGREENajust(String temp) {
	greenAjust = Integer.parseInt(temp); 

  }              
    public void setBLUEajust(String temp) {
	blueAjust = Integer.parseInt(temp); 

  }  
  
  public void setC1(String temp) {
	c1 = Double.valueOf(temp).doubleValue();

  }                                                           
public void setC2(String temp) {
	c2 = Double.valueOf(temp).doubleValue();
    repaint();
  }  
  
}// end Julia2


