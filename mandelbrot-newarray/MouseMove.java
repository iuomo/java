import java.awt.*;
import java.applet.*;
import java.lang.*;
/*
<applet code="MouseMove" width=1000 height=900>
<param name=red value=0> 
<param name=green value=0> 
<param name=blue value=0> 

<param name=redA value=255> 
<param name=greenA value=255> 
<param name=blueA value=255> 

<param name=limit value=2> 
<param name=scale value=200> 
</applet>
*/

public class MouseMove extends Applet implements Runnable {
// applet variables
  Thread t = null;
  int state;
  int ired, igreen, iblue,iradj,igadj,ibadj,ilimit,iscale;
  boolean stopFlag;

	// newtons method variables
	int red ,green,blue;
	

  // Set colors and initialize thread.
  public void init() {
    setBackground(Color.white);
   setForeground(Color.white);
  }

  // Start thread
  public void start() {
   t = new Thread(this);
    stopFlag = false;
    t.start();
    
    String temp; 

    temp = getParameter("red"); 
    try { if(temp != null) ired = Integer.parseInt(temp); 
      else  ired = 0; } catch(NumberFormatException exc) {  ired = -1;  } 
	  
	   temp = getParameter("green"); 
    try { if(temp != null) igreen = Integer.parseInt(temp); 
      else  igreen = 0; } catch(NumberFormatException exc) {  igreen = -1;  } 
	  
	   temp = getParameter("blue"); 
    try { if(temp != null) iblue = Integer.parseInt(temp);
      else  iblue = 0; } catch(NumberFormatException exc) {  iblue = -1;  }
	  
	  temp = getParameter("redA"); 
	      try { if(temp != null) iradj = Integer.parseInt(temp); 
      else  iradj = 0; } catch(NumberFormatException exc) {  iradj = -1;  } 
	  
	   temp = getParameter("greenA"); 
    try { if(temp != null) igadj = Integer.parseInt(temp); 
      else  igadj = 0; } catch(NumberFormatException exc) {  igadj = -1;  } 
	  
	   temp = getParameter("blueA"); 
    try { if(temp != null) ibadj = Integer.parseInt(temp); 
      else  ibadj = 0; } catch(NumberFormatException exc) {  ibadj = -1;  } 
	  
	   temp = getParameter("limit"); 
    try { if(temp != null) ilimit = Integer.parseInt(temp); 
      else  ilimit = 0; } catch(NumberFormatException exc) {  ilimit = -1;  } 
      
      temp = getParameter("scale"); 
    try { if(temp != null) iscale = Integer.parseInt(temp); 
      else  iscale = 0; } catch(NumberFormatException exc) {  iscale = -1;  } 
	
	   
    
    
    
  }

  // Entry point for the thread that runs the banner.
  public void run() {
    char ch;

    for( ; ; ) {
      try {
	     // red++;
	     // green++;
		//blue++;
        repaint();
        Thread.sleep(10000);

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
	class ColorArray{
		int rgb[][] = new int[3][256]; 
		int[][] color(){
		int i;
		int colors = ilimit;
		// -- build array
		double startR,endR, startG,endG, startB, endB;
		double redD, greenD, blueD;
		startR = (double) ired;	endR = (double) iradj;  
		startG = (double)igreen; endG = (double)igadj ;
		startB = (double)iblue ; endB = (double)ibadj;
		redD = (endR - startR)/ colors;
		greenD = (endG - startG)/colors;
		blueD = (endB - startB)/colors;
		 System.out.println(ired+" \t"+igreen+"\t"+iblue);
		  System.out.println(iradj+" \t"+igadj+"\t"+ibadj);
		 System.out.println(redD+" \t"+greenD+"\t"+blueD);
		 
		for (i = 0; i < 256;i++){
			rgb[0][i] = (int)startR;
			rgb[1][i] = (int)startG;
			rgb[2][i] = (int)startB;
			
		
			startR = startR + redD;
			startG = startG +greenD;
			startB = startB +blueD;
			// System.out.println(startR+" \t"+startG+"\t"+startB);
			
		if (startR > 255) startR = 0;if (startR < 0) startR = 255;
		if (startG > 255) startG = 0;if (startG < 0) startG = 255;
		if (startB > 255) startB = 0;if (startB < 0) startB =  255;
	}
		
		
		/////////////////////////
		
				return rgb;
		}
	
	}//end color

  public void paint(Graphics g) {
		int rgb[][] = new int[3][256]; 
   // this algorithm written by Craig Coleman
	
   int rval = 0;	

	 double c,c1,c2,x,y,x1,x2,y1,z; 
	 double id, jd; 
		int Iterations = 1000;
   
   //
	 int limit,i,j,h,k,red,green,blue;
	 limit = ilimit;
	
	 red = 0; green = 0; blue = 0;
	 int mc;
	//g.setColor(new Color(red,green,blue));
	//		g.drawRect(10,10,570,570);
	ColorArray ca = new ColorArray();
	rgb = ca.color();
	int scale = iscale;
			c = 0;
			int max = 0;


for (int b = 0; b < 256; b++){
				red = rgb[0][b];
				green= rgb[1][b];
				blue = rgb[2][b];
				g.setColor(new Color(red,green,blue));
				g.drawLine(810,b+100,860,b+100);
}
///////////////////////////////////////////////////////

		for (j = 0 ; j < 800 ; j++) {
			jd = (double) j;
			y1 = (400 - jd) / scale;
				for (i = 0; i < 800; i++){
					id = (double) i;
					x1 = (id - 400) / scale;			
					c1 = x1;
					c2 = y1;
					x = 0;y= 0;
					z = 0.0;
					k = 0;
					do {
						x2 = (x * x) - (y * y) + c1;
						y = (2 * x * y) + c2;
						x = x2;
						z = (x * x) + (y * y);
						k++;							
					}while ((k < Iterations) & (z < 4.0));
						//if (k > limit) {
						if (k > 255) k = 255;
						red = rgb[0][k];
							green= rgb[1][k];
								blue = rgb[2][k];
				g.setColor(new Color(red,green,blue));
							
					g.drawLine(i+10,j+10,i+10,j+10);
						//}
	    	}//end for i
        }//end for j

///////////////////////////////////////////////////////
stopFlag = true;
	
	 
	 
  
}// end paint


   public void setRED(String temp) {
		ired = Integer.parseInt(temp); 
	//repaint();
   }              
  
    public void setGREEN(String temp) {
	igreen = Integer.parseInt(temp); 
	//repaint();
    }
  
   public void setBLUE(String temp) {
	iblue = Integer.parseInt(temp); 
	//repaint(); 
   }            
	
	
 public void setRADJ(String temp) {
	iradj = Integer.parseInt(temp);   
	//repaint(); 
 }              
  
    public void setGADJ(String temp) {
	igadj = Integer.parseInt(temp); 
	//repaint();
    }
  
   public void setBADJ(String temp) {
	ibadj = Integer.parseInt(temp); 
	//repaint(); 
   }              

 public void setLIMIT(String temp) {
	ilimit = Integer.parseInt(temp); 
	//repaint(); 
 }   

 public void setSCALE(String temp) {
	iscale = Integer.parseInt(temp); 
	//repaint(); 
 }   


}

