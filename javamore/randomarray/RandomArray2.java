import java.util.*;  
class RandomArray2{

	public static void main (String args[]){
	
		int max, count,i,j, size = 52;
		double dval;
		int val;
			int a[] = new int[size];
			int b[] = new int[size];
			boolean ok;   
			//build arrays
			max = 0;
			int total = 0;
	//for(;;){
		//System.out.println ("Shuffle");
			for (i=0 ; i < 52; i++){ 
					
				dval = Math.random()*10000;
				val = (int)dval;
				a[i] = val;
				b[i] = a[i];
				//System.out.println (a[i]+ " "+b[i]);
			}
			//print arrays
			// sort array a[]
			//if (a[0] == b[0]) {
			//System.out.println (" ------ ");
			//System.out.println (a[0]+ " "+b[0]);
			
			
			Arrays.sort(a);
			for (i=0 ; i < 52; i++){ 
		
				System.out.println (a[i]+ " "+b[i]);
			}
			
			count = 0;j = 0;
			do {
				
				if (a[j] == b[j]) count++;
				j++;
			}while  (j < 52);	

			if (count > max){ max = count;
			System.out.println (max+ " <- max");
			}
			//if (max > count){
			//		System.out.println (" * "+max);
							
			//}
	}
	//} // infinite for loop
}
