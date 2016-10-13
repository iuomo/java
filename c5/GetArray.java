class ReturnArray {
	int i,j;
		double num0[] = new double[100];
		
		double[] RAmethod(int choice){
			double num1[] = new double[100];double num2[] = new double[100];
			double num3[] = new double[100];double num4[] = new double[100];
			double num5[] = new double[100];double num6[] = new double[100];
			double num7[] = new double[100];double num8[] = new double[100];
			double num9[] = new double[100];
			for(i = 0; i < 100; i++){num1[i] = Math.random();}
			for(i = 0; i < 100; i++){num2[i] = Math.random()*10;}
			for(i = 0; i < 100; i++){num3[i] = Math.random()*100;}
			for(i = 0; i < 100; i++){num4[i] = Math.random()*1000;}
			for(i = 0; i < 100; i++){num5[i] = Math.random()*10000;}
			for(i = 0; i < 100; i++){num6[i] = Math.random()*100000;}
			for(i = 0; i < 100; i++){num7[i] = Math.random()*1000000;}
			for(i = 0; i < 100; i++){num8[i] = Math.random()*10000000;}
			for(i = 0; i < 100; i++){num9[i] = Math.random()*100000000;}
			switch (choice){
					case 1:
						for (j = 0; j < 100; j++){
							num0[j]=num1[j];
						}
						break;
					case 2:
						for (j = 0; j < 100; j++){
							num0[j]=num2[j];
						}		
						break;
					case 3:
						for (j = 0; j < 100; j++){
							num0[j]=num3[j];
						}		
						break;
					case 4:
						for (j = 0; j < 100; j++){
							num0[j]=num4[j];
						}		
						break;
		
				}//end swtich


				return num0;
		}
		
		}
	


class GetArray {
  public static void main(String args[]) {
	int n,j;
	double thearray[] = new double[100]; 
       	ReturnArray narray = new ReturnArray(); 
	for (n = 0; n < 10; n ++){
		thearray = narray.RAmethod(n);
			for (j = 0; j < 100; j++){
				System.out.print( thearray[j]+" ");
			}
	}
	}
}