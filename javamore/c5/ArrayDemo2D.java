class ArrayDemo2D {

	public static void main (String args[]){
	
		int suit,card;
		String c[][] = new String[4][13];
			
			c[0][0] = "A";
			c[1][0] = "A";
			c[2][0] = "A";
			c[3][0] = "A";
			
			c[0][1] = "2";
			c[1][1] = "2";
			c[2][1] = "2";
			c[3][1] = "2";
			
			c[0][2] = "3";
			c[1][2] = "3";
			c[2][2] = "3";
			c[3][2] = "3";
			
			c[0][3] = "4";
			c[1][3] = "4";
			c[2][3] = "4";
			c[3][3] = "4";
			
					c[0][9] = "10 OF SPADES";
			c[1][9] = "10 OF CLUBS";
			c[2][9] = "10 OF HEARTS";
			c[3][9] = "10 DIAMONDS";
			
			c[0][12] = "K";
			c[1][12] = "K";
			c[2][12] = "K";
			c[3][12] = "K";
			   
			for (suit = 0; suit <4; suit++){
					for (card = 0; card <13; card++){
						System.out.println (c[suit][card]);	
				}	
			}
			// get 5 cards
	int s,c2;
			System.out.println();
				s = (int) (Math.random()*4);
				c2 = (int) (Math.random()*13);
			System.out.println(s+" <- suit  card ->  "+c2);
			System.out.println(c[3][9]);
		
		
}

			
}
