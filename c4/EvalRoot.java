class Pwr{  // this is a class (object)
double c;	double b;  int e; double val;
	
	Pwr (double coef, double base, int exp){
		int i;b = base;e = exp;
		double c = coef;
		val = 1;
		for (i = e; i > 0;i--){
			val = val * b;}
			val = c* val;}
		double value (){  
				return val;
	}
}//end Pwr



class CalcRoot{  //stub
	double b;   int r; int e;
	
		double calc (double bs,  int pwr, int rt){
		b = bs;			e = pwr; r = rt;  //reassign variables
		double val;
		
			val = b + e + r;		
			return val;// this returns a double to the calling method
		}
	}
	
class EvalRoot {
public static void main (String args[]){
	double n;
	
	CalcRoot v1 = new CalcRoot(); //create object called v1
	n = v1.calc(27,1,3); // 
	System.out.println("n = "+n);

	}
}

