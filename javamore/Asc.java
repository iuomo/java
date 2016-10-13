class Asc {

  public static void main (String a[]){
   
   int i;
   char c;
   for (i = 0 ;i < 256; i++){
	   c = (char)i;
	if (i % 5 == 0) System.out.println();	
	System.out.print (i+ " = " + c + " ");
	
   }
	}

}
