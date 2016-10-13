class Value {
	double val;
	
	double round (double v, double places){
		int temp = 0;
		if (v > 0)temp = (int)((v + 0.0005) * places);
		if (v < 0)temp = (int)((v - 0.0005) * places);
		val = (temp/places);
	return val;
}


}


class Wth {

	public static void main (String args[]){
		double t,r;
			Value v = new Value(); //this class rounds a value;eg (v.round(d,10000);
			
			for (int i = 0; i < 1000; i++){
				 t = Math.random();
				 r = v.round(t,1000);
				 System.out.println(t+ " "+r);
		}
	}
}
