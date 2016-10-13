class SwitchLoop{
	public static void main (String args[]){
	
	int x,y, zi;


	for (y = -10; y < 11; y++){
			for (x= -10; x < 11; x++){
					
			zi = (int) (Math.sqrt(x*y) *100);
			// start of switch		
			switch (zi){
						case 0:
							System.out.println("case 0 "+zi);
						case 1:
							System.out.println("case 1 "+zi);
						case 2:
							System.out.println("case 2 "+zi);
						default:
							System.out.println("case 3 "+zi);
				}//end switch
				
				
				
				}// end for x
				}// end for y
}
}
