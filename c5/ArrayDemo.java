import java.util.*;  

class CompareArrays{
	CompareArrays(int y[],int z[],int size){
		int i,match = 0;
		for (i = 0; i < size; i++){
				if (y[i]==z[i]) match++;		
		}
		System.out.println("match = "+match);
	}
}

class PrintArray{
	PrintArray(int z[],int size){
		int i;
		for (i = 0; i < size; i++){
				if ((i != 0 ) && (i % 10 == 0))
					System.out.println();
				System.out.print(z[i]+" ");
		}
	}
}

class ArrayDemo {

	public static void main (String args[]){
	
		int i,j,val;
	int miss = 0;
			int size = 100;
			int a[] = new int[100];
			int b[] = new int[100];
			boolean ok;   
			//build arrays
			for (i=0 ; i < 100; i++){ 
			
				ok = true;
				val = 1+(int) (Math.random()*100);
					for (j = 0; j < 100;j++)
						{if (val == a[j]) ok = false;}
					if (ok){
						a[i] = val;
						b[i] = val; // copy array
					}else{i--;}
				
			}
			//print arrays
			PrintArray pa = new PrintArray(a,100);
			System.out.println("array a \n\n");
			
			PrintArray pb = new PrintArray(b,100);
			System.out.println("array b \n");
			
			// sort array a[]
			Arrays.sort(a);
			
			PrintArray sa = new PrintArray(a,100);
			System.out.println("array a sorted \n\n");
			
			  CompareArrays ca = new CompareArrays (a,b,100);
			System.out.println("array a sorted \n\n");
 
		
}
}
