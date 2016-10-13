import java.awt.*; 
import java.awt.event.*; 
import java.applet.*; 
/* 
  <applet code="TrigApplet" width=800 height=600> 
  </applet> 
*/ 
class Plot{
		public Plot(Graphics g){
	
			double t = 0;
			double hd, kd;
			int hi,ki;	int xi,yi;
			int pzvalue = 1;
			int pz,i,j;	double scale = 100;//change this for a scale
			int x = 0;	int y = 262;
			// this code builds the array using sine and cosine
			int p = 628;
			double sin[] = new double[p];	double cos[] = new double[p];
			for (i = 0;i < p;i++){
				cos[i]= Math.cos(t); 
				sin[i]= Math.sin(t); 
				t = t + (6.28/p);
			}
			//*********************************************************************************
			int red = 0;int green = 0;int blue = 0;
			// red = 255; green = 50; blue = 0;
			g.setColor(new Color(255,255,255));
			g.fillRect(0,0,726,525);
			g.setColor(new Color(50,50,50));
			g.drawLine( 314,25,314,525);
			g.drawLine( 0,y,628,y);
			//unit circle
			g.setColor(new Color(100,50,100));
			g.drawLine(610,100,750,100);
			g.drawLine( 670,40,670,160);
			red = 0; green = 0; blue = 255;
       g.setColor(new Color(red,green,blue));
			 g.drawLine (0,25,628,25);
			 for (i = 0; i < p;i++){
				 	ki = (int)(y - scale*sin[i]);
	      	g.drawLine( i,ki,i,ki);
					xi = 670+(int)(50*cos[i]);
					yi = 100-(int)(50*sin[i]);
					g.drawLine(xi,yi,xi,yi);
					for (pz = 0 ; pz <pzvalue;pz++);
			 }
			 red = 0; green = 255; blue = 0;
          g.setColor(new Color(red,green,blue));
					for (i = 0; i < p;i++){
						ki = (int)(y - scale*cos[i]);
						g.drawLine( i,ki,i,ki);
						xi = 670+(int)(50*cos[i]);
						yi = 100-(int)(50*sin[i]);
						g.drawLine(xi,yi,xi,yi);
						for (pz = 0 ; pz <pzvalue;pz++);
					}
					red = 255; green = 0; blue = 0;
           g.setColor(new Color(red,green,blue));
					 for (i = 0; i < p;i++){
		    if (cos[i] == 0) continue;
		      ki = (int)(y - scale*(sin[i]/cos[i]));
	      		g.drawLine( i,ki,i,ki);
						xi = 670+(int)(50*cos[i]);
						yi = 100-(int)(50*sin[i]);
						g.drawLine(xi,yi,xi,yi);
						for (pz = 0 ; pz <pzvalue;pz++);
	      }
		}
}

public class TrigApplet extends Applet 
  implements Runnable, MouseListener, MouseMotionListener{ 
 Thread t;
 boolean done;
 boolean stopFlag;
  String msg = ""; 
  int mouseX = 0, mouseY = 0; // coordinates of mouse 
 
  public void init() { 
     addMouseListener(this); 
     addMouseMotionListener(this); 
		 t = null;
  } 
	
	public void start() {
		t = new Thread(this);
		stopFlag = false;
		done = false;
		t.start(); 

	}
 
	public void run(){
		for (;;){
			try{ repaint();
				Thread.sleep(100);		
				if (stopFlag) break;
			}catch(InterruptedException exc){}
	}
	}
	
	public void stop(){
		stopFlag = true;
		t = null;
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
    repaint(); 
  } 
 
  // Handle mouse exited. 
  public void mouseExited(MouseEvent obj) { 
    mouseX = 0; 
    mouseY = 10; 
    msg = "Mouse exited."; 
    repaint(); 
  } 
 
  // Handle button pressed. 
  public void mousePressed(MouseEvent obj) { 
    // save coordinates 
    mouseX = obj.getX(); 
    mouseY = obj.getY(); 
    msg = "X"; 
    repaint(); 
  } 
 
  // Handle button released. 
  public void mouseReleased(MouseEvent obj) { 
    // save coordinates 
    mouseX = obj.getX(); 
    mouseY = obj.getY(); 
    msg = "-"; 
   repaint(); 
  } 
 
  // Handle mouse dragged. 
  public void mouseDragged(MouseEvent obj) { 
    // save coordinates 
    mouseX = obj.getX(); 
    mouseY = obj.getY(); 
    msg = "*"; 
    showStatus("Dragging mouse at " + mouseX + ", " + mouseY); 
   repaint(); 
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

