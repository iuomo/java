import java.awt.*;
import java.applet.*;
import java.io.*;

/*                      
<applet code="InvestInterest.class" width= 600 height=500> 
<param name=principal value=1000> 
<param name=rate value=0.08> 
<param name=month_invest value=100> 
<param name=years value=10> 

</applet> 
*/ 
public class InvestInterest extends Applet  {
	String input_c1,inout_c2;
	int ired, igreen, iblue,redAjust, greenAjust, blueAjust,limit;
double p,r,m,y;

  public void start() { 
    String temp; 


	   
	     temp = getParameter("principal"); 
    try { if(temp != null) p = Double.valueOf(temp).doubleValue();
      else  p = 0; } catch(NumberFormatException exc) { p = 1000;  } 
	  
	 temp = getParameter("rate"); 
    try { if(temp != null) r = Double.valueOf(temp).doubleValue();
     else  r = 0; } catch(NumberFormatException exc) {  r = 0.1;  } 
     
     	 temp = getParameter("month_invest"); 
    try { if(temp != null) m = Double.valueOf(temp).doubleValue();
     else  m = 0; } catch(NumberFormatException exc) {  m = 100;  } 
     
     temp = getParameter("years"); 
    try { if(temp != null) y = Double.valueOf(temp).doubleValue();
     else  y = 0; } catch(NumberFormatException exc) {  y = 10;  } 
     
	 	  
  } 
 
  public void paint(Graphics g){	
	int i;
	double nr = r/12;
g.setColor(new Color(0,0,0));
g.drawString("INITIAL PRINCIPAL = $ "+p,10,60);
g.drawString("YEALRY INTEREST RATE = "+r+ " = "+r*100+"%",10,90);
g.drawString("MONTHLY INVESTMENT = $ "+m,10,120);
g.drawString("YEARS OF INVESTMENT = "+y,10,150);
g.drawString("THE INTEREST RATE IS REPORTED YEARLY AND COMPOUNDED MONTHLY."+y,10,180);
for (i = 0; i < y*12; i++){
				p = p *(1 + nr) + m;
			}
	g.drawString("ENDING BALANCE = "+p,10,210);
	
		
    }//end paint


}// InvestInterest

