import java.applet.*;
import java.awt.*;

public class TestApp extends Applet 
{
	public String hdr0;
	public String hdr1;
	
public String get() 
{
	getAppletContext().showStatus("Got here ok, hdr is: "+hdr0);
	return hdr0 + " -- ";
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

public void put0(String hdr0) 
{
	hdr = hdr0; repaint();
}

public void put1(String hdr1) 
{
	hdr = hdr1; repaint();
}

}
