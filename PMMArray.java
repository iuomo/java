class PMMArray {
	public static void main (String a[]){	
		int nums[] = new int[10];
		int i, min, max;

		nums[0] = 90;
		nums[1] = -5;
		nums[2] = -655;
		nums[3] = 537;
		nums[4] = -5;
		nums[5] = 5;
		nums[6] = 378;
		nums[7] = -5;
		nums[8] = -1555;
		nums[9] = 1024;
			
		for( i = 0; i < 10; i++){
			System.out.print(nums[i]);
			System.out.print(" ");
		}
System.out.print(" \n\n");
	min = max = nums[0];
	for ( i = 1; i < 10; i++){
		if(nums[i] < min)min = nums[i];
		if(nums[i] > max)max = nums[i];
	}
	System.out.println("min -> "+min);
	System.out.println("max -> "+max);

}
}