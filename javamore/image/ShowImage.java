import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// First extend JApplet instead of JApplet
public class ShowImage extends JApplet {

  public void init() {

    // Need to paint on a panel added to JApplet rather
    // than directly on JApplet.
    Image img = getImage( getCodeBase(), "monaSmall.gif" );

    // Get the ContentPane and add the panel to it
    // on which we will paint the background and image.
    getContentPane().add(new MyPanel(img));
  }
}

// This class displays the background and the image
// Also, it responds to the mouse events.
class MyPanel extends JPanel implements MouseMotionListener{
  Image img;
  int grid = 10;
  int currentX, currentY;

  MyPanel(Image img){
    this.img = img;
    addMouseMotionListener(this);
  }

  public void mouseDragged( MouseEvent e ) {
    currentX = e.getX();
    currentY = e.getY();
    repaint();
  }

  // Have to override mouseMoved with empty method.
  public void mouseMoved ( MouseEvent e){}

  // With Swing components, instead of paint() we
  // must override paintComponent.
  public void paintComponent( Graphics g ) {
    // Need to first call the paintComponent for
    // the JPanel.
    super.paintComponent(g);

    // The rest here is same as before.
    int w = getSize().width/grid;
    int h = getSize().height/grid;
    boolean black = false;
    // Draw the checkerboard background
    for ( int y = 0; y <= grid; y++ )
      for ( int x = 0; x <= grid; x++ ) {
        g.setColor(  (black = !black) ? Color.black : Color.white );
        g.fillRect( x * w, y * h, w, h );
      }
    // then the image
    g.drawImage( img, currentX, currentY, this );
  }
}
