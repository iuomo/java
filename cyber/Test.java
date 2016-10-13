import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestStringIntDouble {
    public static void main(String[] args) throws IOException { 
    	    String s;
    	    int i = 0;
    	    double d = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter String: ");
        s = br.readLine();
        System.out.print("Enter an Integer: ");
        try{
            i = Integer.parseInt(br.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }
        System.out.print("Enter a Double:");
        try{
            d = Double.parseDouble(br.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }
        
        System.out.println("String "+s);
        System.out.println("Integer "+i);
         System.out.println("Double "+ d);
    }
}
