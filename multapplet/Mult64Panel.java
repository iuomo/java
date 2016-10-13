import java.awt.*;        
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Mult64Panel extends JPanel {
	double starttime; int totaltime; //set time doubles and int
	private NumberGrid numbergrid;
	private LED led;
	private matrixLED matrixled;
	int next = 0;
	int answer = 0;
	int ccount = 0;
	int errors = 0;
	boolean alldone = false;
	boolean gottime = false;
	String globalchar ="*";
  
	int globalint = -1;
	int gotinput = -1;
	int input1 = -1, input2 = -1, input3 = -1;
	boolean got1 = false, got2 = false, got3 = false;
   
   
	private Timer timer;        // Timer that drives the animation.
	private int gwidth, gheight;  
	private Mult mult;         
	private Input input;          
	private Problem problem;   
      
	private class matrixLED{
   
	matrixLED() {   }
 
      void draw(Graphics g, int left, int top, char cnumber) {  
      	      left = left - 5;
      	      int matrix0[][]={ {0,0,0,0,0,},
					{0,0,1,0,0},
					{1,0,1,0,1},
					{0,1,1,1,0},
					{1,0,1,0,1},
					{0,0,1,0,0},
					{0,0,0,0,0},
					};
      	      switch (cnumber){
      	      	      case '=':
      	      	      	      int matrix1[][]={ 	{0,0,0,0,0,},
						{0,0,0,0,0},
						{0,1,1,1,0},
						{0,0,0,0,0},
						{0,1,1,1,0},
						{0,0,0,0,0},
						{0,0,0,0,0},
					};
						matrix0 = matrix1;
      	      	      	      break;
      	      	      case '*':
      	      	      	      int matrix2[][]={ {0,0,0,0,0,},
					{0,0,1,0,0},
					{1,0,1,0,1},
					{0,1,1,1,0,},
					{1,0,1,0,1},
					{0,0,1,0,0},
					{0,0,0,0,0},
					};
					matrix0 = matrix2;
      	      	       break;
      	      	       case '^':
      	      	      	      int matrix3[][]={ {0,0,0,0,0,},
					{0,0,1,0,0},
					{0,1,1,1,0},
					{1,0,1,0,1},
					{0,0,1,0,0},
					{0,0,1,0,0},
					{0,0,0,0,0},
					};
					matrix0 = matrix3;
      	      	       break;
      	      	         case '+':
      	      	      	      int matrix4[][]={ {0,0,0,0,0,},
					{0,0,0,0,0},
					{0,0,0,0,0},
					{0,1,0,1,0},
					{0,0,0,0,0},
					{1,0,0,0,1},
					{0,1,1,1,0},
					};
					matrix0 = matrix4;
      	      	       break;
      	      }
          
			
			
      	      int rd, gn, be,x,y, h,k,i,c, s, row, col;
      //	  g.setColor(Color.YELLOW);
     //    g.fillRect(left, top, 100, 400);
         //  horizontal //////////////////////////////////////////////////
      k = 0;h = 0;int sc;
 // System.out.println("*****");
         for (row = 0;row <7;row++){
         	         col = 0;
         	while (col < 5){
         		sc = 110;
         		
         		for (s = 0; s < 6;s++){
         	 		 g.setColor(new Color(0,255 - sc,0));	 
         	 		 if (matrix0[row][col] == 0) g.setColor(new Color(255,255,255));
         	 		 g.fillRect(left +h+s,top + k+s ,10-(2*s),19-(2*s));
         	 		 	
         	 		 	  if (s < 5){ sc = sc - 10;}else{sc = sc + 10;};
         	 		
         		}
         	 	  h = h + 11;
         	 
         	 	 //System.out.print(" | "+row+" "+col+ " = "+star[row][col]+" ");
         	 	col++;
         	 }
         	 	// System.out.println();
         	 	h = 0;
         	 	k = k + 20;
		  	
	 	}	
      }
   } // end nested class matrixLED
  
  private class LED{
   
      LED() { // Constructor centers the boat horizontally, 80 pixels from top.
      }
 
      void draw(Graphics g, int left, int top, int width, int rotation, int colorOff) {  // Draws the boat at its current location.
         
      	      int rd, gn, be, i,c, s;
      //	  g.setColor(Color.YELLOW);
     //    g.fillRect(left, top, 100, 400);
         //  horizontal //////////////////////////////////////////////////
         if(rotation == 0){
         c = 0;
         s =110;
          
         for (i = 0;i <16;i++){
         	 if(colorOff == 1){
         	 	 rd = gn = be = 255;//changed to 255
         	 	 g.setColor(new Color(rd,gn,be));
         	 }else{
         	 	
         	 	 g.setColor(new Color(0,255-s,0));	 
         	 }
         	 g.drawLine(left + c, top + i ,left - c + width ,top + i);
		  	 if (i < 8){c --  ; s = s - 5;}else{c ++;s = s + 5;};
	 	}
	 }else{
	 	  c = 0;
	 	    s =110;
	 	  for (i = 0;i <16;i++){
	 	  	  if(colorOff == 1){
	 	  	 rd = gn = be = 255;
         	 	 g.setColor(new Color(rd,gn,be));
         	 }else{
         	 	
         	 	  g.setColor(new Color(0,255-s,0));	 
         	 }
	 	  	  g.drawLine(left + i, top + c,left + i ,top + width - c);
		  	 if (i < 8){c --  ; s = s - 5;}else{c ++;s = s + 5;};
	 	}
	 	 
	 	 
	 }
	
	  //  vertical //////////////////////////////////////////////////
	
      }
   } // end nested class LED
  
     private class NumberGrid {
      int centerX, centerY;  // Current position of the center of the boat.
      NumberGrid() { // Constructor centers the boat horizontally, 80 pixels from top.
         //centerX = width/2;
         //centerY = 80;
      }
     // void updateForNewFrame() { // Makes sure boat has not moved off screen.
    //    if (centerX < 0)
     //       centerX = 0;
    //     else if (centerX > width)
   //         centerX = width;
    //  }
      void draw(Graphics g, int left, int top, int number) {  
      	
      	  
    
          
     //g.fillRect(0, 0, 800, 600);
     int width = 40;
          	led.draw(g,left,top,width,0,1); //bar 1
       		led.draw(g,left,top+60,width,0,1); //bar 2
       	       	led.draw(g,left,top +120,width,0,1); //bar 3
    	 	led.draw(g,left - 18 ,top + 18,width,1,1); //bar 4
	      	led.draw(g,left - 18,top + 78,width,1,1); // bar 5
        	led.draw(g,left + 42,top + 18,width,1,1); //bar 6
         	led.draw(g,left + 42,top + 78,width,1,1); // bar 7
         
      
      
      
    //  bar 1 //////////////////////////////////////////////////
      		
    if ((number == 0)||(number == 2)||(number == 3)||(number == 5)||(number == 6)||(number == 7)||(number == 8)||(number == 9))
    	    led.draw(g,left,top,width,0,0);
       		 //  bar 2 //////////////////////////////////////////////////
	if ((number == 2)||(number == 3)||(number == 4)||(number == 5)||(number == 6)||(number == 8)||(number == 9))
       		 	 led.draw(g,left,top+60,width,0,0);
       		 //  bar 3 //////////////////////////////////////////////////
       			if ((number == 0)||(number == 2)||(number == 3)||(number == 5)||(number == 6)||(number == 8)||(number == 9))
       		 	led.draw(g,left,top + 120,width,0,0);
    	
		  //  bar 4 //////////////////////////////////////////////////
	if ((number == 0)||(number == 4)||(number == 5)||(number == 6)||(number == 7)||(number == 8)||(number == 9))
         	led.draw(g,left - 18 ,top + 18,width,1,0);
	
	 //  bar 5 //////////////////////////////////////////////////
		 	if ((number == 0)||(number == 2)||(number == 6)||(number == 8))
         	led.draw(g,left - 18,top + 78,width,1,0);
	 //  bar 6 //////////////////////////////////////////////////
			   	if ((number == 0)||(number == 1)||(number == 2)||(number == 3)||(number == 4)||(number == 7)||(number == 8)||(number == 9))
         	led.draw(g,left + 42,top + 18,width,1,0);
		 //  bar 7 //////////////////////////////////////////////////
		if ((number == 0)||(number == 1)||(number == 3)||(number == 4)||(number == 5)||(number == 6)||(number == 7)||(number == 8)||(number == 9))
         	led.draw(g,left + 42,top + 78,width,1,0);
	
      //   g.fillRoundRect(100 + 40, 100 + 20, 80, 40, 20, 20);
      }
   } // end nested class NumberGrid
  // Display the banner.
    
    
 //////////////end of number grids
   public Mult64Panel() {
   	   int x, y;
      setBackground(Color.WHITE);
     
    // problem.nextProblem = true;
         
         //
      ActionListener action = new ActionListener() {
               // Defines the action taken each time the timer fires.
         public void actionPerformed(ActionEvent evt) {
            if (problem != null) {
               mult.updateForNewFrame();
               input.updateForNewFrame();
               problem.updateForNewFrame();
         
            }
            repaint();
         }
      };
      timer = new Timer( 30, action );  

      addMouseListener( new MouseAdapter() {
              // The mouse listener simply requests focus when the user
              // clicks the panel.
         public void mousePressed(MouseEvent evt) {
            requestFocus();
                   starttime = System.currentTimeMillis();
                //System.out.println("starttime "+starttime);
              
         }
      } );

      addFocusListener( new FocusListener() {
             // The focus listener starts the timer when the panel gains
             // the input focus and stops the timer when the panel loses
             // the focus.  It also calls repaint() when these events occur.
         public void focusGained(FocusEvent evt) {
            timer.start();
            repaint();
         }
         public void focusLost(FocusEvent evt) {
            timer.stop();
            if(input.gotCorrect == true)
            repaint();
         }
      } );

      addKeyListener( new KeyAdapter() {
           
         public void keyPressed(KeyEvent evt) {
         	 String schar;
            int code = evt.getKeyCode(); 
           
             if(input.gotInput == false){globalint = code;  input.gotInput = true;}
            	
            if (code == KeyEvent.VK_LEFT) {
               
             }
            
            else if (code == KeyEvent.VK_RIGHT) {  
          
            }
             else if (code == KeyEvent.VK_ENTER) {  
               
            }
            else if (code == KeyEvent.VK_DOWN) {
                 
                input.gotInput= true;
                
            }
         }
      } );

   } // end constructor
   
   
   /**
    * The paintComponent() method draws the current state of the game.  It
    * draws a gray or cyan border around the panel to indicate whether or not
    * the panel has the input focus.  It draws the boat, sub, and inputby
    * calling their respective draw() methods.
    */
   public void paintComponent(Graphics g) {
      
      super.paintComponent(g);  // Fill panel with background color, green.
      
       numbergrid = new NumberGrid();
       led = new LED();
       matrixled = new matrixLED();
 
                
      if (problem == null) {
            // The first time that paintComponent is called, it assigns
            // values to the instance variables.
         gwidth = getWidth();
         gheight = getHeight();
        mult = new Mult();
         problem = new Problem();
         input = new Input();

      }
       
      
      if (hasFocus())
             	  g.setColor(new Color(0,155,0));
      else {
              	  g.setColor(new Color(0,100,0));
              	  Font font = new Font("Dialog", Font.BOLD, 24);
              	  g.setFont(font);
              	  g.drawString("CLICK TO START. USE LEFT ARROW TO CLEAR INPUT", 30,350);
              	  g.setColor(Color.GRAY);
      }
 
            int x,y;     
     
           
      mult.draw(g);
      problem.draw(g);
     input.draw(g);
      
   } // end drawFrame()
   
   private class Mult {
     //int centerX, centerY;  // Current position of the center of the boat.
      Mult() { // Constructor centers the boat horizontally, 80 pixels from top.
      }
      void updateForNewFrame() { // Makes sure boat has not moved off screen.
  
     }
      void draw(Graphics g) {  // Draws the boat at its current location.
   //      g.setColor(Color.BLUE);
       //  g.fillRoundRect(centerX - 40, centerY - 20, 80, 40, 20, 20);        
      }
   } // end nested 
   
   
   /**
    * This nested class defines the input. 
    */
   private class Input {
     int product, theinput ,in1, in2, in3, inputLeft, inputTop; // Current position of the center of the input.
     boolean gotInput;    // If true, the inputis falling; if false, it
      boolean inputNum; 
        boolean gotCorrect;                   // is attached to the boat.
      Input() { // Constructor creates a inputthat is initially attached to boat.
        gotInput = false;
        inputLeft = 510 ; inputTop = 30;
        theinput = input1 = input2 = input3 = -1;
        
      }
      void updateForNewFrame() {
      	     
      	      // If inputis falling, take appropriate action.
      	      gotCorrect = false;
        if (gotInput) {
        	//System.out.println(gotInput+" got input");
        	 gotInput = false;
        	 
        	 
        	 if((globalint == 10)&&(input1 >=0)){
        	 
        	 if ((input2 == -1)&&(input3 == -1)) product = input1;
        	  if ((input3 == -1)&&(input2>=0)&&(input1>=0)) product = (input1*10)+input2;
        	  if (input3 >=0) product = (input1*100) + (input2*10) + input3;
        	  //System.out.println("product ="+product);
        	  // System.out.println(input1+" "+input2+" "+input3+" input1 input2 input3");
        	         input1 = input2 = input3 = -1;	
        	           inputLeft = 510 ; 
        	            if (product ==answer ){problem.nextProblem = false;
        	
        	input1 = input2 = input3 = -1;	
        	gotCorrect = true;
        	ccount++;	
        		    }else{errors++;}
        	}
        	
        	 
        	 if(globalint == 37){
        	 	 if (input3 >= 0){input3 = -1; inputLeft = inputLeft -80;}
        	 	  if (input2 >= 0){input2 = -1; inputLeft = inputLeft -80;}
        	 	  if (input1 >= 0){input1 = -1; inputLeft = inputLeft -80;} 
        	 }
        	 if ((globalint >= 96)&&(globalint <= 105)){
        	 	theinput =  globalint - 96;
        	 	       //System.out.println(theinput+" the input");
        	 	     //  	System.out.println(in1+" "+in2+" "+in3+" in1 in2 in3");
        	 	       	if ((input3 < 0)&&(input2 >= 0)){ input3 = theinput;inputLeft = inputLeft + 80;   }
        	 	       	if ((input2 < 0)&&(input1 >= 0)) {input2 = theinput; inputLeft = inputLeft + 80;   }
        	 	       	if (input1 < 0) {input1 = theinput;inputLeft = inputLeft + 80;   }
        	 	
     
        	 }
        	 
        	  if ((globalint >= 48)&&(globalint <= 57)){
        	 	theinput =  globalint - 48;
        	 	       //System.out.println(theinput+" the input");
        	 	       //	System.out.println(in1+" "+in2+" "+in3+" in1 in2 in3");
        	 	       	if ((input3 < 0)&&(input2 >= 0)){ input3 = theinput;inputLeft = inputLeft + 80;   }
        	 	       	if ((input2 < 0)&&(input1 >= 0)) {input2 = theinput; inputLeft = inputLeft + 80;   }
        	 	       	if (input1 < 0) {input1 = theinput;inputLeft = inputLeft + 80;   }
        	 	
     
        	 }
  
        }
    }
      void draw(Graphics g) {  
         Font font = new Font("Dialog", Font.BOLD, 24);
         g.setFont(font);
                  
         g.setColor(new Color(0,0,0));
   
         in1 = 510; in2 = 510 + 80; in3 = 510 + 80 + 80;
         numbergrid.draw(g,in1,30,input1);
          numbergrid.draw(g,in2,30,input2);
           numbergrid.draw(g,in3,30,input3);
          char letter = '^';
		matrixled.draw(g,inputLeft ,175 ,letter);
     	  g.setColor(new Color(0,155,0));
          //  g.drawString("VALUE = "+globalchar, 102, 102);
         
         // if(gotCorrect){

          g.drawString("CORRECT = "+ccount+" ERRORS = "+errors, 20, 400);
             g.drawString("64 TOTAL PROBLEMS ", 20, 425);
          if(alldone){
          	   if(!gottime){ 
          	  totaltime = (int)((System.currentTimeMillis() - starttime)/1000);
          	   gottime = true;	 }
          	  //System.out.println("total time "+totaltime);
          	  //g.drawString("49 PROBLEMS COMPLETED. ", 20, 450);
          	
          	      // at which it was allocated, measured to the nearest millisecond.
        Date dateNow = new Date ();
 
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        	 SimpleDateFormat nowYYYYMMDD = new SimpleDateFormat("yyyyMMdd");
    

        StringBuilder nowDATE = new StringBuilder( nowYYYYMMDD.format( dateNow ) );
         StringBuilder nowTIME = new StringBuilder( sdf .format( dateNow ) );
 g.setColor(new Color(0,0,0));
        //System.out.println( nowDATE + " "+nowTIME);
        if (totaltime < 300){ g.drawString(totaltime+" SECONDS.", 20, 450); }
        else { g.drawString("GREATER THAN 600 SECONDS.", 20, 450); }
               g.setColor(new Color(0,155,0));    
        g.drawString( nowDATE + " "+nowTIME, 20, 500);  

          }
                  letter = '+';
      }
   } // end nested class Input
   
   
   /**
    * This nested class defines the problem.  Note that its constructor cannot
    * be called until the width of the panel is known!
    */
   private class Problem {
      int n,i,j, r,  pleft, ptop; // Current position of the center of the problem.
    //  boolean isMovingLeft; // Tells whether the sub is moving left or right
   //   boolean isExploding;  // Set to true when the sub is hit by the input.
    // int explosionFrameNumber;  // If the sub is exploding, this is the number
                                 //   of frames since the explosion started.
          int factor1[] = new int[100];
	  int factor2[] = new int[100];	
	  int plist[]= new int[100];
	    int clist[]= new int[100];
	  boolean nextProblem;
	
	int p, f1 = -1;
      	    int f2 = -1;
      	      		int f3 = -1;
      	      		int f4 = -1;	
	
      Problem() {  // Create the sub at a random location 40 pixels from bottom.
        pleft = 30;
        ptop = 30;
       	n = 0;
        for ( i = 2; i < 10; i++){
        	      for ( j = 2; j < 10; j++){
        	      	      factor1[n]=i;
        	      	      factor2[n]=j;
        	      	      plist[n]=-1;
        	      	      clist[n] = n;
        	      	   //   System.out.println(i+" "+j+" "+n);
        	      	        n++;
        	      }
        }
        
        //shuffle problems
        	java.util.Random generator = new java.util.Random(System.currentTimeMillis());
		
		boolean keep;
		int ival,sval, count = 0;
		//for (i = 0; i < n;i++)System.out.println (i+" plist ="+plist[i]);
		for (i = 0; i < n;i++){
			keep = false;
			while(!keep){
			//System.out.print (i+"="+plist[i]+" ");
				ival =  generator.nextInt(n);
				if(clist[ival] != -1){
					sval = clist[ival];
					plist[i] = sval;
					clist[ival] = -1;
					keep = true;
					
				}
				
			}
		}
      }
      void updateForNewFrame() { // next problems
        if (!nextProblem) {
          
		
		p = plist[next];
		 f2 = problem.factor1[p];
		 f4 =  problem.factor2[p];
		 answer = f2 * f4;
      	      nextProblem = true;
      	      next++;
      	  //    System.out.println(next+" next "+p);
      	  if (next > 64){alldone = true;   f2 = 0; f4 = 0;}
      		      //if (next > 64)alldone = true;      
      	      		
       //   }
    }
   
      }
      
      void draw(Graphics g) {  // Draw sub and, if it is exploding, the explosion.
           	      		int pajust = 80;
            	      		 //problem.plist[r] =1;
      	      		 	 numbergrid.draw(g,pleft,ptop,f1);
      	      		 	 numbergrid.draw(g,pleft + pajust,ptop,problem.f2);
      	      		 	 char letter = '*';
      	      		 	 matrixled.draw(g,pleft + 160 ,ptop ,letter);
      	      		 	 numbergrid.draw(g,pleft + 240,ptop,f3);
      	      		 	 numbergrid.draw(g,pleft + 320,ptop,f4);
      	      		 	 letter = '=';
      	      		 	 matrixled.draw(g,pleft + 400 ,ptop ,letter);
      	      	     
      }
   } // end nested class Problem   
   
   
} 
