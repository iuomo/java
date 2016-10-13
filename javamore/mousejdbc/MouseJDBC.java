import java.awt.*; 
import java.awt.event.*; 
import java.applet.*; 
import java.sql.*;
import java.util.Date;
//import java.lang.Object;
/*
CREATE TABLE `mouse` (
  `id` int(32) NOT NULL auto_increment,
  `name` varchar(32) NOT NULL default '',
  `color` varchar(32) NOT NULL default '',
  `score` int(32) NOT NULL default '0',
  `datetime` varchar(32) NOT NULL default '',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM AUTO_INCREMENT=0 ;
*/

/* 
  <applet code="MouseJDBC" width=400 height=400>
  </applet> 
*/ 





class InsertData {
	//Connection conn = null;
	Statement stmt = null;
	 InsertData(Graphics g,Connection idconn,String thecolor){
			 
				 
			//g.setColor(new Color(0,0,255));
	
		//***************************************************
		// id  name  maze score date
		Date date = new Date();
		String dateString = ""+ date;
		String name = "test";
		int score = 77;
		//thecolor = this.thecolor;
		
				try
				{
		String sqlInsert = "INSERT INTO mouse VALUES ('','"+name+"','"+thecolor+"','"+score+"','"+dateString+"');";
				g.drawString(sqlInsert, 5,350); 			
			System.out.println(sqlInsert);
			
					
	//Class.forName ("com.mysql.jdbc.Driver").newInstance ();
					
          //conn = DriverManager.getConnection (url);
          System.out.println ("Database connection established");                        
					//coleman added this
					stmt = idconn.createStatement();
					stmt.executeUpdate(sqlInsert);
					// i added this 
					//conn.close ();
				}
        	catch (Exception e)
        {
           System.err.println ("Cannot connect to database server.");
         }
							 
          /* finally
           {
               if (conn != null)
               {
                   try
                   {
                       conn.close ();
                       System.out.println ("Database connection terminated");
                   }
                   catch (Exception e) { // ignore close errors  }
               }
           }
	   */
			 
		}//end InsertData constructor
		}//end InsertData



public class MouseJDBC extends Applet implements  MouseListener, MouseMotionListener{ 

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
	  	   conn = null;
	  String url = "jdbc:mysql://pascobulldogs.com:3306/web?user=????&password=????";
	  System.out.println (url);
	
	  try{
		  Class.forName ("com.mysql.jdbc.Driver").newInstance ();
		  conn = DriverManager.getConnection (url);
	  }
        	catch (Exception e)
        {
           System.err.println ("Cannot connect to database server.");
         }

		}//end init()
		
	public void stop(){  
		
				if (conn != null){
				try{
					conn.close ();
					System.out.println ("Database connection terminated");
				}
                   catch (Exception e) { /* ignore close errors */ }
               }
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
				InsertData s = new InsertData(g,conn,thecolor);
		
			}
	if (((mouseX <= 200)&& (mouseX >= 101))&&((mouseY <=300)&&(mouseX >= 0))){   
				thecolor = "red";
				InsertData s = new InsertData(g,conn,thecolor);
		
			}
	if (((mouseX <= 300)&& (mouseX >= 201))&&((mouseY <=300)&&(mouseX >= 0))){   
				thecolor = "green";
				InsertData s = new InsertData(g,conn,thecolor);
		
			}
	if (((mouseX <= 400)&& (mouseX >= 301))&&((mouseY <=300)&&(mouseX >= 0))){   
				thecolor = "blue";
				InsertData s = new InsertData(g,conn,thecolor);
		
			}
			System.out.println(conn);
				g.drawString(thecolor, mouseX, mouseY); 
  } 
}



