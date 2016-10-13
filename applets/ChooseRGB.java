/*
     This applet demonstrates four easy-to-use routines for
     showing a dialog box and, in three cases, getting back
     some information from the user.  The methods are:
     
         JOptionPane.showMessageDialog
         JOptionPane.showConfirmDialog
         JOptionPane.showInputDialog
         JColorChooser.showDialog
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
<applet code="ChooseRGB.class"  height=150 width=550>
</applet>
*/
public class ChooseRGB extends JApplet implements ActionListener {

   JLabel message;  

   Color selectedColor = Color.gray; 
                                   
   public void init() {

       setBackground(Color.gray);
       getContentPane().setBackground(Color.gray);
       getContentPane().setLayout( new GridLayout(2,1,5,5) );
       // GridLayout(int numRows, int numColumns, int horz, int vert)
       message = new JLabel("Click to open the color picker.", JLabel.CENTER);
       message.setForeground(new Color(255,0,0));
       message.setBackground(Color.white);
       message.setOpaque(true);
       getContentPane().add(message);

       JPanel buttonBar;
       JButton button;

      buttonBar = new JPanel();
       buttonBar.setLayout(new GridLayout(1,2,3,3));
       buttonBar.setBackground(Color.gray);
       getContentPane().add(buttonBar);
 
       button = new JButton("Color Chooser");
       button.addActionListener(this);
       buttonBar.add(button);

   } // end init()
   
 
   public Insets getInsets() {
      return new Insets(1,1,1,1);
   }
   
   public void actionPerformed(ActionEvent evt) {

      String command = evt.getActionCommand();

    if (command.equals("Color Chooser")) {
         message.setText("Displaying color chooser dialog.");
         Color c = JColorChooser.showDialog(null,"Select a Color",selectedColor);
         if (c == null)
            message.setText("You canceled without selecting a color.");
         else {
            selectedColor = c;  // Remember selected color for next time.
            int r = c.getRed();
            int g = c.getGreen();
            int b = c.getBlue();
	   message.setBackground(new Color(r,g,b));
	     message.setForeground(new Color(r^255,g^255,b^255));
            message.setText("RGB(DEC)= ( " + r + " , " + g + " , " + b + " ) RGB(HEX)=");
         }
      }

   } // end actionPerformed()
} // end class SimpleDialogDemo


