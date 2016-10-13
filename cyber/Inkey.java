import java.io.*;
class InKey {
	public static void main (String args[])
		throws IOException{
		char ch;
		do{
			
			System.out.println("Input a charater:");
			ch = (char) System.in.read(); // get a char
		}while(ch == '\n' | ch == '\r');
		System.out.println("the char is "+ ch+" "+ (int)ch);
	}
}
