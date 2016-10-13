// Julia.java source by Craig Coleman
import java.awt.*;
import java.applet.*;
import java.io.*;

/*                      
<applet name="pattern" code="Graph.class" width="1200" height="1000">
<param name=red value=198> 
<param name=green value=231> 
<param name=blue value=222> 
</applet>  
*/ 
public class Graph extends Applet  {
	
	int  ired, igreen, iblue;
     public void init() 
     {

  
     }

  public void start() { 
    String temp; 
  
    temp = getParameter("red"); 
    try { if(temp != null) ired = Integer.parseInt(temp); 
      else  ired = 0; } catch(NumberFormatException exc) {  ired = -1;  } 
	  
	   temp = getParameter("green"); 
    try { if(temp != null) igreen = Integer.parseInt(temp); 
      else  igreen = 0; } catch(NumberFormatException exc) {  igreen = -1;  } 
	  
	   temp = getParameter("blue"); 
    try { if(temp != null) iblue = Integer.parseInt(temp);
      else  iblue = 0; } catch(NumberFormatException exc) {  iblue = -1;  }	  
	 	  
  } 
 
public void paint(Graphics g) {
		int x, y, nred, ngreen, nblue;
        	g.setColor(new Color(255,255,255));
			g.fillRect(0,0,650,700);
			g.setColor(new Color(0,0,0));
			g.drawString("red:"+ired,510,90);
			g.drawString("green:"+igreen,510,110);
			g.drawString("blue:"+iblue,510,130);
			nred = ired;
			ngreen = igreen;
			nblue = iblue;
		
		//	g.setColor(new Color(255,255,255));
		//	g.fillRect(0,0,500,500);
		int adjust = 10;
			for (x = 0 ; x < 500 ;x = x + adjust) {
				for (y = 0; y < 500; y = y + adjust){
				g.setColor(new Color(190,240,240));
				if ((x == 250 )||(y == 250)){g.setColor(new Color(0,0,102));}
				g.drawLine(x,0,x,500);
				g.drawLine(0,y,500,y);
				//System.out.prin"+y);	
			}
	    	}//end for i
		 //plot sin
	  double t = -6.2832;
	  double amp = 30;
	  double add_to_t = (( 4*3.1416 )/500);
	  x = 0;
	  while (t < 6.3){
		y = (int) (amp * Math.sin(t));
		g.setColor(new Color(255,127,0));
		g.drawLine(x,250-y,x,250-y);  
		t = t + add_to_t;
		x ++;
		  
	  }
		
        }//end paint
         

 }//end Pattern



