class MakeArray{
		double[] randomArray (int length){
		double a[] = new double[length];
		int i;
			for (i = 0; i < length;i++){
					a[i] = Math.random();	
			}
		return a;
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
 
class QSortDemo { 
	public static void main(String args[]) { 
		int i; 
		MakeArray darray = new MakeArray();
		double[] b = darray.randomArray(100);
		System.out.print("Original array: "); 
		System.out.println(); 
		// now, sort the array 
		Quicksort.qsort(b); 
		System.out.print("Sorted array: "); 
		for(i=0; i < b.length; i++)  
			System.out.println(b[i]); 
		} 
}
