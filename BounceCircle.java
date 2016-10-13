import java.awt.*;
import java.applet.*;
import java.io.*;
/*                      
<applet code="BounceCircle.class" width= 1600 height=900> 
<param name=radius value= 5> 
<param name=adjust value= 7> 
<param name=text value="DONE!"> 
</applet> 
*/ 
public class BounceCircle extends Applet  {
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
	int i,j,h,k,count,cmod,left;
	double x,y,xadj,yadj,tx,ty,p;
	double scale;
	boolean flag;	
	int red = 0,green = 0,blue = 0;
	x = 0; y = 0;
	h = (int)x; k = (int)y;
	count = 0;
	
	xadj = 0.1;
	yadj = 0.1;
	scale = 70;
		
	// change the following code
	g.setColor(new Color(0,0,255));
	g.fillRect(0,0,500,500);
	g.setColor(new Color(255,255,255));
	g.fillRect(50,50,400,400);
	flag = true;
	for (;;){ tx = 0;
		g.setColor(new Color(255,255,0));
		h = (int)(x * scale) + 250;
		k = 250 - (int)(y * scale);
		g.fillOval(h,k,20,20);
		x = x + xadj;	
		y = y + yadj;
		p = (x*x + y * y);
		if ((flag)&&(((x*x) +(y*y))) > 1.0){
			tx = Math.random()*0.1;
			ty = Math.random()*0.1;
			xadj = xadj * (-1.0 + tx);yadj = yadj * (-1.0 + ty);
			System.out.println(p+ " -p "+x+ " -x y- "+y+" "+h+" -h k- "+k+" tx - "+tx);
			flag = false;
		}

				
	}//end for 
			
			
		
	// you can stop changing now
	// g.setColor(new Color(0,0,200));
       // g.drawString(m,10,250);  
	
}
}



