import java.util.*;  

class CreateRandomArray2 {

	public static void main (String yep[]){

		double dval;	int ival,i, j, count; 
		//boolean done = false;	boolean dup = false;
		int max = 10;
		// initialize  an array
		int a[] = new int[max];		int b[] = new int[max];
		for(;;){
		boolean done = false;	boolean dup = false;
		for (j = 0; j < max; j++)a[j] = -1; //sets the array to -1
		
		i= 0; count = 0;// int i keeps track of the array index while count counts the interations
		while (!done){
			dval = Math.random();
			ival = (int) (Math.random()*max);		
			dup = false;
			for (j = 0; j <=i;j++){
				count++;
				if(ival == a[j]) dup = true;	
				}
				if (!dup) {
					a[i] = ival;
					i++;
				}
			
			if (i >= max) done = true;
		}
		
		//print array a
		System.out.println("ARRAY NOT SORTED");
		for (j = 0; j < max; j++){	
			System.out.print(a[j]+" ");	
		}
		if (count == 10) break;
		System.out.println("   "+count);
		
		System.out.println("ARRAY SORTED");
		Arrays.sort(a);
		for (j = 0; j < max; j++){	
			System.out.print(a[j]+" ");	
		}
		}
	}

}
