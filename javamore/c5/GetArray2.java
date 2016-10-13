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

			switch (choice){
					case 1:
						for (j = 0; j < 100; j++){
							num0[j]=num1[j];
						}
						break;
					case 2:
						for (j = 0; j < 100; j++){
							num0[j]=num2[j];
								
						break;
		
				}//end swtich


			
		}
		return num0;
		}
	}


class GetArray2 {
  public static void main(String args[]) {
	int j;
	double thearray[] = new double[100]; 
       	ReturnArray narray = new ReturnArray(); 
	thearray = narray.RAmethod(1);
		for (j = 0; j < 100; j++){
			System.out.print( thearray[j]+" ");
		}
	}
}
