import java.awt.*; 
import java.awt.event.*; 
import java.applet.*; 
import java.sql.*;
import java.util.Date;

/* 
  <applet code="Mouse.class" width=400 height=400>
  </applet> 
*/ 








public class Mouse extends Applet implements  MouseListener, MouseMotionListener{ 

Connection conn;

 boolean done;
 boolean stopFlag;
  String msg = ""; 
  int mouseX = 400, mouseY = 400; // coordinates of mouse
  
 // public void start(){

	  
 // }
  

  
  public void init() {
	   addMouseListener(this); 
	  addMouseMotionListener(this); 
	 

		}//end init()
		
	public void stop(){  
		
           }//end stop	
		
	
	
  // Handle mouse clicked. 
  public void mouseClicked(MouseEvent obj) { 
    mouseX = 10; 
    mouseY = 370;                                           
    msg = "Mouse clicked."; 
   repaint(); 
  } 
 
  // Handle mouse entered. 
  public void mouseEntered(MouseEvent obj) { 
    mouseX = 10; 
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
   // msg = "*"; 
//insert scores into database

    repaint(); 
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
    showStatus(obj.getX() + ", " + obj.getY()); 
  } 
 
  // Display msg in applet window at current X,Y location. 
  public void paint(Graphics g) { 
	  String thecolor = "Click the colors.";
		 //*********************************************************************************	
		setBackground(new Color (0,0,0));
			g.setColor(new Color(255,255,0));
			g.fillRect (0,0,100,300);
			g.setColor(new Color(255,0,0));
			g.fillRect (100,0,100,300);
			g.setColor(new Color(0,255,0));
			g.fillRect (200,0,100,300);
			g.setColor(new Color(0,0,255));
			g.fillRect (300,0,100,300);
			g.setColor(new Color(255,255,255));
			g.fillRect (0,300,400,100);
			g.setColor(new Color(0,0,0));
			g.drawString("Click to insert data into the database.", 5,310 );
			if (conn != null)
				g.drawString("The database connection is not null.", 5,330); 

	if (((mouseX <= 100)&& (mouseX >= 0))&&((mouseY <=300)&&(mouseX >= 0))){   
				thecolor = "yellow";
				
		
			}
	if (((mouseX <= 200)&& (mouseX >= 101))&&((mouseY <=300)&&(mouseX >= 0))){   
				thecolor = "red";
			
		
			}
	if (((mouseX <= 300)&& (mouseX >= 201))&&((mouseY <=300)&&(mouseX >= 0))){   
				thecolor = "green";
			
			}
	if (((mouseX <= 400)&& (mouseX >= 301))&&((mouseY <=300)&&(mouseX >= 0))){   
				thecolor = "blue";
				
		
			}
			System.out.println(mouseX+"\t\t "+mouseY);
				g.drawString(thecolor, mouseX, mouseY); 
  } 
}



