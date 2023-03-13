import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame extends JFrame implements ActionListener {
    private Container c;
    private JButton button;
    private JLabel b1Label;
    private JTextField b1TextField;
    private JLabel b2Label;
    private JTextField b2TextField;
    private JLabel b3Label;
    private JTextField b3TextField;

    public MyFrame() {
        setBounds(400, 190, 390, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        b1Label = new JLabel("Перша сторона: ");
        b1Label.setFont(new Font("Times New Roman", Font.BOLD, 16));
        b1Label.setSize(120, 50);
        b1Label.setLocation(50, 30);
        c.add(b1Label);

        b1TextField = new JTextField();
        b1TextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b1TextField.setSize(80, 50);
        b1TextField.setLocation(180, 30);
        c.add(b1TextField);

        b2Label = new JLabel("Друга сторона: ");
        b2Label.setFont(new Font("Times New Roman", Font.BOLD, 16));
        b2Label.setSize(120, 50);
        b2Label.setLocation(50, 110);
        c.add(b2Label);

        b2TextField = new JTextField();
        b2TextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b2TextField.setSize(80, 50);
        b2TextField.setLocation(180, 110);
        c.add(b2TextField);

        b3Label = new JLabel("Третя сторона: ");
        b3Label.setFont(new Font("Times New Roman", Font.BOLD, 16));
        b3Label.setSize(120, 50);
        b3Label.setLocation(50, 190);
        c.add(b3Label);

        b3TextField = new JTextField();
        b3TextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b3TextField.setSize(80, 50);
        b3TextField.setLocation(180, 190);
        c.add(b3TextField);

        button = new JButton("Обрахувати");
        button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        button.setSize(230, 50);
        button.setLocation(70, 320);
        button.addActionListener(this);
        c.add(button);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double b1, b2, b3, square, perimeter, halfPerimeter;
        boolean tag = true;

        b1TextField.setBorder(new BasicBorders.FieldBorder(Color.white, Color.white, Color.white, Color.white));
        b2TextField.setBorder(new BasicBorders.FieldBorder(Color.white, Color.white, Color.white, Color.white));
        b3TextField.setBorder(new BasicBorders.FieldBorder(Color.white, Color.white, Color.white, Color.white));

        try {
            b1 = Double.parseDouble(b1TextField.getText());
            b1 = b1 < 0 ? b1 * (-1) : b1;
        }
        catch (NumberFormatException ex) {
            tag = false;
            b1 = 0;
            b1TextField.setBorder(new BasicBorders.FieldBorder(Color.red, Color.red, Color.red, Color.red));
        }
        try {
            b2 = Double.parseDouble(b2TextField.getText());
            b2 = b2 < 0 ? b2 * (-1) : b2;
        }
        catch (NumberFormatException ex) {
            tag = false;
            b2 = 0;
            b2TextField.setBorder(new BasicBorders.FieldBorder(Color.red, Color.red, Color.red, Color.red));
        }
        try {
            b3 = Double.parseDouble(b3TextField.getText());
            b3 = b3 < 0 ? b3 * (-1) : b3;
        }
        catch (NumberFormatException ex) {
            tag = false;
            b3 = 0;
            b3TextField.setBorder(new BasicBorders.FieldBorder(Color.red, Color.red, Color.red, Color.red));
        }

        perimeter = b1 + b2 + b3;
        halfPerimeter = perimeter / 2;
        square = Math.sqrt(halfPerimeter * (halfPerimeter - b1) * (halfPerimeter - b2) * (halfPerimeter - b3));

        if (b1 + b2 <= b3 || b1 + b3 <= b2 || b2 + b3 <= b1)
            tag = false;

        if (tag) {
            ResultFrame f = new ResultFrame();
            f.setS(Double.toString(square));
            f.setP(Double.toString(perimeter));
        }
    }
}

class ResultFrame extends JFrame {

    private Container c;
    private JLabel s;
    private JLabel p;

    public ResultFrame() {
        setBounds(400, 190, 260, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        s = new JLabel("S = ");
        s.setFont(new Font("Times New Roman", Font.BOLD, 20));
        s.setSize(120, 50);
        s.setLocation(50, 50);
        c.add(s);

        p = new JLabel("P = ");
        p.setFont(new Font("Times New Roman", Font.BOLD, 20));
        p.setSize(120, 50);
        p.setLocation(50, 120);
        c.add(p);

        setVisible(true);
    }
    public void setS(String text) {
        s.setText(s.getText() + text);
    }
    public void setP(String text) {
        p.setText(p.getText() + text);
    }
}

class Draw {
    public static void main(String[] args ) throws Exception {
        MyFrame f = new MyFrame();
    }
}