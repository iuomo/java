class BuildWord {
	public static void main (String input[]){
		String list[] = new String[26];
		int hit[] = new int[26];
			int total = 0;  //total hits
		list[0] = "AAAAA";
		list[1] = "BBBBB";
		list[2] = "CCCCC";
		list[3] = "DDDDD";
		list[4] = "EEEEE";
		list[5] = "FFFFF";
		list[6] = "GGGGG";
		list[7] = "HHHHH";
		list[8] = "IIIII";
		list[9] = "JJJJJ";
		list[10] = "KKKKK";
		list[11] = "LLLLL";
		list[12] = "MMMMM";
		list[13] = "NNNNN";
		list[14] = "OOOOO";
		list[15] = "PPPPP";
		list[16] = "QQQQQ";
		list[17] = "RRRRR";
		list[18] = "SSSSS";
		list[19] = "TTTTT";
		list[20] = "UUUUU";
		list[21] = "VVVVV";
		list[22] = "WWWWW";
		list[23] = "XXXXX";
		list[24] = "YYYYY";
		list[25] = "ZZZZZ";

			String str1 = new String ("MAKE A 5 LETTER RANDOM WORD");
			String str2 = "***************************";
			String word = new String("");
			char c0, c1,c2,c3,c4,c5,c6,c7,c8,c9;
			int i,j, compare;
			long count = 0;
			boolean done = false;
			while (!done){
				word = "";
				c0 = (char)(Math.random()*26 + 65);
				c1 = (char)(Math.random()*26 + 65);
				c2 = (char)(Math.random()*26 + 65);
				c3 = (char)(Math.random()*26 + 65);
				c4 = (char)(Math.random()*26 + 65);
		
				word = word + c0 + c1 + c2 + c3 + c4;
				// compare list[] to word ***************************
				for (i = 0; i < 26; i++){
					count ++;
					compare = word.compareTo(list[i]);
							if (compare == 0){
							
	System.out.println(word+" compare = "+compare+" count ="+count);	
								hit[i] = hit[i] + 1;
									//check to see if all of hit is 1
									done = true;
									for (j = 0; j < 26; j++){
										if (hit[j] == 0) {done = false;break;}
									}
							}
				}
				
			}// do(!done)
		
			for (j = 0; j < 26; j++){
								total = total + hit[j];
			}
			System.out.println("total hits = "+total);	
			}
				
	
	}

