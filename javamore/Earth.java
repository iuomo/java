import java.awt.*;
import java.applet.*;
import java.io.*;
/*                      
<applet code="Earth.class" width= 800 height=600> 
</applet> 
*/ 
public class Earth extends Applet  {
int iradius;
	int adj;
	String m; 
	
public void init() {
  
       Font font = new java.awt.Font("Monospaced", Font.BOLD, 18);
        setFont(font);
        
        }

  public void start() { 
    } 
 
public void paint(Graphics g) {
	int h,k,x;
	
	for(;;){
		h = 0;k = 0; 
		g.setColor(new Color(0,0,0));
		g.fillRect(0,0,800,600);
		g.setColor(new Color(0,0,255));
		g.fillOval(100,100,350,350);
		for (x = 0; x < 18; x++){
			g.setColor(new Color(170,170,230));
			g.drawOval(100-x,100-x,350+2*x,350+2*x);//ice
			
			g.setColor(new Color(0,0,0));
			g.fillRect(250,60,50,50-(k));
			
			g.setColor(new Color(255,255,255));
			g.fillRect(250,60+k,50,55-(2*k));
			
			k = k + 2;
			g.setColor(new Color(170,170,230));
			g.fillOval(100-h,100-h,350+2*h,350+2*h);
			if (x % 8 == 0)h++;
				g.setColor(new Color(0,0,255));
				g.fillOval(100,100,350,350);
				g.setColor(new Color(13,246,117));
				Font serif36 = new Font("Serif", Font.BOLD, 36);
				g.setFont(serif36);
				g.drawString("EARTH", 210,280); 
				for (int p = 0; p < 10000000; p++);
		
		}//end for
	}
	
	
}
}



