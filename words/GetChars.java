import java.io.*; 
/*

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {

public static void main(String[] args) throws IOException {

	BufferedReader buffer = new BufferedReader(
                 new InputStreamReader(System.in));
	int c = 0;
	while((c = buffer.read()) != -1) {
		char character = (char) c;

		System.out.println(character);

	}

}

} */
class GetChars { 
  public static void main(String args[]) throws Exception { 
    FileReader fr = new FileReader("words.txt"); 
    BufferedReader br = new BufferedReader(fr); 
    int count,i,j;
    int val;
    double dval;
    char c;
    char clist[] = new char[1000];
    String s,w; 
    count = 0;
    while((c = br.read()) != -1) { 
    	    clist[count] = c;
      count++;
    } 
    fr.close(); 
   
    System.out.println("\n\n");
/////////////////////////////////////////////////////////////////////////////////////////
   
	    for (j = 0;j < count;j++){
		System.out.print(clist[j]);
		
	    }
    }
} 

