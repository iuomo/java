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

class Words{
	public static void main (String args[]) throws java.io.IOException{
	int track[] = new int[10];     
	int i,j;

		GetWords wd = new GetWords();
	
		for( i = 0; i< 10;i++){
			System.out.println(wd.words[i]);
		}
	}
}
