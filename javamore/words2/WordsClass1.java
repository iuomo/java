import java.io.*;
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


class WordsClass1 {
  public static void main(String args[]) { 
	 
	 String s = "aaa"; 
	 String wo = "";
	  int i, count = 0;
	  boolean match;
	  int rval;
	  match = false;
	  while (!match){
		  //get word
		  rval = (int)((Math.random()*21)+1);
		  ReturnWord nw = new ReturnWord(rval);   
		  wo = nw.word();
		  count++;
		  System.out.println(wo+" - "+count+" - "); 
		  if (wo.equals(s))
		  	{ 
				match = true;	
			}
		

    }
  } 
}
