class SumMatrix {
	static void calcsum (int m[][], int c, int r){
				int j,i,n, carry,temp; 
				int sum [] = new int[c+1]; 
				System.out.println("c = "+c+ " r = "+r);
					for (i = 0; i < c; i++){for (j = 0; j < r; j++){
						temp = m[i][j];sum[i] = sum[i] + temp;
					}}
				System.out.println("summation");
					for (i = 0; i < c; i++){
						if (i == 23)System.out.println();
							System.out.print(sum[i]+" ");
					}
					int l = sum.length-1;
					System.out.println();
					System.out.println(l+" = length");
					for (i = l; i > 0; i--){
						carry = 0;
					n = sum[i];
						if (sum[i] > 9){
							carry = (n - (n % 10))/10 ;
										sum[i-1] = sum[i-1] + carry;
										sum[i] = n % 10;
							}			
						if (i == 23)System.out.println();
							System.out.print(sum[i]+" ");
					}
									System.out.println();
						for (i = 0; i < sum.length; i++){
							System.out.print(sum[i]);
					}
						System.out.println();
}
}

class BuildMatrix {
	static void build(int m[][], int n, int c , int r){
		int swap [] = new int[c+10]; 
		int j,rr; int quotient = 1;int i  = 0;
		
		int divisor = 10;
		int dividend = n;
		int count;
			//	System.out.println("n ="+n);
				while (quotient != 0) {
					quotient = (int) (dividend / divisor); 
					rr = dividend - (quotient*10);
					dividend = quotient;
					swap[i] = rr;
				//	System.out.println(swap[i]);
					i++;
				}
		
		count = i;
		i--; //decrement i due to the i++;
		//System.out.println("n="+n+" c="+c+" r="+r+" m[][] = "+m[c][r]);
		for (j = 0; j < count; j++){	
			//digits[j] = swap[i];
		m[c][r] = swap[i];
	
		//System.out.println("n="+n+" c="+c+" r="+r+" m[][] = "+m[c][r]);
				//	m[0][0] = 7;
		//			System.out.println("j="+j);
			i--;
			c++;
		}
}
}


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

class Div89 {
	public static void main (String args[]){
		int i,j;int count = 1;
		int cols = 47;int rows = 45;
		int matrix[][] = new int[cols][rows];
		int fibinachi[] = new int[rows];
		// set matrix elemments to zero
		for (i = 0;i < cols; i++){for (j = 0;j < rows;j++){ matrix[i][j]= 0;}}
		LongDiv q2 = new LongDiv (1,89,cols);
		System.out.println (); 
		// calculate Fibinachi values
		int prev = 0;int div;int next = 1;int fib = 0;int d = 100;int col = 1; int row = 0;
		fibinachi[0] = 1;
		BuildMatrix.build(matrix,1,col,row);// first Fibinachi
		row ++;	col++;
		for (i = 1; i < (rows); i ++){
			fib = prev +  next;	prev = next; next = fib;
			fibinachi[i] = fib;
			
			if (fib == 13) col--;    
			if (fib == 144 )col--;      
if (fib == 1597) col--;  
if (fib == 10946) col--;        
if (fib == 121393) col--;         
if (fib == 1346269) col--;  
if (fib == 14930352) col--;       
if (fib == 102334155) col--;  

			BuildMatrix.build(matrix,fib,col,row);	
						
			row ++;	col++; 

		}
			row--;col--;
			SumMatrix.calcsum (matrix, cols-1, row);
		
			for (i = 0;i < (rows-1); i++){
					System.out.print((i+1)+" ");
					if  (fibinachi[i] < 10946){
				System.out.print(fibinachi[i]+"\t\t");
				}else {System.out.print(fibinachi[i]+"\t");}
				for (j = 0;j < (cols-1);j++){
					System.out.print(matrix[j][i]);
				}
				System.out.println();}
			
	}

	}
	                  

