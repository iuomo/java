class RandomIndex {
	public static void main (String args[]){
		int i,rv,sum, count;//rv(random value) sum(add 1's in ra[]) count(count randoms created)
		int ra[] = new int[52];//random array
		boolean done = false;
		
		for (i = 0; i < 52; i++) ra[i] = 0;
		count = 0;
		while(!done){
			count ++;
			rv = (int)(Math.random() * 52);
			System.out.print(rv+" ");
			ra[rv] = 1;
			//check for zeros by adding all the elements in array ra[]
			sum = 0;
			for (i = 0; i < 52; i++) 		sum = sum + ra[i];
			
			if (sum == 52) done = true;
			else done = false;
		}

			

	System.out.println();
	for (i = 0; i < 52; i++) {System.out.print(ra[i]);
			if (i % 5 == 0) System.out.println();
	}
		System.out.println(count+ " random values need to created 52 unique integers.");	
	}
}

