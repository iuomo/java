import java.awt.*;
import java.applet.*;
import java.io.*;

/*
<applet code="Poly2.class" width= 600 height=500>
<param name=red value=100>
<param name=green value=200>
<param name=blue value=0>
<param name=redA value=-10>
<param name=greenA value=-35>
<param name=blueA value=2>
<param name=limit value=20>
<param name=c1String value=-1.1>
<param name=c2String value=0>
</applet>
*/

public class Poly2 extends Applet  {
String input_c1,inout_c2;
int ired, igreen, iblue,redAjust, greenAjust, blueAjust,limit;
double c1,c2;

public void start() {
String temp;

temp = getParameter("red");
try { if(temp != null) ired = Integer.parseInt(temp);
else  ired = 0; } catch(NumberFormatException exc) {  ired = -1;  }

temp = getParameter("green");
try { if(temp != null) igreen = Integer.parseInt(temp);
else  igreen = 0; } catch(NumberFormatException exc) {  igreen = -1;  }

temp = getParameter("blue");
try { if(temp != null) iblue = Integer.parseInt(temp);
else  iblue = 0; } catch(NumberFormatException exc) {  iblue = -1;  }

temp = getParameter("redA");
try { if(temp != null) redAjust = Integer.parseInt(temp);
else  redAjust = 0; } catch(NumberFormatException exc) {  redAjust = -1;  }

temp = getParameter("greenA");
try { if(temp != null) greenAjust = Integer.parseInt(temp);
else  greenAjust = 0; } catch(NumberFormatException exc) {  greenAjust = -1;  }

temp = getParameter("blueA");
try { if(temp != null) blueAjust = Integer.parseInt(temp);
else  blueAjust = 0; } catch(NumberFormatException exc) {  blueAjust = -1;  }

temp = getParameter("limit");
try { if(temp != null) limit = Integer.parseInt(temp);
else  limit = 0; } catch(NumberFormatException exc) {  limit = -1;  }

temp = getParameter("c1String");
try { if(temp != null) c1 = Double.valueOf(temp).doubleValue();
else  c1 = 0; } catch(NumberFormatException exc) {  c1 = -1;  }

temp = getParameter("c2String");
try { if(temp != null) c2 = Double.valueOf(temp).doubleValue();
else  c2 = 0; } catch(NumberFormatException exc) {  c2 = -1;  }

}
//////////////////////////////////////////////////////////
// change stuff here
public void paint(Graphics g) {
int x,h,k;
double y;
g.setColor(new Color(255,255,255));
g.fillRect(0,0,650,700);
g.setColor(new Color(0,0,0));
g.drawString("Poly.java",300,50);
// draw and x y here
g.setColor(new Color(0,0,0));
g.drawString("X",505,255);
g.drawLine(10,250,500,250);
g.setColor(new Color(0,0,0));
g.drawLine(250,15,250,480);
g.drawString("Y",247,12);
//
for (x = -250 ; x < 250 ; x++) {
g.setColor(new Color(255,0,0));
h = 250 + x;
y = (x * x) + (2* x) + 1;
k = 250 - (int) y ;
g.drawLine(h,k,h,k);
g.fillRect(h,k,3,3);

}//end for j
}//end paint
// end change
///////////////////////////////////////////////////////

public void setREDajust(String temp) {
redAjust = Integer.parseInt(temp);

}

public void setGREENajust(String temp) {
greenAjust = Integer.parseInt(temp);

}
public void setBLUEajust(String temp) {
blueAjust = Integer.parseInt(temp);

}

public void setC1(String temp) {
c1 = Double.valueOf(temp).doubleValue();

}
public void setC2(String temp) {
c2 = Double.valueOf(temp).doubleValue();
repaint();
}

}// end Julia2
