import java.io.*;
class Question {
	public static void main (String args[])
	throws IOException {
        char ch;
	
   		do{
			System.out.println("The condition controlling the if must be of what type?");
			System.out.println("a: char ");
			System.out.println("b: integer ");
			System.out.println("c: boolean ");
			System.out.println("d: none of the above");
			System.out.println("Input the correct answer:");
			ch = (char) System.in.read(); // get a char
		}while(ch == '\n' | ch == '\r');
		if ((ch == 'c')|(ch == 'C')) System.out.println("Correct!!!!!!");
		 else System.out.print(ch + " is not correct.Try again. ");
	}
}
