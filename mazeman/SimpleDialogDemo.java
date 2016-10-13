
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
/*<html>
<applet code="SimpleDialogDemo" width=400 height=400></applet>
</html>*/
public class SimpleDialogDemo extends JApplet implements ActionListener {

   JLabel message;  // A label for giving some feedback to the user.
                    // It appears at the top of the applet.

   Color selectedColor = Color.gray; // This color will be used as the
                                     // initial color in the color chooser.
                                     // It is used to rememeber the user's
                                     // color choice, so that the color 
                                     // chooser can show the same color,
                                     // if it is opened twice.
                                   

   public void init() {
          // Set up the applet with a message label and four buttons.
          // Each button will open a different type of dialog.

       setBackground(Color.gray);
       getContentPane().setBackground(Color.gray);
       getContentPane().setLayout( new GridLayout(3,1,3,3) );
       message = new JLabel("Click a button to open a dialog", JLabel.CENTER);
       message.setForeground(new Color(180,0,0));
       message.setBackground(Color.white);
       message.setOpaque(true);
       getContentPane().add(message);

       JPanel buttonBar;
       JButton button;

       buttonBar = new JPanel();
       buttonBar.setLayout(new GridLayout(1,2,3,3));
       buttonBar.setBackground(Color.gray);
       getContentPane().add(buttonBar);
       button = new JButton("Message Dialog");
       button.addActionListener(this);
       buttonBar.add(button);
       button = new JButton("Confirm Dialog");
       button.addActionListener(this);
       buttonBar.add(button);

       buttonBar = new JPanel();
       buttonBar.setLayout(new GridLayout(1,2,3,3));
       buttonBar.setBackground(Color.gray);
       getContentPane().add(buttonBar);
       button = new JButton("Input Dialog");
       button.addActionListener(this);
       buttonBar.add(button);
       button = new JButton("Color Chooser");
       button.addActionListener(this);
       buttonBar.add(button);

   } // end init()
   
 
   public Insets getInsets() {
         // Leave a gray border around the applet.
      return new Insets(3,3,3,3);
   }
   
 
   public void actionPerformed(ActionEvent evt) {
          // Respond to a button click by showing a dialog
          // and setting the message label to describe the
          // user's response.

      String command = evt.getActionCommand();

      if (command.equals("Message Dialog")) {In
         message.setText("Displaying message dialog.");
         JOptionPane.showMessageDialog(null,
             "This is an example of JOptionPane.showMessageDialog.");
         message.setText("You closed the message dialog.");
      }

      else if (command.equals("Confirm Dialog")) {
         message.setText("Displaying confirm dialog.");
         int response = JOptionPane.showConfirmDialog(null,
             "This is an example of JOptioPane.showConfirmDialog.\n" 
               + "Click any button to indicate your response.");
         switch(response) {
            case JOptionPane.YES_OPTION: 
               message.setText("You clicked \"Yes\".");
               break;
            case JOptionPane.NO_OPTION: 
               message.setText("You clicked \"No\".");
               break;
            case JOptionPane.CANCEL_OPTION: 
               message.setText("You clicked \"Cancel\".");
               break;
            case JOptionPane.CLOSED_OPTION: 
               message.setText("You closed the box without making a selection.");
         }
      }

      else if (command.equals("Input Dialog")) {
         message.setText("Displaying input dialog.");
         String response = JOptionPane.showInputDialog(null,
             "This is an example of JOptioPane.showInputDialog.\n" 
               + "Type your response, and click a button.");
         if (response == null)
            message.setText("You canceled the input.");
         else if (response.trim().length() == 0)
            message.setText("You left the input box empty.");
         else
            message.setText("You entered \"" + response + "\".");
      }

      else if (command.equals("Color Chooser")) {
         message.setText("Displaying color chooser dialog.");
         Color c = JColorChooser.showDialog(null,"Select a Color",selectedColor);
         if (c == null)
            message.setText("You canceled without selecting a color.");
         else {
            selectedColor = c;  // Remember selected color for next time.
            int r = c.getRed();
            int g = c.getGreen();
            int b = c.getBlue();
            message.setText("You selected RGB = (" + r + "," + g + "," + b + ").");
         }
      }

   } // end actionPerformed()


} // end class SimpleDialogDemo

