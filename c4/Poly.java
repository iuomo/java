class CalcTerm{
	double c;	double b;  int e; double val;
	// the following method calculates a power then multiplies by the coefficient
	double term (double coef, double base, int exp){
		int i;
		b = base;			e = exp; c = coef;
		val = 1;
		for (i = e; i > 0;i--){
			val = val * b;
		}
			val = c* val;
			return val;// this returns a double to the calling method
		}
	}
	


class Poly {
public static void main (String args[]){
	double x,y,termvalue1,termvalue2, termvalue3;
	int i;
	
	CalcTerm t1 = new CalcTerm(); //create object called t1
	CalcTerm t2 = new CalcTerm(); 
	CalcTerm t3 = new CalcTerm(); 
	x = -10.0;
	// f(x) = 1x^2 + 2x^1 + 1x^0
	for (i = 0;i < 11 ; i ++){
		termvalue1 = t1.term(1,x,2); // send ti 3 values c,x,e
		termvalue2 = t2.term(2,x,1); // send ti 3 values c,x,e
		termvalue3 = t3.term(1,x,0); // send ti 3 values c,x,e
		y = termvalue1 + termvalue2 + termvalue3;
		System.out.println("x = "+x+"y = "+y); //print the value;
		x = x + 2;
	}
	}
}
