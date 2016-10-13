import java.util.Scanner;

public class SuperSecure {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String input = in.next();
    
    //cwc added this
 
	//System.out.print(" - ");
	//	System.out.print(in.next());
	//	System.out.print(" - > ");
	//				System.out.print(input);
	//			System.out.print(" <- ");
		
    if(input.length() != 10) {
      System.out.println("LOL no");
      System.exit(0);
    }
    String changed = change(input);
   // if(changed.equals("fvbl}bf334"))
    if(changed.equals("dddddddddd")) {
      System.out.println("Awesome!");
      System.out.println("The flag is: " + input);
    } else {
      System.out.println("LOL no");
    }
   }
   
   
   private static String change(String s) {
    char[] temp = new char[10];
    for(int i = 0; i < s.length(); i++) {
      temp[i] = (char)(s.charAt(i) + 3);
        System.out.println(temp);
    }
    return new String(temp);
  }
}
