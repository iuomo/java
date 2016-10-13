import java.awt.*; 
import java.awt.event.*; 
import java.applet.*; 
import java.sql.*;
import java.util.Date;
/* 
  <applet code="MLjdbc.class" width=700 height=100>
  </applet> 
*/ 
class InsertData{
	Connection conn = null;
	Statement stmt = null;
	public void insert(Graphics g){
		//***************************************************
		Date date = new Date();
		String dateString = ""+ date;
				try
				{
		String url = "jdbc:mysql://66.225.18.30:3306/web?user=webuser&password=w0506r";
String sqlInsert = "INSERT INTO maze VALUES ('','maze','maze',77,'"+dateString+"');";
	g.drawString(sqlInsert, 0,30 );
			System.out.println(sqlInsert);
			
					
					System.out.println (url);
					Class.forName ("com.mysql.jdbc.Driver").newInstance ();
					System.out.println ("--after Class.forName--");
          conn = DriverManager.getConnection (url);
          System.out.println ("Database connection established");                        
					//coleman added this
					stmt = conn.createStatement();
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


///////////////////////////////////////////////////////////////////////////////////////////

public class MLjdbc extends Applet 
  implements  MouseListener, MouseMotionListener{ 

 boolean done;
 boolean stopFlag;
  String msg = ""; 
  int mouseX = 400, mouseY = 400; // coordinates of mouse 
 
  public void init() { 
     addMouseListener(this); 
     addMouseMotionListener(this); 
		 
  } 
	  // Handle mouse clicked. 
  public void mouseClicked(MouseEvent obj) { 
    mouseX = 0; 
    mouseY = 90;                                           
    msg = "Mouse clicked."; 
   repaint(); 
  } 
 
  // Handle mouse entered. 
  public void mouseEntered(MouseEvent obj) { 
    mouseX = 0; 
    mouseY = 90; 
    msg = "Mouse entered."; 
   // repaint(); 
  } 
 
  // Handle mouse exited. 
  public void mouseExited(MouseEvent obj) { 
    mouseX = 0; 
    mouseY = 90; 
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
			g.fillRect (0,0,700,100);
			g.setColor(new Color(0,0,0));
			g.drawString("Click to insert data into database.", 5,15 );

			if ((mouseX < 301)&& (mouseY < 101)){         
				InsertData s = new InsertData();
					s.insert(g);
			}
				g.drawString(msg, mouseX, mouseY); 
  } 
}

