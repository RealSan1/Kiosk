package sw;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;
import static sw.Main.Info;
import javax.swing.Timer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author 산
 */
public class AddTime extends javax.swing.JFrame {
    protected static Timer timer;
    static int remain, elapsed;
    static Order order;
    static boolean startTimer=false;
    static Main m;
    /**
     * Creates new form AddTime
     */
    public AddTime() {
        initComponents();
        User_Name_Text.setText(Info.getUser_Name());
        if(order == null){
            Order.timer_run=true;
            order = Order.getInstance();
        }
    }
    private static void MainCls(){
        if(m==null)
            m=Main.getInstance();
        if(m.isVisible())
            m.dispose();
        else
            m.setVisible(true);
    }
    
    private void btn_AddTime(int btn){
        JOptionPane.showMessageDialog(null,btn/60+"시간이 충전 되었습니다.");
        if(order.isVisible()){
            remain+=btn;
            SetTimePrt(remain,elapsed);
        }else{
            //MainCls();
            remain+=btn;
            SetTimePrt(remain,0);
            //if(!startTimer){Timer_m(); startTimer=true;}
            //order.setVisible(true);
        }
    }
    
    private static void SetTimePrt(int minute, int elapsed){
        int hour = minute/60;
        int min = minute%60;
        int uhour = elapsed/60;
        int umin = elapsed%60;
        Order.lblRtIme.setText(String.format("%02d:%02d",hour,min));
        Order.lblUtime.setText(String.format("%02d:%02d",uhour,umin));
    }
    
