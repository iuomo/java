class TheMoves{
	String move[];
	TheMoves(){	//constructor
	
		move = new String[50];
			
		move[0] = "\nWhat type of character do you want to be? \nA. Thief \nB. Wise Guy \nC. Tough Guy\n";
		move[1] = "\nWhat type of character do you want to be? \nA. Thief \nB. Wise Guy \nC. Tough Guy\n";
		move[2] = "\nWhat type of character do you want to be? \nA. Thief \nB. Wise Guy \nC. Tough Guy\n";
		move[3] = "\nWhat type of character do you want to be? \nA. Thief \nB. Wise Guy \nC. Tough Guy\n";
		move[4] = "\nWhat type of character do you want to be? \nA. Thief \nB. Wise Guy \nC. Tough Guy\n";
		
		move[10] = "\nWhy do you want to be a theif? \nA. I have no cash. \nB. I'll give to the poor.\n";
		move[11] = "\nO.K. Wise Guy? Everyone wants wisdom.  Why do you need wisdom? \nA. I'm not wise. \nB. My sister needs wisdom \n";
		move[12] = "\nTough guy, hmmmm? Do you lift weights? \nA. Yes \nB. No \n";
		move[13] = "\nWhat type of character do you want to be? \nA. Thief \nB. Wise Guy \nC. Tough Guy\n";
		move[14] = "\nWhat type of character do you want to be? \nA. Thief \nB. Wise Guy \nC. Tough Guy\n";
		
	}
}


class IfLadder2 {
	public static void main (String args[]) throws  java.io.IOException{
	TheMoves moveSet = new TheMoves();// this code build the array of moves
	
	char chInput;
	
	System.out.println(moveSet.move[0]);
	//**********************************************************************************
		do {  chInput = (char) System.in.read(); }while ((chInput == '\n') | (chInput == '\r'));//Inkey routine
		if (chInput  > (65+26)) chInput = (char) (chInput - 32);//change to cap
	//**********************************************************************************
		if (chInput == 'A'){
			System.out.println(moveSet.move[10]);
		}else if(chInput == 'B') {
			System.out.println(moveSet.move[11]);
		}else{
			System.out.println(moveSet.move[12]);
	}
	
	
}



}