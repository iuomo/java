class OperatingOnStrings {
	public static void main (String args[]){
		//read page 193-194
		String str1 = new String("Java strings are objects.");
		String str2 = "This is another string.";
		String str3;
		str3 = str2;
		int idx, t;
		System.out.println(str1);
			System.out.println(str2);
				System.out.println(str3);
				
				String test = str1.substring(0,3);
				System.out.println(test);
				t = test.compareTo("Jav");
				
				System.out.println("t = "+t);
				
					
					idx = str1.indexOf("s");
							System.out.print("First index of ");
					System.out.println(idx);
					
						idx = str1.lastIndexOf("s");
								System.out.print("Last index of ");
					System.out.println(idx);
					
	}
}
