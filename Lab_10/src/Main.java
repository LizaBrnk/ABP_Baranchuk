import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class MyFrame extends JFrame {

    private Container c;
    private Container c2;
    private JTextArea area;

    public MyFrame() {
        setBounds(300, 100, 300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        area = new JTextArea(readFile());
        area.setSize(400, 400);
        area.setFont(new Font("Serif", Font.PLAIN, 20));
        c.add(area);

        setVisible(true);

        countSigns();
    }
    public String readFile() {
        String text = "  ";
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("C:\\Liza\\хай буде\\Input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            String str = "  ";
            while ((str = reader.readLine()) != null) {
                text += str;
                text += "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return text;
    }

    public void countSigns() {
        int count = 0;
        String text = readFile().replaceAll("\n", "");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("C:\\Liza\\хай буде\\Output.txt");
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == '.' || text.charAt(i) == ',' || text.charAt(i) == ':'
                        || text.charAt(i) == '-' || text.charAt(i) == ';' || text.charAt(i) == '?' || text.charAt(i) == '!')
                    count++;
            }
            fileWriter.write("COUNT: " + String.valueOf(count));
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        MyFrame f = new MyFrame();
    }
}