import java.util.*;

class Print{
	static void array(double list[]){ 
		int size = list.length;
		int i;
		for(i = 0;i < size; i++){
			System.out.print(list[i]+" ");
			if (i % 4 == 0)System.out.println();
		}
		System.out.println();
	}
}

class Bubble {  
	static void sort(double list[]){
		int a, b;
		double t;// t(temp)  
		int size = list.length;  
			// This is the bubble sort.  
		for(a=1; a < size; a++)  
    	for(b=size-1; b >= a; b--) {  
				if(list[b-1] > list[b]) { // if out of order  
						// exchange elements   
					t = list[b-1];  
					list[b-1] = list[b];  
					list[b] = t;         }  
      }
		}
}


class TimeSort{

	public static void main (String args[]){
		double now,after,time,v;
		
		int i;
		int max = 100000;
		double nums[] = new double[max];
			double numscopy[] = new double[max];
		// build the array
			
		for ( i = 0; i < max; i++){ 
			v = Math.random();
			nums[i] = v;
			numscopy[i] = v;
			
		
		}
		System.out.println("********** SORTING USING Bubble.sort **********");
		now = System.currentTimeMillis();  		
		Bubble.sort(nums);
		after = System.currentTimeMillis();    
		time = (after - now)/1000;
		System.out.println(time);
	//	Print.array(nums);
		
		System.out.println("********** SORTING USING Quicksort.sort **********");
		now = System.currentTimeMillis();  		
		//Quicksort.qsort(numscopy); 
		Arrays.sort(numscopy);
		after = System.currentTimeMillis();    
		time = (after - now)/1000;
		System.out.println(time);
	//	Print.array(numscopy);
	}//end main
}//end class
