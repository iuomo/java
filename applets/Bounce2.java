import java.awt.*;
import java.applet.*;
import java.io.*;

/*                      
<applet code="Bounce2.class" width= 2048 height=2048> 
<param name=radius value= 5> 
<param name=adjust value= 7> 
<param name=text value="DONE!"> 
</applet> 
*/ 
public class Bounce2 extends Applet  {
int iradius;
	int adj;
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
	   
      temp = getParameter("adjust");    
    try { if(temp != null) adj = Integer.parseInt(temp); 
      else  adj = 0; } catch(NumberFormatException exc) {  adj = -1;  } 
      
		m = getParameter("text"); 
    if(m == null) m = "not found"; 
  } 
 
public void paint(Graphics g) {
	// only edit code in the paint method
	//ired, igreen, iblue,redAjust, greenAjust, blueAjust
	int i,j,x,y,count,cmod,left;

	g.setColor(new Color(0,0,0));
	g.fillRect(0,0,2048,2048);	
	int red = 0,green = 0,blue = 0;

	count = 0;
	left = 0;
	// change the following code
	for (y = 0; y < 2048; y = y + adj){
			for (x= 0; x < 2048; x = x + adj){
				//begin switch *******************************
				cmod = count % 4;  //mod 
				switch (cmod){
					case 0:
						red = 0;green =0;blue= 0;
						break;
					case 1:
						red = red + adj;green =green + adj;blue= blue + adj;
						break;
					case 2:
						red = red + adj;green =green + adj;blue= blue + adj;
						break;
					case 3:
						red = red + adj;green =green + adj;blue= blue + adj;
						break;
					case 4:
						red = red + adj;green =green + adj;blue= blue + adj;
						break;
					default:
						red = red + adj;green =green + adj;blue= blue + adj;
				
				}//end switch ****************************
				g.setColor(new Color(red,green,blue));
				//g.fillOval(x,y,20,20);
				g.fillRect(x,y,20,20);	
				count++;
			}//end for x
			count= count + 2;
			left = left + adj;
		}//end for y
	// you can stop changing now
	// g.setColor(new Color(0,0,200));
       // g.drawString(m,10,250);  
	
}
}



