import java.awt.*;
import java.applet.*;
import java.io.*;
/*                      
<applet code="Bounce.class" width= 1600 height=900> 
<param name=radius value= 5> 
<param name=adjust value= 7> 
<param name=text value="DONE!"> 
</applet> 
*/ 
public class Bounce extends Applet  {
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
	int h,k;
	double x,y,xa,ya;
	g.setColor(new Color(255,255,255));
	g.fillRect(0,0,1600,900);	
	int red = 0,green = 0,blue = 0;
	double r;
	x = 0.5;
	y = 0.5;
	xa = 0.12;
	ya = -0.1;
	// change the following code
	for (;; ){		
				x = x + xa;
				y = y + ya;
				System.out.println(x+ " "+y);
				r = Math.random();
				if ((x*x >1)&(y*y <1)&(x >= 0)){xa = xa * -1; }
				if ((x*x < 1)&(y*y > 1)&(x >= 0)){ ya = ya * -1;  }
						
				if (x < 0)xa = xa * -1;
				if (y < 0)ya = ya * -1;
			
					
				
				//g.fillOval(x,y,20,20);
				h = (int)((x * 30) + 200);
				k = (int)(200 - (y *30));
				g.setColor(new Color(255,0,0));
				g.fillOval(h,k,10,10);	
				for (int p = 0; p < 100000;p++)
				g.setColor(new Color(255,255,0));
				g.fillOval(h,k,10,10);	
			
				
				
			}//end for
			
			
		}//end for y
}




