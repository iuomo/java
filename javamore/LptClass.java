import java.lang.*;
import java.io.*; 

class TurnOn {  // turn on parallel bit for a specific time
	void go(int h,long i){
	String envp[] = null;			
	String workingDir="/home/cwc/java";
	String command = "lptout "+h;
	long t0, t1;
	try { 
		//System.out.println(command);
		Runtime.getRuntime().exec(command,envp,new java.io.File(workingDir)); 
		t0 =  System.currentTimeMillis();
		do{t1 = System.currentTimeMillis();}while (t1 - t0 < i);
		//dataOut.write(';');  
	 }catch(IOException exc){};
	 
	   // dataOut.close();
	

   
    }

}

class Delay {  // just do a delay loop

  void delay(long i) {  
	  //long delay = i;
	  long t0, t1;
	  t0 =  System.currentTimeMillis();
	  do{
	  	t1 = System.currentTimeMillis();
	  }while (t1 - t0 < i);	
  	}    
}



class LptClass {
	public static void main(String Arg[]) 	throws Exception {
		long n = 100;
		Delay d = new Delay();
		TurnOn g = new TurnOn();
		
	for(;;){	
		d.delay(n);		
		g.go(0,n);
		g.go(1,n);
		g.go(2,n);
		g.go(4,n);
		g.go(8,n);
		g.go(16,n);
		g.go(32,n);
		g.go(64,n);
		g.go(128,n);
		g.go(0,n);
		g.go(1,n);
		g.go(3,n);
		g.go(15,n);
		g.go(31,n);
		g.go(63,n);
		g.go(127,n);
		g.go(255,n);
	
	
	}


	}
}

