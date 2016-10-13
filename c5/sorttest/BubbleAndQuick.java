class Print{
	static void array(int list[]){
		int size = list.length;
		int i;
		
		for(i = 0;i < size; i++){
			System.out.print(list[i]+" ");
		//	if (i % 4 == 0)System.out.println();
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
      }  
    } while(i <= j);  
  
    if(left < j) qs(items, left, j);  
    if(i < right) qs(items, i, right);  
  } 
} 
 






class BubbleAndQuick {  
  public static void main(String args[]) {  
    int nums[] = { 10,9,8,7,6,5,4,3,2,1 }; 
		//int nums[] = { 1,2,3,4,5,6,7,8,9,10 }; 
    int a, b, t;  
    int size;  
		int exchange = 0;
    size = 10; // number of elements to sort  
  
    // display original array  
    System.out.println("Original array is:"); 
		Print.array(nums);
  
    // This is the bubble sort.  
    for(a=1; a < size; a++)  
      for(b=size-1; b >= a; b--) {  
        if(nums[b-1] > nums[b]) { // if out of order  
          // exchange elements
					exchange ++;
          t = nums[b-1];
          nums[b-1] = nums[b];  
          nums[b] = t;  
									//print array for each loop
									System.out.print ("a="+a+"b="+b+">");
								Print.array(nums);
								
        }  
      }  

    // display sorted array  
    System.out.println("Sorted array is:");  
    Print.array(nums);
		System.out.println(exchange + " exchanges.");
  } 
}


