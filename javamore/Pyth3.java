class Pyth3 {
public static void main (String zip[]){


int a, b , hyp, count = 0;
double c;
	for ( a = 1; a < 1001; a++){
		for (b = 1; b < 1001; b++){
		c = Math.sqrt((a*a)+(b*b));
		hyp = (int)c;
		
		if (c == hyp){count ++;
		System.out.println("a= "+a + " b= "+b+" c = " +hyp + " (a^2 + b^2 = c^2)");
		}
		
		}// for b
	}//for a
System.out.println("count "+count); 
}
}
