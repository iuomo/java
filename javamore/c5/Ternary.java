class Ternary{
	public static void main (String args[]) throws java.io.IOException {
		char chinput ='?';
		char change = ' ';
		int count = 0;
	
		for (;;){
			//inkey
			System.out.print("Input a character : ");
			do {
				chinput = (char) System.in.read();
			}while ((chinput == '\n') | (chinput == '\r'));
			//end in key
		//	change = chinput;
			if (change == '.')break;
			change = chinput <= 'Z' ? (char)(chinput+32): (char)(chinput-32);
				System.out.println("* convert *");
				System.out.print(chinput+" -> ");
				System.out.println(change);
		}
	}
}
