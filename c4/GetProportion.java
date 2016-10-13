class Proportion {
	double d;
	
	double value (double a, double b, double c){
				d = (b*c)/a;
				return d;
	}

	
}

class GetProportion{
	public static void main (String args[]){
		double n;
		Proportion  p = new Proportion();
		n = p.value(1,2,3);
		System.out.println(n);
}
}
