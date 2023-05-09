import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

public class Data extends JFrame {
    DataConnect connection = new DataConnect("jdbc:ucanaccess://Lab_9/Baranchuk.accdb");
    DefaultTableModel tableModel;
    JTable table;
    Data() {
        System.out.println(connection.getRows());
        setTitle("Магазин");
        setPreferredSize(new Dimension(600, 400));
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
        });

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("Product Name");
        tableModel.addColumn("Number");
        tableModel.addColumn("Price");
        fillTable(connection.getDatabase());
        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton addInf = new JButton("Add");
        addInf.addActionListener(e -> add());

        JButton deleteInf = new JButton("Delete");
        deleteInf.addActionListener(e -> delete());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(addInf);
        buttonPanel.add(deleteInf);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    void fillTable(Object[][] data){
        for (int i = 0; i < connection.getRows(); i++){
            int id = (int) data[i][0];
            String productName = (String) data[i][1];
            String number = (String) data[i][2];
            int price = (int) data[i][3];
            tableModel.addRow(new Object[]{id, productName, number, price});
        }
    }

    void delete() {
        int[] selectedRows = table.getSelectedRows();
        for (int row : selectedRows) {
            int id = (int) table.getValueAt(row, 0);
            tableModel.removeRow(row);
            connection.deleteInfo(id);
        }
    }

    void add() {
        int price = 0;
        String productName = JOptionPane.showInputDialog("Enter Product Name:");
        String number = JOptionPane.showInputDialog("Enter Number:");
        String tx_price;
        tx_price = JOptionPane.showInputDialog("Enter Price:");
        try {
            price = Integer.parseInt(tx_price);
        } catch (NumberFormatException ignored) {}
        if (!Objects.equals(productName, "") && !Objects.equals(number, "") && price != 0) {
            tableModel.addRow(new Object[]{connection.getFreeID(), productName, number, price});
            connection.addNewInfo(productName, number, price);
        } else {
            JOptionPane.showMessageDialog(Data.this,
                    "Something went wrong. Row was not added", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
