package viewer;

import javax.swing.*;
import java.awt.*;

public class ActionProcessor {

    DBConnection dbConnection;

    public ActionProcessor(SQLiteViewer viewer) {

        viewer.setOpenListener(actionEvent -> {

            //Creating connection to the database//
            this.dbConnection = new DBConnection(viewer.fileNameTextField.getText());
            switchComponents(viewer, false);

            //Checking for that database doesn't exist yet
            if (dbConnection.getTableList().isEmpty()) {
                JOptionPane.showMessageDialog(new Frame(), "File doesn't exist!");
            } else {

                //Activating components
                switchComponents(viewer, true);

                //Clearing the ComboBox from previous tableList//
                viewer.tablesComboBox.removeAllItems();

                //Writing new tableList into tablesComboBox//
                for (String table : dbConnection.getTableList()) {
                    viewer.tablesComboBox.addItem(table);
                }
            }
        });

        viewer.setComboBoxListener(actionEvent -> {

            String tableName = (String) viewer.tablesComboBox.getSelectedItem();
            viewer.queryTextArea.setText("SELECT * FROM " + tableName + ";");

        });

        viewer.setExecuteListener(actionEvent -> {

            TableModel tm = dbConnection.getValuesList(viewer.queryTextArea.getText());
            viewer.table.setModel(tm);

        });


    }

    private void switchComponents(SQLiteViewer viewer, boolean flag) {
        viewer.queryTextArea.setEnabled(flag);
        viewer.execute.setEnabled(flag);
    }


}
