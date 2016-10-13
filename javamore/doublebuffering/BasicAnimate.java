import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class BasicAnimate extends Applet implements Runnable
{
  private Thread thread = null;  // The thread that is used to drive the animation.


  private Image offscreenImage = null; // The off-screen image used for double buffering.


  private Graphics offscreenGraphics = null;

  private Graphics primaryGraphics = null;

 
  private boolean done;

 
  private long pulseCount;

  private int pulseLength = 100;


  private boolean doubleBuffer = true;

  public void init()
  {
    thread = new Thread(this);

    offscreenImage = createImage(getWidth(), getHeight());

    offscreenGraphics = offscreenImage.getGraphics();
    primaryGraphics = getGraphics();
    pulseCount = 0;
    thread.start();
  }

  public void paintOffscreen(Graphics g)
  {
    // paint the off-screen image
    g.setColor(Color.black);
    g.fillRect(0, 0, getWidth(), getHeight());
  }

  
  public void run()
  {
    done = false;
    while (!done)
    {
      try
      {
        // pause for this frame
        Thread.sleep(pulseLength);

        // draw the off-screen image
        if (doubleBuffer)
          paintOffscreen(offscreenGraphics);
        else
          paintOffscreen(primaryGraphics);

        // paint off-screen image to primary display, if needed
        if (doubleBuffer)
          primaryGraphics.drawImage(offscreenImage, 0, 0, this);

        // increase the pulse count
        pulseCount++;
      } catch (InterruptedException e)
      {
      }
    }
  }

  public void setPulseLength(int pulseLength)
  {
    this.pulseLength = pulseLength;
  }

  public int getPulseLength()
  {
    return pulseLength;
  }

  public void setDoubleBuffer(boolean doubleBuffer)
  {
    this.doubleBuffer = doubleBuffer;
  }

  public boolean getDoubleBuffer()
  {
    return doubleBuffer;
  }

  public void setPulseCount(long pulseCount)
  {
    this.pulseCount = pulseCount;
  }

  public long getPulseCount()
  {
    return pulseCount;
  }

}
