package sw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import static sw.Main.*;

public class Sales_history extends javax.swing.JFrame {

    int current = 0;
    int temp = 0;

    public Sales_history() {
        initComponents();

        //스레드 부분
        Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {

                System.out.println("Refresh");
                System.out.println(current);
                if (temp != current) //주문이 들어오면
                {
                    int Cul = current - temp;
                    String Id = null;
                    String Menu_name = null;
                    String count = null;
                    ArrayList<String> Id_list = new ArrayList<>();
                    ArrayList<String> Menu_name_list = new ArrayList<>();
                    ArrayList<String> Count_list = new ArrayList<>();
                    try {

                        String sql = "select User_id, menu_name, count from cart order by time desc fetch first " + Cul + "rows only";   // DML 명령어
                        Connection con = DriverManager.getConnection(orcle_url, orcle_ID, orcle_PW); // DB 연결
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            Id = rs.getString("User_id");
                            Menu_name = rs.getString("menu_name");
                            count = rs.getString("count");
                            Id_list.add(Id);
                            Menu_name_list.add(Menu_name);
                            Count_list.add(count);
                        }
                        for(int i=0; i<Menu_name_list.size(); i++){
                            MakeTable(Id_list.get(i), Menu_name_list.get(i), Count_list.get(i));
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
    
        public void MakeTable(String id, String Menu, String Count) {
        int iCntRow;
        iCntRow = jTable1.getRowCount();
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            if (jTable1.getValueAt(i, 0) == null) {
                iCntRow = i;
                break;
            }
        }
        jTable1.setValueAt(id, iCntRow, 0);
        jTable1.setValueAt(Menu, iCntRow, 1);
        jTable1.setValueAt(Count, iCntRow, 2);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Time = new javax.swing.JPanel();
        lblBack1 = new javax.swing.JLabel();
        lblTimeMan2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

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
                {null, null, null}
            },
            new String [] {
                "아이디", "메뉴", "수량"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jButton1.setText("확인");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(jButton1))
                    .addGroup(TimeLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
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
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 757, Short.MAX_VALUE)
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

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblBack1;
    private javax.swing.JLabel lblTimeMan2;
    // End of variables declaration//GEN-END:variables
}
