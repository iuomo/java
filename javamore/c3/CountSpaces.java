class CountSpaces {
	public static void main (String args[]) throws java.io.IOException {
		char chinput ='?';
		int count =0;
		System.out.println("count = "+count);
		for (;;){
			//inkey
			System.out.print("Input a charater:");
			do {
				chinput = (char) System.in.read();
				
			}while ((chinput == '\n') | (chinput == '\r'));
			//end in key
				if (chinput == '.')break;
				if (chinput == ' ')count++;
		}
		System.out.println("after count = "+count);
		
	}
}
