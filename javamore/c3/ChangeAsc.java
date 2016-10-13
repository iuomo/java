class ChangeAsc {
	public static void main (String args[]) throws java.io.IOException {
		char chinput;
		char newchar;
		int ichange;
		
		for (;;){
			//inkey
			//A to Z is 65 to 90
			//a to z is  97 to 122
			System.out.print("input a character -> ");
			do {
				chinput = (char) System.in.read();
			}while ((chinput == '\n') | (chinput == '\r'));
			//end in key
			System.out.println("character input is "+chinput);
		if (chinput == '.')break;
		ichange = (byte) chinput;
		newchar = chinput;
		if ((ichange >= 65) && (ichange <= 90)){
					newchar = (char) (ichange +32);	
		}
		if ((ichange >= 97) && (ichange <= 122)){
					newchar = (char) (ichange - 32);	
		}
		System.out.println(chinput + " -> " + newchar);
	}//end for
}
}
