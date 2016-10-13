class CalcRoot{
	double b;  int e; int r;
	// the following method calculates a power then multiplies by the coefficient
	double calc (int rt, int pwr, double bs){
		b = bs;			e = pwr; r = rt;
		int val = 1;
		for (i = e; i > 0;i--){
			val = val * b;
		}
			val = c* val;
			return val;// this returns a double to the calling method
		}
	}
	
class PolyMeth {
public static void main (String args[]){
	double termvalue;
	double term1, term2, term3;
	CalcTerm t1 = new CalcTerm(); //create object called t1
	term1 = t1.term(1,-5,2); // send ti 3 values c,x,e
		term2 = t1.term(2,-5,1); // send ti 3 values c,x,e
			term3 = t1.term(1,-5,0); // send ti 3 values c,x,e
	System.out.println("termvalue = "+termvalue); //print the value;
	}
}
