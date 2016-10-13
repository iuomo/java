class ArrayCards {

	public static void main (String args[]){
	
		int suit,card;
		String c[][] = new String[4][13];
			
			c[0][0] = "A";
			c[1][0] = "A";
			c[2][0] = "A";
			c[3][0] = "A";
			
		
			
			for (suit = 0; suit <4; suit++){
		
					for (card = 0; card <13; card++){
						System.out.print (c[suit][card]);
								switch (suit){
				case 0:
					System.out.println(" OF SPADES");
					break;
					case 1:
					System.out.println(" OF CLUBS");
					break;
					case 2:
					System.out.println(" OF HEARTS");
					break;
					case 3:
					System.out.println(" OF DIAMONDS");
					break;
					
				}	
			}
			// get 5 cards
			
			
}

int s,c2;
			System.out.println();
				s = (int) (Math.random()*4);
				c2 = (int) (Math.random()*13);
			System.out.println(s+" <- suit  card ->  "+c2);
			System.out.println(c[s][c2]);

}
}
