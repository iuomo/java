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
			double hd, kd;
			int hi,ki;	int xi,yi;
			int pzvalue = 1000000;
			int pz,i,j;	double scale = 100;//change this for a scale
			double ucscale = 50; //unit circle scale
			int x = 0;	int y = 262;
			// this code builds the array using sine and cosine
			int p = 62832;
			double sin[] = new double[p];	double cos[] = new double[p];
			for (i = 0;i < p;i++){
				cos[i]= Math.cos(t); 
				sin[i]= Math.sin(t); 
				t = t + (6.2832/p);
			}
			//*********************************************************************************
			int red = 0;int green = 0;int blue = 0;
			// red = 255; green = 50; blue = 0;
		//	g.setColor(new Color(255,255,255));
		//	g.fillRect(0,0,800,600);
			g.setColor(new Color(0,0,255));
			g.drawLine( 10,0,10,y*2);
			g.drawLine( 10,y,638,y);
			
			red = 0; green = 0; blue = 255;
			g.setColor(new Color(red,green,blue));
		//	 g.drawLine (0,25,628,25);
			 //this draws the uni circle
			 int ucox= 670; int ucoy= 100; //unit circle origin(x,y)
			 //unit circle axis
			g.setColor(new Color(0,0,255));
			g.drawLine(ucox-50,ucoy,ucox+50,ucoy);
			g.drawLine(ucox-50,ucoy,ucox+50,ucoy);
		
			 
				for (i = 0; i < p;i++){
						 //unit circle axis
						 g.drawString("UNIT CIRCLE", ucox-20, ucoy- 55);
			g.setColor(new Color(0,0,255));
			g.drawLine(ucox-50,ucoy,ucox+50,ucoy);
			g.drawLine(ucox,ucoy-50,ucox,ucoy+50);
						g.setColor(new Color(255,0,0));
				 	//this draws the sine
				 	ki = (int)(y - scale*sin[i]);
	      	g.drawLine( i+10,ki,i+10,ki);
					//this draws the unit circle
					xi = ucox+((int)(ucscale*cos[i]));
					yi = ucoy-((int)(ucscale*sin[i]));
					g.drawLine(ucox,ucoy,xi,yi);
					g.drawLine(xi,yi,xi,ucoy);
				//	g.drawLine(xi,0,ucox,ucoy);
					for (pz = 0 ; pz <(pzvalue*10);pz++);
			g.setColor(new Color(255,255,255));
						g.drawLine(ucox,ucoy,xi,yi);
							g.drawLine(xi,yi,xi,ucoy);
					 //unit circle axis
			g.setColor(new Color(0,0,255));
			g.drawLine(ucox-50,ucoy,ucox+50,ucoy);
			g.drawLine(ucox,ucoy-50,ucox,ucoy+50);
					
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

