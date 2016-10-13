import java.awt.*;
import java.applet.*;
import java.io.*;
/*                      
<applet code="Earth_Example.class" width= 800 height=600> 
</applet> 
*/ 
public class Earth_Example extends Applet  {
public void init() { }
public void start() { } 
public void paint(Graphics g) {
	int h,k,x;
		g.setColor(new Color(0,0,0));
		g.fillRect(0,0,800,600);
		/////////////////////////////////////////
		g.setColor(new Color(255,255,255));
		g.fillRect(170,60,50,50);
		g.setColor(new Color(0,0,255));
		g.fillOval(20,100,350,350);
		g.setColor(new Color(170,170,230));
		
		/////////////////////////////////////////
		g.setColor(new Color(170,170,230));
			g.fillOval(390,90,370,370);
		
		g.setColor(new Color(0,0,255));
		g.fillOval(400,100,350,350);
		
		
		
		g.setColor(new Color(13,246,117));
				Font serif36 = new Font("Serif", Font.BOLD, 24);
				g.setFont(serif36);
				g.drawString("EARTH WITH ICE", 100,280); 
				g.drawString("THE ICE MELTED", 430,280); 
	}
}

