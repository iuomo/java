import java.util.*;
class RandomArray {

	public static void main (String args[]){
		double dval;
		int i;
		int max = 100000;
		double randomNumber[] = new double[max];
		// build the array
		for ( i = 0; i < max; i++){ 
			randomNumber[i] = Math.random();
		}
			
		for ( i = 0; i < randomNumber.length; i++){ 
			System.out.print(randomNumber[i]+" ");
			if (i % 3 == 0) System.out.println();
		}
		   Arrays.sort(randomNumber);  
	// this sorts the array     
		System.out.println("\narray sorted\n");
		for ( i = 0; i < max; i++){ 
			System.out.print(randomNumber[i]+" ");
			if (i % 3 == 0) System.out.println();
		}
		
		
	}//end main
}//end class
