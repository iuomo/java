class ConvertLoop {

	public static void main (String args[]){
		int n,d,i,r,q,h16,h1,z;
		char hc16, hc1;
		for (z = 0; z < 256; z++){
			n = z;
			d = 128;
			System.out.print(z+" = ");
			for (i = 0; i < 8 ; i++){
				q = (int)n/d;
				n = n % d;
				d = d / 2;
				System.out.print(q);
				if (i == 3) System.out.print(" ");
			}
				// start of hex convert
				 System.out.print(" = $");
	n = z;
		h16 = (int) n / 16;
		if (h16 > 9){
			hc16 = (char)(h16 + 55);}
			else {
			hc16 = (char)(h16 + 48);	
			}
		
		h1 = n % 16;
		if (h1 > 9){
			hc1 = (char)(h1 + 55);}
			else {
			hc1 = (char)(h1 + 48);	
			}
		h1 = n - h16*16;
		//hc1 = (char)h1 + 55;
		System.out.print(hc16);
		System.out.print(hc1);
		System.out.print(" "+(char)z+" * ");
		if ( z % 4 == 0)System.out.print("\n");
		}
	}
}
