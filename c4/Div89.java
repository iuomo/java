


class LongDiv {
	LongDiv ( long dividend,long divisor, int precision){
	long quotient = 0L;
	int i,j;
	int count = 1;
	System.out.println (dividend+" / "+divisor+ " = ");
	
	System.out.print (".");
	dividend = dividend *10L;
	for (i = 0; i < precision; i ++){
		quotient = (int) (dividend / divisor); 
		dividend = (dividend - (quotient * divisor))*10L;
		System.out.print (quotient);
		count ++;
	}
	}
	
	}

class LongDivision {
	public static void main (String args[]){

			LongDiv q2 = new LongDiv (1,89,50);
		
}
	                  

