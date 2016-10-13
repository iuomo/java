
class OneD {
	public static void main(String args[]){
		int list[] = new int[15];
		int list2[] = new int[15];
		int c;
		int value = 100;
		// build array
		for (c = 0; c < 15;c++){
					list[c] = value;
					value = value + 10;
				}
		// reassign array
		list2 = list;
		
		list[9] = -9;
		// print array
		for (c = 0; c < list2.length;c++){
					System.out.print(list2[c]+" ");
				}
				System.out.println();
				
				for (c = 0; c < list.length;c++){
					System.out.print(list   [c]+" ");
				}
				System.out.println();
			
		}
}
		
