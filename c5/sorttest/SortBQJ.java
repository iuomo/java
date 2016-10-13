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

class Quicksort { 
  // Set up a call to the actual Quicksort method. 
  static void qsort(double items[]) { 
    qs(items, 0, items.length-1); 
  } 

 
  // A recursive version of Quicksort for characters. 
  private static void qs(double items[], int left, int right)  
  {  
    int i, j;  
		double x, y;  
  
    i = left; j = right;  
    x = items[(left+right)/2];  
  
    do {  
      while((items[i] < x) && (i < right)) i++;  
      while((x < items[j]) && (j > left)) j--;  
      
      if(i <= j) {  
        y = items[i];  
        items[i] = items[j];  
        items[j] = y;  
        i++; j--;
	//			System.out.println("x="+x+" y="+y+" left="+left+" right="+right);//trace left right middle
	//			Print.array(items);
      }  
    } while(i <= j);  
  
    if(left < j) qs(items, left, j);  
    if(i < right) qs(items, i, right);  
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


class SortBQJ{

	public static void main (String args[]){
		double now,after,time,v;
		
		int i;
		int max = 10000;
		double nums[] = new double[max];
			double numscopy[] = new double[max];
			double numscopycopy[] = new double[max];
		// build the array
				System.out.println("Arrays are being created with "+max+" values.");
		for ( i = 0; i < max; i++){ 
			v = Math.random();
			nums[i] = v;
			numscopy[i] = v;
			numscopycopy[i] = v;
		
		}
		System.out.println(max+" items are being sorted.");
		System.out.println("********** SORTING USING Bubble.sort **********");
		now = System.currentTimeMillis();  		
		Bubble.sort(nums);
		after = System.currentTimeMillis();    
		time = (after - now)/1000;
		System.out.println(time);
	//Print.array(nums);
			System.out.println(max+" items are being sorted.");
		System.out.println("********** SORTING USING Quicksort.sort **********");
		now = System.currentTimeMillis();  		
		Quicksort.qsort(numscopy); 
		after = System.currentTimeMillis();    
		time = (after - now)/1000;
		System.out.println(time);
			System.out.println(max+" items are being sorted.");
			System.out.println("********** SORTING USING Arrays.sort **********");
		now = System.currentTimeMillis();  		
		Arrays.sort(numscopycopy);
		after = System.currentTimeMillis();    
		time = (after - now)/1000;
		System.out.println(time);
		
		//Print.array(numscopy);
	}//end main
}//end class
