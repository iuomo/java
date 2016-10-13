class QuestionIf {
	public static void main (String args[]) throws java.io.IOException {
		
		char chinput;
		
		for (;;){
			//inkey
							System.out.println("What is an endian?");
							System.out.println("A. The byte order of an integer.");
							System.out.println("B.  Is there a big, middle and little endian?");
							System.out.println("C. Does this have anything to do with unicode?");
							System.out.println("D. I'll ask http://en.wikipedia.org\n");
							System.out.print("Please input: ");
			do {
				chinput = (char) System.in.read();
			}while ((chinput == '\n') | (chinput == '\r'));
			//end in key
	
			if (chinput == '.'){break;}
			else if ((chinput == 'A')|(chinput == 'a')){ 	System.out.print("YEP!\n\n");}
				else if (chinput == 'B'){ 	System.out.print("THERE IS A BIG, MIDDLE, AND LITTLE.\n\n");}
			else if (chinput == 'C'){ 	System.out.print("YES IS DOES.\n\n");}
			else if (chinput == 'D'){ 	System.out.print("THAT'S WHERE I WENT\n\n");}
			else { 	System.out.print("BYE BYE NOW\n\n");}
		
	}//end for
}
}
