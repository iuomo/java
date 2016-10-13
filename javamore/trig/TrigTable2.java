class RoundVal {
	double val;
	double round (double v, double places){
		int temp = 0;
		if (v > 0)temp = (int)((v + 0.0005) * places);
		if (v < 0)temp = (int)((v - 0.0005) * places);
		val = (temp/places);
		return val;
	}
}



class TrigTable2 {

	public static void main (String args[]){
		double s,c; //temp double for sine and cosine so they can be rounded
		int d; // theta (angle from 0 to 360 degrees)
		double r;// radian measure
		double pi = 3.1416;
		int i,j;
		
		RoundVal v = new RoundVal(); 
			//*******************************
		// build array
		d = 0; //set angle equal to 0;
		i = 0;
		System.out.println("theta | sin(theta" );
		while (d <= 360){
			//convert angle t to radians r
			r =(d*(pi/180));
			s = Math.sin(r); 
			s = v.round(s,1000);
			System.out.println(d+ " | "+ s);
			d = d + 45;// increase the angle by 15
		}
		
		
		}
	}

