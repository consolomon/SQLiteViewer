package viewer;

import javax.swing.table.AbstractTableModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableModel extends AbstractTableModel {

    private List<String> columns;
    private List<Object[]> data;

    TableModel() {
        columns = new ArrayList<>();
        data = new ArrayList<>();

    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columns.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns.get(columnIndex);
    }

    public String[] getColumnNames() {
        if(columns.isEmpty())
            return new String[] {};
        else
            return columns.toArray(new String[0]);
    }

    public void setColumnNames(String[] columns) {
        if(!Arrays.equals(getColumnNames(), columns))
            this.data = new ArrayList<>();
        this.columns = Arrays.asList(columns);
        fireTableStructureChanged();
    }
    public void addRow(Object[] row) {
        data.add(row);
        fireTableRowsInserted(getRowCount(), getRowCount());
    }
}
