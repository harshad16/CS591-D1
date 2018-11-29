package src.gui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
 
public class CustomTable<E> extends AbstractTableModel
{
	private final List<E> customList;
	  private final String[] columnNames;
	  private final Class[] columnClass;
//    private final String[] columnNames = new String[] {
//            "Id", "Name", "Hourly Rate", "Part Time"
//    };
//    private final Class[] columnClass = new Class[] {
//        Integer.class, String.class, Double.class, Boolean.class
//    };
 
    public CustomTable(List customlist,String[] Names, Class[] columnType)
    {	
      this.customList = customlist;
      this.columnNames = Names;
      this.columnClass = columnType;
    }
     
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }
 
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }
 
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
 
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return true;
    }

@Override
public Object getValueAt(int arg0, int arg1) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public int getRowCount() {
	// TODO Auto-generated method stub
	return 0;
}
 
}