class SwitchLoop{
	public static void main (String args[]){
	
	int i,zi;


	for (i = 0; i < 1000; i++){
			// start of switch	
			zi = i % 5;
			switch (zi){
				case 0:
					System.out.println("case 0 "+zi);
					break;
				case 1:
					System.out.println("case 1 "+zi);
					break;
				case 2:
					System.out.println("case 2 "+zi);
					break;
				default:
					System.out.println("default case 3 "+zi);
					break;
				}//end switch
				
				
				
				}// end for i
			
}
}
