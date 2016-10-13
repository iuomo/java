import java.io.*; 
import java.util.*;

class ReadFile{
	static void fileread(String wordfile, String list[],int c)throws Exception{
		String s; 
	 FileReader fr = new FileReader(wordfile); 
	 BufferedReader br = new BufferedReader(fr); 
	 
	 while((s = br.readLine()) != null) { 
		 list[c] = s; 
		 System.out.println(c+ " - " + s);
		 c++;
	 } 
	 System.out.println("this is c "+c);
	 fr.close(); 
    }		
	}
 
class BSearch{
	// binary search 
	BSearch(int s, int m, int e){
	
	}
}


class RandomWords { 
  public static void main(String args[]) throws Exception{ 
    int i,c;
	int count = 0;
	String wlist[] = new String[300];//word lisr
	
	ReadFile ob  = new ReadFile();
	ReadFile.fileread("words.txt",wlist,count);
	c = count;
	int l = wlist.length;
	System.out.println(l);
	//Arrays.sort(wlist);
     for (i = 0; i < 13; i++){
	   System.out.println(i+ " =  "+ wlist[i] +" ");
    }
  }
}
