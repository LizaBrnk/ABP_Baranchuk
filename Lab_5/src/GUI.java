import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
class GUI extends JFrame {
    private Container c;
    private JLabel wIcon;
    private JLabel title;
    private JLabel title2;
    private JLabel name;
    private JTextField tname;
    private JLabel city;
    private JTextField tcity;
    private JLabel addr;
    private JTextField taddr;
    private JLabel contact;
    private JTextField tcontact;
    private JLabel phone;
    private JTextField tphone;
    private JLabel email;
    private JTextField temail;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;

    public GUI() {
        setTitle("Інформаціоне");
        setBounds(300, 90, 730, 560);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("C:\\Users\\lizab\\Downloads\\image.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        wIcon = new JLabel(new ImageIcon(image.getScaledInstance(55,100, java.awt.Image.SCALE_SMOOTH)));
        wIcon.setSize(100, 100);
        wIcon.setLocation(600, 30);
        c.add(wIcon);

        title = new JLabel("Інформація про організацію");
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        title.setSize(400, 35);
        title.setForeground(Color.BLUE);
        title.setLocation(30, 30);
        c.add(title);

        name = new JLabel("Назва *");
        name.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(30, 100);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        tname.setBorder(new BasicBorders.FieldBorder(Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE));
        tname.setSize(300, 30);
        tname.setLocation(250, 100);
        c.add(tname);

        city = new JLabel("Місто *");
        city.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        city.setSize(100, 20);
        city.setLocation(30, 150);
        c.add(city);

        tcity = new JTextField();
        tcity.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        tcity.setBorder(new BasicBorders.FieldBorder(Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE));
        tcity.setSize(300, 30);
        tcity.setLocation(250, 150);
        c.add(tcity);

        addr = new JLabel("Адреса *");
        addr.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        addr.setSize(100, 20);
        addr.setLocation(30, 200);
        c.add(addr);

        taddr = new JTextField();
        taddr.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        taddr.setBorder(new BasicBorders.FieldBorder(Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE));
        taddr.setSize(300, 30);
        taddr.setLocation(250, 200);
        c.add(taddr);

        title2 = new JLabel("Контактна особа");
        title2.setFont(new Font("Times New Roman", Font.BOLD, 30));
        title2.setSize(400, 35);
        title2.setForeground(Color.BLUE);
        title2.setLocation(30, 250);
        c.add(title2);

        contact = new JLabel("Контактна особа *");
        contact.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        contact.setSize(200, 20);
        contact.setLocation(30, 300);
        c.add(contact);

        tcontact = new JTextField();
        tcontact.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        tcontact.setBorder(new BasicBorders.FieldBorder(Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE));
        tcontact.setSize(300, 30);
        tcontact.setLocation(250, 300);
        c.add(tcontact);

        phone = new JLabel("Телефон *");
        phone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        phone.setSize(100, 20);
        phone.setLocation(30, 350);
        c.add(phone);

        tphone = new JTextField();
        tphone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        tphone.setBorder(new BasicBorders.FieldBorder(Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE));
        tphone.setSize(300, 30);
        tphone.setLocation(250, 350);
        c.add(tphone);

        email = new JLabel("E-mail *");
        email.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        email.setSize(100, 20);
        email.setLocation(30, 400);
        c.add(email);

        temail = new JTextField();
        temail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        temail.setBorder(new BasicBorders.FieldBorder(Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE));
        temail.setSize(300, 30);
        temail.setLocation(250, 400);
        c.add(temail);

        term = new JCheckBox("Хочу отримувати розсилку");
        term.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        term.setSize(250, 20);
        term.setLocation(30, 480);
        term.setSelected(true);
        c.add(term);

        reset = new JButton("Скасувати");
        reset.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        reset.setBackground(Color.RED);
        reset.setSize(140, 50);
        reset.setLocation(400, 450);
        c.add(reset);

        sub = new JButton("Надіслати");
        sub.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        sub.setBackground(Color.GREEN);
        sub.setSize(140, 50);
        sub.setLocation(560, 450);
        c.add(sub);

        setVisible(true);
    }
}