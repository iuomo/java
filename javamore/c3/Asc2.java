class Asc2 {
	public static void main (String s[]){
	char c,d;
	for(int z = 33;z < 256;z++){
		
		c = (char) z;
		d = (char) (c - 32);
		System.out.println(z + " " +c +" - 32 " + d);
	}
}
}
