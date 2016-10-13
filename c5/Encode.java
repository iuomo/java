// Use XOR to encode and decode a message. 
class Encode {  
  public static void main(String args[]) { 
    String msg = "CHANGE THE TEXT OF THIS STRING";  
    String encmsg = ""; 
    String decmsg = ""; 
		String key = "secretcd";
	int j;
		// int key = 88; 
 
    System.out.print("Original message: "); 
    System.out.println(msg); 
		  System.out.println(key); 
 
    // encode the message 
		j = 0;
    for(int i=0; i < msg.length(); i++){ 
      	encmsg = encmsg + (char) (msg.charAt(i) ^ key.charAt(j)); 
				j++;
				if (j > 7) j = 0;
				System.out.print(" j "+j);
		}
    System.out.print("Encoded message: "); 
    System.out.println(encmsg); 
 
    // decode the message 
				j = 0;
		for(int i=0; i < msg.length(); i++) {
				decmsg = decmsg + (char) (encmsg.charAt(i) ^ key.charAt(j)); 
				j++;
				if (j > 7)  j = 0;
				System.out.print(" j "+j);
			}
				System.out.print("Decoded message: "); 
				System.out.println(decmsg); 
  } 
}