    protected static void Timer_m(){
        remain = Integer.parseInt(Info.getUser_RemainTime());
        timer = new javax.swing.Timer(60000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                remain--;
                elapsed++;
                if(remain == 10){
                    JOptionPane.showMessageDialog(null, Info.getUser_Name()+"님의 이용시간이 "+remain+"분 남았습니다.");
                }else if(remain == 5){
                    JOptionPane.showMessageDialog(null, Info.getUser_Name()+"님의 이용시간이 "+remain+"분 남았습니다.");
                }
                SetTimePrt(remain, elapsed);
                if(remain==0){
                    timer.stop();
                    System.exit(0);
                }
            }
        });
        timer.start();
        order.timer_run=true;
        SetTimePrt(remain, 0);
    }
    public void Call_DB(String Input_Time){
        //DB 시간추가 메소드
       
       String current_time = Info.getUser_RemainTime(); //사용자가 보유하고 시간
       int result = Integer.parseInt(Input_Time) + Integer.parseInt(current_time);  //String -> int
       Info.setUser_RemainTime(Integer.toString(result));
       
       try {
            String sql = "Update users set User_RemainTime = " + Info.getUser_RemainTime() +" where User_ID = '" + Info.getUser_ID() + "'"; // DML 명령어
            
            Connection con = DriverManager.getConnection(Main.orcle_url, Main.orcle_ID, Main.orcle_PW); // DB 연결
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("Time Update");
            
            } catch (SQLException ex) {
            System.err.println("Update Error");
        }
    }
    protected static void DBtimeUpdate(){
        try{
            String[] parts = Order.lblRtIme.getText().split(":");
            int remain = (Integer.parseInt(parts[0])*60+Integer.parseInt(parts[1]));
            parts = Order.lblUtime.getText().split(":");
            int use = (Integer.parseInt(parts[0])*60+Integer.parseInt(parts[1]));
            String sql = "Update users set User_RemainTime = ? where user_id = ?"; // DML 명령어
            String sql2 = "Update users set User_useTime = ? where user_id = ?";
            Connection con = DriverManager.getConnection(Main.orcle_url, Main.orcle_ID, Main.orcle_PW); // DB 연결
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, remain);
            pstmt.setString(2,Info.getUser_ID());
            pstmt.executeUpdate();
            pstmt = con.prepareStatement(sql2);
            pstmt.setInt(1, use);
            pstmt.setString(2,Info.getUser_ID());
            pstmt.executeUpdate();
            System.out.println("Time Update");
            if(order == null){
                order = Order.getInstance();
                order.dispose();
            }else{
                order.dispose();
            }
            //MainCls();
            Main.order=null;
            Order.timer_run=false;
            Order.order=null;
            elapsed = 0;
            startTimer=false;
            order=null;
            timer.stop();
            timer=null;
            
        }catch(SQLException ex){
            System.err.println("Update Error"+ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        AddTime_Label = new javax.swing.JLabel();
        AddTime_2 = new javax.swing.JButton();
        AddTime_1 = new javax.swing.JButton();
        AddTime_4 = new javax.swing.JButton();
        AddTime_3 = new javax.swing.JButton();
        AddTime_10 = new javax.swing.JButton();
        AddTime_5 = new javax.swing.JButton();
        Exit_Button = new javax.swing.JButton();
        User_Name_Text = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(35, 35, 35));

        jPanel1.setBackground(new java.awt.Color(35, 35, 35));
        jPanel1.setMinimumSize(new java.awt.Dimension(356, 402));
        jPanel1.setPreferredSize(new java.awt.Dimension(356, 402));

        AddTime_Label.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        AddTime_Label.setForeground(new java.awt.Color(255, 255, 255));
        AddTime_Label.setText("시간 충전");

        AddTime_2.setFont(new java.awt.Font("맑은 고딕", 1, 16)); // NOI18N
        AddTime_2.setText("2시간");
        AddTime_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTime_2ActionPerformed(evt);
            }
        });

        AddTime_1.setFont(new java.awt.Font("맑은 고딕", 1, 16)); // NOI18N
        AddTime_1.setText("1시간");
        AddTime_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTime_1ActionPerformed(evt);
            }
        });

        AddTime_4.setFont(new java.awt.Font("맑은 고딕", 1, 16)); // NOI18N
        AddTime_4.setText("4시간");
        AddTime_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTime_4ActionPerformed(evt);
            }
        });

        AddTime_3.setFont(new java.awt.Font("맑은 고딕", 1, 16)); // NOI18N
        AddTime_3.setText("3시간");
        AddTime_3.setToolTipText("");
        AddTime_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTime_3ActionPerformed(evt);
            }
        });

        AddTime_10.setFont(new java.awt.Font("맑은 고딕", 1, 16)); // NOI18N
        AddTime_10.setText("10시간");
        AddTime_10.setToolTipText("");
        AddTime_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTime_10ActionPerformed(evt);
            }
        });

        AddTime_5.setFont(new java.awt.Font("맑은 고딕", 1, 16)); // NOI18N
        AddTime_5.setText("5시간");
        AddTime_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTime_5ActionPerformed(evt);
            }
        });

        Exit_Button.setFont(new java.awt.Font("맑은 고딕", 1, 16)); // NOI18N
        Exit_Button.setText("닫기");
        Exit_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit_ButtonActionPerformed(evt);
            }
        });

        User_Name_Text.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        User_Name_Text.setForeground(new java.awt.Color(255, 255, 255));
        User_Name_Text.setText("사용자명");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Exit_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(145, 145, 145))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(User_Name_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddTime_2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(AddTime_5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(AddTime_10, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(AddTime_3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(AddTime_4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(AddTime_Label)))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addComponent(AddTime_1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(233, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddTime_Label)
                    .addComponent(User_Name_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(AddTime_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddTime_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddTime_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddTime_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddTime_10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(Exit_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(133, 133, 133)
                    .addComponent(AddTime_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(229, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddTime_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTime_1ActionPerformed
            Call_DB("60");
            btn_AddTime(60);
    }//GEN-LAST:event_AddTime_1ActionPerformed

    private void Exit_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit_ButtonActionPerformed
        dispose();
    }//GEN-LAST:event_Exit_ButtonActionPerformed

    private void AddTime_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTime_2ActionPerformed
        Call_DB("120");
        btn_AddTime(120);
    }//GEN-LAST:event_AddTime_2ActionPerformed

    private void AddTime_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTime_3ActionPerformed
        Call_DB("180");
        btn_AddTime(180);
    }//GEN-LAST:event_AddTime_3ActionPerformed

    private void AddTime_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTime_4ActionPerformed
        Call_DB("240");
        btn_AddTime(240);
    }//GEN-LAST:event_AddTime_4ActionPerformed

    private void AddTime_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTime_5ActionPerformed
        Call_DB("300");
        btn_AddTime(300);
    }//GEN-LAST:event_AddTime_5ActionPerformed

    private void AddTime_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTime_10ActionPerformed
        Call_DB("600");
        btn_AddTime(600);
    }//GEN-LAST:event_AddTime_10ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AddTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddTime().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddTime_1;
    private javax.swing.JButton AddTime_10;
    private javax.swing.JButton AddTime_2;
    private javax.swing.JButton AddTime_3;
    private javax.swing.JButton AddTime_4;
    private javax.swing.JButton AddTime_5;
    private javax.swing.JLabel AddTime_Label;
    private javax.swing.JButton Exit_Button;
    private javax.swing.JLabel User_Name_Text;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
