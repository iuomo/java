import java.io.*; 
import java.util.*;
/////////////////////////////////////////////////////////////////////
class ReadFile{
	static int creturn = 0;
	static void fileread(String file, String list[])throws Exception{
		String s; int c =0;
		FileReader fr = new FileReader(file); 
		BufferedReader br = new BufferedReader(fr); 
	 
		while((s = br.readLine()) != null) { 
			list[c] = s; 
		 	c++;
			 creturn++;
			
		} 
			fr.close(); 
		
	}//end of ReadFile method
	static int getListLength(){
		return creturn;}
}
/////////////////////////////////////////////////////////////////////

class ReturnWord{
	String w; 
	
	ReturnWord(int v){
	  char c;
	  double dval;
	   int j, val;
	   w ="";
	   for (j = 0; j < v;j++){
		    dval = Math.random();  
		    dval = dval *26; 
		    val = (int)dval+97;
		    c = (char)val;
		    w = w + c;
	    }
}//end contructor
 String word(){
		     return w;
		}
}//end class
/////////////////////////////////////////////////////////////////////

class BinarySearch{
	public static int results(String keyWord,String dlist[],int dictionarylength){
		int first= 0;
		int last = dictionarylength;
		int upto = last;
		int mid = (first + last) / 2;
		int count = 0;
		while (first < upto) {
			System.out.println(count + "compare count");
			mid = (first + upto) / 2;  // Compute mid point.
			if (keyWord.compareTo(dlist[mid]) < 0) {
				count++;
				upto = mid;     // repeat search in bottom half.
				} else if (keyWord.compareTo(dlist[mid]) > 0) {
					count++;
					first = mid + 1;  // Repeat search in top half.
				} else {
					return mid;     // Found it. return position
				}
			}
		return -(first + 1);    // Failed to find key
	}//end method
	}
/////////////////////////////////////////////////////////////////////
class WordsPlus { 
  public static void main(String args[]) throws Exception{ 
    int i,c,max,wl,slength,rval;
      boolean match = false;
    int count = 0;
	String wlist[] = new String[70000];//word list
	int wnt[] = new int[70000];
	for (i = 0; i < 70000;i++){wlist[i] = null; wnt[i] = 0 ; }//clear word list
	ReadFile ob  = new ReadFile();
	ReadFile.fileread("words60000.txt",wlist);
	wl = ob.getListLength();
	System.out.println("wlist "+wl);

	
	max =0; slength = 0;
     for (i = 0; i < wl; i++){
	     slength = wlist[i].length();
	     if (slength > max){max = slength;  
	 }
    }
    System.out.println(max+" max length ");
     String wo;
   
     int matchcount = 0;
     int thelength = 0;
     int  maxlength = 0;
     int listindex = 0;
     int fill = 0;
    for(int j = 0 ;;){
	    	rval = (int)((Math.random()*21)+1);
    		ReturnWord nw = new ReturnWord(rval);   
		  wo = nw.word(); count++;
		  if (count % 50000 == 0)
		  	{
				System.out.println(count);
			//for (long p = 0L; p <1000000000L;p++);	
			}
				  int indexvalue;
		  indexvalue = BinarySearch.results(wo,wlist,wl); 
		fill = 0;
		if (indexvalue > -1){
			for (int p = 0; p <10000000;p++);
			wnt[indexvalue] = wnt[indexvalue] + 1;
			for (j = 0; j < wl; j++)if(wnt[j]>0)fill++; 
			System.out.println("word # "+indexvalue+" - ");
			System.out.print( wo + " -  " );
		
	System.out.println(fill+" different words created | "+wlist[indexvalue]+" was hit "+wnt[indexvalue]+" times");				
		}
				matchcount++;
		  	}
  }
}

