import java.awt.*;
import java.applet.*;
import java.io.*;

/* 
<applet code="Julia.class" width= 800 height=800> 
<param name=mssg value="DRAW RGB"> 
<param name=red value=255> 
<param name=green value=0 >
<param name=blue value=100>
<param name=redAjust value=20>
<param name=greenAjust value=0 >
<param name=blueAjust value=10>
<param name=limit value=0> 

<param name=c1 value=1-7>
<param name=c2 value=0>
</applet> 
*/ 
public class Julia extends Applet  {
	int red, green, blue,redAjust, greenAjust, blueAjust,limit;
	double c1,c2;

  public void start() { 
    String temp; 

    temp = getParameter("red"); 
    try { if(temp != null) red = Integer.parseInt(temp); 
      else  red = 0; } catch(NumberFormatException exc) {  red = -1;  } 
	  
	   temp = getParameter("green"); 
    try { if(temp != null) green = Integer.parseInt(temp); 
      else  green = 0; } catch(NumberFormatException exc) {  green = -1;  } 
	  
	   temp = getParameter("blue"); 
    try { if(temp != null) blue = Integer.parseInt(temp); 
      else  blue = 0; } catch(NumberFormatException exc) {  blue = -1;  } 
	  
	      try { if(temp != null) redAjust = Integer.parseInt(temp); 
      else  redAjust = 0; } catch(NumberFormatException exc) {  redAjust = -1;  } 
	  
	   temp = getParameter("greenAjust"); 
    try { if(temp != null) greenAjust = Integer.parseInt(temp); 
      else  greenAjust = 0; } catch(NumberFormatException exc) {  greenAjust = -1;  } 
	  
	   temp = getParameter("blueAjust"); 
    try { if(temp != null) blue = Integer.parseInt(temp); 
      else  blueAjust = 0; } catch(NumberFormatException exc) {  blueAjust = -1;  } 
	  
	   temp = getParameter("limit"); 
    try { if(temp != null) limit = Integer.parseInt(temp); 
      else  limit = 0; } catch(NumberFormatException exc) {  limit = -1;  } 
	   
	     temp = getParameter("c1"); 
    try { if(temp != null) c1 = Double.parseDouble(temp); 
      else  c1 = 0; } catch(NumberFormatException exc) {  c1 = -1;  } 
	  
	  temp = getParameter("c2"); 
    try { if(temp != null) c2 = Double.parseDouble(temp); 
      else  c2 = 0; } catch(NumberFormatException exc) {  c2 = -1;  } 
	  
	  
	  
  } 
 
public void paint(Graphics g) {
	int ared[] = new int[256];
	int agreen[] = new int[256];
	int ablue[] = new int[256];
	int i;
	
	int rval = 0;
	    	int  j,p;
		int k;
	    	double x,y,x1,x2,y1,z;
		double id, jd;
	
		int Iterations = 200;
		String msg;
        	
		for (i = 0; i < 256;i++){
			ared[i] = red;
			agreen[i] = green;
			ablue[i] = blue;
			red = red+redAjust;
			green = green+greenAjust;
			blue = blue+blueAjust;
		if (red > 255) red = 0;if (red < 0) red = 255;
	if (green > 255) green = 0;if (green < 0) green = 255;
		if (blue > 255) blue = 0;if (blue < 255) blue =  255;
	}
			g.setColor(new Color(255,255,255));
			g.fillRect(0,0,700,700);
		for (j = 0 ; j < 700 ; j++) {
			jd = (double) j;
			y1 = (350 - jd) / 175;
				for (i = 0; i < 700; i++){
					id = (double) i;
					x1 = (id - 350) / 175;			
					x = x1;
					y = y1;
					//g.drawString(k, 10, 10);
					z = 0.0;
					k = 0;
					do {
						x2 = (x * x) - (y * y) + c1;
						y = (2 * x * y) + c2;
						x = x2;
						z = (x * x) + (y * y);
						k++;							
					}while ((k < Iterations) & (z < 4.0));
						if (k > limit) {
							if (k > 255) k = 255;
								g.setColor(new Color(ared[k],agreen[k],ablue[k]));
							g.drawLine(i,j,i,j);
						}
	    	}//end for i
        }//end for j
    }//end paint

}// end Julia2

