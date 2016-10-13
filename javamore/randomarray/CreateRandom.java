class CreateRandomArray {

	public static void main (String yep[]){

		double dval;
		int ival,i, j; 
		boolean done = false;
		boolean check = false;
		int max = 10;
		// initialize  an array
		int a[] = new int[max];
		int b[] = new int[max];
		
		
		i= 0;
		while (!done){
			dval = Math.random();
			ival = (int) (Math.random()*10);		
			System.out.println(dval+ "    "+ival);
			
			// check for duplicates
			
				
				
			i++;
			if (i > 10) done = true;
		}

	}

}
