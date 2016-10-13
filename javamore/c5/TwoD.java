
class TwoD {
	public static void main(String args[]){
		int table[][] = new int[2][10];

		int c, r;
	
		int value = 100;
		// build array
		for (r = 0; r < 2;r++){
			for (c = 0; c < 10; c++){
					table[r][c] = value;
					value = value + 10;
			}
		}
		
		for (r = 0; r < 2;r++){
			for (c = 0; c < 10; c++){
				System.out.print(table[r][c]);
				System.out.print(" ");
			}
			System.out.println();
		}
	
		}

			
}
