// grep "parse" /home/cwc/java/*

class SphereVolume {
	public static void main (String args[]){
		double PI = 3.1416;
		double radius, volume;
		String temp;
		temp = args[0];
		
		radius = Double.parseDouble(temp); 

		volume = (4 / 3) * PI * radius * radius * radius;
		
		System.out.println("Volume of a sphere with a radius of "+radius);
		System.out.println("Volume = "+volume);
	}

}
