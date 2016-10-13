class LongDiv {
	LongDiv ( long dividend,long divisor, int precision){
			long quotient = 0L;
			int i;
			System.out.println (dividend+" / "+divisor+ " = ");
			System.out.print (".");
			dividend = dividend *10L;
			for (i = 0; i < precision; i ++){
				quotient = (long) (dividend / divisor); 
				dividend = (dividend - (quotient * divisor))*10L;
				System.out.print (quotient);
			}//end for
	}//end constructor
}//end class LongDiv

class LongDivision {
	public static void main (String args[]){
		
		// LongDiv q1 = new LongDiv (22,7,100);
		System.out.println("\n"+1/89+"\n");
		System.out.println((double)1/89);
		LongDiv q2 = new LongDiv (1,89,90);
		System.out.println();
	}
}                  

