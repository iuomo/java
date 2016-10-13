import java.awt.*;
import java.applet.*;
import java.lang.*;
/*
<applet code="NewtonParms" width=800 height=700>
<param name=red value=200> 
<param name=green value=200> 
<param name=blue value=0> 
<param name=redA value=-10> 
<param name=greenA value=-35> 
<param name=blueA value=2> 
<param name=limit value=20> 

</applet>
*/

public class NewtonParms extends Applet implements Runnable {
// applet variables
int ired, igreen, iblue,redAjust, greenAjust, blueAjust,modvalue, limit;
  Thread t = null;
  int state;
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
	INewtonMethod (double a, double bi, int root, int limit){
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
	  ///////////////////////////////////////////////////////////////
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
	      try { if(temp != null) redAjust = Integer.parseInt(temp); 
      else  redAjust = 0; } catch(NumberFormatException exc) {  redAjust = -1;  } 
	  
	   temp = getParameter("greenA"); 
    try { if(temp != null) greenAjust = Integer.parseInt(temp); 
      else  greenAjust = 0; } catch(NumberFormatException exc) {  greenAjust = -1;  } 
	  
	   temp = getParameter("blueA"); 
    try { if(temp != null) blueAjust = Integer.parseInt(temp); 
      else  blueAjust = 0; } catch(NumberFormatException exc) {  blueAjust = -1;  } 
	  
	   temp = getParameter("limit"); 
    try { if(temp != null) limit = Integer.parseInt(temp); 
      else  limit = 0; } catch(NumberFormatException exc) {  limit = -1;  } 
	   
      temp = getParameter("modvalue"); 
    try { if(temp != null) limit = Integer.parseInt(temp); 
      else  limit = 0; } catch(NumberFormatException exc) {  limit = -1;  } 
	
	  
	  
	  
	  ///////////////////////////////////////////////////////////////
	  
   t = new Thread(this);
    stopFlag = false;
    t.start();
  }

  // Entry point for the thread that runs the banner.
  public void run() {
   // char ch;


  //try {
	     // red++;
	     // green++;
		//blue++;
       //repaint();
       // Thread.sleep(10000);

       // if(stopFlag)break;
    //  } catch(InterruptedException e) {}
   
  }

  // Pause the banner.
  public void stop() {
    stopFlag = true;
    t = null;
  }

// color array  
class ColorArray{
		int rgb[][] = new int[3][100]; 
		int[][] color(){
		int c,v;
		int radj;
		int gadj;
		int badj;
		
		radj = 7;
		gadj = 7;
		badj = 7;
			for (v = 0; v < 100; v ++){
				red = red + radj;
				green = green + gadj;
				blue = blue + badj;
				if (red > 255) red = 0; if (red < 0) red = 255;
				if (green > 255) green = 0; if (green < 0)green = 255;
				if (blue > 255) blue = 0; if (blue < 0) blue= 255;
				rgb[0][v] = red;
				rgb[1][v] = green;
				rgb[2][v] = blue;
			}
				return rgb;
		}
	
	}
	// Display the banner.

public void paint(Graphics g) {
	int rgb[][] = new int[3][100]; 
	// this algorithm written by Craig Coleman
	int h,k,c,red,green,blue;
	double x,y;
	red = 100; green = 100; blue = 100;
	int mc;
	g.setColor(new Color(red,green,blue));
	g.drawRect(10,10,570,570);
	ColorArray ca = new ColorArray();
	rgb = ca.color();
	int scale = 250;
			c = 0;
			int max = 0;
	for (h = -250; h <= 250; h ++ ){
		for (k = -250; k <= 250; k++){
			x =(double)h/scale;
			y =(double)k/scale;
			int locallimit = 100000000;
			INewtonMethod n = new INewtonMethod(x,y,4,locallimit);
			c = n.value();
			//System.out.println(c);
			//c++;
			int modvalue = 100;// default int modvalue = 30;
			mc = c % modvalue;
			if (mc > max) max = mc;
				//System.out.println(mc);
				red = rgb[0][mc];
				green= rgb[1][mc];
				blue = rgb[2][mc];
				g.setColor(new Color(red,green,blue));
				g.drawLine(h+290,280-k,h+290,280-k);
						 
				
}//end for h
}//end for k
		
g.setColor(new Color(0,0,0));
g.drawString("Newton's method of approximating the imaginary roots to x^4 -1", 50,560);
stopFlag = true;
	
	 
	 
  
}
}

