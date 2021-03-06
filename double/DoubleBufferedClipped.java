import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
<applet code="DoubleBufferedClipped.class" codebase = "Examples/flicker" width="200" height="200">
                      </applet>
*/
		      public class DoubleBufferedClipped extends Clipped { 
  Image offScrImg;

  public void update( Graphics g ) {
   // Create an offscreen image and then get its graphics context
   if ( offScrImg == null )
     offScrImg = createImage( getSize().width, getSize().height );
   Graphics og = offScrImg.getGraphics();

   // Must do the clipping on both the off 
   // and on screen graphics contexts. 
   int lastX = currentX, lastY = currentY;
   currentX = nextX; currentY = nextY;
   clipToAffectedArea( og, lastX, lastY, currentX, currentY, imgWidth, imgHeight );
   clipToAffectedArea( g, lastX, lastY, currentX, currentY, imgWidth, imgHeight );

   // Now draw on the offscreen image.
   paint( og );

   // Don't bother to call paint, just draw the offscreen image
   // to the screen.
   g.drawImage(offScrImg, 0, 0, this);

   // Get rid of the offscreen graphics context. Can't unclip a graphics
   // context so have to get a new one next time around.
   og.dispose();
  }
}

