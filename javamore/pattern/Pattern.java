// Julia.java source by Craig Coleman
import java.awt.*;
import java.applet.*;
import java.io.*;

/*                      
<applet name="pattern" code="Pattern.class" width="1200" height="1000">
<param name=red value=198> 
<param name=green value=231> 
<param name=blue value=222> 
</applet>  
*/ 
public class Pattern extends Applet  {
	
	int  ired, igreen, iblue;


  public void start() { 
    String temp; 
  
    temp = getParameter("red"); 
    try { if(temp != null) ired = Integer.parseInt(temp); 
      else  ired = 0; } catch(NumberFormatException exc) {  ired = -1;  } 
	  
	   temp = getParameter("green"); 
    try { if(temp != null) igreen = Integer.parseInt(temp); 
      else  igreen = 0; } catch(NumberFormatException exc) {  igreen = -1;  } 
	  
	   temp = getParameter("blue"); 
    try { if(temp != null) iblue = Integer.parseInt(temp);
      else  iblue = 0; } catch(NumberFormatException exc) {  iblue = -1;  }	  
	 	  
  } 
 
public void paint(Graphics g) {
		int x, y, nred, ngreen, nblue;
        	g.setColor(new Color(255,255,255));
			g.fillRect(0,0,650,700);
			g.setColor(new Color(0,0,0));
			g.drawString("red:"+ired,510,90);
			g.drawString("green:"+igreen,510,110);
			g.drawString("blue:"+iblue,510,130);
			nred = ired;
			ngreen = igreen;
			nblue = iblue;
		
		//	g.setColor(new Color(255,255,255));
		//	g.fillRect(0,0,500,500);
		for (x = 0 ; x < 500 ;x++) {
			for (y = 0; y < 500; y++){
				g.setColor(new Color(nred,ngreen,nblue));
				g.drawLine(x,y,x,y);
				//System.out.println(x + " "+y);
				
				
			}
			// this is what i want you to play with
			nred--; ngreen--; nblue--;
			if (nred > 255) nred = ired;
			if (ngreen > 255) ngreen = igreen;
			if (nblue > 255) nblue = iblue;
			if (nred < 0) nred = ired;
			if (ngreen < 0) ngreen = igreen;
			if (nblue < 0) nblue = iblue;
	    	}//end for i
        }//end for j  
	
 public void setRED(String temp) {
	ired = Integer.parseInt(temp);   
	repaint();
  }              
  
    public void setGREEN(String temp) {
	igreen = Integer.parseInt(temp); 
	repaint();
  }
  
   public void setBLUE(String temp) {
	iblue = Integer.parseInt(temp); 
	repaint();

  }              
  
 }//end Pattern



