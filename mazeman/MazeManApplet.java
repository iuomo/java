/*
  
<applet code="MazeManApplet" width=400 height=400></applet> 
 
  
MazeManApplet.java

This assignment shows application and reinforces multi-dimensional arrays.
by Nancy Reddig, Oracle IA
jdbc by Craig Coleman, , Oracle IA
	
mysql script
CREATE TABLE `maze` (
  `id` int(32) NOT NULL auto_increment,
  `name` varchar(32) NOT NULL default '',
  `maze` varchar(32) NOT NULL default '',
  `score` int(32) NOT NULL default '0',
  `datetime` varchar(32) NOT NULL default '',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM AUTO_INCREMENT=10 ;

String name = "cwc";
String maze = "EASY STREET";
int score = 97;
String sqlInsert = "INSERT INTO maze VALUES ('','"+name+"','"+maze+"','"+score+"','"+dateString+"');";


*/


import java.awt.event.*;
import java.awt.*;
import java.awt.Graphics;    // import class Graphics
import javax.swing.*;  // import class JApplet 
import java.sql.*;
import java.util.Date;

class InsertData {
	Connection conn = null;
	Statement stmt = null;

	
		 InsertData(Graphics g, int time){
			
		//***************************************************
		String response = JOptionPane.showInputDialog(null,"INPUT YOUR INTIALS.");
				String initials = response.substring(0,3);
				Date date = new Date();
		
				String dateString = ""+ date;
		
				String name = initials;
				String maze = "EASY";
				int score = time;
				try
				{
String url = "jdbc:mysql://pascobulldogs.com:3306/web?user=webuser&password=w0506r";

String sqlInsert = "INSERT INTO maze VALUES ('','"+name+"','"+maze+"','"+score+"','"+dateString+"');";
g.drawString("SCORE RECORED. REFRESH TO START OVER!",10,380);
					
			//System.out.println(sqlInsert);		
			//	System.out.println (url);
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
          conn = DriverManager.getConnection (url);                     
					//cwc added this
					stmt = conn.createStatement();
						stmt.executeUpdate(sqlInsert);
					// i added this 
					conn.close ();
				}
        	catch (Exception e)
        {
          // System.err.println ("Cannot connect to database server.");
         }
							 
           finally
           {
               if (conn != null)
               {
                   try
                   {
                       conn.close ();
                    //   System.out.println ("Database connection terminated");
                   }
                   catch (Exception e) { /* ignore close errors */ }
               }
           }
			 
		}
		}

public class MazeManApplet extends JApplet implements ActionListener , KeyListener,  MouseListener
{
	public void actionPerformed(ActionEvent evt) {
			 
	}
	
	double starttime; int totaltime; //set time doubles and int
	 boolean focussed = false; // set focussed to false
	 boolean done;
	 boolean reportscore = false;

