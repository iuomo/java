import java.awt.*;
import java.applet.*;
import java.io.*;

/*                      
<applet code="BounceSwitch.class" width= 500 height=500> 
<param name=radius value=10> 
<param name=text value="DONE!"> 
</applet> 
*/ 

public class BounceSwitch extends Applet  {
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
	int i,j,x,y,count,	cmod;

	g.setColor(new Color(0,0,0));
	g.fillRect(0,0,600,600);	
	int red,green,blue;
	
	count = 0;
	for (y = 0; y < 500; y = y + 20){
			for (x= 0; x < 500; x = x + 20){
				//begin switch
				cmod = count % 8;  //mod 
				switch (cmod){
					case 0:
						red = 255;green =0;blue= 0;
						break;
					case 1:
									red = 0;green =255;blue= 0;
						break;
					case 2:
									red = 0;green =0;blue= 255;
						break;
					
					case 3:
							red = 255;green =0;blue= 255;
						break;
					case 4:
						red = 100;green =100;blue= 100;
						break;
							case 5:
						red = 50;green =255;blue= 50;
						break;
							case 6:
						red = 255;green =255;blue= 10;
						break;
						default:
								red= 255;green =175;blue= 0;
				
				}//end switch
				g.setColor(new Color(red,green,blue));
			//	g.fillOval(x,y,20,20);
				g.fillRect(x,y,20,20);	
				count++;
			}//end for x
				}//end for y
					g.setColor(new Color(0,0,200));
        	g.drawString(m,10,450);  
	
}
}



