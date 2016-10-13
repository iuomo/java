import java.util.*;  

class RandomArrayMatch {

	public static void main (String yep[]){

		double dval;	int ival,i, j,hits, count; 
		//boolean done = false;	boolean dup = false;
		int max = 52;
		int maxhits;
		// initialize  an array
		int a[] = new int[max];		int b[] = new int[max];
	
		boolean match, done;	boolean dup = false;
		
		
		 count = 0;// int i keeps track of the array index while count counts the interations
		match = false;
		count = 0;
		maxhits = 0;
		while (!match){
			for (j = 0; j < max; j++)a[j] = -1; //sets the array to -1
			i = 0;// set i to 0;
			done = false;
			while (!done){
				dval = Math.random();
				ival = (int) (Math.random()*max);		
				dup = false;  	// check for duplicates
				for (j = 0; j <=i;j++){
					if(ival == a[j]) dup = true;
					//System.out.println("IN CHECK i "+i);
				}
				if (!dup) {
					//System.out.println("IN !DUP i "+i);
			
					a[i] = ival;
					b[i] = ival;// add this
					i++;
				}
			
			if (i >= max) done = true;
		}//end while done
		
		//print array a
		//System.out.println("ARRAY NOT SORTED");
		//for (j = 0; j < max; j++){	
		//	System.out.print(a[j]+" ");	
		//}
		
		
		//System.out.println("ARRAY SORTED");
		Arrays.sort(a);
		hits = 0;
		
		//check for a match
		for (j = 0; j < max; j++){
			if(a[j] == b[j]) hits++;	
			//System.out.println(a[j] +" a  -  b "+b[j]);
		}// end j
		
		//System.out.println("\n\n");
		if(hits == max) match = true;	
		//System.out.println("hits : " +hits+" max hits : "+maxhits+" / "+count);
		count++;
			if (hits > maxhits) {
				maxhits = hits;
				System.out.println("*hits : " +hits+" max hits : "+maxhits+" / "+count);
			}
			
		}//end while match
	}
}
