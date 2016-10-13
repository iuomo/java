class FDemo {  
  int x;  
  
  FDemo(int i) {  
    x = i;  
  }    
 
  // called when object is recycled 
  protected void finalize() { 
    System.out.println("**************** Finalizing " + x); 
  } 
   
  // generates an object that is immediately destroyed 
  void generator(int i) { 
		   System.out.println("Creating object" + i); 
    FDemo o = new FDemo(i); 
  } 
 
}    
    
class Finalize{    
  public static void main(String args[]) {    
    int count; 
 
    FDemo ob = new FDemo(0); 
    for(count=1; count < 100000; count++) 
      ob.generator(count);  
  }    
}
