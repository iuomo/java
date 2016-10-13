// original code by D.Eck modified by C.W.Coleman
//    A = payment Amount per period
//    P = initial Principal (loan amount)
//    r = interest rate per period
//    n = total number of payments or periods
// a (payment amount)   p (initial principal)   r (interest rate per period)  n (total number of payments or periods

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*<applet code="Amortization.class" width=600 height=150
           alt="(Applet 'Amortization' should be displayed here.)">
</applet>
*/
public class Amortization extends JApplet implements ActionListener {

   JTextField pInput,  rInput, yInput;  // Input boxes for the numbers.
   
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
      
      pInput = new JTextField("10000");
      pInput.setBackground(Color.pink);
       rInput = new JTextField("0.05");
      rInput.setBackground(Color.pink);
    yInput = new JTextField("5");
      yInput.setBackground(Color.pink);
   
      
      /* Create panels to hold the input boxes and labels "x =" and
         "y = ".  By using a BorderLayout with the TextField in the
         Center position, the TextField will take up all the space
         left after the label is given its preferred size. */
      
      JPanel pPanel = new JPanel();
      pPanel.setLayout(new BorderLayout());
      pPanel.add( new Label("Initial Principal(Loan Amount) = "), BorderLayout.WEST );
      pPanel.add(pInput, BorderLayout.CENTER);
      
    	JPanel rPanel = new JPanel();
      rPanel.setLayout(new BorderLayout());
      rPanel.add( new Label("Yearly Interest Rate = "), BorderLayout.WEST );
      rPanel.add(rInput, BorderLayout.CENTER);

          JPanel yPanel = new JPanel();
      yPanel.setLayout(new BorderLayout());
      yPanel.add( new Label("Years of Loan = "), BorderLayout.WEST );
      yPanel.add(yInput, BorderLayout.CENTER);

      
      /* Create a panel to hold the four buttons for the four
         operations.  A GridLayout is used so that the buttons
         will all have the same size and will fill the panel. 
         The applet servers as ActionListener for the buttons. */
         
      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridLayout(1,4));

      JButton plus = new JButton("CALCULATE PAYMENT AMOUNT");
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

   
      double p,m,r,y;  // The numbers from the input boxes.

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
// a (payment amount)   p (initial principal)   r (interest rate per period)  n (total number of payments or periods

  double count = 0;
  double b,a,power,n,v;
	n = 12 * y;
  	b = p;
	power = Math.pow(1+(r/12),(-12*y));

	v = b *((r /12)/( 1- power ));	
		//System.out.println("b r n rate v "+ b+" "+r +" "+n+" rate "+power+" "+v);	
      String op = evt.getActionCommand();
      if (op.equals("CALCULATE PAYMENT AMOUNT")) 
		answer.setText( "MONTHLY PAYMENT AMOUNT = $" + v);     
         
        
      
   } // end actionPerformed()


}  // end class SimpleCalculator

