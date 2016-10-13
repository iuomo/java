import java.awt.*;
import java.applet.*;
import java.io.*;




/*                      
<applet name="Interest"  code="InterestOld.class" width="420" height="230">
<param name=pString value=1000> 
<param name=mString value=100> 
<param name=rString value=0.08> 
<param name=yString value=40> 
</applet>  
</applet> 
*/ 
public class InterestOld extends Applet  {
	
double p,m,r,y;


  public void start() { 
    String temp; 


	     temp = getParameter("pString"); 
    try { if(temp != null) p = Double.valueOf(temp).doubleValue();
      else  p = 0; } catch(NumberFormatException exc) {  p = 1000;  } 
	  
	 temp = getParameter("mString"); 
    try { if(temp != null) m = Double.valueOf(temp).doubleValue();
     else  m = 0; } catch(NumberFormatException exc) {  m = 100;  } 
	 	 
     temp = getParameter("rString"); 	 
    try { if(temp != null) r = Double.valueOf(temp).doubleValue();
     else  r = 0; } catch(NumberFormatException exc) {  r = 0.08;  }
     
     temp = getParameter("yString"); 	 
    try { if(temp != null) y = Double.valueOf(temp).doubleValue();
     else  y = 0; } catch(NumberFormatException exc) {  y = 40;  } 	 
     
  } 
 
public void paint(Graphics g) {
		
	
	//double p = 1000;
	//double m = 100;
	double nr = r/12;
	double b = 0;
	int v = 0;    
		g.setColor(new Color(255,255,255));
			g.fillRect(0,0,500,300);
	
		g.setColor(new Color(0,0,255));
			g.drawRect(0,10,400,210);
			g.drawLine(0,50,400,50);
			g.drawLine(0,85,400,85);
			g.drawLine(0,120,400,120);
				g.drawLine(0,155,400,155);
				g.drawLine(0,190,400,190);
        
	
			g.setColor(new Color(0,0,0));
			g.drawString("INITIAL INVESTMENT = $"+p,20,50);
			g.drawString("MONTHY INVESTMENT = $"+m,20,85);
			g.drawString("INTEREST RATE = "+r,20,120);
			g.drawString("YEARS OF INVESTMENT = "+y,20,155);
			
		
				double n = 0;
				b = p;
			while (n < (y*12)){
				b = (b *(1+nr))+ m;
				
				n++;
			}
			n = 0;
			v = (int)b;
			g.setColor(new Color(255,0,0));
			g.drawString("ENDING BALANCE= $"+v,20,190);
	                                                                
    }//end paint
 
  


  
  public void setP(String temp) {
	p = Double.valueOf(temp).doubleValue();
  }                                                        
public void setM(String temp) {
	m = Double.valueOf(temp).doubleValue();
 }  
 public void setR(String temp) {
	r = Double.valueOf(temp).doubleValue();
 }  
 public void setY(String temp) {
	y = Double.valueOf(temp).doubleValue();

	    repaint();
 }  
  
}// end Julia2


