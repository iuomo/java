import java.io.*; 
import java.util.*;

class ReadFile{
	static int creturn = 0;
	static void fileread(String file, String list[])throws Exception{
		String s; int c =0;
		FileReader fr = new FileReader(file); 
		BufferedReader br = new BufferedReader(fr); 
	 
		while((s = br.readLine()) != null) { 
			list[c] = s; 
		 //System.out.println(c+ " - " + s);
		 	c++;
			 creturn++;
			
		} 
		//creturn = c;
		//System.out.println("this is c "+c);
		fr.close(); 
		
	}//end of ReadFile method
	static int getListLength(){
		//System.out.println(creturn+ " creturn");
	return creturn;}
}
	


	
 
class BSearch{
	// binary search 
	BSearch(int s, int m, int e){}
	}

class RandomWords { 
  public static void main(String args[]) throws Exception{ 
    int i,c,max,wl,slength;
	String wlist[] = new String[70000];//word lisr
	for (i = 0; i < 70000;i++)wlist[i] = null;
	ReadFile ob  = new ReadFile();
	ReadFile.fileread("words60000.txt",wlist);
	wl = ob.getListLength();
	System.out.println("wlist "+wl);

	//System.out.println(wl);
	//Arrays.sort(wlist);
	max =0;
	slength = 0;
     for (i = 0; i < wl; i++){
	     slength = wlist[i].length();
	     if (slength > max){max = slength;  
	 System.out.println(i+ " =  "+ wlist[i] +" ");
	 }
	    // System.out.println(i+" "+max+" max length ");
    }
    System.out.println(max+" max length ");
  }
}
