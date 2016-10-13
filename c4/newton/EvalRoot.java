class Rad {
	int r; double n; double val;
	// radial y radican x
	Rad (int y, double x){
		double x0 = x / 2;
		double x1,num, den;
		int i;
		r = y; n = x;
System.out.println(" r "+r+" n "+n);//trace
		for (i = 0; i < 1000; i++){
				System.out.print("x0 "+x0);//trace
				Pwr temp0 = new Pwr(x0,r); num = temp0.value() - n;
				Pwr temp1 = new Pwr(x0,r-1); den = r*temp1.value();
				x1 = x0 - (num/den); 
				if (x1 == x0) break;
				x0 = x1;
				System.out.println(" x1 "+x1);//trace
			val = x1;
		}
	}
		double value (){  
				return val;
		}
}
class Pwr{  // this is a class (object)
double b;  int e; double val;
	
	Pwr (double base, int exp){
		int i;b = base;e = exp;
			val = 1;
		for (i = e; i > 0;i--){
			val = val * b;}
			}
		double value (){  
				return val;
	}
}//end Pwr



class CalcRoot{  
	double b;   int r; int e; 
	
		double calc (double bs,  int pwr, int rt){
			b = bs;			e = pwr; r = rt;  //reassign variables
			double val,n;
			Pwr v1 = new Pwr(b,e);
			n = v1.value();
			Rad v2 = new Rad(r,n); //create object called v1
			val = v2.value();
				System.out.println(" val "+val);//trace
			return val;// this returns a double to the calling method
	}
		}
			
	
class EvalRoot {
public static void main (String args[]){
	double n;
	CalcRoot v1 = new CalcRoot(); //create object called v1
	n = v1.calc(256,17,3); // calculate n ^(x/y)
	System.out.println("\n\nn = "+n);

	}
}

