// java Bounce project
import java.awt.*;
import java.applet.*;
import java.io.*;

/*   add at least one param name                    
<applet code="BounceBall.class" width= 800 height=600> 
<param name=radius value= 5> 
<param name=text value="DONE!"> 
</applet> 
*/ 
public class BounceBall extends Applet  {
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
	int i,j,x,y,count,cmod,p;
	int xadj = 16;
	int yadj = 12;
	x = 101;	
	y = 101;
	
	g.setColor(new Color(255,255,0));
	g.fillRect(0,0,800,600);	
	int red,green,blue;
	int a; //a = adjust
	count = 0;
	// change the following code

	for (; ; ){	
		x = x + xadj;
		y = y + yadj;
		cmod = count % 5;  //mod 
		if (count == 0){
			g.setColor(new Color(255,255,0));
			g.fillRect(0,0,800,600);
			g.setColor(new Color(255,255,255));
			g.fillRect(100,100,400,400);
		}
		g.setColor(new Color(0,0,0));
		g.fillOval(x,y,50,50);
		//pause here
		for (p = 0; p <100000000;p++);
		g.setColor(new Color(255,255,255));
		g.fillOval(x,y,50,50);
		//g.fillRect(100,100,400,400);	
		//System.out.print(y + " ");
		if (y < 100) yadj = (yadj * -1);
		if (y > 460) yadj = (yadj * -1);
		if (x < 100) xadj = (xadj * -1);
		if (x > 455) xadj = (xadj * -1);
				//g.fillRect(x,y,50,20);	
				count++;
	}//end for x
				
		
	// you can stop changing now
	// g.setColor(new Color(0,0,200));
       // g.drawString(m,10,250);  
	
}
}



