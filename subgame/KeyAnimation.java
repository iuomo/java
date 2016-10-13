
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyAnimation extends JApplet 
                 implements ActionListener, KeyListener, FocusListener, MouseListener {
                 
   protected void doInitialization(int width, int height) {
    
   }

   protected void drawFrame(Graphics g, int width, int height) {
      g.setColor(Color.lightGray);
      g.fillRect(0,0,width,height);
      g.setColor(Color.black);
      g.drawString("Elapsed Time:  " + (getElapsedTime()/1000),10,20);
      g.drawString("Frame Number:  " + (getFrameNumber()),10,35);
   }
   
   public void keyTyped(KeyEvent evt) { 
   
   }
   
   public void keyPressed(KeyEvent evt) { 
  
   }
   
   public void keyReleased(KeyEvent evt) { 
     
   }
   
   public int getFrameNumber() {

      return frameNumber;
   }
   

   public void setFrameNumber(int frameNumber) {
 
      if (frameNumber < 0)
         this.frameNumber = 0;
      else
         this.frameNumber = frameNumber;      
   }
   

   public long getElapsedTime() {

      return elapsedTime;
   }
   

   public void setFrameCount(int max) {
 
      if (max <= 0)
         this.frameCount = -1;
      else 
         frameCount = max;
   }
   

   public void setMillisecondsPerFrame(int time) {
        
      millisecondsPerFrame = time;
      if (timer != null)
         timer.setDelay(millisecondsPerFrame);
   }
   

   public void setFocusBorderColor(Color c) {
	   focusBorderColor = c;
   }
   

   // This rest of this file is private stuff that you don't have to know about
   // when you write subclasses of this class.

   private int frameNumber = 0;            // Current frame number.
   private int frameCount = -1;            // If > 0, frame number loops from
                                           //   frameNumber-1 back to 0.
   private int millisecondsPerFrame = 40;  // Approximate time between frames.
   
   private long startTime;       // Time since animation was started or restarted.
   private long oldElapsedTime;  // Holds time the animation had been running before
                                 //    it was most recently restarted.
   private long elapsedTime;     // Time animation has been running.  This is set
                                 //    just before each frame is drawn.

   private Timer timer;   // The timer that drives the animation.
   
   private JPanel frame;  // Where the frames are drawn.  This panel fills the applet.
   
   private boolean focussed = false;  // set to true when the applet has the keyboard focus
   
   Color focusBorderColor = Color.black; //of border when applet has the focus.
   
   public KeyAnimation() {  // Constructor
      frame = new JPanel() {
            public void paintComponent(Graphics g) {
               int width = getSize().width;
               int height = getSize().height;
               drawFrame(g,width,height);
               if (focussed)                     // Draw a 3-pixel border.  If the applet has the
                  g.setColor(focusBorderColor);  //   focus, draw it in focusBorderColor; otherwise,
               else                              //   draw it in the background color.
                  g.setColor(KeyAnimation.this.getBackground());
               g.drawRect(1,1,width-1,height-1);
               //g.drawRect(1,1,width-3,height-3);
               //g.drawRect(2,2,width-5,height-5);
               if (!focussed) { // If the applet does not have the focus, 
                                // print a message for the user.
                  g.setColor(KeyAnimation.this.getForeground());
                  g.drawString("Click to activate",(int)(width / 2) ,(int)(height / 2));
               }
            }
         };
      setContentPane(frame);
      setBackground(Color.gray); // Color used for border when applet doesn't have focus.
      setForeground(Color.white);
      frame.setFont(new Font("Serif",Font.BOLD,24));
      frame.addFocusListener(this);
      frame.addKeyListener(this);
      addMouseListener(this);
   }
   
   public void init() {
      
      doInitialization(getSize().width, getSize().height);
   }
   
   public void actionPerformed(ActionEvent evt) {
         // Called by the timer when it's time to draw a new frame.
      frameNumber++;
      if (frameCount > 0 && frameNumber >= frameCount)
         frameNumber = 0;
      elapsedTime = oldElapsedTime + (System.currentTimeMillis() - startTime);
      frame.repaint();
   }
      
   private void startAnimation() {
         // Start or restart the animation, but only if the applet has focus.
      if (focussed) {
          if (timer == null) {
             timer = new Timer(millisecondsPerFrame, this);
             timer.start();
          }
          else
             timer.restart();
         startTime = System.currentTimeMillis();
      }
   }
   
   private void stopAnimation() {
         // Start the animation, if it's running, i.e. if the applet has focus.
      if (focussed) {
         oldElapsedTime += (System.currentTimeMillis() - startTime);
         elapsedTime = oldElapsedTime;
         frame.repaint();
         timer.stop();
      }
   }

   public void start() {
          
      startAnimation();
   }
   
   public void stop() {
           // Called by the system to suspend the applet. 
      stopAnimation();
   }
   
   public void focusGained(FocusEvent evt) {
      focussed = true;
      startAnimation();
   }
   
    public void focusLost(FocusEvent evt) {
       stopAnimation();
      focussed = false;
   }
   
   public void mousePressed(MouseEvent evt) {
         frame.requestFocus();
   }
   
   public void mouseEntered(MouseEvent evt) { }  // Required by the
   public void mouseExited(MouseEvent evt) { }   //    MouseListener
   public void mouseReleased(MouseEvent evt) { } //       interface.
   public void mouseClicked(MouseEvent evt) { }


} // end class KeyboardAnimationApplet2
