class Inkey {
	public static void main (String args[]) throws java.io.IOException {
		char chinput;
	
		int ichange;
		
		for (;;){
			//inkey
			System.out.print("input a character -> ");
			do {
				chinput = (char) System.in.read();
			}while ((chinput == '\n') | (chinput == '\r'));
			//end in key
			System.out.println("character input is "+chinput);
		if (chinput == '.')break;
		ichange = (byte) chinput;
		
		System.out.println("the asc value is " + ichange);
	}//end for
}
}
