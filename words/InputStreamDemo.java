import java.io.*; 
/*

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InputStreamDemo {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("words.txt");
            outputStream = new FileWriter("characteroutput.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}

} */
public class InputStreamDemo {
	public static void main(String[] args) throws IOException {
    	     char clist[] = new char[1000];
    	     char copylist[] = new char[1000];
    	     int ilist[] = new int[1000];
    	     int nc;  //new character
    	     int i, c,count;
    	     count = 0;
    	     // *****************************  this code was obtained from Oracle
    	     FileReader inputStream = null;
    	     try { inputStream = new FileReader("words2.txt");
    	          while ((c = inputStream.read()) != -1) {
    	          	  ilist[count] = c;
    	          	 // clist[count] = (char)c;
    	          	  count++;
            }
             System.out.println("."+count+".");
             } finally { if (inputStream != null) {inputStream.close();}
        }//end of finally and try
        System.out.println("******************************************");
       // ***************************** 
      //  int val;
    //    char ncar;
        //   for (i = 0; i < count ; i ++){
            //	System.out.print (clist[i]);
            	//val = (int)clist[i];
            	//nc = val+7;
            	//copylist[i] = (char)nc;
            //	copylist[i] = clist[i];
         // }
        
            for (i = 0; i < count ; i ++){
            	System.out.print (" "+ilist[i]+" - ");
            }
            
    }
}

