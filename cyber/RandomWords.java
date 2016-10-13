import java.util.*;
class Dictionary{
	String dWords[];
	Dictionary (){	//constructor
		 dWords = new String[500];
		
		dWords[0] = "AAA";
		dWords[1] = "BBB";
		dWords[2] = "CCC";
		dWords[3] = "DDD";
		dWords[4] = "EEE";
		dWords[5] = "FFF";
		dWords[6] = "GGG";
		dWords[7] = "HHH";
		dWords[8] = "III";
		dWords[9] = "JJJ";
		dWords[10] = "KKK";
		dWords[11] = "LLL";
		dWords[12] = "MMM";
		dWords[13] = "NNN";
		dWords[14] = "OOO";
		dWords[15] = "PPP";
		dWords[16] = "QQQ";
		dWords[17] = "RRR";
		dWords[18] = "SSS";
		dWords[19] = "TTT";
		dWords[20] = "UUU";
		dWords[21] = "VVVV";
		dWords[22] = "WWW";
		dWords[23] = "XXX";
		dWords[24] = "YYY";
		dWords[25] = "ZZZ";

	}

}



class RandomWords {
	public static void main (String args[]){
	int max = 1000000;//1000000 is one million
	int dList = 0;
	Dictionary dictionaryWords = new Dictionary();
	
	int i,j;
	int count = 0;
	int acount = 0;
	long now, after;
	double dnow, dafter,quickTime,bubbleTime;//these are used to keep time
	
	double val1, val2, val3;
	//char letter1 , letter2 ,letter3;
	char chars[] = new char[3];
	char bell = 7;
	int ival1,ival2, ival3;
	String theWord;
	//create random[]
	//	System.out.println("\n\nThis is the array unsorted.\n");	
		
		for( i = 0; i < max;i++){
		 	val1 = Math.random()*26;ival1 = (int) val1;
			val2 = Math.random()*26;ival2 = (int) val2;
			val3 = Math.random()*26;ival3 = (int) val3;
			
			chars[0]= (char)(ival1 + 65);
			chars[1] = (char)(ival2 + 65);
			chars[2] = (char)(ival3 + 65);
			
			String newWord = new String(chars);
			
			String subWord = newWord.substring(0,1);
			if (subWord.equals("A")acount++;
			
		System.out.print(subWord+" ");
			for( j = 0; j <= dList; j++){ 
				if (newWord.equals(dictionaryWords.dWords[j])){
				//System.out.println(newWord+ " = "+dictionaryWords.dWords[j]);
				count ++;
				//if (j % 20 == 0) System.out.println();
				}
				
			}
		}
		System.out.println(count + " hits from "+max+" words.");
			
}
}
