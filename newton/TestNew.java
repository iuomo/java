import java.awt.*;
import java.applet.*;
import java.lang.*;


/* 
<applet name="testnew" code="TestNew" width=300 height=300>
<param name=red value=0>
<param name=green value=255>
<param name=blue value=255>

<param name=redA value=255>
<param name=greenA value=193>
<param name=blueA value=0>

<param name=limit value=10>
<param name=scale value=100>
</applet>
*/


public class TestNew extends Applet {
// applet variables

  int ired, igreen, iblue,iradj,igadj,ibadj,ilimit,iscale;
  	// newtons method variables
	int red ,green,blue;

  public void init() {
	setBackground(Color.white);
	   setForeground(Color.white);
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
  }


  public void paint(Graphics g) {
	
	 int h,k,c,red,green,blue;
	 double x,y;
	
		g.setColor(new Color(0,0,0));
		g.drawString(" r 1 : "+ired, 10,10);
		g.drawString(" g 1 : "+igreen, 10,30);
		g.drawString(" b 1 : "+iblue, 10,50);
		g.drawString(" r 2 : "+iradj, 10,70);
		g.drawString(" g 2 : "+ibadj, 10,90);
		g.drawString(" b 2 : "+igadj, 10,110);
		g.drawString(" steps : "+ilimit, 10,130);
		g.drawString(" scale : "+iscale, 10,150);

  
}// end paint


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


}

