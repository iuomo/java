import java.applet.*;
import java.awt.*;

/*
  <html><head></head>
  <script language="JavaScript">
  function pass()
  {
    document.tstapp.put(document.a.in0.value);
    document.a.out0.value = document.tstapp.get();
  }
 
  </script>
<body>
	applet
  <applet name="tstapp" code="TestApp.class"  WIDTH=100 HEIGHT=30>
  </applet>
  form
  <form name=a action="x.htm">
  <input type=text name=in0>
  <input type=text name=out0>
  <input type=button value="Try" onClick="pass();">
  </form>
  </body>
  </html>
  
  */
  

public class TestApp extends Applet 
{
	public String hdr = "";

public String get() 
{
	getAppletContext().showStatus("Got here ok, hdr is: "+hdr);
	return hdr + " -- ";
}

public String getAppletInfo() 
{
	return "TestApp\n" + 
		"\n" + 
		"This type was created by StupidGuide.\n" + 
		"";
}

public void init() 
{
	super.init();
}

public void paint(Graphics g) 
{
	super.paint(g);
	g.drawString(hdr,5,15);
}

public void put(String hdr1) 
{
	hdr =  hdr1; repaint();
}

}
