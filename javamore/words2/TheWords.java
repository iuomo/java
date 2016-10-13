import java.io.*; 
 
class TheWords { 
  public static void main(String args[]) throws Exception { 
    FileReader fr = new FileReader("words.txt"); 
    BufferedReader br = new BufferedReader(fr); 
    int count,i,j;
    int val;
    double dval;
    char c;
    String list[] = new  String[300];
    String s,w; 
    count = 0;
    while((s = br.readLine()) != null) { 
   list[count] = s;
      count++;
    } 
    fr.close(); 
    for (i = 0; i < count;i++){
	System.out.print(list[i]+" ");    
    }
    System.out.println("\n\n");
/////////////////////////////////////////////////////////////////////////////////////////
    for (i = 0; i < 100000;i++){
	    w ="";
	    for (j = 0; j < 3;j++){
		    dval = Math.random()*26;
		    val = (int)dval+65;
		    c = (char)val;
		    	w = w + c;
		
		  
	    }
	    for (j = 0;j < count;j++){
		//  System.out.print(w+" - ");
		if (w.equals(list[j]))System.out.println(list[j]+" MATCHES with "+w); 

	    }
    }
  } 
}
