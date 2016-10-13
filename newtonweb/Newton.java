import java.awt.*;
import java.applet.*;
import java.lang.*;


/* 
<applet code="Newton.class" width=1000 height=900>
<param name=red value=0>
<param name=green value=100>
<param name=blue value=0>

<param name=redA value=255>
<param name=greenA value=127>
<param name=blueA value=0>

<param name=limit value=25>
<param name=scale value=1>
</applet>
*/


public class Newton extends Applet  {
// applet variables
 
  int ired, igreen, iblue,iradj,igadj,ibadj,ilimit,iscale;

	// newtons method variables
	int red ,green,blue;
	
	public void start() {
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
		 //System.out.println(ired+" \t"+igreen+"\t"+iblue);
		//  System.out.println(iradj+" \t"+igadj+"\t"+ibadj);
		 //System.out.println(redD+" \t"+greenD+"\t"+blueD);
		 
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
		
	return rgb;
		}
	
	}//end color

  


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

