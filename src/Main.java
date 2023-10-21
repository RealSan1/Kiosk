package sw;
import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author 산
 */
public class Main extends javax.swing.JFrame {
    
    static String orcle_url = "jdbc:oracle:thin:@localhost:1521:orcl"; //DB URL
    static String orcle_ID = "c##san"; //DB ID
    static String orcle_PW = "123"; // DB Password    
    /**
     * Creates new form Login
     */
    public Main() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Main = new javax.swing.JPanel();
        Login = new javax.swing.JPanel();
        Input_PW = new javax.swing.JPasswordField();
        Input_ID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Sing_Up = new javax.swing.JLabel();
        Find_PW = new javax.swing.JLabel();
        Order = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        User_name = new javax.swing.JLabel();

        Main.setBackground(new java.awt.Color(35, 35, 35));
        Main.setPreferredSize(new java.awt.Dimension(700, 500));
        Main.setLayout(new java.awt.CardLayout());

        Login.setBackground(new java.awt.Color(35, 35, 35));
        Login.setPreferredSize(new java.awt.Dimension(700, 500));

        Input_PW.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        Input_PW.setText("Password");
        Input_PW.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Input_PWFocusGained(evt);
            }
        });

        Input_ID.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        Input_ID.setText("ID");
        Input_ID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Input_IDFocusGained(evt);
            }
        });

        jButton1.setText("로그인");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Sing_Up.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        Sing_Up.setForeground(new java.awt.Color(255, 255, 255));
        Sing_Up.setText("계정 생성");
        Sing_Up.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Sing_UpMouseClicked(evt);
            }
        });

        Find_PW.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        Find_PW.setForeground(new java.awt.Color(255, 255, 255));
        Find_PW.setText("비밀번호 찾기");

        javax.swing.GroupLayout LoginLayout = new javax.swing.GroupLayout(Login);
        Login.setLayout(LoginLayout);
        LoginLayout.setHorizontalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addComponent(Sing_Up, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Find_PW))
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Input_ID)
                            .addComponent(Input_PW, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addGap(265, 265, 265))
        );
        LoginLayout.setVerticalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addComponent(Input_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Input_PW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Sing_Up)
                    .addComponent(Find_PW))
                .addContainerGap(216, Short.MAX_VALUE))
        );

        Main.add(Login, "card3");

        Order.setBackground(new java.awt.Color(35, 35, 35));
        Order.setPreferredSize(new java.awt.Dimension(700, 500));
        Order.setRequestFocusEnabled(false);

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("주문화면");

        User_name.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        User_name.setForeground(new java.awt.Color(255, 255, 255));
        User_name.setText("사용자 이름");

        javax.swing.GroupLayout OrderLayout = new javax.swing.GroupLayout(Order);
        Order.setLayout(OrderLayout);
        OrderLayout.setHorizontalGroup(
            OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderLayout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(User_name, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        OrderLayout.setVerticalGroup(
            OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(User_name, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(397, Short.MAX_VALUE))
        );

        Main.add(Order, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Sing_UpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Sing_UpMouseClicked
        new Setting().setVisible(true);

    }//GEN-LAST:event_Sing_UpMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean connection = false; //접속상태확인
        try {
            String sql = "select * from users"; //sql명령문
            Connection con = DriverManager.getConnection(orcle_url, orcle_ID, orcle_PW); // DB 연결
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // DB 접근과정
            
            while(rs.next()){ // 
                String User_ID = rs.getString("User_ID");
                String User_PW = rs.getString("User_PW");
                String User_Name = rs.getString("User_Name");
                if (User_ID.equals(Input_ID.getText()) && User_PW.equals(Input_PW.getText())){
                    connection = true; // ID랑 PW같다면 로그인
                 }
                }
                if (connection){
                    Login.setVisible(false);
                    Order.setVisible(true);
                } else{
                    JOptionPane.showMessageDialog(null, "등록된 아이디가 아닙니다.");
                }
            
        } catch (SQLException ex) {
            System.err.println("로그인 오류");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void Input_IDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Input_IDFocusGained
        //로그인 편의기능
        String status = Input_ID.getText();
        if(status.equals("ID")){
            Input_ID.setText(null);
        }
    }//GEN-LAST:event_Input_IDFocusGained

    private void Input_PWFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Input_PWFocusGained
        //로그인 편의기능
        String status = Input_PW.getText();
        if(status.equals("Password")){
            Input_PW.setText(null);
        }
    }//GEN-LAST:event_Input_PWFocusGained

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Find_PW;
    private javax.swing.JTextField Input_ID;
    private javax.swing.JPasswordField Input_PW;
    private javax.swing.JPanel Login;
    private javax.swing.JPanel Main;
    private javax.swing.JPanel Order;
    private javax.swing.JLabel Sing_Up;
    private javax.swing.JLabel User_name;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
