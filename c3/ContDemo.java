class ContDemo {   
  public static void main(String args[]) { 
	double x; 
		double y;
   
    for(x = -10; x<=10; x++) {
			if ( x == 0) {
				   System.out.println("y is undefined"); 
				
				
				continue;
			}
			y =  (1 / (x*x));
			
      System.out.println(x+" -> "+y); 
    } 
  }   
}
