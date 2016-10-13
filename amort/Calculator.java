// original code by D.Eck modified by C.W.Coleman

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*<applet code="Calculator.class" width=600 height=150
           alt="(Applet 'Calculator' should be displayed here.)">
</applet>
*/
public class Calculator extends JApplet implements ActionListener {

   JTextField pInput, mInput, rInput, yInput;  // Input boxes for the numbers.
   
   JLabel answer;  // JLabel for displaying the answer, or an 
                   //    error message if appropriate.

   public void init() {
      
      /* Since I will be using the content pane several times,
         declare a variable to represent it.  Note that the
         return type of getContentPane() is Container. */
      
      Container content = getContentPane();
      
      /* Assign a background color to the applet and its
         content panel.  This color will show through between
         components and around the edges of the applet. */
      
      setBackground(Color.white) ;
      content.setBackground(Color.white);
      
      /* Create the input boxes, and make sure that the background
         color is white.  (They are likely to be white by default.) */
      
      pInput = new JTextField("1000");
      pInput.setBackground(Color.yellow);
      mInput = new JTextField("100");
      mInput.setBackground(Color.yellow);
       rInput = new JTextField("0.08");
      rInput.setBackground(Color.yellow);
    yInput = new JTextField("40");
      yInput.setBackground(Color.yellow);
   
      
      /* Create panels to hold the input boxes and labels "x =" and
         "y = ".  By using a BorderLayout with the TextField in the
         Center position, the TextField will take up all the space
         left after the label is given its preferred size. */
      
      JPanel pPanel = new JPanel();
      pPanel.setLayout(new BorderLayout());
      pPanel.add( new Label("INITIAL INVESTMENT = "), BorderLayout.WEST );
      pPanel.add(pInput, BorderLayout.CENTER);
      
      JPanel mPanel = new JPanel();
      mPanel.setLayout(new BorderLayout());
      mPanel.add( new Label("MONTHLY INVESTMENT = "), BorderLayout.WEST );
      mPanel.add(mInput, BorderLayout.CENTER);
      
    JPanel rPanel = new JPanel();
      rPanel.setLayout(new BorderLayout());
      rPanel.add( new Label("YEARLY INTEREST RATE = "), BorderLayout.WEST );
      rPanel.add(rInput, BorderLayout.CENTER);

          JPanel yPanel = new JPanel();
      yPanel.setLayout(new BorderLayout());
      yPanel.add( new Label("YEARS OF INVESTMENT (n) = "), BorderLayout.WEST );
      yPanel.add(yInput, BorderLayout.CENTER);

      
      /* Create a panel to hold the four buttons for the four
         operations.  A GridLayout is used so that the buttons
         will all have the same size and will fill the panel. 
         The applet servers as ActionListener for the buttons. */
         
      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridLayout(1,4));

      JButton plus = new JButton("CALCULATE ENDING BALANCE AFTER n YEARS");
      plus.addActionListener(this);
      buttonPanel.add(plus);

    /*  JButton minus = new JButton("-");
      minus.addActionListener(this);
      buttonPanel.add(minus);

      JButton times = new JButton("*");
      times.addActionListener(this);
      buttonPanel.add(times);

      JButton divide = new JButton("/");
      divide.addActionListener(this);
      buttonPanel.add(divide);
      */
      /* Create the label for displaying the answer in red
         on a white background.  The label is set to be
         "opaque" to make sure that the white background
         is painted. */
      
      answer = new JLabel("0", JLabel.CENTER);
      answer.setForeground(Color.blue);
      answer.setBackground(Color.yellow);
      answer.setOpaque(true);
      
      /* Set up the layout for the applet, using a GridLayout,
          and add all the components that have been created. */

      content.setLayout(new GridLayout(6,1,2,2));
      content.add(pPanel);
      content.add(mPanel);
       content.add(rPanel);
       content.add(yPanel);
      content.add(buttonPanel);
      content.add(answer);
      
      /* Try to give the input focus to mInput, which is the natural
         place for the user to start. */
      
      pInput.requestFocus();
      
   }  // end init()
   
   
   public Insets getInsets() {
           // Leave some space around the borders of the applet.
      return new Insets(2,2,2,2);
   }
   

   public void actionPerformed(ActionEvent evt) {
           // When the user clicks a button, get the numbers
           // from the input boxes and perform the operation
           // indicated by the button.  Put the result in
           // the answer label.  If an error occurs, an
           // error message is put in the label.
   
      double p,m,r,y;  // The numbers from the input boxes.
      
      /* Get a number from the mInput TextField.  Use 
         xInput.getText() to get its contents as a String.
         Convert this String to a double.  The try...catch
         statement will check for errors in the String.  If 
         the string is not a legal number, the error message
         "Illegal data for x." is put into the answer and
         the actionPerformed() method ends. */
//**************************************************************************
      try {
         String pStr = pInput.getText();
         p = Double.parseDouble(pStr);
      }
      catch (NumberFormatException e) {
            // The string xStr is not a legal number.
         answer.setText("Illegal data for principal.");
         return;
      }
 //**************************************************************************
    try {
         String mStr = mInput.getText();
         m = Double.parseDouble(mStr);
      }
      catch (NumberFormatException e) {
            // The string xStr is not a legal number.
         answer.setText("Illegal data for principal.");
         return;
      }
       //**************************************************************************
    try {
         String rStr = rInput.getText();
         r = Double.parseDouble(rStr);
      }
      catch (NumberFormatException e) {
            // The string xStr is not a legal number.
         answer.setText("Illegal data for principal.");
         return;
      }
       //**************************************************************************
    try {
         String yStr = yInput.getText();
         y = Double.parseDouble(yStr);
      }
      catch (NumberFormatException e) {
            // The string xStr is not a legal number.
         answer.setText("Illegal data for principal.");
         return;
      }
  //**************************************************************************
  // calculate the investment
  double count = 0;
  double b;
	int v;
  b = p;
  r = (r /12);
  	while (count < (y*12)){
		b = b *(1+r)+m;
		count ++;
	}
	v = (int)b;
      String op = evt.getActionCommand();
      if (op.equals("CALCULATE ENDING BALANCE AFTER n YEARS"))
	        answer.setText( "ENDING BALANCE = $" + v );
     
           else if (y == 0)  answer.setText("Can't divide by zero!");
        
      
   } // end actionPerformed()


}  // end class SimpleCalculator
