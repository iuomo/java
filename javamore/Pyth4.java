import java.io.*;

class Pyth4 {

  public static void main (String ag[]){
	   int a, b , hyp, count = 0;
	   double c;
      try{
	       FileWriter fstream = new FileWriter("out.txt");  
	       BufferedWriter out = new BufferedWriter(fstream);
	        // out.write(" code");

	for ( a = 1; a < 1001; a++){
		for (b = 1; b < 1001; b++){
		c = Math.sqrt((a*a)+(b*b));
		hyp = (int)c;
		
		if (c == hyp){count ++;
		out.write("a= "+a + " b= "+b+" c = " +hyp + " (a^2 + b^2 = c^2)\n");
		}
		
		}// for b
	}//for a
out.write("\n\n total count count = "+count); 	
		   out.close();
		   }catch (Exception e){//Catch exception if any
      System.err.println("Error: " + e.getMessage());
	}

}
}
