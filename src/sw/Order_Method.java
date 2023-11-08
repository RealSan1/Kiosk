package sw;

import javax.swing.table.DefaultTableModel;

public class Order_Method {
    
    public static class MakeRowData {
        public String Menu;
        public int Count;
        public int Price;
    }
    
    public void MakeTable(String menu, int count, int price) {
        int iCntRow;
        iCntRow = Order.order.jTable1.getRowCount();
        for (int i = 0; i < Order.order.jTable1.getRowCount(); i++) {
            if (Order.order.jTable1.getValueAt(i, 0) == null) {
                iCntRow = i;
                break;
            }
        }
        Order.order.jTable1.setValueAt(menu, iCntRow, 0);
        Order.order.jTable1.setValueAt(count, iCntRow, 1);
        Order.order.jTable1.setValueAt(price, iCntRow, 2);
    }
    
     public void CountTable(String Menu, int count, int price) {
        DefaultTableModel model = (DefaultTableModel) Order.order.jTable1.getModel();
        String targetValue = Menu;
        int targetRow = -1; // 초기값으로 -1 설정

        for (int row = 0; row < model.getRowCount(); row++) {
            String cellValue = (String) model.getValueAt(row, 0); // 0은 열 인덱스
            if (cellValue.equals(targetValue)) {
                targetRow = row;
                break;
            }
        }
        Order.order.jTable1.setValueAt(count, targetRow, 1);
        Order.order.jTable1.setValueAt(count * price, targetRow, 2);
    }
}
