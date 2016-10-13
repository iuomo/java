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
			int p,wfx,wfy,x,y,deg;
			
			int yadjust = 300;
			int xadjust = 40;
			double pi = 3.1416;
			int scale = 50;
			int wfscale = 30;
			double wsin[] = new double[723];
			double wcos[] = new double[723];
			double sin[] = new double[723];
			double cos[] = new double[723];
			int i = 0;
			// build sin array
			for (deg = -360;deg < 360;deg++){
				t = deg *(pi/180);
				sin[i]= Math.sin(t);
				cos[i] = Math.cos(t);	
				wsin[i]= Math.sin(t);
				wcos[i] = Math.cos(t);
				i++;
			}
			//*********************************************************************************
			//x y axisg.
			g.setColor(new Color(255,255,255));
			g.fillRect(0,0,800,600);
			int red = 127;int green = 127;int blue = 127;
			g.setColor(new Color(127,127,127));
			g.drawLine(0,299,800,299);	
			g.drawLine(0,300,800,300);	
			g.drawLine(0,301,800,301);	
			
			g.drawLine(399,0,399,580);	
			g.drawLine(400,0,400,580);	
			g.drawLine(401,0,401,580);
			g.setColor(new Color(230,230,230));
				for (x = 0;x < 720;x=x + 15){
					g.drawLine(xadjust+ x,0,xadjust+ x,580);	
			}
			
			for (y = 0;y < 600;y=y + 15){
					g.drawLine( xadjust,y, 800-xadjust,y);		
			}
			//small y y axis
			g.setColor(new Color(127,127,127));
			g.drawLine(xadjust,45,xadjust+90,45);	
			g.drawLine(xadjust+xadjust+5,0,xadjust+xadjust+5,90);
			
			g.drawString("X", 780, 280); 	g.drawString("Y", 410, 30); 
			g.drawString("X", 120, 45); 	g.drawString("Y", 90, 13); 
			//*********************************************************************************
			g.setColor(new Color(255,0,0));
			wfx = 0; wfy = 0;	
			for (x = 0;x < 720;x++){
				for (p = 0; p < 1000000;p++)
				wfscale = 30;
				if (x > 360) wfscale = 32;
					wfx = (int)(cos[x]*wfscale);
					wfy = (int)(sin[x]*wfscale);
					y = (int)(sin[x]*scale);
			
					
				g.drawLine( xadjust+ x,yadjust-y, xadjust+x,yadjust-y);	
				g.drawLine( 2*xadjust+5+ wfx,45-wfy,  2*xadjust+5+wfx,45-wfy);	
			}
			//*********************************************************************************
			
			g.setColor(new Color(0,255,0));
			wfx = 0; wfy = 0;	
			for (x = 0;x < 720;x++){
				for (p = 0; p < 1000000;p++)
				wfscale = 30;
				if (x > 360) wfscale = 32;
					wfx = (int)(cos[x]*wfscale);
					wfy = (int)(sin[x]*wfscale);
					y = (int)(sin[x]*scale*2);
			
					
				g.drawLine( xadjust+ x,yadjust-y, xadjust+x,yadjust-y);	
				g.drawLine( 2*xadjust+5+ wfx,45-wfy,  2*xadjust+5+wfx,45-wfy);	
			}
			//*********************************************************************************
			// build sin array
			i = 0;
			for (deg = -360;deg < 360;deg++){
				t = (deg) *(pi/180);
				t = 2 * t;
				sin[i]= Math.sin(t);
				System.out.println(t+ " "+ sin[i]);
				i++;
			}
			
			//*********************************************************************************
			// blue
			g.setColor(new Color(0,0,255));
			wfx = 0; wfy = 0;	
			for (x = 0;x < 720;x++){
				for (p = 0; p < 1000000;p++)
				wfscale = 30;
				if (x > 360) wfscale = 32;
					wfx = (int)(wcos[x]*wfscale);
					wfy = (int)(wsin[x]*wfscale);
					y = (int)(sin[x]*scale);
			
					
				g.drawLine( xadjust+ x,yadjust-y, xadjust+x,yadjust-y);	
				g.drawLine( 2*xadjust+5+ wfx,45-wfy,  2*xadjust+5+wfx,45-wfy);	
			}
			//*********************************************************************************
	
					
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
    //repaint(); 
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

