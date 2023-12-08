package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import functions.*;
import functions.factory.*;
import javax.swing.table.DefaultTableModel;

public class GUI extends JFrame{
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JPanel centre;
    private JPanel inputPanel;
    private JPanel tablePanel;
    private JPanel chooseFunPanel;
    private JButton button = new JButton();
    private JTable table;
    private JTextField countNum;
    private JTextField interval;
    private JComboBox funBox;

    public GUI() {
        this.setTitle("Tabulated Function");

        funBox.addItem("SqrFunction");
        funBox.addItem("IdentityFunction");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
