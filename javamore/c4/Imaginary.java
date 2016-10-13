class Iproduct{
	double return_a, return_b;
	Iproduct (double a, double bi,int exp){
	//	System.out.println(a+" + "+bi+" i ^" + exp);
		double a2,bi2,atmp,btmp;
		int i;
		if (exp == 1){
			return_a = a; return_b = bi;
		}else{
			a2 = ((a*a) - (bi*bi));
			bi2 = (2*a*bi);
			//System.out.println(a2+" + "+bi2+" i ^ 2");
			atmp = a2; btmp = bi2;
			for (i = 1; i < (exp-1); i++){
				// System.out.println(a2+" + "+bi2+" i loop before");
				atmp =  ((a2*a) - (bi2*bi));
				bi2 = ((a*bi2) + (a2*bi));
				a2 = atmp;		
			//	System.out.println(a2+" + "+bi2+" i loop after");
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

class Imaginary{
public static void main (String args[]){
double x, y;
for (x = -2.0; x <= 2.0; x = x + .01){
	for (y = -2.0; y <= 2.0; y = y + .01){
	Iproduct ip = new Iproduct(x,y,5);
 System.out.println(x+" + "+ y +" -> "+ip.avalue()+" + "+ip.bvalue()+" i");
}//end for y
}//end for x
}
}
