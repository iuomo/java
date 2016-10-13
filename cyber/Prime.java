class Prime {
	public static void main (String args[]){
		boolean prime;
		double dx; 
		int x, d, c = 1;// x is the number to check to be prime
		for (x = 2; x < 2147483647; x++){ 
			dx = x;
		  	prime = true;//assume value is prime	
			for (d = 2; d < (x/2+1);d ++){
				if ((dx / d) == (x / d)) prime = false;  
			}
			if (prime) {
			System.out.print(x + " ");
			if (c % 15 == 0) System.out.println();
			c++;//count the number of primes
		}
	}
	System.out.println("count ="+c);
}
}
