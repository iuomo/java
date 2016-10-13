class Asc2 {

	public static void main (String a[]){	
		int i,j;
		j = 0;


		for (j = 0; j < 10; j++) System.out.print((char)7); 
		System.out.println("\n ----------------------------------------------------------\n");
			for (i = 32; i < 256; i++){
				
				System.out.print(i+"\t"+(char)i+"\t");
				if (i % 8 == 0) {System.out.println();
							
				}
			
			}
		}
	}



