import java.awt.*;
import java.awt.event.*;
public class Main extends Frame {
    public void paint(Graphics g) {
        g.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));

        g.setColor(new Color(189, 29, 29));
        g.fillOval(50, 150, 100, 100);

        g.setColor(new Color(19, 19, 169));
        g.fillRect(210, 150, 100, 100);

        g.setColor(new Color(27, 153, 66));
        int[] x = {360, 400, 450, 450};
        int[] y = {250, 150, 150, 250};
        g.fillPolygon(x, y, 4);

        g.setColor(new Color(75, 75, 75));
        g.drawString("Червоний круг", 55, 300);
        g.drawString("Синій квадрат", 210, 300);
        g.drawString("Зелена трапеція", 350, 300);
    }
    public static void main(String[] args) {
        Frame f = new Main();
        f.setSize(500, 400);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
        });
    }
}