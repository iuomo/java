class RoundVal {
	//  call from class 	s = v.round(s,1000);
	double val;
	double round (double v, double places){
		int temp = 0;
		if (v > 0)temp = (int)((v + 0.0005) * places);
		if (v < 0)temp = (int)((v - 0.0005) * places);
		val = (temp/places);
		return val;
	}
}

class Trig {
	double degv, radv, cosv,sinv,tanv;
	Trig (int deg){
		radv = deg * (3.1416 / 180);
		
		cosv = Math.cos(radv);
		sinv = Math.sin(radv);
		tanv = Math.tan(radv);
		//System.out.println(deg+ " | "+ radv+ " | "+sinv);
	}
	
	double getCos (){
		return	cosv;
	}
	
	double getSin (){
		return	sinv;
	}
	
	double getTan(){
		return	tanv;
	}
}


class TrigTableObj {
	public static void main (String args[]){
			//Trig tv = new Trig(180); 
			//*******************************
		// build array
		String ts = "";
		RoundVal v = new RoundVal(); 
		double vcos,vtan,vsin,s,c,t;
		int degrees = 0; //set angle equal to 0;
		int incrementdegrees = 15;
		int radians = 0;
		System.out.println("\tdegrees\t\tsin\t\tcos\t\ttan");
			
		while (degrees <= (360)){
			Trig tv = new Trig(degrees); 
			//convert angle t to radians r
			vcos = tv.getCos();
			vsin = tv.getSin();
			vtan = tv.getTan();
				s = v.round(vsin,1000);
				c = v.round(vcos,1000);
				
				if (c != 0) {
					t  = v.round(vtan,1000);
					ts = ""+t;
				}else {ts = "UN";}
			System.out.println("\t"+degrees+ "\t\t"+s+ "\t\t"+c+ "\t\t"+ts);
			degrees = degrees + incrementdegrees;// increase the angle by 15
		}
		
		
		}
	}

