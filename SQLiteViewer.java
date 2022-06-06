package viewer;

import javax.swing.*;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.*;
import java.awt.event.ActionListener;

public class SQLiteViewer extends JFrame {

    JTextField fileNameTextField;
    JButton openFileButton;
    JComboBox<String> tablesComboBox;
    JTextArea queryTextArea;
    JButton execute;
    JTable table;

    ActionProcessor actionProcessor;

    public SQLiteViewer() {


        setTitle("SQLite Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
        setResizable(false);
        setLocationRelativeTo(null);

        initComponents();

        setVisible(true);

        actionProcessor = new ActionProcessor(this);


    }

    protected void initComponents() {

        fileNameTextField = new JTextField();
        fileNameTextField.setPreferredSize(new Dimension(500,30));
        fileNameTextField.setName("FileNameTextField");
        fileNameTextField.setEditable(true);

        add(fileNameTextField);



        openFileButton = new JButton();
        openFileButton.setPreferredSize(new Dimension(80, 30));
        openFileButton.setName("OpenFileButton");
        openFileButton.setText("Open");

        add(openFileButton);

        tablesComboBox = new JComboBox<>();
        tablesComboBox.setPreferredSize(new Dimension(600, 30));
        tablesComboBox.setName("TablesComboBox");
        tablesComboBox.setEditable(true);

        add(tablesComboBox);

        queryTextArea = new JTextArea();
        queryTextArea.setPreferredSize(new Dimension(400, 80));
        queryTextArea.setName("QueryTextArea");
        queryTextArea.setEditable(true);
        queryTextArea.setEnabled(false);

        add(queryTextArea);

        execute = new JButton();
        execute.setPreferredSize(new Dimension(80, 30));
        execute.setName("ExecuteQueryButton");
        execute.setText("Execute");
        execute.setEnabled(false);

        add(execute);

        table = new JTable();
        table.setPreferredSize(new Dimension(600, 300));
        table.setName("Table");

        add(table);

        JScrollPane scrollPane = new JScrollPane(table,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(610, 310));
        scrollPane.setViewportBorder(new MetalBorders.ScrollPaneBorder());


        add(scrollPane);

    }

    public void setOpenListener(ActionListener l) {
        openFileButton.addActionListener(l);
    }
    public void setComboBoxListener(ActionListener l) {
        tablesComboBox.addActionListener(l);
    }
    public void setExecuteListener(ActionListener l) {
        execute.addActionListener(l);
    }


}
