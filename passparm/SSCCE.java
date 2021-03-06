import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Area;
import javax.swing.*;

public class SSCCE extends JFrame implements ActionListener {

    //Variable declaration
    JLabel LengthLabel = new JLabel("Length");
    JLabel WidthLabel = new JLabel("Width");
    JLabel Area = new JLabel();
    JLabel Perimeter = new JLabel();
    JLabel Volume = new JLabel();
    JTextField Length = new JTextField();
    JTextField Width = new JTextField();
    int LengthInt;
    int WidthInt;
    String LengthStr;
    String WidthStr;
    JDialog dialog;
    Color darkGreen = new Color(50, 150, 50);
    JButton close = new JButton("Close");
    boolean visi = true;
    JButton go = new JButton("Go");

    public SSCCE() {
        super("Geometry");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout grid = new GridLayout(20, 10);

        setLayout(grid);

        add(LengthLabel);
        add(Length);
        add(WidthLabel);
        add(Width);
        add(go);
        add(Area);
        add(Perimeter);
        go.addActionListener(this);
        setVisible(true);
    }
    JPanel p = new JPanel();
    int x = 100;
    int y = 50;
    int h;
    int w;

    private void Dodrawing(Graphics g, int w, int h, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillRect(x, y, w, h);
    }

    protected void paintComponent(Graphics g) {
        p.paintComponents(g);

        //Graphics, width, heigth, x coordinate, y coordinate
        Dodrawing(g, w, h, x, y);
    }

    //Action Peformed method
    public void actionPerformed(ActionEvent e) {
        //Getting the text from the input fields
        LengthStr = Length.getText().toString();
        WidthStr = Width.getText().toString();
        try {
            LengthInt = Integer.parseInt(LengthStr);
            WidthInt = Integer.parseInt(WidthStr);
            init();
        } catch (Exception event) {
            System.out.println(event);
        }
    }

    protected void init() {

        dialog = new JDialog(this, "Copie", true);
        dialog.setResizable(false);

        dialog.add(p);

        dialog.pack();
        Dimension Size = Toolkit.getDefaultToolkit().getScreenSize();
        dialog.setLocation(new Double((Size.getWidth() / 2) - (dialog.getWidth() / 2)).intValue(), new Double((Size.getHeight() / 2) - (dialog.getHeight() / 2)).intValue());
        dialog.setLayout(new BorderLayout());
        dialog.add(new DrawRectangle(WidthInt, LengthInt));
        dialog.pack();
        dialog.setSize(300, 200);
        dialog.setVisible(visi);
    }

    protected void close() {
        this.dialog.dispose();
        this.dialog.setVisible(false);
    }

    public static void main(String[] args) {
        SSCCE ge = new SSCCE();
    }
}

class DrawRectangle extends JPanel {

    int x = 100;
    int y = 50;
    int h = 100;
    int w = 100;

    DrawRectangle(int w, int h) {
        this.w = w;
        this.h = h;
    }

    private void Dodrawing(Graphics g, int w, int h, int x, int y) {
        g.setColor(Color.RED);
        g.fillRect(x, y, w, h);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("paintComponent");
        //Graphics, width, heigth, x coordinate, y coordinate
        Dodrawing(g, w, h, x, y);
    }
}
