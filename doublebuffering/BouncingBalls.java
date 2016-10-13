import java.awt.*;
import java.applet.*;
import java.awt.event.*;
/*<applet code="BouncingBalls.class" width=500 height=500>
</applet>
*/


public class BouncingBalls extends BasicAnimate
{
  
  public static final int IDEAL_WIDTH = 640;  //When this class is ran as an application, how wide should it be.
  public static final int IDEAL_HEIGHT = 480; //When this class is ran as an application, how tall should it be.
  public static final int SIZE = 32; //What is the size of each bouncing ball.
  public final int BALL_COUNT = 20; //The number of balls to animate.
  private int x[]; //What is the current x-coordinate of the ball.
  private int y[]; //What is the current y coordinate of the ball.  
  private int dx[]; //What is the current x-direction of each ball, 1=right, -1=left
  private int dy[]; //What is the current y-direction of each ball, 1=down, -1=Up
  private int checkWidth; // What is the width of the page that we should check, takes into account how wide the ball is.
  private int checkHeight; // What is the height of the page that we should check, takes into account how tall the ball is.

//This method sets up the bouncing balls example.
  public void init()
  {
    super.init();
    checkWidth = getWidth() - SIZE;
    checkHeight = getHeight() - SIZE;

    // create the "balls"
    x = new int[BALL_COUNT]; y = new int[BALL_COUNT];
    dx = new int[BALL_COUNT]; dy = new int[BALL_COUNT];

    for (int i = 0; i < BALL_COUNT; i++)
    {
      x[i] = (int) (Math.random() * checkWidth);
      y[i] = (int) (Math.random() * checkHeight);
      int tdx = (int) (Math.random() * 2);
      int tdy = (int) (Math.random() * 2);

      if (tdx == 1)
        dx[i] = 1;
      else
        dx[i] = -1;

      if (tdy == 1)
        dy[i] = 1;
      else
        dy[i] = -1;
    }
    
    String str = getParameter("double");
    if( str!=null)
    {
      if( Integer.parseInt(str)>0)
        setDoubleBuffer(true);
      else
        setDoubleBuffer(false);
    }

    setPulseLength(10);
  }


  //  This method renders each frame of the bouncing balls.
 // The off-screen graphics object to paint to.

  public void paintOffscreen(Graphics g)
  {
    super.paintOffscreen(g);

    for (int i = 0; i < BALL_COUNT; i++)
    {
      x[i] += dx[i];
      y[i] += dy[i];
      g.setColor(Color.WHITE);
      g.fillOval(x[i], y[i], SIZE, SIZE);

      // bounce if needed
      if ((x[i] > checkWidth) || (x[i] < 0))
        dx[i] = -dx[i];
      if ((y[i] > checkHeight) || (y[i] < 0))
        dy[i] = -dy[i];
    }

  }

  // The main method is called when the class is to be ran
   // as a Java application. This method creates a frame and
   // attaches the applet to the frame. 
  
  public static void main(String args[])
  {
    BouncingBalls applet = new BouncingBalls();
    Frame frame = new Frame();
    frame.addWindowListener(new WindowAdapter()
    {
      public void windowClosing(WindowEvent e)
      {
        System.exit(0);
      }
    });

    frame.add(applet);
    frame.setSize(IDEAL_WIDTH, IDEAL_HEIGHT);
    frame.show();
    applet.init();
  }

}
