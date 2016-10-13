class SubString {
	public static void main (String args[]) throws java.io.IOException{



			String word = new String("");
				String compareword = "LMN";
			char input;
			char c0, c1,c2,c3,c4,c5,c6,c7,c8,c9;
			int  indexof, lastof;

			boolean done = false;
			while (!done){
				word = "";
				c0 = (char)(Math.random()*26 + 65);
				c1 = (char)(Math.random()*26 + 65);
				c2 = (char)(Math.random()*26 + 65);
				c3 = (char)(Math.random()*26 + 65);
				c4 = (char)(Math.random()*26 + 65);
		
				word = word + c0 + c1 + c2 + c3 + c4;
		
			
					indexof = word.indexOf("M");
					lastof = word.lastIndexOf("M");
						System.out.println("SEARCH FOR M");	
					System.out.println(word+" indexof= "+indexof+" lastof= "+lastof);	
					
					
				input = (char)System.in.read();
	
	}

}
	}

