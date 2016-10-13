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


class TrigTable {

	public static void main (String args[]){
		double s,c; //temp double for sine and cosine so they can be rounded
		int d; // theta (angle from 0 to 360 degrees)
		double r;// radian measure
		double pi = 3.1416;
		int i,j;
		double theta[] = new double[360];//angle value array
		double sin[] = new double[360]; //sine array that can hold 360 elements
		double cos[] = new double[360]; //cosine array that can hold 360 elements
		RoundVal v = new RoundVal(); //this class rounds a value;eg (v.round(d,10000);
		//*******************************
		// build array
		d = 0; //set angle equal to 0;
		i = 0;
		while (d <= 360){
			//convert angle t to radians r
			r =(d*(pi/180));
		//	r = v.round(r,1000000);
			theta[i] = r;
			s = Math.sin(r); c = Math.cos(r);
			sin[i] = v.round(s,1000);
			cos[i] = v.round(c,1000);
			d = d + 15;// increase the angle by 15
			i++;
		}
		
		System.out.println("RAD\tDEG\tSIN\tCOS");
		for (j = 0; j < i; j++){
				System.out.print(	theta[j]+"\t");
				d = (int)(theta[j] *(180/pi));
				System.out.print(	d+"\t");
				System.out.print(	sin[j]+"\t");
				System.out.print(	cos[j]+"\t");
				System.out.println();
		}
	}
}
