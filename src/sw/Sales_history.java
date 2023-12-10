package sw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import static sw.Main.*;

public class Sales_history extends javax.swing.JFrame {

    int current = 0;
    int temp = 0;
    ArrayList<String> Menu_name_temp = new ArrayList<>();

    public Sales_history() {
        initComponents();
        ((DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER); //head 가운데 정렬

        //스레드 부분
        Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {

                if (temp != current && temp != 0) //주문이 들어오면
                {
                    JOptionPane.showMessageDialog(null, "새로운 주문이 있습니다.");
                    int Cul = current - temp;
                    String Id = null;
                    String Menu_name = null;
                    String count = null;
                    String Time = null;
                    ArrayList<String> Id_list = new ArrayList<>();
                    ArrayList<String> Menu_name_list = new ArrayList<>();
                    ArrayList<String> Count_list = new ArrayList<>();
                    ArrayList<String> Time_list = new ArrayList<>();

                    try {

                        String sql = "select User_id, menu_name, count, time from cart order by time desc fetch first " + Cul + "rows only";   // DML 명령어
                        Connection con = DriverManager.getConnection(orcle_url, orcle_ID, orcle_PW); // DB 연결
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            Id = rs.getString("User_id");
                            Menu_name = rs.getString("menu_name");
                            count = rs.getString("count");
                            Time = rs.getString("time");
                            Id_list.add(Id);
                            Menu_name_list.add(Menu_name);
                            Menu_name_temp.add(Menu_name);
                            Count_list.add(count);
                            Time_list.add(Time);

                        }
                        Alert();
                        for (int i = 0; i < Menu_name_list.size(); i++) { //새로운 주문들어오면 테이블에 추가
                            MakeTable(Id_list.get(i), Menu_name_list.get(i), Count_list.get(i), Time_list.get(i));
                            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                            Object[] reowData = {null, null, null};
                            model.addRow(reowData);
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        System.out.println("DB Error");
                    }
                }
                temp = current; //저장
                GetSales();
            }
        }, 0, 1000); //1초마다 새로고침

    }

    public void MakeTable(String id, String Menu, String Count, String time) {
        int iCntRow;
        iCntRow = jTable1.getRowCount();
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            if (jTable1.getValueAt(i, 0) == null) {
                iCntRow = i;
                break;
            }
        }
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
        dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로

        TableColumnModel tcm = jTable1.getColumnModel(); // 정렬할 테이블의 컬럼모델을 가져옴

        //가운데 정렬
