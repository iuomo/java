import java.awt.*;
import java.applet.*;
import java.lang.*;


/* 
<applet code="Newton" width=1000 height=900>
<param name=red value=113>
<param name=green value=176>
<param name=blue value=159>

<param name=redA value=255>
<param name=greenA value=127>
<param name=blueA value=0>

<param name=limit value=1>
<param name=scale value=1>
</applet>
*/


public class Newton extends Applet implements Runnable {
// applet variables
  Thread t = null;
  int state;
  int ired, igreen, iblue,iradj,igadj,ibadj,ilimit,iscale;
  boolean stopFlag;

	// newtons method variables
	int red ,green,blue;
	
class DivideImaginary {
	double den,rnum, inum;
	DivideImaginary(double na,double nbi,double da, double dbi){
			den = ((da*da)+(dbi*dbi));	
			rnum = ((na*da) + (nbi*dbi))/den;                                                
			inum = ((na*(-1*dbi))+(nbi*da))/den;
		
				}		
			double a(){
				return  rnum;
			}
				double b(){
				return  inum;
			}
}

class INewtonMethod {
	int r; //double n; 
	double val = 0;
	int count = 0;
	// radial y radican x
	INewtonMethod (double a, double bi, int root, long limit){
		double x0 = a;
		double yi0 = bi;
		int n = root;
		double x1,yi1,na,nbi, da, dbi;
		int i;
		long x0long, y0ilong,x1long, y1ilong, longlimit = limit;
		boolean done = false;
		
		while (!done){
		
			Iproduct ipn = new Iproduct(x0,yi0,n);
			na = ipn.avalue() - 1; nbi = ipn.bvalue(); 
			Iproduct ipd = new Iproduct(x0,yi0,n-1);
			da = n* ipd.avalue(); dbi = n* ipd.bvalue(); 
			DivideImaginary di = new DivideImaginary(na,nbi,da,dbi);
			x1 = x0 - di.a(); 
			yi1 = yi0 - di.b();
			x0long = (long) (x0 * longlimit);		
			x1long= (long) (x1 * longlimit);
			y0ilong = (long) (yi0 * longlimit);		
			y1ilong= (long)( yi1 * longlimit);
			count++;
						 // 
			if (((x0long == x1long) & (y0ilong == y1ilong))|| (count > 255))done = true;
			x0 = x1; yi0 = yi1;
									 
		}
	}
	int value (){  
		return count;
	}
}

class Iproduct{
	double return_a, return_b;
	Iproduct (double a, double bi,int exp){
		double a2,bi2,atmp,btmp;
		int i;
		if (exp == 1){
			return_a = a; return_b = bi;
		}else{
			a2 = ((a*a) - (bi*bi));
			bi2 = (2*a*bi);
			atmp = a2; btmp = bi2;
			for (i = 1; i < (exp-1); i++){
				atmp =  ((a2*a) - (bi2*bi));
				bi2 = ((a*bi2) + (a2*bi));
				a2 = atmp;		
			
			}
		
			return_a = a2; return_b = bi2;
			}
		}
		double avalue(){
		  return return_a;
		}
		double bvalue(){
		return return_b;
		}
}
	
	
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
        Thread.sleep(1000);

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
	 int h,k,c,red,green,blue;
	 double x,y;
	 red = 0; green = 0; blue = 0;
	 int mc;
	//g.setColor(new Color(red,green,blue));
	//		g.drawRect(10,10,570,570);
	ColorArray ca = new ColorArray();
	rgb = ca.color();
	int scale = iscale;
			c = 0;
			int max = 0;
	for (h = -400; h <= 400; h ++ ){
	for (k = -400; k <= 400; k++){
	x =(double)h/scale;
	y =(double)k/scale;

	INewtonMethod n = new INewtonMethod(x,y,4,1000000L);
	c = n.value();
	//System.out.println(max);
	//c++;
			mc = c % 256;
			if (mc > max) max = mc;
//System.out.println(mc);
				red = rgb[0][mc];
				green= rgb[1][mc];
				blue = rgb[2][mc];
				g.setColor(new Color(red,green,blue));
				g.drawLine(h+400,400-k,h+400,400-k);
						 
				
}//end for h
}//end for k
	
for (int b = 0; b < 256; b++){
				red = rgb[0][b];
				green= rgb[1][b];
				blue = rgb[2][b];
				g.setColor(new Color(red,green,blue));
				g.drawLine(810,b+100,860,b+100);
}
g.setColor(new Color(0,0,0));
g.drawString("Newton's method of approximating the imaginary roots to x^4 -1", 50,820);
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

