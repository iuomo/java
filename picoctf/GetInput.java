import java.util.*;

public class GetInput {
  public static void main(String[] args) {
    
        int i,j;
    
    System.out.print("Enter Password: ");
    Scanner s = new Scanner(System.in);
    String user_key = s.next();
    if (user_key.length() != 10) {
      System.out.println("You must know the number of characters.");
      return;
    }
    System.out.print("The key is : ");
    	    System.out.print(user_key);    
}
}
