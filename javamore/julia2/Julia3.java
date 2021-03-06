// Julia.java source by Craig Coleman
import java.awt.*;
import java.applet.*;
import java.io.*;

/*                      java
<applet code="Julia3.class" width= 1000 height=800> 
<param name=scale value=350> 
<param name=red value=100> 
<param name=green value=0> 
<param name=blue value=100> 
<param name=redA value=-30> 
<param name=greenA value=0> 
<param name=blueA value= 30> 
<param name=limit value=20> 
<param name=c1String value= 0.29> 
<param name=c2String value= 0> 
</applet> 
*/ 
public class Julia3 extends Applet  {
	String input_c1,inout_c2;
	int iscale, ired, igreen, iblue,redAjust, greenAjust, blueAjust,limit;
double c1,c2;

  public void start() { 
    String temp; 
    System.out.println("start");
    temp = getParameter("scale"); 
    try { if(temp != null) iscale = Integer.parseInt(temp); 
      else  iscale = 0; } catch(NumberFormatException exc) {  iscale= -1;  } 

    temp = getParameter("red"); 
    try { if(temp != null) ired = Integer.parseInt(temp); 
      else  ired = 0; } catch(NumberFormatException exc) {  ired = -1;  } 
	  
	   temp = getParameter("green"); 
    try { if(temp != null) igreen = Integer.parseInt(temp); 
      else  igreen = 0; } catch(NumberFormatException exc) {  igreen = -1;  } 
	  
	   temp = getParameter("blue"); 
    try { if(temp != null) iblue = Integer.parseInt(temp);
      else  iblue = 0; } catch(NumberFormatException exc) {  iblue = -1;  }
	  
	  temp = getParameter("redA"); 
	      try { if(temp != null) redAjust = Integer.parseInt(temp); 
      else  redAjust = 0; } catch(NumberFormatException exc) {  redAjust = -1;  } 
	  
	   temp = getParameter("greenA"); 
    try { if(temp != null) greenAjust = Integer.parseInt(temp); 
      else  greenAjust = 0; } catch(NumberFormatException exc) {  greenAjust = -1;  } 
	  
	   temp = getParameter("blueA"); 
    try { if(temp != null) blueAjust = Integer.parseInt(temp); 
      else  blueAjust = 0; } catch(NumberFormatException exc) {  blueAjust = -1;  } 
	  
	   temp = getParameter("limit"); 
    try { if(temp != null) limit = Integer.parseInt(temp); 
      else  limit = 0; } catch(NumberFormatException exc) {  limit = -1;  } 
	   
	     temp = getParameter("c1String"); 
    try { if(temp != null) c1 = Double.valueOf(temp).doubleValue();
      else  c1 = 0; } catch(NumberFormatException exc) {  c1 = -1;  } 
	  
	 temp = getParameter("c2String"); 
    try { if(temp != null) c2 = Double.valueOf(temp).doubleValue();
     else  c2 = 0; } catch(NumberFormatException exc) {  c2 = -1;  } 
	 	  
  } 
 
public void paint(Graphics g) {

	int ared[] = new int[256];
	int agreen[] = new int[256];
	int ablue[] = new int[256];
	int i;
	
	int rval = 0;
	    	int  j,p;
		int k;
	    	double x,y,x1,x2,y1,z;
		double id, jd; 
		int Iterations = 200;
		String msg;
        	g.setColor(new Color(255,255,255));
			g.fillRect(0,0,1000,800);
			g.setColor(new Color(0,0,0));
g.drawString("scale:"+iscale,810,30);
g.drawString("c1:"+c1,810,50);
g.drawString("c2:"+c2,810,70);
g.drawString("red:"+ired,810,90);
g.drawString("green:"+igreen,810,110);
g.drawString("blue:"+iblue,810,130);
g.drawString("r ajust:"+redAjust,810,150);
g.drawString("g ajust:"+greenAjust,810,170);
g.drawString("b ajust:"+blueAjust,810,190);
g.drawString("limit:"+limit,810,210);
		for (i = 0; i < 256;i++){
			ared[i] = ired;
			agreen[i] = igreen;
			ablue[i] = iblue;
			ired = ired+redAjust;
			igreen = igreen+greenAjust;
			iblue = iblue+blueAjust;
		if (ired > 255) ired = 0;if (ired < 0) ired = 255;
		if (igreen > 255) igreen = 0;if (igreen < 0) igreen = 255;
		if (iblue > 255) iblue = 0;if (iblue < 0) iblue =  255;
	}
		//	g.setColor(new Color(255,255,255));
		//	g.fillRect(0,0,500,500);
		//int iscale = 250;
		for (j = 0 ; j < 800 ; j++) {
			jd = (double) j;
			y1 = (400 - jd) / iscale;
				for (i = 0; i < 800; i++){
					id = (double) i;
					x1 = (id - 400) / iscale;			
					x = x1;
					y = y1;
				
					z = 0.0;
					k = 0;
					do {
						x2 = (x * x) - (y * y) + c1;
						y = (2 * x * y) + c2;
						x = x2;
						z = (x * x) + (y * y);
						k++;							
					}while ((k < Iterations) & (z < 4.0));
						if (k > limit) {
							if (k > 255) k = 255;
							g.setColor(new Color(ared[k],agreen[k],ablue[k]));
							g.drawLine(i,j,i,j);
						}
	    	}//end for i
        }//end for j                                                                    
    }//end paint

public void setLimit(String temp) {
	limit = Integer.parseInt(temp); 
	}    

public void setRed(String temp) {
	ired = Integer.parseInt(temp); 
	}              
	
public void setGreen(String temp) {
	igreen = Integer.parseInt(temp); 
	}   

public void setBlue(String temp) {
	iblue = Integer.parseInt(temp); 
	}   
	
public void setREDajust(String temp) {
	redAjust = Integer.parseInt(temp); }              
  
public void setGREENajust(String temp) {
	greenAjust = Integer.parseInt(temp); }
	
public void setBLUEajust(String temp) {
	blueAjust = Integer.parseInt(temp);
	  }  
  
  public void setC1(String temp) {
	c1 = Double.valueOf(temp).doubleValue();

  }                                                           
public void setC2(String temp) {
	c2 = Double.valueOf(temp).doubleValue();
  }  
  
}// end Julia2


