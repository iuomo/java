class RoundVal {
// call from class s = v.round(s,1000);
double val;
double round (double v, double places){
int temp = 0;
if (v > 0)temp = (int)((v + 0.0005) * places);
if (v < 0)temp = (int)((v - 0.0005) * places);
val = (temp/places);
return val;
}
}

class Trig {
double degv, radv, sinv;
Trig (int deg){
radv = deg * (3.1416 / 180);

sinv = Math.sin(radv);
System.out.println(deg+ " | "+ radv+ " | "+sinv);
}

double getSin (){
return sinv;
}
}

class TrigTableObj {
public static void main (String args[]){
//Trig tv = new Trig(180);
//*******************************
// build array
double vsin;
int degrees = 0; //set angle equal to 0;
int incrementdegrees = 15;
int radians = 0;
while (degrees <= (360)){
Trig tv = new Trig(degrees);
//convert angle t to radians r
vsin = tv.getSin();
System.out.println(degrees+ ? ||| ?+ vsin);
degrees = degrees + incrementdegrees;// increase the angle by 15
}

}
}