//      tcm.getColumn(0).setCellRenderer(dtcr);  
//      tcm.getColumn(1).setCellRenderer(dtcr);  
//      tcm.getColumn(2).setCellRenderer(dtcr);  
//      tcm.getColumn(3).setCellRenderer(dtcr);  
        jTable1.setValueAt(id, iCntRow, 0);
        jTable1.setValueAt(Menu, iCntRow, 1);
        jTable1.setValueAt(Count, iCntRow, 2);
        jTable1.setValueAt(time, iCntRow, 3);

        jTable1.getTableHeader().setReorderingAllowed(false);

    }

    public void GetSales() {
        try {
            String sql = "select count(*) from cart";   // DML 명령어
            Connection con = DriverManager.getConnection(orcle_url, orcle_ID, orcle_PW); // DB 연결
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                current = Integer.parseInt(rs.getString("count(*)"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("DB Error");
        }

    }

    public void Alert() {
        String Menu_name = null;
        ArrayList<String> Menu_name_list = new ArrayList<>();
        String Menu_count = null;
        ArrayList<String> Menu_count_list = new ArrayList<>();
        String name = "";
        try {
            String sql = "select Menu_name from menu where Menu_stock <= 5";   // DML 명령어
            Connection con = DriverManager.getConnection(orcle_url, orcle_ID, orcle_PW); // DB 연결
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Menu_name = rs.getString("Menu_name");
                Menu_name_list.add(Menu_name);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("DB Error");
        }
        List<String> commonElements = findCommonElements(Menu_name_list, Menu_name_temp);
        for (int i = 0; i < commonElements.size(); i++) {
            name += "'"+commonElements.get(i)+"'";
            if (i < commonElements.size() - 1) {
                name += ","; // 마지막 요소가 아닌 경우에만 쉼표 추가
            }
        }
        Menu_name_list.clear();
        Menu_name_temp.clear();
        
        try {
            String sql = "select Menu_name, Menu_stock from menu where Menu_name in ("+name+")";   // DML 명령어
            Connection con = DriverManager.getConnection(orcle_url, orcle_ID, orcle_PW); // DB 연결
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Menu_name = rs.getString("Menu_name");
                Menu_name_list.add(Menu_name);
                Menu_count = rs.getString("Menu_stock");
                Menu_count_list.add(Menu_count);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("DB Error");
        }
        
        for (int i = 0; i < Menu_name_list.size(); i++) {
            JOptionPane.showMessageDialog(null, Menu_name_list.get(i) + " 재고가 "+ Menu_count_list.get(i) +"개 남았습니다.");
        }

    }

    public static List<String> findCommonElements(List<String> list1, List<String> list2) {
        List<String> commonElements = new ArrayList<>(list1);
        commonElements.retainAll(list2);

        return commonElements;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        Time = new javax.swing.JPanel();
        lblBack1 = new javax.swing.JLabel();
        lblTimeMan2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Time.setBackground(new java.awt.Color(35, 35, 35));

        lblBack1.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblBack1.setForeground(new java.awt.Color(255, 255, 255));
        lblBack1.setText("◀");
        lblBack1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBack1MouseClicked(evt);
            }
        });

        lblTimeMan2.setFont(new java.awt.Font("맑은 고딕", 1, 22)); // NOI18N
        lblTimeMan2.setForeground(new java.awt.Color(255, 255, 255));
        lblTimeMan2.setText("주문 내역");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "아이디", "메뉴", "수량", "주문 시간"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        jButton1.setText("주문 내역 지우기");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        jButton2.setText("전체 주문 내역");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        jButton3.setText("선택 주문 지우기");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TimeLayout = new javax.swing.GroupLayout(Time);
        Time.setLayout(TimeLayout);
        TimeLayout.setHorizontalGroup(
            TimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TimeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TimeLayout.createSequentialGroup()
                        .addComponent(lblBack1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTimeMan2)
                        .addGap(259, 259, 259))
                    .addGroup(TimeLayout.createSequentialGroup()
                        .addGap(0, 73, Short.MAX_VALUE)
                        .addGroup(TimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(TimeLayout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)))))
                .addGap(76, 76, 76))
        );
        TimeLayout.setVerticalGroup(
            TimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TimeLayout.createSequentialGroup()
                .addGroup(TimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TimeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBack1))
                    .addGroup(TimeLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblTimeMan2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(TimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object[] reowData = {null, null, null};
        model.addRow(reowData);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lblBack1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBack1MouseClicked
        new Admin().setVisible(true);
        dispose();
    }//GEN-LAST:event_lblBack1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String Id = null;
        String Menu_name = null;
        String count = null;
        String Time = null;
        ArrayList<String> Id_list = new ArrayList<>();
        ArrayList<String> Menu_name_list = new ArrayList<>();
        ArrayList<String> Count_list = new ArrayList<>();
        ArrayList<String> Time_list = new ArrayList<>();
        try {

            String sql = "select User_id, menu_name, count, time from cart order by time desc";   // DML 명령어
            Connection con = DriverManager.getConnection(orcle_url, orcle_ID, orcle_PW); // DB 연결
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Id = rs.getString("User_id");
                Menu_name = rs.getString("menu_name");
                count = rs.getString("count");
                Time = rs.getString("time");
                Id_list.add(Id);
                Menu_name_list.add(Menu_name);
                Count_list.add(count);
                Time_list.add(Time);
            }
            for (int i = 0; i < Menu_name_list.size(); i++) { //새로운 주문들어오면 테이블에 추가
                MakeTable(Id_list.get(i), Menu_name_list.get(i), Count_list.get(i), Time_list.get(i));
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                Object[] reowData = {null, null, null};
                model.addRow(reowData);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("DB Error");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        MakeRowData objRowData;
        Vector myVC = new Vector();

        int iCntRow = jTable1.getSelectedRow();
        DefaultTableModel jTableModel = (DefaultTableModel) jTable1.getModel();

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            if (jTable1.getValueAt(i, 0) != null) {
                objRowData = new MakeRowData();
                objRowData.Id = jTable1.getValueAt(i, 0).toString();
                objRowData.Menu_name = jTable1.getValueAt(i, 1).toString();
                objRowData.Count = jTable1.getValueAt(i, 2).toString();
                objRowData.Time = jTable1.getValueAt(i, 3).toString();
                myVC.add(objRowData);
            } else {
                break;
            }
        }

        myVC.removeElementAt(iCntRow);
        jTableModel.removeRow(iCntRow);

        for (int i = 0; i < myVC.size(); i++) {
            objRowData = (MakeRowData) myVC.get(i);
            jTable1.setValueAt(objRowData.Id, i, 0);
            jTable1.setValueAt(objRowData.Menu_name, i, 1);
            jTable1.setValueAt(objRowData.Count, i, 2);
            jTable1.setValueAt(objRowData.Time, i, 3);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    public static class MakeRowData {
        public String Id;
        public String Menu_name;
        public String Count;
        public String Time;
    }
    
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sales_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Sales_history().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Time;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblBack1;
    private javax.swing.JLabel lblTimeMan2;
    // End of variables declaration//GEN-END:variables
}
