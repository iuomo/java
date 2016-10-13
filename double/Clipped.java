import java.awt.*;
import java.awt.event.*;

public class Clipped extends TerribleFlicker {
  int nextX, nextY;
  int imgWidth = 60;
  int imgHeight = 79;
 
  public void mouseDragged( MouseEvent e ) {
    nextX=e.getX();
    nextY=e.getY();
    repaint();
  }

  void clipToAffectedArea(Graphics g, int oldx, int oldy,
    int newx, int newy, int width, int height) {
    int x = Math.min( oldx, newx );
    int y = Math.min( oldy, newy );
    int w = ( Math.max( oldx, newx ) + width ) - x;
    int h = ( Math.max( oldy, newy ) + height ) - y;
    g.clipRect( x, y, w, h );
  }

  public void update( Graphics g ) {
    int lastX = currentX, lastY = currentY;
    currentX = nextX; currentY = nextY;
    clipToAffectedArea( g, lastX, lastY,currentX,
                         currentY, imgWidth, imgHeight );
    paint( g );
  }
} 