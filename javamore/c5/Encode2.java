class Encode {
	public static void main (String args[]){
		
		String key = "AAAAAAAAAA";
		String message = "This is a message.";
		String enmessage = "";
		char a = key.charAt(0);
		char b = key.charAt(1);
		char c = key.charAt(2);
		char d = key.charAt(3);
		char e = key.charAt(4);
		char f = key.charAt(5);
		char g = key.charAt(6);
		char h = key.charAt(7);
		
		//make a keycode
		int keycode = a|b|c|d|e|f|g|h;
		//keycode = keycode|;
		System.out.println(keycode);
		
		for (int i = 0;i < message.length();i++){
			enmessage = enmessage + (char) (message.charAt(i) ^ keycode);
		}
		System.out.println(enmessage);
	}
}

