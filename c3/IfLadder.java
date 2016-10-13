class TheMoves{
	String move[];
	TheMoves(){	//constructor
		
	
		move = new String[50];
		
		
		move[0] = "\nWhat type of character do you want to be? \nA. Thief \nB. Wise Guy \nC. Tough Guy\n\n";
		move[1] = "\nWhat type of character do you want to be? \nA. Thief \nB. Wise Guy \nC. Tough Guy\n\n";
		move[2] = "\nWhat type of character do you want to be? \nA. Thief \nB. Wise Guy \nC. Tough Guy\n\n";
		move[3] = "\nWhat type of character do you want to be? \nA. Thief \nB. Wise Guy \nC. Tough Guy\n\n";
		move[4] = "\nWhat type of character do you want to be? \nA. Thief \nB. Wise Guy \nC. Tough Guy\n\n";
		
	}
}


class IfLadder {
	public static void main (String args[]) throws  java.io.IOException{
	TheMoves moveSet = new TheMoves();
	char chInput;
	String q1 = "\nWhat type of character do you want to be? \nA. Thief \nB. Wise Guy \nC. Tough Guy\n\n";
	System.out.print (q1);
	do {
		chInput = (char) System.in.read();
	}while ((chInput == '\n') | (chInput == '\r'));
	if (chInput  > (65+26)) chInput = (char) (chInput - 32);
	if (chInput == 'A'){
		System.out.println("A. So you want to be a Theif. Are you sure that's what you want? ");	
	}

	
	
	
	System.out.println(moveSet.move[0]);
	
}



}