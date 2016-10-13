
class TwoDRan {
	public static void main(String args[]){
		int table[][] = new int[5][10];

		int c, r;
	
		int value = 100;
		// build array
		for (c = 0; c < 5;c++){
			for (r = 0; r < 10; r++){
					table[c][r] = value;
					value = value + 10;
			}
		}
		
		for (c = 0; c < 5;c++){
			for (r = 0; r < 10; r++){
				System.out.print(table[c][r]);
				System.out.print(" ");
			}
			System.out.println();
		}
	
		}

			
}

		
