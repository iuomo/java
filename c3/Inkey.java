//cdoe by ccoleman
class Inkey {
	public static void main (String args[]) throws java.io.IOException {
		char chinput;
		int ichange;
		
		for (;;){
			//prompt user
			System.out.print("input a character -> ");
			
			//get a character then press Enter 
			do {
				chinput = (char) System.in.read();
			}while ((chinput == '\n') | (chinput == '\r'));
			
			//output the character
			System.out.println("character input is "+chinput);
			
			if (chinput == '.')break;  //a "." ends the routine
		
			ichange = (byte) chinput;		//type cast the character
			System.out.println("the asc value is " + ichange);
		}//end for
	}
}
