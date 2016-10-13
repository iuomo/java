import java.util.*;
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

class CheckDups {
		boolean checkArray (double check[]){
			int i,j;
			boolean isDup = false;
			double checkValue;
					//Arrays.sort(check);
					for (i = 0;i < check.length; i++){
						// get check[i] and compare to all other array elements
						for (j = i+1; j < check.length; j++){
							if (check[i] == check[j]) {
								isDup = true;
								System.out.println("dup = "+check[i]);
							}
						}
					}
			if (isDup)	return true;
			else	return false;
	}
}

class UniqueRandoms {
	public static void main(String args[]){
		int max = 52;
			Value v = new Value();
			double rv[] = new double[max];
			int i;
			double n;
			boolean areDups;
			//build an array of random numbers
			for (i = 0; i < max;i++){
				n = Math.random();
				rv[i] = v.round(n,1000); 
			}
			Arrays.sort(rv);
			CheckDups check = new CheckDups(); 
			areDups = check.checkArray(rv);
			
			for (i = 0; i < max;i++){
				System.out.print(rv[i] +" ");
				if (i%4 == 0)System.out.println();
			}
		
				System.out.println();
			System.out.print("DUPS = ");
			System.out.println(areDups);
	}
}
