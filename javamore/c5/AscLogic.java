class BinCon {
	int q1,q2,q3,q4,q5,q6,q7;//binary quotient
	int r1,r2,r3,r4,r5,r6,r7,r8;//binary remainder
	BinCon(int r1){
		q1 = r1 / 128;r2 = r1 % 128;q2 = r2 / 64;r3 = r2 % 64;
		q3 = r3 / 32;r4 = r3 % 32;q4 = r4 / 16;r5 = r4 % 16;
		q5 = r5 / 8;r6 = r5 % 8;q6 = r6 / 4;r7 = r6 % 4;
		q7 = r7 / 2;r8 = r7 % 2;
		System.out.print("\t"+q1+q2+q3+q4+q5+q6+q7+r8+"\n");
	}
}
class AscLogic {
	public static void main(String args[]){
	char c1,c2,c3;//character
	int n1,n2,n3;//number
//************************************************************************
	
	//System.out.println (b1|b2);
	//System.out.println (b1&b2);
	//System.out.println (b1^b2);

	System.out.println ("COMPARING INTEGERS");
	n1 = 7;		n2 = 11;
	System.out.print(n1+ " = \t");
	BinCon bc0 = new BinCon(n1);//class does a print
	System.out.print(n2+ " = \t");
	BinCon bc1 = new BinCon(n2);//class does a print
	n3 = (n1&n2);
	System.out.print(n1 +" AND "+ n2+ " = " + n3);
	BinCon bc2 = new BinCon(n3);//class does a print
	System.out.println ("\nCOMPARING CHARACTERS");
	c1 = 'A';		c2 = 'B';
	n1 = (int)c1;	n2 = (int)c2;
	System.out.print(c1+" = "+ (int)c1+" = ");
	BinCon bc3 = new BinCon(n1);//class does a print
	System.out.print(c2+" = "+ (int)c2+" = ");
	BinCon bc4 = new BinCon(n2);//class does a print
	

	n3 = (int)(c1|c2);
	System.out.print(c1 +" OR "+ c2+ " = " + n3);
	
	BinCon bc5 = new BinCon(n3);//class does a print
	System.out.println ();
	
	
	n3 = (int)(c1^c2);
	System.out.print(c1 +" XOR "+ c2+ " = " + n3);
	
	BinCon bc6 = new BinCon(n3);//class does a print
	System.out.println ();
	
	int w = ~7;
	System.out.println ("not 7 "+w);
	
	
//************************************************************************
	
		}
	}	

