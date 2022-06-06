package viewer;

import org.sqlite.SQLiteDataSource;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DBConnection {

    SQLiteDataSource dataSource;

    public DBConnection(String url) {

        //Creating database file abstraction in java class
        this.dataSource = new SQLiteDataSource();
        dataSource.setUrl("jdbc:sqlite:" + url);

        //Connection//BEGIN
        try (Connection con = dataSource.getConnection()) {
            if (con.isValid(5)) {
                System.out.println("Connection is complete");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Connection//END
    }


    private void setStatement (String query) {

        //Connection//BEGIN
        try (Connection con = dataSource.getConnection()) {
            if (con.isValid(5)) {

                try (Statement statement = con.createStatement()) {

                    System.out.println("Query is executed");
                    //Setting up the query result into database//
                    statement.executeUpdate(query);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Connection//END

    }


    public List<String> getTableList() {

        List<String> tableList = new ArrayList<>();

        //Connection//BEGIN
        try (Connection con = dataSource.getConnection()) {

            if (con.isValid(5)) {
                Statement statement = con.createStatement();

                ResultSet resultSet = statement.executeQuery(
                        "SELECT name FROM sqlite_master WHERE type ='table' AND name NOT LIKE 'sqlite_%'");

                //Writing the TableList//BEGIN
                while (resultSet != null && resultSet.next()) {
                    tableList.add(resultSet.getString("name"));
                }
                //Writing the TableList//END

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Connection//END

        return tableList;

    }

    public TableModel getValuesList(String query) {

        TableModel model = new TableModel();

        //Connection//
        try (Connection con = dataSource.getConnection()) {
            if (con.isValid(5)) {

                Statement statement = con.createStatement();

                //Getting the answer from database//BEGIN
                ResultSet resultSet = statement.executeQuery(query);
                ResultSetMetaData metaData = resultSet.getMetaData();
                //Getting the answer from database//END

                //Setting up the columns into TableModel//BEGIN
                int columnsNumber = metaData.getColumnCount();
                String[] columns = new String[columnsNumber];

                for (int i = 0; i < columnsNumber; i++) {
                    columns[i] = metaData.getColumnName(i + 1);
                }
                model.setColumnNames(columns);
                //Setting up the columns into TableModel//END

                //Setting up the Values into TableModel//BEGIN
                while (resultSet.next()) {

                    Object[] row = new Object[columnsNumber];
                    for (int i = 0; i < columnsNumber; i++) {
                        row[i] = resultSet.getObject(i + 1);
                    }
                    model.addRow(row);
                }
                //Setting up the Values into TableModel//END

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new Frame(), e.getMessage());
        }
        //Connection//END

        return model;
    }

}
