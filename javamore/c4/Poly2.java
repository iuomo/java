function  
(x -5)(3x+2)
y = 3x^2 + -13x -10
f(x) = 3x^2 + -13x -10

x   |   y
---------
-10	420
-8
-6
-4
-2
0 	-10
2
4
6
8
10      160


class Poly {
	public static void main (String az[]){
		int x;
		double y;
		System.out.println("x | y" );

		for (x = -10; x < 11; x = x + 2){
			//y = 3x^2 + -13x -10
			y = (3*x*x) + (-13*x) -10;
			System.out.println(x + " | " + y);
		}


	}

}


