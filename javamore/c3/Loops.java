class Loops {

	public static void main (String args[]){
	double n,v;
	int i,j;
	
	//for loop with a double
	for (n = -4.0; n < 4.1; n = n + 0.1){
	 v = Math.sqrt(n);
		System.out.println (n+" ^.5 = " +v );
	}// end for n
	
	//a nested for loop and no body
	for (i = 0, j = 20; i < 21; i++, j --) System.out.println("i = "+i+" j "+j);
	
	// a loop with a missing piece
	for (i = 0; i < 3;){
		System.out.println("i = "+i);
		i++;
	}
	
	}
}
