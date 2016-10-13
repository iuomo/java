class CreateRandomArray {

	public static void main (String yep[]){

		double dval;	int ival,i, j; 
		boolean done = false;	boolean dup = false;
		int max = 10;
		// initialize  an array
		int a[] = new int[max];		int b[] = new int[max];
			
		i= 0;
		while (!done){
			dval = Math.random();
			ival = (int) (Math.random()*10);		
			System.out.println(dval+ "    "+ival);
			// check for duplicates
			a[i] = ival;
			i++;
			if (i >= max) done = true;
		}
		
		//print array a
		for (j = 0; j < max; j++){	
			System.out.print(a[j]+" ");	
		}

	}

}
