import java.awt.*; 
import java.awt.event.*; 
import java.applet.*; 
/* 
  <applet code="PiApplet" width=800 height=600> 
  </applet> 
*/ 
class PiPlot{
		public PiPlot(Graphics g, int fontSize){
			 Font serif36 = new Font("Serif", Font.BOLD, 36);
			g.setFont(serif36);

			double x,y,s,sx,sy;
			String pi = "3.1415";
			String spi ="";
			int h,k, count = 0,p;
			int hit =0;
			int dart = 0;
			double dhit,ddart,ratio;
			String shits,sdarts,smiss,sratio,s1,s2,s3,s4,s5,s6;
			g.setColor(new Color(200,200,200));
					g.fillRect(0,0,800,600);
			Boolean done = false;
			while (!done){	
			
				s = Math.random(); sx = 1; if (s > 0.5) sx = -1;
				s = Math.random(); sy = 1; if (s > 0.5) sy = -1;
				x = Math.random()*sx;
				y = Math.random()*sy;
				
				g.setColor(new Color(255,255,255));
				
				dart++;
				if (((x*x)+(y*y))<=1.0){ hit++;
					//System.out.println(x+" "+y);
					g.setColor(new Color(255,127,0));
					if ((x > 0) & (y > 0)) 	g.setColor(new Color(127,0,255));
					if ((x > 0) & (y < 0)) 	g.setColor(new Color(127,255,0));
					if ((x < 0) & (y > 0)) 	g.setColor(new Color(255,0,127));
					
				}
					dhit = (double)hit;
					ddart = (double)dart;
					ratio = 4*(dhit/ddart);
					sh =""+hit;
					sdarts = ""+dart;
					
					sratio = ""+ratio;
					count ++;
					
					s1 = sratio.substring(0,1);
						s2 = sratio.substring(1,2);
						s3 = sratio.substring(2,3);
						s4 = sratio.substring(3,4);
						s5 = sratio.substring(4,5);
						s6 = sratio.substring(5,6);
					spi = sratio.substring(0,6);
					if (pi.equals(spi)) done = true;
					if ((count % 1000 == 0)||(done == true)){
						
						g.setColor(new Color(255,255,255));
						g.fillRect(0,0,800,70);
						g.setColor(new Color(0,0,0));
						//g.drawString(sratio, 50,50); 
						
						g.drawString(s1, 50,50); 
						g.drawString(s2, 90,50); 
						g.drawString(s3, 130,50); 
						g.drawString(s4, 170,50); 
						g.drawString(s5, 210,50); 
						g.drawString(s6, 250,50); 
						g.setColor(new Color(255,255,255));
						g.fillRect(0,520,800,100);
						//System.out.println(sht+" "+sdarts);
						g.setColor(new Color(0,0,0));
						g.drawString(sh +" hits "+sdarts+" darts" , 20,580); 
					}
						
					
					h = 201+(int)(x*201); k = 201+ (int)(y*201);
					g.drawLine(h+ 100,k+100,h+100,k+100);
						g.setColor(new Color(0,0,0));
						g.drawLine(100,299,500,299);
						g.drawLine(100,300,500,300);
						g.drawLine(100,301,500,301);
					
						g.drawLine(299,100,299,500);
						g.drawLine(300,100,300,500);
						g.drawLine(301,100,301,500);
						g.drawString("X", 510,300); 
						g.drawString("Y", 300,100); 
						
				}//end while
					
	
	
		
  }
}

			 


public class PiApplet extends Applet 
  implements  MouseListener, MouseMotionListener{ 
    static final int REGULAR_WD = 15;
    static final int REGULAR_HT = 36;
    static final int SMALL_WD = 12;
    static final int SMALL_HT = 24;

    Font regularFont = new Font("Serif", Font.BOLD, REGULAR_HT);
    Font smallFont = new Font("Serif", Font.BOLD, SMALL_HT);

	  
	  
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
     showStatus("Mouse clicked at " + mouseX + ", " + mouseY); 

  // repaint(); 
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
				int fontsize =  REGULAR_HT;
				PiPlot p = new PiPlot(g,fontsize);
				done = true;
				//g.drawString(msg, mouseX, mouseY); 
  } 
}

