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
                    JOptionPane.showMessageDialog(null, "새로운 주문이 입력되었습니다.");
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
        for(int i=0; i<commonElements.size(); i++){
            JOptionPane.showMessageDialog(null, commonElements.get(i) +" 5개 이하 남았습니다.");
        }
        Menu_name_temp.clear();
        
        
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

        lblTimeMan2.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
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

        jButton1.setText("주문 확인");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("전체 주문 내역");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TimeLayout = new javax.swing.GroupLayout(Time);
        Time.setLayout(TimeLayout);
        TimeLayout.setHorizontalGroup(
            TimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TimeLayout.createSequentialGroup()
                .addGroup(TimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(TimeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBack1)
                        .addGap(304, 304, 304)
                        .addComponent(lblTimeMan2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(TimeLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        TimeLayout.setVerticalGroup(
            TimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TimeLayout.createSequentialGroup()
                .addGroup(TimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TimeLayout.createSequentialGroup()
                        .addGroup(TimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TimeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblBack1))
                            .addGroup(TimeLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(lblTimeMan2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39))
                    .addGroup(TimeLayout.createSequentialGroup()
                        .addGroup(TimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 789, Short.MAX_VALUE)
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
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblBack1;
    private javax.swing.JLabel lblTimeMan2;
    // End of variables declaration//GEN-END:variables
}
