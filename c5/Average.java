class Average {

	public static void main (String args[]){
		int c[] = new int[10];
		int j,sum;
		c[0] = 1;
		c[1] = 2;
		c[2] = 3;
		c[3] = 4;
		c[4] = 5;
		c[5] = 6;
		c[6] = 7;
		c[7] = 8;
		c[8] = 9;
		c[9] = 10;
		int l = c.length;
			System.out.println("lenght of the array "+l);
		sum = 0;
		for (j = 0; j < l;j ++)
			{System.out.println(sum);
				sum = sum + c[j];
			}
			System.out.println(sum);
			System.out.println("The average of the array is "+sum/l);
		
	}

}
