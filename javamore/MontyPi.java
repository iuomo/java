class MontyPi {
	public static void main (String args[]){
		double ratio= 0;
		double dart = 0;
		double hit = 0;
		double x,y;
		int i;
 			for (i = 0;i < 10000000;i++){
				x = Math.random();
				y = Math.random();
				dart++;
				if (((x*x)+(y*y))<1.0)hit++;
					ratio = 4*(hit/dart);
					System.out.println(x+"\t"+y+"\t"+ratio);
		}
		System.out.println("pi is close to "+ratio);
	}
}
