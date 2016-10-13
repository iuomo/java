class Pwr{
double c;	double b;  int e; double val;
	
	Pwr (double coef, double base, int exp){
		int i;b = base;e = exp;
		double c;
		c = coef;
		val = 1;
		for (i = e; i > 0;i--){
			val = val * b;
		}
			System.out.println(c +" ** "+val); 
		System.out.print(base);
			System.out.print("^");
			System.out.print(exp);
			System.out.print("=");
			System.out.print(val); 
			System.out.println();
	}
			double value (){
				System.out.println(c +" "+val); 
		return val;
	}
	
}

class Term {
	double c; // coefficient
	double x; // varaible x
	int		e;  // exponent;
}

class BuildPolynomial {
public static void main (String args[]){
	double termvalue;
	Term t1 = new Term();
	t1.c = 4.5;
	t1.x = 2.0;
	t1.e = 2;
	Pwr  p1 = new Pwr(t1.c,t1.x,t1.e);
	termvalue = p1.value();
	System.out.println("termvalue = "+termvalue);
	}
}
