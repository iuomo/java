class Fib {
	public static void main (String args[]){
		int rows = 92;
		int i;
		long swap [] = new long[rows]; 
		long digits [] = new long[rows]; 
		long fibinachi[] = new long [rows];

		long fib = 0;
		long prev = 0; 
		long next = 1;
		int div;int d = 100;int col = 1; int row = 0;
		fibinachi[0] = 1;
		for (i = 1; i < (rows); i ++){
			fib = prev +  next;	prev = next; next = fib;
			fibinachi[i] = fib;
}

	for (i = 0; i < (rows); i ++){
			System.out.println (i+1+ " "+		fibinachi[i] );

	}
	long dividend  = fibinachi[91];
	long divisor = 10;
	long quotient = 1;
	long r ;
	i  = 0;
		System.out.println (dividend);

	while (quotient != 0) {
		quotient =  (dividend / divisor); 
		r = dividend - (quotient*10);
		dividend = quotient;
				System.out.print (r+" ");
		//swap[i] = r;
		//i++;
	}
	
	
	
	
	
}
}



