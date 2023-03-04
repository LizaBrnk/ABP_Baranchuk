import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class DrawGUI extends JFrame implements ActionListener{
    private Container c1;
    private Container c2;
    private JButton circleButton;
    private JButton squareButton;
    private JButton polygonButton;

    public DrawGUI(){
        setBounds(300, 90, 720, 560);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c1 = getContentPane();
        c1.setLayout(null);

        circleButton = new JButton("Намалювати коло");
        circleButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        circleButton.setSize(210, 50);
        circleButton.setLocation(30, 30);
        circleButton.addActionListener(this);
        c1.add(circleButton);

        squareButton = new JButton("Намалювати квадрат");
        squareButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        squareButton.setSize(210, 50);
        squareButton.setLocation(240, 30);
        squareButton.addActionListener(this);
        c1.add(squareButton);

        polygonButton = new JButton("Намалювати багатокутник");
        polygonButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        polygonButton.setSize(210, 50);
        polygonButton.setLocation(450, 30);
        polygonButton.addActionListener(this);
        c1.add(polygonButton);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Graphics graphics = getGraphics();
        c2 = new Container();
        if (e.getSource() == circleButton) {
            graphics.setColor(new Color(189, 29, 29));
            graphics.drawOval(30, 200, 150, 150);
            c2.paintComponents(graphics);
        } else if (e.getSource() == squareButton) {
            graphics.setColor(new Color(27, 153, 66));
            graphics.drawRect(260, 200, 150, 150);
            c2.paintComponents(graphics);
        } else if (e.getSource() == polygonButton) {
            graphics.setColor(new Color(17, 17, 161));
            int[] x = {550, 625, 600, 525, 500};
            int[] y = {250, 250, 350, 400, 300};
            graphics.drawPolygon(x, y, 5);
            c2.paintComponents(graphics);
        }
    }
}
