





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



class TwoDouble {
	public static void main(String args[]){
		long total = 0;
		double table[][] = new double[2][10];
		double cd;
                int maxmatch = 0;
		int match = 0;
		int c, r;
		//bubble sort varaibles
			int a, b;  
		double t0, t1;
		int size = 10;  
		//end bubble sort variables
		double value;
		// build array
		for(;;){
			value = 0;
			for (c = 0; c < 10; c++){
					table[0][c] = value;
					value++;
			}
			for (c = 0; c < 10; c++){
					table[1][c] = Math.random();
					//value = value + 10;
			}
			
			//System.out.println();
			for (c = 0; c < 10; c++){
			//	System.out.println(table[1][c]);
				//System.out.print(" ");
			}
	
		
		// bubble sort
	
	
		
			for(a=1; a < size; a++)  
				for(b=size-1; b >= a; b--) {  
					if(table[1][b-1] < table[1][b]) { // if out of order  
					t1 = (double)table[1][b-1];
					t0 = (double)table[0][b-1];//move index
					table[1][b-1] = table[1][b]; 
					table[0][b-1] = table[0][b];//move index
					table[1][b] = t1;
					table[0][b] = t0;
					}  
				}  
		
		
		//end bubble sort
		// display arrays and check orf
			match = 0;total++;
			for (c = 0; c < 10; c++){
				cd = (double)c;
				if (cd == table[0][c])match ++;
				System.out.print(table[0][c]);
				System.out.print(" - ");
				System.out.println(table[1][c]);
				System.out.print(" ");
			}
			System.out.println("match = "+match+ " maxmatch "+ maxmatch+" total lists "+total);
			if (match > maxmatch)maxmatch = match;
		} //end infinite loop
	
		}

			
}
