import java.awt.*; 
import java.awt.event.*; 
import java.applet.*; 
/* 
  <applet code="TrigApplet" width=800 height=600> 
  </applet> 
*/ 
class Plot{
		public Plot(Graphics g){
	
			double t = 0;//angle theta
			int x,y,deg;
			int yadjust = 300;
			double pi = 3.1416;
			int scale = 50;
			double sin[] = new double[720];
			int i = 0;
			// build sin array
			for (deg = -360;deg < 360;deg++){
				t = deg *(pi/180);
				sin[i]= Math.sin(t); 
				i++;
			}
			//*********************************************************************************
			//x y axisg.
			
	
		
			//*********************************************************************************
		
			// red = 255; green = 50; blue = 0;
			g.setColor(new Color(255,255,255));
		//	g.fillRect(0,0,800,600);
			g.setColor(new Color(255,0,0));
			g.drawLine(0,30,800,30);	
			for (x = 0;x < 720;x++){
				
				y = (int)(sin[x]*scale);
				g.drawLine(  x,yadjust-y, x,yadjust-y);	
			}

		}
}


public class TrigApplet extends Applet 
  implements  MouseListener, MouseMotionListener{ 

 boolean done;
 boolean stopFlag;
  String msg = ""; 
  int mouseX = 0, mouseY = 0; // coordinates of mouse 
 
  public void init() { 
     addMouseListener(this); 
     addMouseMotionListener(this); 
		 
  } 
	
	
	
  // Handle mouse clicked. 
  public void mouseClicked(MouseEvent obj) { 
    mouseX = 0; 
    mouseY = 10;                                           
    msg = "Mouse clicked."; 
   repaint(); 
  } 
 
  // Handle mouse entered. 
  public void mouseEntered(MouseEvent obj) { 
    mouseX = 0; 
    mouseY = 10; 
    msg = "Mouse entered."; 
   // repaint(); 
  } 
 
  // Handle mouse exited. 
  public void mouseExited(MouseEvent obj) { 
    mouseX = 0; 
    mouseY = 10; 
    msg = "Mouse exited."; 
    //repaint(); 
  } 
 
  // Handle button pressed. 
  public void mousePressed(MouseEvent obj) { 
    // save coordinates 
    mouseX = obj.getX(); 
    mouseY = obj.getY(); 
    msg = "*"; 
    repaint(); 
  } 
 
  // Handle button released. 
  public void mouseReleased(MouseEvent obj) { 
    // save coordinates 
    mouseX = obj.getX(); 
    mouseY = obj.getY(); 
    msg = "-"; 
   //repaint(); 
  } 
 
  // Handle mouse dragged. 
  public void mouseDragged(MouseEvent obj) { 
    // save coordinates 
    mouseX = obj.getX(); 
    mouseY = obj.getY(); 
    msg = "*"; 
    showStatus("Dragging mouse at " + mouseX + ", " + mouseY); 
  // repaint(); 
  } 
 
  // Handle mouse moved. 
  public void mouseMoved(MouseEvent obj) { 
    // show status 
    showStatus("Moving mouse at " + obj.getX() + ", " + obj.getY()); 
  } 
 
  // Display msg in applet window at current X,Y location. 
  public void paint(Graphics g) { 
		 //*********************************************************************************	
		 		setBackground(new Color (255,255,255));
				Plot p = new Plot(g);
				done = true;
				g.drawString(msg, mouseX, mouseY); 
  } 
}

