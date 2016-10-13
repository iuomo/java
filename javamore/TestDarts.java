class TestDarts {

	public static void main (String args[]){

		double x,y;
		int hits = 0;
		double ratio;
		
		for (int i = 0; i < 1000000;i++){
		x = Math.random();
		y = Math.random();
		if (((x*x)+(y*y))<=1.0)hits ++;	
		
		ratio = (double)4*hits/i;
		
		System.out.print(ratio+" ");
		}
	}


}
