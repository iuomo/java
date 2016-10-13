// java Bounce project
import java.awt.*;
import java.applet.*;
import java.io.*;

/*   add at least one param name                    
<applet code="Bounce.class" width= 1600 height=900> 
<param name=radius value= 5> 
<param name=text value="DONE!"> 
</applet> 
*/ 
public class Bounce extends Applet  {
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
	int i,j,x,y,count,cmod;

	g.setColor(new Color(0,0,0));
	g.fillRect(0,0,1600,900);	
	int red,green,blue;
	int a; //a = adjust
	count = 0;
	// change the following code
	for (y = 0; y < 1600; y = y + 50){
			for (x= 0; x < 900; x = x + 10){
				//begin switch *******************************
				cmod = count % 5;  //mod 
				switch (cmod){
					case 0:
						red = 255;green =255;blue= 0;
						break;
					case 1:
						red = red + 10;green = green + 10;blue= 50;
						break;
					case 2:
						red = 255;green =255;blue= 0;
						break;
					case 3:
						red = 25;green =0;blue= 55;
						break;
					case 4:
						red = 5;green =25;blue= 100;
						break;
					default:
						red= 0;green =0;blue= 0;
				
				}//end switch ****************************
				g.setColor(new Color(red,green,blue));
				//g.fillOval(x,y,20,20);
				g.fillRect(x,y,50,20);	
				count++;
			}//end for x
				count = count +2;
		}//end for y
	// you can stop changing now
	// g.setColor(new Color(0,0,200));
       // g.drawString(m,10,250);  
	
}
}



