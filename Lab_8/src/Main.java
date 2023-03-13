import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.event.KeyEvent.*;

class MyFrame extends JFrame implements ActionListener {
    private Container c;
    private Container c2;
    private JMenuBar menuBar;
    private JMenuItem drawCircle;
    private JMenuItem drawSquare;
    private JMenuItem drawPolygon;

    public MyFrame() {
        setBounds(300, 90, 720, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();

        menuBar = new JMenuBar();

        drawCircle = new JMenuItem("Намалювати коло");
        drawCircle.addActionListener(this);
        drawCircle.setAccelerator(KeyStroke.getKeyStroke('C', SHIFT_DOWN_MASK));

        drawSquare = new JMenuItem("Намалювати квадрат");
        drawSquare.addActionListener(this);
        drawSquare.setAccelerator(KeyStroke.getKeyStroke('V', SHIFT_DOWN_MASK));

        drawPolygon = new JMenuItem("Намалювати багатокутник");
        drawPolygon.addActionListener(this);
        drawPolygon.setAccelerator(KeyStroke.getKeyStroke('B', SHIFT_DOWN_MASK));

        menuBar.add(drawCircle);
        menuBar.add(drawSquare);
        menuBar.add(drawPolygon);
        setJMenuBar(menuBar);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        Graphics graphics = getGraphics();
        c2 = new Container();
        graphics.clearRect(0, 200, 720, 210);
        if (e.getSource() == drawCircle) {
            graphics.setColor(new Color(189, 29, 29));
            graphics.drawOval(30, 200, 150, 150);
            c2.paintComponents(graphics);
        } else if (e.getSource() == drawSquare) {
            graphics.setColor(new Color(27, 153, 66));
            graphics.drawRect(260, 200, 150, 150);
            c2.paintComponents(graphics);
        } else if (e.getSource() == drawPolygon) {
            graphics.setColor(new Color(17, 17, 161));
            int[] x = {550, 625, 600, 525, 500};
            int[] y = {250, 250, 350, 400, 300};
            graphics.drawPolygon(x, y, 5);
            c2.paintComponents(graphics);
        }
        add(c2, BorderLayout.CENTER);
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        MyFrame f = new MyFrame();
    }
}