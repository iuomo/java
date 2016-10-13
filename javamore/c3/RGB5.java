import java.awt.*;
import java.applet.*;
import java.io.*;

/*                      
<applet code="RGB5.class" width= 256 height=256> 
<param name=red value=50> 
<param name=green value=200> 
<param name=blue value=10> 
<param name=redA value=3> 
<param name=greenA value=5> 
<param name=blueA value=7> 
<param name=text value="CIRCLE"> 
</applet> 
*/ 
public class RGB5 extends Applet  {
int ired, igreen, iblue,redAjust, greenAjust, blueAjust;
	String m; 
public void init() {
  
       Font font = new java.awt.Font("Monospaced", Font.BOLD, 18);
        setFont(font);
        
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
	  
	  temp = getParameter("redA"); 
	      try { if(temp != null) redAjust = Integer.parseInt(temp); 
      else  redAjust = 0; } catch(NumberFormatException exc) {  redAjust = -1;  } 
	  
	   temp = getParameter("greenA"); 
    try { if(temp != null) greenAjust = Integer.parseInt(temp); 
      else  greenAjust = 0; } catch(NumberFormatException exc) {  greenAjust = -1;  } 
	  
	   temp = getParameter("blueA"); 
    try { if(temp != null) blueAjust = Integer.parseInt(temp); 
      else  blueAjust = 0; } catch(NumberFormatException exc) {  blueAjust = -1;  } 
			
		m = getParameter("text"); 
    if(m == null) m = "not found"; 
  } 
 
public void paint(Graphics g) {
	//ired, igreen, iblue,redAjust, greenAjust, blueAjust
	int i,j,x,y;
	double pi;
	int a = 255;
	for (i = 0; i < 127; i++){
		if (ired > 255) ired = 0;if (ired < 0) ired = 255;
		if (igreen > 255) igreen = 0;if (igreen < 0) igreen = 255;
		if (iblue > 255) iblue = 0;if (iblue < 0) iblue =  255;
		g.setColor(new Color(ired,igreen,iblue));
		g.fillOval(i,i,a - (2*i),a -(2*i));	
		igreen =	igreen+greenAjust;
	iblue =	iblue + blueAjust;
	ired = ired + redAjust;
	
	}
	
	g.setColor(new Color(255,255,255));
         g.drawString(m,10,250);  
				
					  	
    }//end paint

 
  
  
}// end RGB4


