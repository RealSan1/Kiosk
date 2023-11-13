package sw;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import static sw.Main.*;

public class Order extends javax.swing.JFrame {

    ArrayList<Integer> prices = new ArrayList<Integer>(); //가격저장을 위한변수
    Order_Method OM = new Order_Method();
    int counts = 1;
    static Order order;
    static boolean timer_run;
    Cart Shin_Ramen;
    Cart RTA_Ramen;

    public String Setting_Price(String Menu_name) {
        // 메뉴가격, 재고를 DB에서 갖고오는 메소드
        String Price = null;
        String Inventory = null;
        try {
            String sql = "select Menu_Price,Menu_Inventory from menu where Menu_Name = '" + Menu_name + "'  ";   // DML 명령어
            Connection con = DriverManager.getConnection(orcle_url, orcle_ID, orcle_PW); // DB 연결
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Price = rs.getString("Menu_Price");
                Inventory = rs.getString("Menu_Inventory");
            }
            return Price;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("DB Error");
        }
        return "1000";
    }

    public Order() {
        if (order == null) {
            initComponents();
            order = this;
            int remain = Integer.parseInt(Info.getUser_RemainTime());
            int hour = remain/60;
            int min = remain%60;
            lblRtIme.setText(String.format("%02d:%02d",hour,min));
            if(!timer_run){AddTime.Timer_m();}
            lblUser.setText(Info.getUser_Name());
        }
    }

    public static Order getInstance() {
        if (order == null) {
            order = new Order();
        }
        return order;
    }

    static class HookThread extends Thread {

        //만약 사용자가 프로그램 강제 종료 시 잔여시간 DB전송
        //수정필요
        public void run() {
            AddTime.DBtimeUpdate();
            //사용자 잔여시간 DB전송(코드작성)
            System.out.println("Hook Run Test");
        }
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
        btnCountPlus = new javax.swing.JButton();
        btnCountMinus = new javax.swing.JButton();
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
        Find = new javax.swing.JPanel();
        Find_Menu = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();

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
        btnAddTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTimeActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        btnExit.setText("종료");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lblUser.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setText("홍길동");

        lblRtIme.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        lblRtIme.setForeground(new java.awt.Color(255, 255, 255));
        lblRtIme.setText("00:00");

        lblUtime.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        lblUtime.setForeground(new java.awt.Color(255, 255, 255));
        lblUtime.setText("00:00");

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "메뉴", "수량", "가격"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTable1);

        btnCountPlus.setBackground(new java.awt.Color(204, 204, 204));
        btnCountPlus.setFont(new java.awt.Font("맑은 고딕", 1, 16)); // NOI18N
        btnCountPlus.setText("선택 메뉴 +1");
        btnCountPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCountPlusActionPerformed(evt);
            }
        });

        btnCountMinus.setBackground(new java.awt.Color(204, 204, 204));
        btnCountMinus.setFont(new java.awt.Font("맑은 고딕", 1, 16)); // NOI18N
        btnCountMinus.setText("선택 메뉴 -1");
        btnCountMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCountMinusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout subPanelLayout = new javax.swing.GroupLayout(subPanel);
        subPanel.setLayout(subPanelLayout);
        subPanelLayout.setHorizontalGroup(
            subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
                            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelLayout.createSequentialGroup()
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCountPlus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(txtPrice)
                            .addComponent(btnCountMinus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCountPlus, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnCountMinus, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
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
            .addGap(0, 496, Short.MAX_VALUE)
        );

        Menu.addTab("식사", Food);

        Ramen.setBackground(new java.awt.Color(80, 80, 80));

        RamenBtn.setText("신라면");
        RamenBtn.setToolTipText("");
        RamenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RamenBtnActionPerformed(evt);
            }
        });

        RamenBtn1.setText("너구리");
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
                .addContainerGap(379, Short.MAX_VALUE))
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
            .addGap(0, 496, Short.MAX_VALUE)
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
            .addGap(0, 496, Short.MAX_VALUE)
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
            .addGap(0, 496, Short.MAX_VALUE)
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
            .addGap(0, 496, Short.MAX_VALUE)
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
            .addGap(0, 496, Short.MAX_VALUE)
        );

        Menu.addTab("카페음료", Cafe);

        Find.setBackground(new java.awt.Color(80, 80, 80));

        javax.swing.GroupLayout FindLayout = new javax.swing.GroupLayout(Find);
        Find.setLayout(FindLayout);
        FindLayout.setHorizontalGroup(
            FindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 636, Short.MAX_VALUE)
        );
        FindLayout.setVerticalGroup(
            FindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

        Menu.addTab("검색", null, Find, "");

        Find_Menu.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        Find_Menu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Find_MenuKeyTyped(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        lblSearch.setForeground(new java.awt.Color(255, 255, 255));
        lblSearch.setText("검색 :");

        javax.swing.GroupLayout OrderLayout = new javax.swing.GroupLayout(Order);
        Order.setLayout(OrderLayout);
        OrderLayout.setHorizontalGroup(
            OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OrderLayout.createSequentialGroup()
                        .addComponent(lblSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Find_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(subPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        OrderLayout.setVerticalGroup(
            OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(OrderLayout.createSequentialGroup()
                        .addGroup(OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Find_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(subPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(114, 114, 114))
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
        System.out.println(RamenBtn.getBounds());
        boolean status = false;
        String Price = null;
        int rowCount = jTable1.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            Object value = jTable1.getValueAt(i, 0);
            if (value != null && value.toString().equalsIgnoreCase(RamenBtn.getText())) {
                status = true;
                break;
            }
        }
        if (!status) {
            // 버튼 최초 클릭시
            Shin_Ramen = new Cart(RamenBtn.getText(), 1, Integer.parseInt(Setting_Price(RamenBtn.getText())));
            OM.MakeTable(Shin_Ramen.getMenu(), Shin_Ramen.getCount(), Shin_Ramen.getPrice());
            prices.add(Shin_Ramen.getPrice());
            //MakeTable(Shin_Ramen.getMenu(), Shin_Ramen.getCount(), Shin_Ramen.getPrice());

            //다음 주문내역을 위한 테이블 생성
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            Object[] reowData = {null, null, null};
            model.addRow(reowData);
            OM.ShowPrice();
        } else {
            // 수량 추가
            return;
//            counts = Shin_Ramen.getCount();
//            counts += 1;
//            Shin_Ramen.setCount(counts);
//            OM.CountTable(Shin_Ramen.getMenu(), Shin_Ramen.getCount(), Shin_Ramen.getPrice());
        }

    }//GEN-LAST:event_RamenBtnActionPerformed

    private void RamenBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RamenBtn1ActionPerformed
        System.out.println(RamenBtn1.getBounds());
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
            RTA_Ramen = new Cart(RamenBtn1.getText(), 1, 10000);
            OM.MakeTable(RTA_Ramen.getMenu(), RTA_Ramen.getCount(), RTA_Ramen.getPrice());
            prices.add(RTA_Ramen.getPrice());

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            Object[] reowData = {null, null, null};
            model.addRow(reowData);
            OM.ShowPrice();
        } else {
            // 수량 추가
            return;
//            counts = RTA_Ramen.getCount();
//            counts += 1;
//            RTA_Ramen.setCount(counts);
//            OM.CountTable(RTA_Ramen.getMenu(), RTA_Ramen.getCount(), RTA_Ramen.getPrice());
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
            JOptionPane.showMessageDialog(null, "주문이 완료되었습니다.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("DB Error");
        }


    }//GEN-LAST:event_btnOrderActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //메뉴 제거
        Order_Method.MakeRowData objRowData;
        Vector myVC = new Vector();

        int iCntRow = jTable1.getSelectedRow();
        DefaultTableModel jTableModel = (DefaultTableModel) jTable1.getModel();

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            if (jTable1.getValueAt(i, 0) != null) {
                objRowData = new Order_Method.MakeRowData();
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
        prices.remove(iCntRow);

        for (int i = 0; i < myVC.size(); i++) {
            objRowData = (Order_Method.MakeRowData) myVC.get(i);
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
        prices.clear();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        AddTime.DBtimeUpdate();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnAddTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTimeActionPerformed
        new AddTime().setVisible(true);
    }//GEN-LAST:event_btnAddTimeActionPerformed

    private void btnCountPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCountPlusActionPerformed
        int selectedRow = jTable1.getSelectedRow();

        // 선택된 행이 없는 경우 또는 선택된 행의 인덱스가 유효하지 않은 경우, 아무 작업도 수행하지 않음
        if (selectedRow == -1 || selectedRow >= jTable1.getRowCount()) {
            return;
        }
        // 현재 선택된 행의 "Count" 값을 가져와서 1을 증가시킴
        int currentValue = (int) jTable1.getValueAt(selectedRow, 1);
        int updatedValue = currentValue + 1;
        int price = prices.get(selectedRow);
        int sum = updatedValue * price;

        // 테이블 모델을 업데이트하여 변경된 값을 테이블에 반영
        jTable1.setValueAt(updatedValue, selectedRow, 1);
        jTable1.setValueAt(sum, selectedRow, 2);

        //전체 가격 출력
        OM.ShowPrice();
    }//GEN-LAST:event_btnCountPlusActionPerformed

    private void btnCountMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCountMinusActionPerformed
        int selectedRow = jTable1.getSelectedRow();

        // 선택된 행이 없는 경우 또는 선택된 행의 인덱스가 유효하지 않은 경우, 아무 작업도 수행하지 않음
        if (selectedRow == -1 || selectedRow >= jTable1.getRowCount()) {
            return;
        }
        // 현재 선택된 행의 "Count" 값을 가져와서 1을 증가시킴
        int currentValue = (int) jTable1.getValueAt(selectedRow, 1);
        int updatedValue = currentValue - 1;
        int price = prices.get(selectedRow);
        int sum = updatedValue * price;

        // 0이하로 내려가는걸 방지
        if (updatedValue == 0) {
            btnDeleteActionPerformed(evt);
            OM.ShowPrice();
            return;
        }

        // 테이블 모델을 업데이트하여 변경된 값을 테이블에 반영
        jTable1.setValueAt(updatedValue, selectedRow, 1);
        jTable1.setValueAt(sum, selectedRow, 2);
        OM.ShowPrice();
        //전체 가격 출력

    }//GEN-LAST:event_btnCountMinusActionPerformed

    private void Find_MenuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Find_MenuKeyTyped
        //검색 기능
        String Menu_Name = null;
        int Menu_Price = 0;
        ArrayList<String> Menu_Name_List = new ArrayList<String>(); //검색된 메뉴 저장
        ArrayList<Integer> Menu_Price_List = new ArrayList<Integer>(); //검색된 메뉴 저장

        if (evt.getKeyChar() == KeyEvent.VK_ENTER) { // Enter 키 입력시
            Menu.setSelectedIndex(7); // Tab Focus(검색)
            Find.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));

            try {
                String Find_Menus = Find_Menu.getText() + "%";
                String sql = "select Menu_name,Menu_Price from Menu where Menu_Name like ?"; //메뉴 이름, 가격 가져오기
                Connection con = DriverManager.getConnection(orcle_url, orcle_ID, orcle_PW);
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, Find_Menus);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) { //DB 입력
                    Menu_Name = rs.getString("Menu_Name");
                    Menu_Price = rs.getInt("Menu_Price");
                    Menu_Name_List.add(Menu_Name);
                    Menu_Price_List.add(Menu_Price);
                }

            } catch (SQLException ex) {
                System.err.println("Find_Menu Error");
            }
            
            
            // 입력된 메뉴만큼 버튼 생성
            HashMap<JButton, Integer> buttonPriceMap = new HashMap<>();
            
            for (int i = 0; i < Menu_Name_List.size(); i++) {
                JButton btn = new JButton(Menu_Name_List.get(i));
                btn.setPreferredSize(new Dimension(92, 57));

                int price = Menu_Price_List.get(i);

                btn.addActionListener((e) -> {
                    boolean status = false;
                    JButton targetButton = (JButton) e.getSource();
                    int buttonPrice = buttonPriceMap.get(targetButton);
                    
                    int rowCount = jTable1.getRowCount();
                    for (int j = 0; j < rowCount; j++) {
                        Object value = jTable1.getValueAt(j, 0);
                        if (value != null && value.toString().equalsIgnoreCase(btn.getText())) {
                            status = true;
                            break;
                        }
                    }
                    if (!status) {
                        OM.MakeTable(btn.getText(), 1, buttonPrice);
                        prices.add(buttonPrice);
                        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                        Object[] reowData = {null, null, null};
                        model.addRow(reowData);
                        OM.ShowPrice();
                    } else {
                        return;
                    }
                    System.out.println(jTable1.getRowCount());
                });

                // 버튼과 가격을 맵에 추가
                buttonPriceMap.put(btn, price);

                Find.add(btn);
            }

            Find.setVisible(true);
            
        }
    }//GEN-LAST:event_Find_MenuKeyTyped

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

        Runtime.getRuntime().addShutdownHook(new HookThread());
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Cafe;
    private javax.swing.JPanel Can;
    private javax.swing.JPanel Find;
    private javax.swing.JTextField Find_Menu;
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
    private javax.swing.JButton btnCountMinus;
    private javax.swing.JButton btnCountPlus;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnReset;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblRemainTime;
    protected static javax.swing.JLabel lblRtIme;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblUsedTime;
    protected static javax.swing.JLabel lblUser;
    protected static javax.swing.JLabel lblUtime;
    private javax.swing.JPanel subPanel;
    public javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
