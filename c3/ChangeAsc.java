class ChangeAsc {
	public static void main (String args[]) throws java.io.IOException {
		char chinput ='?';
		char change = ' ';
		
		for (;;){
			//inkey
			System.out.print("Input a charater:");
			do {
				chinput = (char) System.in.read();
			}while ((chinput == '\n') | (chinput == '\r'));
			//end in key
				if (chinput == '.')break;
				if ((chinput >= 'A')&(chinput <= 'Z'))
					{ change = (char)(chinput+32 );
						
					}
					if ((chinput >= 'a')&(chinput <= 'z'))
					{ change = (char)(chinput-32 );
						
					}
					System.out.println(change);
					
					System.out.println(chinput+ " -> "+ change);
	int cCAP;
	cCAP = (int) change;
	System.out.println(chinput+ " -> "+ cCAP);
					
		}
	

	}
}
