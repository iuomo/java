import java.io.*;

class Words3Letter {
  public static void main(String args[]) { 
	  String w; 
	  String s = "aaa"; 
	  char c;
	  int count = 0;
	  int i,j, val;
	  double dval;

    for (i = 0; i < 1000000;i++){
	    w ="";
	    for (j = 0; j < 3;j++){
		    dval = Math.random();  
		    dval = dval *26; 
		    val = (int)dval+97;
		    c = (char)val;
		    w = w + c;
	    }
	    System.out.print(w+" - "); 
	
		//System.out.print(w+" - ");
		if (w.equals(s))
		{	System.out.println("\n\n\n\n"); 
			System.out.println(s+" MATCHES with "+w+" total hits "+count); 
			count++;	
		}

    }
  } 
}
