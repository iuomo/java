
class BubbleString {
		//arg[] is an array of strings
	public static void main (String args[]){
		
	String list[] =  {"ZOO","APE","CAN","RAN","FUN","AGE","TEA","BEE"};
		int size = list.length;
		String t,first,next;
		int compare;
		// buuble sort *************************************************
			int b,a;   
	for(a=1; a < size; a++)  
		 for(b=size-1; b >= a; b--) {  
			 next = list[b-1];
			 first = list[b];
			 compare =  next.compareTo(first);
			
	
			 if (compare > 0){ // if out of order  
				 // swap elements
				 t = list[b-1];
				 list[b-1] = list[b];  
				 list[b] = t;  							
			 }  
		 }
	System.out.println();
	for (int z = 0; z < size;z++)System.out.print(list[z]+" ");
	System.out.println();
	}
}

