class SimpleWord {
	public static void main  (String IDM[]){

			String word = new String("");
					String compareword = "zxc";
			char c0, c1,c2;
			int  compare;
			long count = 0;
			boolean done = false;
			while (!done){
				word = "";
				c0 = (char)(Math.random()*26 + 65);
					c0 = (char)((int) c0 | 32);
				c1 = (char)(Math.random()*26 + 65);
					c1 = (char)((int) c1 | 32);
				c2 = (char)(Math.random()*26 + 65);
					c2 = (char)((int) c2 | 32);
					word = word + c0 + c1 + c2 ;
					count ++;
			
					compare = word.compareTo(compareword);
					System.out.println(word+" compare = "+compare);	
					if (compare == 0)done = true;
						System.out.println(count);	
				
	
	}

}
	}

