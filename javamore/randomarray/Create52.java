import java.util.*;  
class Create52{

	public static void main (String args[]){
	
		int val, count,i,j,c;
		double dval;
			int max = 52;
			int a[] = new int[max];
			int b[] = new int[max];
			boolean ok;   
			
			for (i = 0; i < max; i++)	{a[i] = -1; b[i] = -1;}
			j = 0;c = 0;
			while  (j < max) {
				
				dval = Math.random()*max;
				val = (int)dval;
				ok = true;
				for (i = 0; i < j; i++){
					if (val == a[i]){
						ok = false;
						System.out.println (val+" "+a[j]+" j = "+j);
					}
					
					}//end j c	heck for duplicates
					if (ok){
						a[j] = val;
						b[j] = a[j];
						System.out.println (" j = "+j);
						j++;
						
					
				}
				c++;
				System.out.println (" count  = "+c);
			}//while	
			
			
				
			Arrays.sort(a);
			for (i=0 ; i < max; i++){ 
		
				System.out.print (a[i]+ " "+b[i]+" - ");
				
			}
			
			

			
	}
	//} // infinite for loop
}
