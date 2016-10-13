import java.util.*;
class RandomSort {
	public static void main (String args[]){
	int max = 100000;//1000000 is one million
	int random[] = new int[max];
	int copy_random[] = new int[max];

	int i, ival;
	long now, after;
	double dnow, dafter,quickTime,bubbleTime;//these are used to keep time
	
	double val=0;
	//create random[]
		System.out.println("\n\nThis is the array unsorted.\n");	
		
		for( i = 0; i < max;i++){
		 	val = Math.random()*52;
		
			ival = (int) val;
			//	System.out.print( ival+" ");
			random[i] = ival;
			copy_random[i] = ival;
			}
	//System.out.println("\nThis is the array sorted\n");	
	//print the array
	
	
	//sort the array
	// put the buble sort here
		
	now = System.currentTimeMillis();
	dnow = now;

	int a,b,t;
	int size;
	size = max;
	
	//this is the bubble sort
	for (a=1;a < size;a++)
		for(b = size - 1;b >= a; b--){
		if (random[b-1] > random[b]){
		//exchange elements
		t = random[b-1];
		random[b-1] = random[b];
		random[b] = t;
		}
	}

	//end of sorting the array
	 after = System.currentTimeMillis();
	 dafter = after;
	 bubbleTime = (dafter - dnow)/1000;
	
	// print random[] array
	System.out.println("\n\nThis is the array sorted with the bubble sort.\n\n");
//	for (i = 0; i < max ;i++){ System.out.print(random[i]+" ");	}
	
	
	now = System.currentTimeMillis();
	dnow = now;

	//sort the array
	Arrays.sort(copy_random);
	//end of soring the array
	 System.out.println("\n\nThis is the array sorted with the quick sort.\n\n");
	//for (i = 0; i < max ;i++){System.out.print(copy_random[i]+" ");}
	
	//copy the random[] to copy_random[];
	// THIS IS YOUR ASSIGNMENT
	
	 after = System.currentTimeMillis();
	 dafter = after;
	 quickTime = (dafter - dnow)/1000;
	 
	 System.out.println("\n\n"+max+" items were sorted.");
	 System.out.println("\n\nThe bubble sort time is " + bubbleTime+" seconds.\n\n");		
	// print random[] array
	//for (i = 0; i < max ;i++){
		// System.out.print(copy_random[i]+" ");
		// if (i % 10 == 0) System.out.println();
	//}
		System.out.println("\n\nThe quick sort time is " + quickTime+" seconds.\n\n");	
	}
}
