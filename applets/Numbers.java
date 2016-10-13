import java.awt.*;
import java.applet.*;
    import java.util.Random;
/*
<applet code="Numbers" width=800 height=600>
</applet>
*/

public class Numbers extends Applet implements Runnable {
	int ones, tens, hundreds, thousands ;
	

	
private NumberGrid numbergrid;

private LED led;

private matrixLED matrixled;//   public void paintComponent(Graphics g) {
      
 //     super.paintComponent(g);  // Fill panel with background color, green.
      
 //     if (numbergrid == null) {
            // The first time that paintComponent is called, it assigns
            // values to the instance variables.
        
    //     numbergrid = new NumberGrid();
         
   //   }
      
  
 //     numbergrid.draw(g);
    
//   } // end drawFrame()
 
 
  String msg = " A Simple Moving Banner.";
  int x,y;
  Thread t = null;
  int state;
  boolean stopFlag;

  // Set colors and initialize thread.
  public void init() {
    setBackground(Color.white);
    setForeground(Color.red);
     numbergrid = new NumberGrid();
     led = new LED();
     matrixled = new matrixLED();
     ones = tens = hundreds = thousands = 0;
       
  }

  // Start thread
  public void start() {
    t = new Thread(this);
    stopFlag = false;
    t.start();
  }

  // Entry point for the thread that runs the banner.
  public void run() {
    char ch;

    // Display banner 
    for( ; ; ) {
      try {
	     
	   //   x = (int) (Math.random()*500);
	//      y = (int)(Math.random()*500);
        repaint();
        Thread.sleep(100);
        ch = msg.charAt(0);
        msg = msg.substring(1, msg.length());
        msg += ch;
        if(stopFlag)
          break;
      } catch(InterruptedException e) {}
    }
  }

  // Pause the banner.
  public void stop() {
    stopFlag = true;
    t = null;
  }
 private class matrixLED{
   
      matrixLED() { // Constructor centers the boat horizontally, 80 pixels from top.
         //centerX = width/2;
         //centerY = 80;
         
       
         
         
      }
 
      void draw(Graphics g, int left, int top, char cnumber) {  // Draws the boat at its current location.
      	      left = left - 5;
           int star1[][]={{1,2,3,4,5,},
         	 	 {6,7,8,9,10},
         	 	 {11,12,13,14,15},
			 {16,17,18,19,20,},
			 {21,22,23,24,25,},
			 {26,27,28,29,30,},
			 {31,32,33,34,35,},
			};
			
			int star[][]={ {0,0,0,0,0,},
					{0,0,1,0,0},
					{1,0,1,0,1},
					{0,1,1,1,0,},
					{1,0,1,0,1,},
					{0,0,1,0,0,},
					{0,0,0,0,0,},
					};
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
         	 		 if (star[row][col] == 0) g.setColor(new Color(245,245,245));
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

	
	  //  vertical //////////////////////////////////////////////////
	
      }
   } // end nested class matrixLED
  
  private class LED{
   
      LED() { // Constructor centers the boat horizontally, 80 pixels from top.
         //centerX = width/2;
         //centerY = 80;
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
         	 	 rd = gn = be = 245;
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
	 	  	 rd = gn = be = 245;
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
      void draw(Graphics g, int left, int top, int number) {  // Draws the boat at its current location.
      	
      	  
    
          
     //g.fillRect(0, 0, 800, 600);
     int width = 40;
          	led.draw(g,left,top,width,0,1); //bar 1
       		led.draw(g,left,top+60,width,0,1); //bar 2
       	       	led.draw(g,left,top +130,width,0,1); //bar 3
    	 	led.draw(g,left - 18 ,top + 18,width,1,1); //bar 4
	      	led.draw(g,left - 18,top + 96,width,1,1); // bar 5
        	led.draw(g,left + 42,top + 18,width,1,1); //bar 6
         	led.draw(g,left + 42,top + 96,width,1,1); // bar 7
         
      
      
      
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
  
  
  
  public void paint(Graphics g) {
    int r1,r2, r3, r4, c,k,i, j,rd,oe,be, left, top;
	double it;
	java.util.Random generator = new java.util.Random(System.currentTimeMillis());
	
	left = 100;
	top = 10;
	boolean done = false;
	
	

	//for (i = 0;i <20;i++){
	//g.setColor(new Color(255,0,255));
	//g.drawLine(left + c, top+i ,left -c + 100,top+i);
	//	c++;
	//}
	
		//g.fillRect(70, 0, 800, 600);
		 r1 = generator.nextInt(10);
		 r2 = generator.nextInt(10);
		 	r3 = generator.nextInt(10);
		 			r4 = generator.nextInt(10);
		 			//r1 =r2 =r3 =r4 = 7;
		 				if ((r1 == r2)&&(r2 == r3)&&(r3 == r4)){
		 			g.setColor(Color.YELLOW);	
		 			ones = ones + 1;
		 			if (ones > 9){ones = 0; tens = tens + 1;}
		 			if (tens > 9){tens = 0;hundreds = hundreds + 1;}
		 			if (hundreds > 9){hundreds = 0;thousands = thousands + 1;}
		 		
		 	}else {g.setColor(Color.BLACK);}
		numbergrid.draw(g,20,10,r1);
		
		numbergrid.draw(g,100,10,r2);
	char letter = '*';
		matrixled.draw(g,180,10,letter);
		numbergrid.draw(g,260,10,r3);

		numbergrid.draw(g,340,10,r4);
		numbergrid.draw(g,420,10,r4);
		numbergrid.draw(g,500,10,r4);
		numbergrid.draw(g,580,10,r4);
			numbergrid.draw(g,660,10,r4);
		//numbergrid.draw(g,100,300,thousands);
		numbergrid.draw(g,240,300,hundreds);
		numbergrid.draw(g,380,300,tens);
		numbergrid.draw(g,520,300,ones);
		
	  
   	/////////////////////////


  }
}
