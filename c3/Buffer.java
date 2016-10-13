class Buffer {
	public static void main (String args[]) throws java.io.IOException {
			char ch,newch;
			int temp = 0;
			int c = 0;
			int factor = 100;
				System.out.print("? INPUT 3 CHARACTERS = ");
			while (c < 3){
					do {
						ch = (char) System.in.read();
				}while ((ch == '\n') | (ch == '\r'));
						temp = (((int)ch)-48)*factor + temp; //summation
				factor = factor / 10;
			  c++;
			}//while c , 3
			System.out.println(temp);
			newch = (char) temp;
				System.out.println(newch);
		}
}
