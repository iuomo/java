import java.util.*;
class BubbleSort{
	
}

class TimeSort{

	public static void main (String args[]){
		double now,after,time;
		
		int i;
		int max = 1000000;
		double dArray[] = new double[max];
		// build the array
			
		for ( i = 0; i < max; i++){ 
			dArray[i] = Math.random();
	
		
		}
		System.out.println("STAR SORTING");
		now = System.currentTimeMillis();  		
				Arrays.sort(dArray);
				
		after = System.currentTimeMillis();    
		time = (after - now)/1000;
		System.out.println(time);
	}//end main
}//end class
