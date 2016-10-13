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

class BubbleDemo {
		//arg[] is an array of strings
	public static void main (String args[]){
		String value = args[0];
		String value2 = args[1];
		System.out.println("value is "+value);
		System.out.println("value2 is "+value2);
		System.out.print("array length is ");
		System.out.println(args.length);
		
		
		int max = Integer.parseInt(value);
		System.out.println(max);
		int i,j,val,swap = 0;
		int scale = max*1000;
		int size = max;
		double after,now,totaltime;
			int list[] = new int[size];
			int list2[] = new int[size];
	

			//build arrays
			for (i=0 ; i < size; i++){ 
						list[i] = (int) (Math.random()*scale);
						 list2[i] = list[i];
				}
					PrintArray pa = new PrintArray(list,max);
			System.out.print ("before sort \n");
		now = System.currentTimeMillis();
		// buuble sort *************************************************
			int t,b,a;   
		 for(a=1; a < size; a++)  
      for(b=size-1; b >= a; b--) {  
        if(list[b-1] > list[b]) { // if out of order  
          // swap elements
					swap ++;
          t = list[b-1];
         list[b-1] = list[b];  
          list[b] = t;  
							
								
        }  
      }
		// end of bubble sort	
			after = System.currentTimeMillis();
			totaltime = (after - now)/1000;
			System.out.println("Bubble sort total time = "+totaltime+" seconds");
			System.out.println("swaps = "+swap);
		System.out.print ("\n");
		//		PrintArray pa2 = new PrintArray(list,max);
			
			
				now = System.currentTimeMillis();
				Arrays.sort(list2);
				after = System.currentTimeMillis();
			totaltime = (after - now)/1000;
			System.out.println("\n\n Arrays.sort total time = "+totaltime+" seconds");
			
	
}
}
