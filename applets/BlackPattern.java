import java.awt.*;
import java.applet.*;
import java.io.*;

/*                      
<applet code="BlackPattern.class" width= 2048 height=2048> 
<param name=size value= 10> 
<param name=mod value= 3> 
<param name=adjust value= 10> 
<param name=text value="DONE!"> 
</applet> 
*/ 
public class BlackPattern extends Applet  {
int imod,adj,isize;
	String m; 
	
public void init() {
  
       Font font = new java.awt.Font("Monospaced", Font.BOLD, 18);
        setFont(font);
        
        }

  public void start() { 
    String temp;

    temp = getParameter("size"); 
    try { if(temp != null) isize = Integer.parseInt(temp); 
      else  isize = 0; } catch(NumberFormatException exc) {  isize = -1;  } 	
		
    temp = getParameter("mod"); 
    try { if(temp != null) imod = Integer.parseInt(temp); 
      else  imod = 0; } catch(NumberFormatException exc) {  imod = -1;  } 
	   
      temp = getParameter("adjust");    
    try { if(temp != null) adj = Integer.parseInt(temp); 
      else  adj = 0; } catch(NumberFormatException exc) {  adj = -1;  } 
      
		m = getParameter("text"); 
    if(m == null) m = "not found"; 
  } 
 
public void paint(Graphics g) {
	// only edit code in the paint method
	//ired, igreen, iblue,redAjust, greenAjust, blueAjust
	int i,j,x,y,count,cmod,left;

	g.setColor(new Color(255,255,255));
	g.fillRect(0,0,2048,2048);	
	int red = 0,green = 0,blue = 0;

	count = 0;
	left = 0;
	// change the following code
	for (y = 0; y < 2048; y = y + isize){
			for (x= 0; x < 2048; x = x + isize){
				//begin switch *******************************
				cmod = count % imod;  //mod 
				switch (cmod){
					case 0:
						red = 0;green =0;blue= 0;
						break;
					case 1:
						red = red + adj;green =green + adj;blue= blue + adj;
						break;
					case 2:
						red = red + adj;green =green + adj;blue= blue + adj;
						break;
					case 3:
						red = red + adj;green =green + adj;blue= blue + adj;
						break;
					case 4:
						red = red + adj;green =green + adj;blue= blue + adj;
						break;
					default:
						red = red + adj;green =green + adj;blue= blue + adj;
				
				}//end switch ****************************
				g.setColor(new Color(red,green,blue));
				//g.fillOval(x,y,20,20);
				g.fillRect(left+x,y,isize,isize);	
				count++;
			}//end for x
			//count= count + 2;
			left = count % imod;
		}//end for y
	// you can stop changing now
	// g.setColor(new Color(0,0,200));
       // g.drawString(m,10,250);  
	
}
}



