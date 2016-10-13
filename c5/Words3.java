import java.io.*;
import java.util.*;

class GetWords{
	
	String words[] = new String[50];
	
	GetWords (){	//constructor
	
		
		words[0] = "AAA";
		words[1] = "BBB";
		words[2] = "CCC";
		words[3] = "DDD";
		words[4] = "EEE";
		words[5] = "FFF";
		words[6] = "GGG";
		words[7] = "HHH";
		words[8] = "III";
		words[9] = "JJJ";
		
	}

}

class Words3{
	public static void main (String args[]) throws java.io.IOException{
	int track[] = new int[10];     
	int h,i,j,k;
	String w = "";
	int val;
	double dval;
	char c;
		GetWords wd = new GetWords();
	
		for( i = 0; i< 10;i++){
			track[i] = 0;
			System.out.println(wd.words[i]);
		}
		
		for( k = 0; k < 1000000; k++){
			w = "";
			for (j = 0; j < 3;j++){
				dval = Math.random();
				dval = dval *26;
				val = (int)dval+65;
				c = (char)val;
				w = w + c;
				//System.out.print(w+" - "); 
			}// end of j make word
			//System.out.print(w+" - "); 
			for (h = 0; h < 10;h++){
				if (w.equals(wd.words[h])){
					System.out.println(w +" ******* MATCH **********  ");	
					track[h] = track[h] +1;
				}
			}//end h loop
			
	    }//end of k loop
		
		for( i = 0; i< 10;i++){
			System.out.println(wd.words[i]+" = "+track[i] );
		}
		
		
		
	}
}
