// newtons method by cwc
// x_(n+1) = xn - f(x)}/{f'(x)}

class CalcTerm{
	double c; double b;  int e; double val;
	// the following method calculates a power then multiplies by the coefficient
	double term (double coef, double base, int exp){
		int i;
		b = base; e = exp; c = coef;
		val = 1;
		for (i = e; i > 0;i--){
			val = val * b;
		}
			val = c* val;
			return val;// this returns a double to the calling method
		}
	}

class NewtonMethod {
public static void main (String args[]){
	double startv;	startv = Double.parseDouble( args[0] );
	double number;	number = Double.parseDouble( args[1] );
	int radical;	radical = (int)Double.parseDouble( args[2] );

	double n,newn ,v,vprime;	
	boolean done = false;
	
	CalcTerm f = new CalcTerm(); 
	
	CalcTerm fprime = new CalcTerm(); 
	System.out.println(startv + " <- startx number-> "+number); 
	System.out.println("Newtons Method"); 
	n = startv; int count = 0;
	while (!done){
		
		v = f.term(1,n,radical) - number; // send ti 3 values c,x,e
		vprime = fprime.term(radical,n,radical -1 ); // send ti 3 values c,x,e
		newn = n - (v / vprime);
 		if (n == newn)done = true;
		if (count > 15) done = true;
		count ++;
		n = newn;
		System.out.println(n); //print the value;
		
	}
}
}