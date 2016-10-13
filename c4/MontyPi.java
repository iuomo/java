// If there is a square 1 Unit by 1 Unit in dimension. And we randomly generate x and y coordinates less than 1 and greater than 0 10 million times.
// We can approximate pi by dividing the hits to the total darts multiplied by 4.
// This is called Monty Carlo Pi http://math.fullerton.edu/mathews/n2003/montecarlopimod.html
//  Compile and run this program.

class MontyPi {
	public static void main (String args[]){
		double ratio= 0;
		double dart = 0;
		double hit = 0;
		double x,y;
		int i;
 			for (i = 0;i < 100;i++){
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
