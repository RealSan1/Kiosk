package sw;
import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author 산
 */
public class Main extends javax.swing.JFrame {
    static String orcle_url = "jdbc:oracle:thin:@116.39.188.187:1521:orcl"; //DB URL
    static String orcle_ID = "c##san"; //DB ID
    static String orcle_PW = "123"; // DB Password  
    static User_Info Info;

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
        Input_PW_TextField = new javax.swing.JPasswordField();
        Input_ID_TextField = new javax.swing.JTextField();
        Login_Button = new javax.swing.JButton();
        Sing_Up_Button = new javax.swing.JLabel();
        Find_PW_Button = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Order = new javax.swing.JPanel();
        User_Info_Panel = new javax.swing.JPanel();
        User_name_Text1 = new javax.swing.JLabel();
        User_RemainTime_Text1 = new javax.swing.JLabel();
        User_UseTime_Text1 = new javax.swing.JLabel();
        User_name_Text = new javax.swing.JLabel();
        User_RemainTime_Text = new javax.swing.JLabel();
        User_UseTime_Text = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("로그인 창");
        setMinimumSize(new java.awt.Dimension(970, 500));
        setName("frame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(970, 535));

        Main.setBackground(new java.awt.Color(35, 35, 35));
        Main.setPreferredSize(new java.awt.Dimension(970, 500));
        Main.setRequestFocusEnabled(false);
        Main.setLayout(new java.awt.CardLayout());

        Login.setBackground(new java.awt.Color(35, 35, 35));
        Login.setMinimumSize(new java.awt.Dimension(970, 500));
        Login.setPreferredSize(new java.awt.Dimension(970, 500));

        Input_PW_TextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        Input_PW_TextField.setText("Password");
        Input_PW_TextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Input_PW_TextFieldFocusGained(evt);
            }
        });

        Input_ID_TextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        Input_ID_TextField.setText("ID");
        Input_ID_TextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Input_ID_TextFieldFocusGained(evt);
            }
        });

        Login_Button.setText("로그인");
        Login_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_ButtonActionPerformed(evt);
            }
        });

        Sing_Up_Button.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        Sing_Up_Button.setForeground(new java.awt.Color(255, 255, 255));
        Sing_Up_Button.setText("계정 생성");
        Sing_Up_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Sing_Up_ButtonMouseClicked(evt);
            }
        });

        Find_PW_Button.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        Find_PW_Button.setForeground(new java.awt.Color(255, 255, 255));
        Find_PW_Button.setText("비밀번호 찾기");
        Find_PW_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Find_PW_ButtonMouseClicked(evt);
            }
        });

        jButton1.setText("종료");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LoginLayout = new javax.swing.GroupLayout(Login);
        Login.setLayout(LoginLayout);
        LoginLayout.setHorizontalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addComponent(Sing_Up_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Find_PW_Button))
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Input_ID_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Input_PW_TextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Login_Button)))
                .addGap(358, 358, 358))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(28, 28, 28))
        );
        LoginLayout.setVerticalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginLayout.createSequentialGroup()
                .addContainerGap(195, Short.MAX_VALUE)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addComponent(Input_ID_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Input_PW_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Login_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Find_PW_Button)
                    .addComponent(Sing_Up_Button))
                .addGap(174, 174, 174)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
        );

        Main.add(Login, "card3");

        Order.setBackground(new java.awt.Color(35, 35, 35));
        Order.setMinimumSize(new java.awt.Dimension(970, 500));
        Order.setPreferredSize(new java.awt.Dimension(970, 500));
        Order.setRequestFocusEnabled(false);

        User_Info_Panel.setBackground(new java.awt.Color(80, 80, 80));
        User_Info_Panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        User_name_Text1.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        User_name_Text1.setForeground(new java.awt.Color(255, 255, 255));
        User_name_Text1.setText("이름 :");

        User_RemainTime_Text1.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        User_RemainTime_Text1.setForeground(new java.awt.Color(255, 255, 255));
        User_RemainTime_Text1.setText("남은시간 :");
        User_RemainTime_Text1.setToolTipText("");

        User_UseTime_Text1.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        User_UseTime_Text1.setForeground(new java.awt.Color(255, 255, 255));
        User_UseTime_Text1.setText("사용시간 :");

        User_name_Text.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        User_name_Text.setForeground(new java.awt.Color(255, 255, 255));
        User_name_Text.setText("이름");

        User_RemainTime_Text.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        User_RemainTime_Text.setForeground(new java.awt.Color(255, 255, 255));
        User_RemainTime_Text.setText("0");
        User_RemainTime_Text.setToolTipText("");

        User_UseTime_Text.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        User_UseTime_Text.setForeground(new java.awt.Color(255, 255, 255));
        User_UseTime_Text.setText("0");

        javax.swing.GroupLayout User_Info_PanelLayout = new javax.swing.GroupLayout(User_Info_Panel);
        User_Info_Panel.setLayout(User_Info_PanelLayout);
        User_Info_PanelLayout.setHorizontalGroup(
            User_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(User_Info_PanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(User_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(User_Info_PanelLayout.createSequentialGroup()
                        .addGroup(User_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(User_RemainTime_Text1)
                            .addComponent(User_UseTime_Text1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addGroup(User_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(User_UseTime_Text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(User_RemainTime_Text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(User_Info_PanelLayout.createSequentialGroup()
                        .addComponent(User_name_Text1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(User_name_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        User_Info_PanelLayout.setVerticalGroup(
            User_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(User_Info_PanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(User_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(User_name_Text1)
                    .addComponent(User_name_Text))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(User_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(User_UseTime_Text1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(User_UseTime_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(User_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(User_RemainTime_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(User_RemainTime_Text1))
                .addContainerGap(137, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout OrderLayout = new javax.swing.GroupLayout(Order);
        Order.setLayout(OrderLayout);
        OrderLayout.setHorizontalGroup(
            OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrderLayout.createSequentialGroup()
                .addContainerGap(708, Short.MAX_VALUE)
                .addComponent(User_Info_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        OrderLayout.setVerticalGroup(
            OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(User_Info_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        Main.add(Order, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
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

    private void Sing_Up_ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Sing_Up_ButtonMouseClicked
        new Sing_Up().setVisible(true);

    }//GEN-LAST:event_Sing_Up_ButtonMouseClicked

    private void Login_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login_ButtonActionPerformed
        boolean connection = false; //접속상태확인     
        String User_ID = null; 
        String User_PW = null;
        String User_Name = null;
        String User_RemainTime = null;
        String User_UseTime = null;
            try {
            String sql = "select * from users"; //sql명령문
            Connection con = DriverManager.getConnection(orcle_url, orcle_ID, orcle_PW); // DB 연결
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // DB 접근과정
            
            while(rs.next()){ //DB 입력
                User_ID = rs.getString("User_ID");
                User_PW = rs.getString("User_PW");
                User_Name = rs.getString("User_Name");
                User_RemainTime = rs.getString("User_RemainTime");
                User_UseTime = rs.getString("User_UseTime");
                if (User_ID.equals(Input_ID_TextField.getText()) && User_PW.equals(Input_PW_TextField.getText())){
                    connection = true; // ID랑 PW같다면 로그인
                    break;
                 }
                }
                if (connection){  //로그인 완료 시                    
                    Info = new User_Info(User_ID, User_PW, User_Name, User_RemainTime, User_UseTime); //생성자
                    if (Info.getUser_RemainTime().equals("0")) {  // 만약 보유시간이 0이면 충전화면 출력
                        new AddTime().setVisible(true);
                    }
                    if (Info.getUser_RemainTime().equals("0")) {
                        new AddTime().setVisible(true); //만약 시간이 남은시간이 0이면 충전화면 창 뜨기
                        } else {
                        Login.setVisible(false);
                        Order.setVisible(true);
                        User_name_Text.setText(Info.getUser_Name());
                        User_RemainTime_Text.setText(Info.getUser_RemainTime());
                        }   
                } else{
                    JOptionPane.showMessageDialog(null, "등록된 아이디가 아닙니다.");
                }
            
         } catch (SQLException ex) {
            System.err.println("Login Error");
        }
             
    }//GEN-LAST:event_Login_ButtonActionPerformed

    private void Input_ID_TextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Input_ID_TextFieldFocusGained
        //로그인 편의기능
        String status = Input_ID_TextField.getText();
        if(status.equals("ID")){
            Input_ID_TextField.setText(null);
        }
    }//GEN-LAST:event_Input_ID_TextFieldFocusGained

    private void Input_PW_TextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Input_PW_TextFieldFocusGained
        //로그인 편의기능
        String status = Input_PW_TextField.getText();
        if(status.equals("Password")){
            Input_PW_TextField.setText(null);
        }
    }//GEN-LAST:event_Input_PW_TextFieldFocusGained

    private void Find_PW_ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Find_PW_ButtonMouseClicked
        //비밀번호 찾기
    }//GEN-LAST:event_Find_PW_ButtonMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JLabel Find_PW_Button;
    private javax.swing.JTextField Input_ID_TextField;
    private javax.swing.JPasswordField Input_PW_TextField;
    private javax.swing.JPanel Login;
    private javax.swing.JButton Login_Button;
    private javax.swing.JPanel Main;
    private javax.swing.JPanel Order;
    private javax.swing.JLabel Sing_Up_Button;
    private javax.swing.JPanel User_Info_Panel;
    private javax.swing.JLabel User_RemainTime_Text;
    private javax.swing.JLabel User_RemainTime_Text1;
    private javax.swing.JLabel User_UseTime_Text;
    private javax.swing.JLabel User_UseTime_Text1;
    private javax.swing.JLabel User_name_Text;
    private javax.swing.JLabel User_name_Text1;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
