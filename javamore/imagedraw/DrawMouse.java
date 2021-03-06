import java.awt.*; 
import java.net.*;
import java.awt.event.*; 
import java.applet.*; 
import java.util.Date;

/* 
<applet code="DrawMouse.class" width=1300 height=1300>
  <param name=red value=0> 
<param name=green value=0> 
<param name=blue value=0> 
<param name=redAjust value=20> 
<param name=greenAjust value=20> 
<param name=blueAjust value=20> 
<param name=limit value= 10> 
  </applet> 
*/ 


public class DrawMouse extends Applet implements  MouseListener, MouseMotionListener{ 

private Font fontFace18; private Font fontFace14; 
 boolean done;
 boolean stopFlag;
 double c1, c2,dx,dy;
 double showX, showY;
int ired, igreen, iblue,redAjust, greenAjust, blueAjust,limit;

  	  String msg = ""; 

	  int mouseX = 400, mouseY = 400; 
	  double dX = 0.0, dY = 0.0; // previous coordinates 
	  boolean draw; 
  
  
  
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
	  
	  temp = getParameter("redAjust"); 
	      try { if(temp != null) redAjust = Integer.parseInt(temp); 
      else  redAjust = 0; } catch(NumberFormatException exc) {  redAjust = -1;  } 
	  
	   temp = getParameter("greenAjust"); 
    try { if(temp != null) greenAjust = Integer.parseInt(temp); 
      else  greenAjust = 0; } catch(NumberFormatException exc) {  greenAjust = -1;  } 
	  
	   temp = getParameter("blueAjust"); 
    try { if(temp != null) blueAjust = Integer.parseInt(temp); 
      else  blueAjust = 0; } catch(NumberFormatException exc) {  blueAjust = -1;  } 
	  
	   temp = getParameter("limit"); 
    try { if(temp != null) limit = Integer.parseInt(temp); 
      else  limit = 0; } catch(NumberFormatException exc) {  limit = -1;  } 
	   	 	  
  } 
  

  
  public void init() {
	  addMouseListener(this); 
	  addMouseMotionListener(this); 
	  fontFace18 = new Font("Arial", Font.PLAIN, 18);
	  fontFace14 = new Font("Arial", Font.PLAIN, 14);

	}//end init()
		
	public void stop(){  		
            
           }//end stop	
		
	
	
  // Handle mouse clicked. 
  public void mouseClicked(MouseEvent obj) { 
    mouseX = 810; 
    mouseY = 370;                                           
    msg = "Mouse clicked."; 
  // repaint(); 
  } 
 
  // Handle mouse entered. 
  public void mouseEntered(MouseEvent obj) { 
    mouseX = 810; 
    mouseY = 350; 
    msg = "Mouse entered."; 
   // repaint(); 
  } 
 
  // Handle mouse exited. 
  public void mouseExited(MouseEvent obj) { 
  
  } 
 
  // Handle button pressed. 
  public void mousePressed(MouseEvent obj) { 
    // save coordinates 
    mouseX = obj.getX(); 
    mouseY = obj.getY(); 
    msg = "*"; 
//insert scores into database

  //  repaint(); 
  } 
 
  // Handle button released. 
  public void mouseReleased(MouseEvent obj) { 
  } 
 
  // Handle mouse dragged. 
  public void mouseDragged(MouseEvent obj) { 
    
  } 
 
  // Handle mouse moved. 
  public void mouseMoved(MouseEvent obj) { 
    // show status 
    dx = (double)obj.getX();
    dy = (double)obj.getY();
    showX = ((dx - 410)/200)+2.0 ;
    showY =  ((410- dy)/200)-2.0 ;
    showStatus(showX + ", " + showY); 
   
  } 
 
  // Display msg in applet window at current X,Y location. 
  public void paint(Graphics g) { int ared[] = new int[256];
	int agreen[] = new int[256];
	int ablue[] = new int[256];
	int i;	int rval = 0;	int  j,p;	int k;
	 double x,y,x1,x2,y1,z; double id, jd; 
		int Iterations = 1000;
		
		  g.drawImage(mygif,10,10,this);		
			
			
	
		g.setColor(new Color(255,255,255));
		g.fillRect(0,0,1000,900);
		
		g.setColor(new Color(255,255,0));
			//g.fillRect(0,0,1000,820);
			g.setColor(new Color(0,0,0));
			g.setFont(fontFace14);
			g.drawString("red:"+ired,820,90);
			g.drawString("green:"+igreen,820,110);
			g.drawString("blue:"+iblue,820,130);
			g.drawString("r ajust:"+redAjust,820,150);
			g.drawString("g ajust:"+greenAjust,820,170);
			g.drawString("b ajust:"+blueAjust,820,190);
			g.drawString("limit:"+limit,820,210);
			g.setColor(new Color(0,0,200));
			g.setFont(fontFace18);
			g.drawString("julia c:"+dx,820,240);
			g.drawString("julia ci:"+dy,820,260);
			g.setColor(new Color(0,0,0));
			g.setFont(fontFace14);
			g.drawString("If c=ci=0.0 click the set.",820,290);
		
		int scale = 300;
		int startxy = 600;
		
	  
  }//end paint
}


