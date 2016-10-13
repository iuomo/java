import java.awt.*;
import java.applet.*;
import java.io.*;

/*                      
<applet code="Bounce.class" width= 2048 height=2048> 
<param name=radius value= 5> 
<param name=text value="DONE!"> 
</applet> 
*/ 
public class Bounce2 extends Applet  {
int iradius;
	String m; 
	
public void init() {
  
       Font font = new java.awt.Font("Monospaced", Font.BOLD, 18);
        setFont(font);
        
        }

  public void start() { 
    String temp;
	
		
    temp = getParameter("radius"); 
    try { if(temp != null) iradius = Integer.parseInt(temp); 
      else  iradius = 0; } catch(NumberFormatException exc) {  iradius = -1;  } 
	
		m = getParameter("text"); 
    if(m == null) m = "not found"; 
  } 
 
public void paint(Graphics g) {
	// only edit code in the paint method
	//ired, igreen, iblue,redAjust, greenAjust, blueAjust
	int i,j,x,y,count,cmod,left;

	g.setColor(new Color(0,0,0));
	g.fillRect(0,0,2048,2048);	
	int red,green,blue;
	
	count = 0;
	left = 0;
	// change the following code
	for (y = 0; y < 2048; y = y + 7){
			for (x= 0; x < 2048; x = x + 11){
				//begin switch *******************************
				cmod = count % 5;  //mod 
				switch (cmod){
					case 0:
						red = 0;green =0;blue= 0;
						break;
					case 1:
						red = 5;green =5;blue= 5;
						break;
					case 2:
						red = 10;green =10;blue= 10;
						break;
					case 3:
						red = 15;green =15;blue= 15;
						break;
					case 4:
						red = 20;green =20;blue= 20;
						break;
					default:
						red= 25;green =25;blue= 25;
				
				}//end switch ****************************
				g.setColor(new Color(red,green,blue));
				g.fillOval(x,y,20,20);
				//g.fillRect(x,y);	
				count++;
			}//end for x
			count= count + 2;
			left = left + 5;
		}//end for y
	// you can stop changing now
	// g.setColor(new Color(0,0,200));
       // g.drawString(m,10,250);  
	
}
}



