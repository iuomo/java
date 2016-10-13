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
  static void qsort(int items[]) { 
    qs(items, 0, items.length-1); 
  } 

 
  // A recursive version of Quicksort for characters. 
  private static void qs(int items[], int left, int right)  
  {  
    int i, j;  
   int x, y;  
  
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
				System.out.println("x="+x+" y="+y+" left="+left+" right="+right);//trace left right middle
				Print.array(items);
      }  
    } while(i <= j);  
  
    if(left < j) qs(items, left, j);  
    if(i < right) qs(items, i, right);  
  } 
} 
 
class QSortDemo { 
	public static void main(String args[]) { 
		int i; 
		int nums[] = { 10,9,8,7,6,5,4,3,2,1 }; 
		System.out.print("Original array: "); 
		Print.array(nums);
		Quicksort.qsort(nums); 
		System.out.print("Sorted array: "); 
				Print.array(nums);
}
}
