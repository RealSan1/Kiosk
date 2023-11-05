package sw;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
//import static sw.Main.Info;

import java.sql.*;
import java.util.*;

import javax.swing.table.DefaultTableModel;
import static sw.Main.Info;
import static sw.Main.orcle_ID;
import static sw.Main.orcle_PW;
import static sw.Main.orcle_url;

/**
 *
 * @author 산
 */
public class Order extends javax.swing.JFrame {

    int counts = 1;
    Cart cart;
    Cart cart1;
    private static javax.swing.Timer timer;
    int hour,min,sec,remain,uhour,umin,usec,elapsed;

    public Order() {
        initComponents();
//        lblUser.setText(Info.getUser_Name());
//        lblRtIme.setText(Info.getUser_RemainTime());
//        lblUtime.setText(Info.getUser_UseTime());
    }
    public Order(String name, String remaintime, String usetime){
        initComponents();
        lblUser.setText(name);
        long rmTime = Integer.parseInt(remaintime);//분 단위
        lblRtIme.setText(remaintime);
        lblUtime.setText(usetime);lblUser.setText(name);
        remain = Integer.parseInt(remaintime);//남은 시간
        min = remain%60;
        sec = 0;
        hour = remain/60;
        elapsed = 0;//사용시간 계산하기 위해 필요 
        uhour = elapsed/60;
        umin = elapsed%60;
        usec = 0;
        
        timer = new javax.swing.Timer(60000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                remain--;
                elapsed++;
                if(remain==30){
                    JOptionPane.showMessageDialog(null,name+"님의 이용시간이 "+remain+"분 남았습니다.");
                }else if(remain == 10){
                    JOptionPane.showMessageDialog(null, name+"님의 이용시간이 "+remain+"분 남았습니다.");
                }else if(remain == 5){
                    JOptionPane.showMessageDialog(null, name+"님의 이용시간이 "+remain+"분 남았습니다.");
                }
                int hours = remain/60;
                int mins = remain%60;
                int uhours = elapsed/60;
                int umins = elapsed%60;
                lblRtIme.setText(String.format("%02d:%02d",hours,mins));
                lblUtime.setText(String.format("%02d:%02d",uhours,umins));
            }
        });
        timer.start();
        lblRtIme.setText(String.format("%02d:%02d",hour,min));
        lblUtime.setText(String.format("%02d:%02d",uhour,umin));
    }
    
    public void Timer(){    //타이머 메소드
        Timer t = new Timer();
        TimerTask tm = new TimerTask(){
            @Override
            public void run() {
                
            }
        };
        t.schedule(tm,120);
    }
    

    public class MakeRowData {

        public String Menu;
        public int Count;
        public int Price;
    }

    public void MakeTable(String menu, int count, int price) {
        int iCntRow;
        iCntRow = jTable1.getRowCount();
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            if (jTable1.getValueAt(i, 0) == null) {
                iCntRow = i;
                break;
            }
        }

        jTable1.setValueAt(menu, iCntRow, 0);
        jTable1.setValueAt(count, iCntRow, 1);
        jTable1.setValueAt(price, iCntRow, 2);

    }

    public void CountTable(String Menu, int count, int price) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String targetValue = Menu;
        int targetRow = -1; // 초기값으로 -1 설정

        for (int row = 0; row < model.getRowCount(); row++) {
            String cellValue = (String) model.getValueAt(row, 0); // 0은 열 인덱스
            if (cellValue.equals(targetValue)) {
                targetRow = row;
                break;
            }
        }
        jTable1.setValueAt(count, targetRow, 1);
        jTable1.setValueAt(count * price, targetRow, 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Order = new javax.swing.JPanel();
        subPanel = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        btnOrder = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtPrice = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblRemainTime = new javax.swing.JLabel();
        lblUsedTime = new javax.swing.JLabel();
        btnAddTime = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblUser = new javax.swing.JLabel();
        lblRtIme = new javax.swing.JLabel();
        lblUtime = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Menu = new javax.swing.JTabbedPane();
        Food = new javax.swing.JPanel();
        Ramen = new javax.swing.JPanel();
        RamenBtn = new javax.swing.JButton();
        RamenBtn1 = new javax.swing.JButton();
        Snack = new javax.swing.JPanel();
        Sncak1 = new javax.swing.JPanel();
        Can = new javax.swing.JPanel();
        Topping = new javax.swing.JPanel();
        Cafe = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(970, 535));

        Order.setBackground(new java.awt.Color(35, 35, 35));
        Order.setMinimumSize(new java.awt.Dimension(1072, 606));
        Order.setPreferredSize(new java.awt.Dimension(1072, 606));
        Order.setRequestFocusEnabled(false);

        subPanel.setBackground(new java.awt.Color(80, 80, 80));
        subPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnReset.setBackground(new java.awt.Color(204, 204, 204));
        btnReset.setFont(new java.awt.Font("맑은 고딕", 1, 16)); // NOI18N
        btnReset.setText("장바구니 비우기");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnOrder.setBackground(new java.awt.Color(204, 204, 204));
        btnOrder.setFont(new java.awt.Font("맑은 고딕", 1, 16)); // NOI18N
        btnOrder.setText("주문하기");
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(204, 204, 204));
        btnDelete.setFont(new java.awt.Font("맑은 고딕", 1, 16)); // NOI18N
        btnDelete.setText("선택 메뉴 삭제");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtPrice.setEditable(false);
        txtPrice.setBackground(new java.awt.Color(204, 204, 204));
        txtPrice.setFont(new java.awt.Font("맑은 고딕", 1, 16)); // NOI18N
        txtPrice.setText("가격 : ");
        txtPrice.setFocusable(false);

        lblName.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("이름");

        lblRemainTime.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        lblRemainTime.setForeground(new java.awt.Color(255, 255, 255));
        lblRemainTime.setText("잔여시간");

        lblUsedTime.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        lblUsedTime.setForeground(new java.awt.Color(255, 255, 255));
        lblUsedTime.setText("사용시간");

        btnAddTime.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        btnAddTime.setText("시간 충전");

        btnExit.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        btnExit.setText("종료");

        lblUser.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setText("홍길동");

        lblRtIme.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        lblRtIme.setForeground(new java.awt.Color(255, 255, 255));
        lblRtIme.setText("00:00");

        lblUtime.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        lblUtime.setForeground(new java.awt.Color(255, 255, 255));
        lblUtime.setText("00:00");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "메뉴", "수량", "가격"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout subPanelLayout = new javax.swing.GroupLayout(subPanel);
        subPanel.setLayout(subPanelLayout);
        subPanelLayout.setHorizontalGroup(
            subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelLayout.createSequentialGroup()
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(txtPrice)))
                    .addGroup(subPanelLayout.createSequentialGroup()
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(lblRemainTime)
                            .addComponent(lblUsedTime))
                        .addGap(95, 99, Short.MAX_VALUE)
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblRtIme)
                            .addComponent(lblUser)
                            .addComponent(lblUtime))
                        .addGap(18, 18, 18)
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        subPanelLayout.setVerticalGroup(
            subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subPanelLayout.createSequentialGroup()
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName)
                            .addComponent(lblUser))
                        .addGap(9, 9, 9)
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRemainTime)
                            .addComponent(lblRtIme))
                        .addGap(9, 9, 9)
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsedTime)
                            .addComponent(lblUtime)))
                    .addGroup(subPanelLayout.createSequentialGroup()
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddTime, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(txtPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Menu.setBackground(new java.awt.Color(80, 80, 80));
        Menu.setForeground(new java.awt.Color(255, 255, 255));
        Menu.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N

        Food.setBackground(new java.awt.Color(80, 80, 80));

        javax.swing.GroupLayout FoodLayout = new javax.swing.GroupLayout(Food);
        Food.setLayout(FoodLayout);
        FoodLayout.setHorizontalGroup(
            FoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 636, Short.MAX_VALUE)
        );
        FoodLayout.setVerticalGroup(
            FoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
        );

        Menu.addTab("식사", Food);

        Ramen.setBackground(new java.awt.Color(80, 80, 80));

        RamenBtn.setText("Raman");
        RamenBtn.setToolTipText("");
        RamenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RamenBtnActionPerformed(evt);
            }
        });

        RamenBtn1.setText("Ramen2");
        RamenBtn1.setToolTipText("");
        RamenBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RamenBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RamenLayout = new javax.swing.GroupLayout(Ramen);
        Ramen.setLayout(RamenLayout);
        RamenLayout.setHorizontalGroup(
            RamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RamenLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(RamenBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(RamenBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(358, Short.MAX_VALUE))
        );
        RamenLayout.setVerticalGroup(
            RamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RamenLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(RamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RamenBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RamenBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(344, Short.MAX_VALUE))
        );

        Menu.addTab("라면", Ramen);

        Snack.setBackground(new java.awt.Color(80, 80, 80));

        javax.swing.GroupLayout SnackLayout = new javax.swing.GroupLayout(Snack);
        Snack.setLayout(SnackLayout);
        SnackLayout.setHorizontalGroup(
            SnackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 636, Short.MAX_VALUE)
        );
        SnackLayout.setVerticalGroup(
            SnackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
        );

        Menu.addTab("간식", Snack);

        Sncak1.setBackground(new java.awt.Color(80, 80, 80));

        javax.swing.GroupLayout Sncak1Layout = new javax.swing.GroupLayout(Sncak1);
        Sncak1.setLayout(Sncak1Layout);
        Sncak1Layout.setHorizontalGroup(
            Sncak1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 636, Short.MAX_VALUE)
        );
        Sncak1Layout.setVerticalGroup(
            Sncak1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
        );

        Menu.addTab("과자", Sncak1);

        Can.setBackground(new java.awt.Color(80, 80, 80));

        javax.swing.GroupLayout CanLayout = new javax.swing.GroupLayout(Can);
        Can.setLayout(CanLayout);
        CanLayout.setHorizontalGroup(
            CanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 636, Short.MAX_VALUE)
        );
        CanLayout.setVerticalGroup(
            CanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
        );

        Menu.addTab("캔음료", Can);

        Topping.setBackground(new java.awt.Color(80, 80, 80));

        javax.swing.GroupLayout ToppingLayout = new javax.swing.GroupLayout(Topping);
        Topping.setLayout(ToppingLayout);
        ToppingLayout.setHorizontalGroup(
            ToppingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 636, Short.MAX_VALUE)
        );
        ToppingLayout.setVerticalGroup(
            ToppingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
        );

        Menu.addTab("토핑", Topping);

        Cafe.setBackground(new java.awt.Color(80, 80, 80));

        javax.swing.GroupLayout CafeLayout = new javax.swing.GroupLayout(Cafe);
        Cafe.setLayout(CafeLayout);
        CafeLayout.setHorizontalGroup(
            CafeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 636, Short.MAX_VALUE)
        );
        CafeLayout.setVerticalGroup(
            CafeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
        );

        Menu.addTab("카페음료", Cafe);

        javax.swing.GroupLayout OrderLayout = new javax.swing.GroupLayout(Order);
        Order.setLayout(OrderLayout);
        OrderLayout.setHorizontalGroup(
            OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(subPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        OrderLayout.setVerticalGroup(
            OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(subPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Order, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Order, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RamenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RamenBtnActionPerformed
        boolean status = false;
        int rowCount = jTable1.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            Object value = jTable1.getValueAt(i, 0);
            if (value != null && value.toString().equalsIgnoreCase(cart.getMenu())) {
                status = true;
                break;
            }
        }
        if (!status) {
            // 버튼 최초 클릭시
            cart = new Cart(RamenBtn.getText(), 1, 2000);
            MakeTable(cart.getMenu(), cart.getCount(), cart.getPrice());

            //다음 주문내역을 위한 테이블 생성
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            Object[] reowData = {null, null, null};
            model.addRow(reowData);
        } else {
            // 수량 추가
            counts = cart.getCount();
            counts += 1;
            cart.setCount(counts);
            CountTable(cart.getMenu(), cart.getCount(), cart.getPrice());
        }

    }//GEN-LAST:event_RamenBtnActionPerformed

    private void RamenBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RamenBtn1ActionPerformed
        boolean status = false;
        int rowCount = jTable1.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            Object value = jTable1.getValueAt(i, 0);
            if (value != null && value.toString().equalsIgnoreCase(RamenBtn1.getText())) {
                status = true;
                break;
            }
        }
        if (!status) {
            // 버튼 최초 클릭시
            cart1 = new Cart(RamenBtn1.getText(), 1, 1000);
            MakeTable(cart1.getMenu(), cart1.getCount(), cart1.getPrice());
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            Object[] reowData = {null, null, null};
            model.addRow(reowData);
        } else {
            // 수량 추가
            counts = cart1.getCount();
            counts += 1;
            cart1.setCount(counts);
            CountTable(cart1.getMenu(), cart1.getCount(), cart1.getPrice());
        }
    }//GEN-LAST:event_RamenBtn1ActionPerformed

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
        //DB접속
        ArrayList<String> Date = new ArrayList<String>();
        String User_ID;
        String Menu;
        String Count;
        String Price;
        int GetSize = jTable1.getRowCount() - 1; // 행 개수 구하기
        for (int i = 0; i < GetSize; i++) {
            Menu = jTable1.getValueAt(i, 0).toString();
            Count = jTable1.getValueAt(i, 1).toString();
            Price = jTable1.getValueAt(i, 2).toString();
            Date.add(Menu);
            Date.add(Count);
            Date.add(Price);
        }

        try {
            String sql = "insert into Cart(USER_ID, MENU_NAME, COUNT, PRICE)" + "values (?,?,?,?)"; // DML 명령어
            Connection con = DriverManager.getConnection(Main.orcle_url, Main.orcle_ID, Main.orcle_PW); // DB 연결
            PreparedStatement pstmt = con.prepareStatement(sql);
            for (int i = 0; i < GetSize; i++) {
                pstmt.setString(1, Info.getUser_ID());
                pstmt.setString(2, Date.get(i * 3));
                pstmt.setString(3, Date.get(1 + i * 3));
                pstmt.setString(4, Date.get(2 + i * 3));
                pstmt.executeUpdate(); //입력값 DB 업데이트
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("DB Error");
        }


    }//GEN-LAST:event_btnOrderActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //메뉴 제거
        MakeRowData objRowData;
        Vector myVC = new Vector();

        int iCntRow = 0;
        iCntRow = jTable1.getSelectedRow();

        DefaultTableModel jTableModel = (DefaultTableModel) jTable1.getModel();

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            if (jTable1.getValueAt(i, 0) != null) {
                objRowData = new MakeRowData();
                objRowData.Menu = jTable1.getValueAt(i, 0).toString();
                objRowData.Count = Integer.parseInt(jTable1.getValueAt(i, 1).toString());
                objRowData.Price = Integer.parseInt(jTable1.getValueAt(i, 2).toString());
                myVC.add(objRowData);
            } else {
                break;
            }
        }

        myVC.removeElementAt(iCntRow);
        jTableModel.removeRow(iCntRow);

        for (int i = 0; i < myVC.size(); i++) {
            objRowData = (MakeRowData) myVC.get(i);
            jTable1.setValueAt(objRowData.Menu, i, 0);
            jTable1.setValueAt(objRowData.Count, i, 1);
            jTable1.setValueAt(objRowData.Price, i, 2);
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object[] reowData = {null, null, null};
        model.addRow(reowData);
    }//GEN-LAST:event_btnResetActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Cafe;
    private javax.swing.JPanel Can;
    private javax.swing.JPanel Food;
    private javax.swing.JTabbedPane Menu;
    private javax.swing.JPanel Order;
    private javax.swing.JPanel Ramen;
    private javax.swing.JButton RamenBtn;
    private javax.swing.JButton RamenBtn1;
    private javax.swing.JPanel Snack;
    private javax.swing.JPanel Sncak1;
    private javax.swing.JPanel Topping;
    private javax.swing.JButton btnAddTime;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnReset;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblRemainTime;
    private javax.swing.JLabel lblRtIme;
    private javax.swing.JLabel lblUsedTime;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUtime;
    private javax.swing.JPanel subPanel;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
