import java.awt.*;
import java.applet.*;
import java.lang.*;


/* 
<applet name="d" code="Dragon" width=900 height=900>
	<param name=limit value=255>
</applet>
*/


public class Dragon extends Applet {
// applet variables

  int state;
  int ired, igreen, iblue,iradj,igadj,ibadj,ilimit,iscale;
  	// newtons method variables
	int red ,green,blue;


  public void init() {
	setBackground(Color.white);
	   setForeground(Color.white);
    String temp; 

	   temp = getParameter("limit"); 
    try { if(temp != null) ilimit = Integer.parseInt(temp); 
      else  ilimit = 0; } catch(NumberFormatException exc) {  ilimit = -1;  } 
      
      temp = getParameter("scale"); 
    try { if(temp != null) iscale = Integer.parseInt(temp); 
      else  iscale = 0; } catch(NumberFormatException exc) {  iscale = -1;  } 
  }

 
  public void paint(Graphics g) {
	

}
g.setColor(new Color(0,0,255));

g.drawString(" steps : "+ilimit, 810,520);
g.drawString(" iscale : "+iscale, 810,540);
g.drawString(" scale : "+scale, 810,560);

	 
	 
  
}// end paint



 public void setLIMIT(String temp) {
	ilimit = Integer.parseInt(temp); 
	repaint(); 
 }   

 public void setSCALE(String temp) {
	iscale = Integer.parseInt(temp); 
	repaint(); 
 }   


}

