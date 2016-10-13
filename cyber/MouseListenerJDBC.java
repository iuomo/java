import java.awt.*; 
import java.awt.event.*; 
import java.applet.*; 
import java.sql.*;
/* 
  <applet code="MouseListenerJDBC" width=200 height=200>
  </applet> 
*/ 
class InsertScore{
	
	Connection conn = null;
	Statement stmt = null;
		public InsertScore(Graphics g){
			g.setColor(new Color(0,0,255));
			g.drawString("scores inserted", 1, 110); 
		//***************************************************
				try
				{
		String url = "jdbc:mysql://192.168.1.15:3306/web?user=duke&password=redhat";
	//				String	url = "jdbc:mysql://127.0.0.1:3306/web?user=wuser&password=sno123";
		
					
					System.out.println (url);
					Class.forName ("com.mysql.jdbc.Driver").newInstance ();
					System.out.println ("--after Class.forName--");
          conn = DriverManager.getConnection (url);
          System.out.println ("Database connection established");                        
					//coleman added this
					stmt = conn.createStatement();
					String sqlInsert = "INSERT INTO scores VALUES ('','appletDUKE',192);";
					System.out.println(sqlInsert);
					stmt.executeUpdate(sqlInsert);
					// i added this 
					conn.close ();
				}
        	catch (Exception e)
        {
           System.err.println ("Cannot connect to database server.");
         }
							 
           finally
           {
               if (conn != null)
               {
                   try
                   {
                       conn.close ();
                       System.out.println ("Database connection terminated");
                   }
                   catch (Exception e) { /* ignore close errors */ }
               }
           }
			 
		}
		}


public class MouseListenerJDBC extends Applet 
  implements  MouseListener, MouseMotionListener{ 

 boolean done;
 boolean stopFlag;
  String msg = ""; 
  int mouseX = 200, mouseY = 200; // coordinates of mouse 
 
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
		//insert scores into database

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
    showStatus(mouseX + ", " + mouseY); 
  // repaint(); 
  } 
 
  // Handle mouse moved. 
  public void mouseMoved(MouseEvent obj) { 
    // show status 
    showStatus(obj.getX() + ", " + obj.getY()); 
  } 
 
  // Display msg in applet window at current X,Y location. 
  public void paint(Graphics g) { 
		 //*********************************************************************************	
		setBackground(new Color (0,0,0));
			g.setColor(new Color(255,255,0));
			g.fillRect (0,0,100,100);
			g.setColor(new Color(255,0,0));
			g.drawString("click to insert", 5,50 );

			if ((mouseX < 101)&& (mouseY < 101)){         
				InsertScore s = new InsertScore(g);
		
			}

				g.drawString(msg, mouseX, mouseY); 
  } 
}

