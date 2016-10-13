class Pwr{  // this is a class (object)
double c;	double b;  int e; double val;
	
	Pwr (double coef, double base, int exp){
		int i;b = base;e = exp;
		double c;
		c = coef;
		val = 1;
		for (i = e; i > 0;i--){
			val = val * b;
		}
			val = c* val;
	
	}
		double value (){  
				return val;
	}
}//end Pwr

class Term {
	double c; // coefficient
	double x; // varaible x
	int		e;  // exponent;
}

class BuildPoly {
public static void main (String args[]){
	double termvalue;
		double temp;
	Term t1 = new Term();
	t1.c = 4.0;		t1.x = 2.0;	t1.e = 2;
	Pwr  p1 = new Pwr(t1.c,t1.x,t1.e);
	termvalue = p1.value();
	System.out.println("termvalue p1 = "+termvalue);
	
	//termvalue = 0;
	Pwr  p2 = new Pwr(5,3,4);
	termvalue = p2.value();
	System.out.println("termvalue p2 = "+termvalue);
	
	
	}
}
