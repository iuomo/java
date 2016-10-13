import java.applet.*;
import java.awt.*;

/*                      
<applet code="Ball.class" width= 800 height=600> 

</applet> 
*/ 



public class Ball extends Applet implements Runnable
{
	
	int x = 10;		
	int y = 10;	
	int xadj = 10;
	int yadj = 10;
	int radius = 20;	

	
	private Image dbImage;
	private Graphics dbg;

	public void init()
	{
		setBackground (Color.blue);
	}

	public void start ()
	{
		
		Thread th = new Thread (this);
		// Starten des Threads
		th.start ();
	}

	public void stop()
	{

	}

	public void destroy()
	{

	}

	public void run ()
	{
		// Erniedrigen der ThreadPriority um zeichnen zu erleichtern
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

		// Solange true ist läuft der Thread weiter
		while (true)
		{
			// Verändern der x- Koordinate
			x = x + xadj;
			y = y + yadj;

			// Neuzeichnen des Applets
			repaint();

			try
			{
				// Stoppen des Threads für in Klammern angegebene Millisekunden
				Thread.sleep (10);
			}
			catch (InterruptedException ex)
			{
				// do nothing
			}

			// Zurücksetzen der ThreadPriority auf Maximalwert
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		}
	}

	/** Update - Methode, Realisierung der Doppelpufferung zur Reduzierung des Bildschirmflackerns */
	public void update (Graphics g)
	{
		// Initialisierung des DoubleBuffers
		if (dbImage == null)
		{
			dbImage = createImage (this.getSize().width, this.getSize().height);
			dbg = dbImage.getGraphics ();
		}

		// Bildschirm im Hintergrund löschen
		dbg.setColor (getBackground ());
		dbg.fillRect (0, 0, this.getSize().width, this.getSize().height);

		// Auf gelöschten Hintergrund Vordergrund zeichnen
		dbg.setColor (getForeground());
		paint (dbg);

		// Nun fertig gezeichnetes Bild Offscreen auf dem richtigen Bildschirm anzeigen
		g.drawImage (dbImage, 0, 0, this);
	}

	public void paint (Graphics g)
	{
		g.setColor  (Color.red);

		g.fillOval (x - radius, y - radius, 2 * radius, 2 * radius);
	}
}