	int a,b;
	int matrix[][]={{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,3,2,2,2,0,2,2,2,2,2,2,2,2,2,2,2,2,3,0},
			{0,2,0,0,2,0,0,0,0,2,0,0,0,0,0,2,0,0,2,0},
			{0,2,0,0,2,0,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
			{0,2,2,2,2,0,2,0,0,0,2,0,0,0,2,0,0,0,0,0},
			{0,2,0,0,2,0,2,0,2,2,2,2,2,0,2,2,2,2,2,0},
			{0,2,2,2,2,0,2,2,2,-1,-1,-1,2,0,2,0,0,0,2,0},
			{0,2,0,0,2,0,2,0,2,-1,-1,-1,2,2,2,0,2,2,2,0},
			{0,2,2,2,2,0,2,0,2,2,2,2,2,0,2,2,2,0,2,0},
			{0,2,0,0,2,2,2,0,0,0,2,0,0,0,2,0,2,0,2,0},
			{0,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,0,2,0},
			{0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0},
			{0,2,2,2,0,2,2,2,2,2,2,2,2,2,2,2,3,0,2,0},
			{0,2,0,2,0,2,0,0,0,0,0,0,0,0,0,0,2,0,2,0},
			{2,2,0,3,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	Maze board;
	MazeMan pacman;
	
	public void init() {
			
		board=new Maze(this);
		pacman=new MazeMan(this,6,10);
		repaint();
		
		addKeyListener(this);
		addMouseListener(this);//cwc
		
	
	
	}
	
	public void paint( Graphics g ) {
			
		board.drawMaze();
		pacman.drawMazeMan(true);
		pacman.start();
	}    
	
	 
	      public void mousePressed(MouseEvent e) {
        // Request the input focus when the user clicks on
        // the applet.
    
	
   }
   
   public void mouseEntered(MouseEvent e) {// requestFocus();  
	   
  // System.out.println("mouse entered");  
   }  
   public void mouseExited(MouseEvent e) {// requestFocus();  
 // System.out.println("mouse exited");  
   }  
   public void mouseReleased(MouseEvent e) {//requestFocus();   
 //  System.out.println("mouse release");   
   }
   public void mouseClicked(MouseEvent e) {requestFocus();   
	   if (!focussed) starttime = System.currentTimeMillis();
	   //	System.out.println("mouse click");  
			requestFocus();
		focussed = true; 
   
   }  


	public void keyReleased(KeyEvent e){
	
		
	}
		
	  public void keyTyped(KeyEvent e){
		//System.out.println("keyTyped");
		if (focussed){
		switch(e.getKeyCode())
			{case KeyEvent.VK_W: //case KeyEvent.VK_W uo:
				pacman.moveUp(); 
				break;
				
				case KeyEvent.VK_Z: //case KeyEvent.VK_Z down:
				pacman.moveDown(); 
				break;
				
				case KeyEvent.VK_S: //case KeyEvent.VK_S right:
				pacman.moveUp(); 
				break;
				
				case KeyEvent.VK_A: //case KeyEvent.VK_A  left:
				pacman.moveUp(); 
				break;
				
				
				case KeyEvent.VK_UP: //case KeyEvent.VK_KP_UP:
					pacman.moveUp();
				break;
				case KeyEvent.VK_DOWN://case KeyEvent.VK_KP_DOWN:
					pacman.moveDown();
				break;
				case KeyEvent.VK_RIGHT://case KeyEvent.VK_KP_RIGHT:
					pacman.moveRight();
				break;
				case KeyEvent.VK_LEFT://case KeyEvent.VK_KP_LEFT:
					pacman.moveLeft();
				break;
			}
		}// end if
	}
	  public void keyPressed(KeyEvent e){
		//System.out.println("keyPressed");
		if (focussed){
		switch(e.getKeyCode())
		{	case KeyEvent.VK_W: //case KeyEvent.VK_W uo:
				pacman.moveUp(); 
				break;
				
				case KeyEvent.VK_Z: //case KeyEvent.VK_Z down:
				pacman.moveDown(); 
				break;
				
				case KeyEvent.VK_S: //case KeyEvent.VK_S right:
				pacman.moveUp(); 
				break;
				
				case KeyEvent.VK_A: //case KeyEvent.VK_A  left:
				pacman.moveUp(); 
				break;
				
			case KeyEvent.VK_UP: //case KeyEvent.VK_KP_UP:
				pacman.moveUp();break;
			case KeyEvent.VK_DOWN://case KeyEvent.VK_KP_DOWN:
				pacman.moveDown();break;
			case KeyEvent.VK_RIGHT://case KeyEvent.VK_KP_RIGHT:
				pacman.moveRight();break;
			case KeyEvent.VK_LEFT://case KeyEvent.VK_KP_LEFT:
				pacman.moveLeft();break;
		}
		} // end if focussed
	}
}

class Maze
{
	MazeManApplet parent;
	Maze(MazeManApplet p)
	{
		parent=p;
	}
	void drawMaze()
	{
		Graphics g=parent.getGraphics();
		for(int i=0;i<20;i++)
			for(int j=0;j<16;j++)
			{
				switch(parent.matrix[j][i])
				{
					case -1:
						g.setColor(Color.gray);
						g.fillRect(i*20,j*20,20,20);
						break;
					case 1:
						g.setColor(Color.black);
						g.fillRect(i*20,j*20,20,20);
						break;
					case 0:
						g.setColor(Color.white);
						g.fillRect(i*20,j*20,20,20);
						break;
					case 2:
						g.setColor(Color.black);
						g.fillRect(i*20,j*20,20,20);
						g.setColor(Color.white);
						g.fillOval(i*20+8,j*20+8,4,4);
						break;
					case 3:
						g.setColor(Color.black);
						g.fillRect(i*20,j*20,20,20);
						g.setColor(Color.white);
						g.fillOval(i*20+4,j*20+4,12,12);
						break;
					
				}
			}
	
		
			    g.setColor(Color.yellow);//change the bg color
                  g.drawString("Click to activate",10,340);
		  g.setColor(Color.red);//change the bg color
                  g.drawString("Click to activate",11,341);
	
			
	}
	
	
}

class MazeMan extends Rectangle implements Runnable
{
	Thread thread;
	boolean mouth=true;
	int direction =1;  //		4
				    //       3    1
				    ///		2
	int count=0;
	int startangle;
	int eyeX,eyeY;
	int row, column;
	MazeManApplet parent;
	MazeMan(MazeManApplet p, int r, int c)
	{
		super(r*20+1,c*20+1,18,18);
		row=c;
		column=r;
		parent=p;
		rotate(1);	
	}
	
 	public void start()
	{
		if(thread==null)
		{
			thread=new Thread(this);
			thread.start();
		}	
	}
	public void run()
	{
		while(true)
		{	try
			{	
				Thread.sleep(25);
			}
			catch(InterruptedException e)
			{}
			count++;
			if(count==20)
			{
				count=0;
				eraseMazeMan();
	    			drawMazeMan(mouth);
	    			mouth=!mouth;
			}
			if(count==10)
			{
				eraseMazeMan();
	    			drawMazeMan(mouth);
	    			mouth=!mouth;
			}
		}
	}
	
	void drawMazeMan(boolean open)
	{
		Graphics g=parent.getGraphics();
		g.setColor(Color.yellow);
	
	
		if(open)
			g.fillArc(x,y,width,height,startangle,270);
		else
		{
			g.fillOval(x,y,width,height);
			g.setColor(Color.black);
			switch(direction)	
			{
				case 1:
					g.drawLine(x+9,y+9,x+18,y+9);
					break;
				case 2:
					g.drawLine(x+9,y+9,x+9,y+18);
					break;
				case 3:
					g.drawLine(x+9,y+9,x,y+9);
					break;
				case 4:
					g.drawLine(x+9,y+9,x+9,y);
					break;
			}
		}
		g.setColor(Color.black);
		g.fillOval(x+eyeX,y+eyeY,3,3);
		
			if ((parent.focussed)&(!parent.reportscore)){
				g.setColor(new Color(0,0,0));//change the bg color
				g.fillRect(0,330,400,350);
				g.setColor(Color.yellow);
		parent.totaltime = (int)((System.currentTimeMillis() - parent.starttime)/1000);
				g.drawString("" + parent.totaltime + " seconds",10,360);
			}
			
			parent.done  = true;
			for (parent.b = 0; parent.b < 20; parent.b++){
			for (parent.a = 0;parent.a < 16; parent.a++){
				if((parent.matrix[parent.a][parent.b] ==2) | (parent.matrix[parent.a][parent.b] ==3))parent.done = false;
				}
			}
			if((parent.done)&(!parent.reportscore)){
				g.setColor(Color.yellow);
			
	//g.drawString("You complete the maze in " + parent.totaltime + " seconds.",10,380);
				parent.reportscore = true;
				InsertData s = new InsertData(g, parent.totaltime);
		}
		   
	}
	void moveUp()
	{
		if(direction!=4)
		{
			eraseMazeMan();
			direction=4;
			rotate(4);
			drawMazeMan(mouth);
		}
		else
		if(parent.matrix[row-1][column]!=0&&parent.matrix[row-1][column]!=-1)
		{
			
			eraseMazeMan();
			if(direction==4)
			{
				row--;
				y=row*20+1;
			}
			
			parent.matrix[row][column]=1;
			direction=4;
			rotate(4);
			drawMazeMan(mouth);
	    		
		}
	
	}
	void moveDown()
	{
		if(direction!=2)
		{
			eraseMazeMan();
			direction=2;
			rotate(2);
			drawMazeMan(mouth);
		}
		else
		if(parent.matrix[row+1][column]!=0&&parent.matrix[row+1][column]!=-1)
		{
			eraseMazeMan();
			if(direction==2)
			{
				row++;
				y=row*20+1;
			}
			parent.matrix[row][column]=1;
			direction=2;
			rotate(2);
			drawMazeMan(mouth);
	    		
		}	
	}
	void moveRight()
	{
		if(direction!=1)
		{
			eraseMazeMan();
			direction=1;
			rotate(1);
			drawMazeMan(mouth);
		}
		else
			 if(column==19&&parent.matrix[row][0]!=0)
			 {	
			 	eraseMazeMan();
			 	column=0;
			 	x=column*20+1;
			 	
				parent.matrix[row][column]=1;
			 	drawMazeMan(mouth);
			 }
			else
			if(parent.matrix[row][column+1]!=0&&parent.matrix[row][column+1]!=-1)
			{
				eraseMazeMan();
				if(direction==1)
				{
					column++;
					if(column==20)
						column=0;
					
					parent.matrix[row][column]=1;
					x=column*20+1;
				}
				direction=1;
				rotate(1);
				drawMazeMan(mouth);
		    		
			}
			
	}
	void moveLeft()
	{
		if(direction!=3)
		{
			eraseMazeMan();
			direction=3;
			rotate(3);
			drawMazeMan(mouth);
		}
		else
		if(column==0&&parent.matrix[row][19]!=0)
		{
				eraseMazeMan();	
				column=19;
				x=column*20+1;
				
				parent.matrix[row][column]=1;
				drawMazeMan(mouth);
		
		}
		else
		if(parent.matrix[row][column-1]!=0&&parent.matrix[row][column-1]!=-1)
		{
			
			eraseMazeMan();
			if(direction==3)
			{	
				column--;
				if(column==-1)
					column=19;
				x=column*20+1;
			}
			
			parent.matrix[row][column]=1;		
			drawMazeMan(mouth);
	    		
		}
	}
	void eraseMazeMan()
	{
		Graphics g=parent.getGraphics();
		g.setColor(Color.black);
		g.fillRect(x-1,y-1,width+2,height+2);
	}
	
	public void rotate(int r)
	{
		switch(r)
		{
			case 2:
				startangle =315;
				direction=2;
				eyeX=8;
				eyeY=4;
				break;
			case 3:
				startangle=225;
				direction=3;
				eyeX=12;
				eyeY=4;
				break;
			case 1:
				startangle =45;
				direction=1;
				eyeX=4;
				eyeY=4;
				break;
			case 4:
				startangle =135;
				direction=4;
				eyeX=8;
				eyeY=12;
				break;
		
		
		}
	
	}
}
