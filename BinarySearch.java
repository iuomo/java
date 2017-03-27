class BinarySearch {
	
	public int binarySearch(int[] array, int key){
		int start = 0, mid;
		int end = array.length -1;
		while (start <= end){
				mid = (start + end) /2;
				if (key == array[mid]) {
					return mid;
				}
				if (key < array[mid]){
					end = mid -1;
				} else {
					start = mid + 1;
				}
		}
		return -1;
	}

	public static void main (String a[]){
		BinarySearch bs = new BinarySearch();
		
		int[ ]  primes = {2, 3, 5, 7, 11, 13, 17, 
			19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 
			61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 
			107, 109, 113, 127, 131, 137, 139, 149, 151, 
			157, 163, 167, 173, 179, 181, 191, 193, 197, 199};
		
			int search131 = bs.binarySearch(primes,31);
		
			System.out.println ("131 position:"+search131);
}
}
