// Julia.java source by Craig Coleman
import java.awt.*;
import java.applet.*;
import java.io.*;

/*                      
<applet name="julia"  code="Julia.class" width="1200" height="1000">
<param name=c1String value=0.345> 
<param name=c2String value=-.07> 
<param name=red value=200> 
<param name=green value=200> 
<param name=blue value=200> 
<param name=redA value=-10> 
<param name=greenA value=-10> 
<param name=blueA value=-10> 
<param name=limit value=50> 
<param name=scale value=800> 
</applet>  
*/ 
public class Julia extends Applet  {
	String input_c1,inout_c2;
	int ired, igreen, iblue,iradj,igadj,ibadj,ilimit,iscale;
double c1,c2;

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
	  
	  temp = getParameter("redA"); 
	      try { if(temp != null) iradj = Integer.parseInt(temp); 
      else  iradj = 0; } catch(NumberFormatException exc) {  iradj = -1;  } 
	  
	   temp = getParameter("greenA"); 
    try { if(temp != null) igadj = Integer.parseInt(temp); 
      else  igadj = 0; } catch(NumberFormatException exc) {  igadj = -1;  } 
	  
	   temp = getParameter("blueA"); 
    try { if(temp != null) ibadj = Integer.parseInt(temp); 
      else  ibadj = 0; } catch(NumberFormatException exc) {  ibadj = -1;  } 
	  
	   temp = getParameter("limit"); 
    try { if(temp != null) ilimit = Integer.parseInt(temp); 
      else  ilimit = 0; } catch(NumberFormatException exc) {  ilimit = -1;  } 
      
      temp = getParameter("scale"); 
    try { if(temp != null) iscale = Integer.parseInt(temp); 
      else  iscale = 0; } catch(NumberFormatException exc) {  iscale = -1;  } 
	
	   
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
			g.fillRect(0,0,1200,1000);
			g.setColor(new Color(0,0,0));
g.drawString("c1:"+c1,810,50);
g.drawString("c2:"+c2,810,70);
g.drawString("r:"+ired,810,90);
g.drawString("g:"+igreen,810,110);
g.drawString("b:"+iblue,810,130);
g.drawString("ra:"+iradj,810,150);
g.drawString("ga:"+igadj,810,170);
g.drawString("ba:"+ibadj,810,190);
g.drawString("limit:"+ilimit,810,210);
g.drawString("scale:"+iscale,810,230);
g.drawString("091016:0557",810,250);
		for (i = 0; i < 256;i++){
			ared[i] = ired;
			agreen[i] = igreen;
			ablue[i] = iblue;
			ired = ired+iradj;
			igreen = igreen+igadj;
			iblue = iblue+ibadj;
		if (ired > 255) ired = 0;if (ired < 0) ired = 255;
	if (igreen > 255) igreen = 0;if (igreen < 0) igreen = 255;
		if (iblue > 255) iblue = 0;if (iblue < 0) iblue =  255;
	}
		//	g.setColor(new Color(255,255,255));
		//	g.fillRect(0,0,500,500);
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
						if (k > ilimit) {
							if (k > 255) k = 255;
								g.setColor(new Color(ared[k],agreen[k],ablue[k]));
							g.drawLine(i,j,i,j);
						}
	    	}//end for i
        }//end for j                                                                    
    }//end paint

 //   public void setX(String temp) {
//	xPlus = Integer.parseInt(temp); }              
  
  
 // public void setY(String temp) {
//	yPlus = Integer.parseInt(temp); 

//  }   


 public void setC1(String temp) {
	c1 = Double.valueOf(temp).doubleValue();  
	repaint(); }              
  
    public void setC2(String temp) {
	c2 = Double.valueOf(temp).doubleValue();  
	//repaint();
    }


   public void setRED(String temp) {
		ired = Integer.parseInt(temp); 
	//repaint();
   }              
  
    public void setGREEN(String temp) {
	igreen = Integer.parseInt(temp); 
	//repaint();
    }
  
   public void setBLUE(String temp) {
	iblue = Integer.parseInt(temp); 
	//repaint(); 
   }            
	
	
 public void setRADJ(String temp) {
	iradj = Integer.parseInt(temp);   
	//repaint(); 
 }              
  
    public void setGADJ(String temp) {
	igadj = Integer.parseInt(temp); 
	//repaint();
    }
  
   public void setBADJ(String temp) {
	ibadj = Integer.parseInt(temp); 
	//repaint(); 
   }              

 public void setLIMIT(String temp) {
	ilimit = Integer.parseInt(temp); 
	//repaint(); 
 }   

 public void setSCALE(String temp) {
	iscale = Integer.parseInt(temp); 
	//repaint(); 
 }   	
  
}// end Julia2

